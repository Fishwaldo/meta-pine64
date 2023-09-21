SUMMARY = "Global Config Files for PineTabV"
DESCRIPTION ="Global Config Files for PineTabV"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://COPYING \
    file://powerdevilrc \
    file://powermanagementprofilesrc \
    file://lockscreen.conf \
"

S="${WORKDIR}"

RDEPENDS:${PN} += " \
    systemd \
    powerdevil \
"

do_install:append() {
    install -d ${D}${sysconfdir}/xdg/
    install -m 0644 ${WORKDIR}/powerdevilrc ${D}${sysconfdir}/xdg/powerdevilrc
    install -m 0644 ${WORKDIR}/powermanagementprofilesrc ${D}${sysconfdir}/xdg/powermanagementprofilesrc
    install -d ${D}${sysconfdir}/systemd/logind.conf.d/
    install -m 0644 ${WORKDIR}/lockscreen.conf ${D}${sysconfdir}/systemd/logind.conf.d/lockscreen.conf
}

pkg_postinst_ontarget:${PN}() {
    systemctl mask sleep.target suspend.target hibernate.target hybrid-sleep.target
}


COMPATIBLE_MACHINE = "pinetabv"

PACKAGE_ARCH = "${MACHINE_ARCH}"