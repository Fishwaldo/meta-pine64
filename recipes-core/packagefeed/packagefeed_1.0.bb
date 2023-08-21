LICENSE="MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:star64 = "\
    file://sources.list.star64 \
    https://pine64.my-ho.st:8443/public-key.asc \
"

SRC_URI:append:pinetabv = "\
    file://sources.list.pinetabv \
    https://pine64.my-ho.st:8443/public-key.asc \
"


SRC_URI[sha256sum] = "8ca5205bcbb703ebe372f40318e748c0b3f1bca64aaf5b8d315eac07e7f95e37"

CONFFILES:${PN} += " \
    ${sysconfdir}/apt/sources.list \
    ${sysconfdir}/apt/trusted.gpg.d/pinix.gpg \
"
FILES:${PN} += " \
    ${sysconfdir}/apt/sources.list \
    ${sysconfdir}/apt/trusted.gpg.d/pinix.gpg \
"

do_install:star64:append() {
    install -d ${D}/${sysconfdir}/apt/trusted.gpg.d
    install -m 644 ${WORKDIR}/sources.list.star64 ${D}/${sysconfdir}/apt/sources.list
    cat ${WORKDIR}/public-key.asc | gpg --dearmor | tee ${D}/${sysconfdir}/apt/trusted.gpg.d/pinix.gpg
}

do_install:pinetabv:append() {
    install -d ${D}/${sysconfdir}/apt/trusted.gpg.d
    install -m 644 ${WORKDIR}/sources.list.pinetabv ${D}/${sysconfdir}/apt/sources.list
    cat ${WORKDIR}/public-key.asc | gpg --dearmor | tee ${D}/${sysconfdir}/apt/trusted.gpg.d/pinix.gpg
}

DEPENDS += " \
    gnupg-native \
"
COMPATIBLE_MACHINE = "(star64|pinetabv)"
PACKAGE_ARCH = "${MACHINE_ARCH}"