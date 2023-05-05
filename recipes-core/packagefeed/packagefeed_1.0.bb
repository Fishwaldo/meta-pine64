LICENSE="MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:star64 = "\
    file://sources.list.star64 \
"

CONFFILES:${PN} += "${sysconfdir}/apt/sources.list"
FILES:${PN} += "${sysconfdir}/apt/sources.list"

do_install:append() {
    install -d ${D}/${sysconfdir}/apt/
    install -m 644 ${WORKDIR}/sources.list.star64 ${D}/${sysconfdir}/apt/sources.list
}