
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:star64 = "\
    file://sddm.conf \
"

CONFFILES:${PN} += "${sysconfdir}/sddm.conf"
FILES:${PN} += "${sysconfdir}/sddm.conf"

do_install:append() {
    install -m 644 ${WORKDIR}/sddm.conf ${D}/${sysconfdir}/
}