LICENSE="MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:star64 = "\
    file://pinix-testing.list.star64 \
"

SRC_URI:append:pinetabv = "\
    file://pinix-testing.list.pinetabv \
"

SRC_URI[sha256sum] = "8ca5205bcbb703ebe372f40318e748c0b3f1bca64aaf5b8d315eac07e7f95e37"

CONFFILES:${PN} += " \
    ${sysconfdir}/apt/sources.list.d/* \
"
FILES:${PN} += " \
    ${sysconfdir}/apt/sources.list.d/* \
"

do_install:star64:append() {
    install -d ${D}/${sysconfdir}/apt/sources.list.d/
    install -m 644 ${WORKDIR}/pinix-testing.list.star64 ${D}/${sysconfdir}/apt/sources.list.d/pinix-testing.list
}

do_install:pinetabv:append() {
    install -d ${D}/${sysconfdir}/apt/sources.list.d/
    install -m 644 ${WORKDIR}/pinix-testing.list.pinetabv ${D}/${sysconfdir}/apt/sources.list.d/pinix-testing.list
}

COMPATIBLE_MACHINE = "(star64|pinetabv)"
PACKAGE_ARCH = "${MACHINE_ARCH}"