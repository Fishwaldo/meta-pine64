SUMMARY = "Customization for PinIx Distribution"
DESCRIPTION ="This recipe applies our custom configs for PinIx Distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://COPYING \
    file://kde_settings.conf \
    file://akonadiserverrc \
    file://kdeglobals \
    file://kvantum.kvconfig \
"
S="${WORKDIR}"

do_install:append() {
    install -d ${D}${sysconfdir}/sddm.conf.d/
    install -m 0644 ${WORKDIR}/kde_settings.conf ${D}${sysconfdir}/sddm.conf.d/
    install -d ${D}${sysconfdir}/xdg/akonadi
    install -m 0644 ${WORKDIR}/akonadiserverrc ${D}${sysconfdir}/xdg/akonadi/akonadiserverrc
    install -m 0644 ${WORKDIR}/kdeglobals ${D}${sysconfdir}/xdg/kdeglobals
    install -d ${D}${sysconfdir}/skel/.config/Kvantum
    install -m 0644 ${WORKDIR}/kvantum.kvconfig ${D}${sysconfdir}/skel/.config/Kvantum/kvantum.kvconfig
    install -m 0644 ${WORKDIR}/kdeglobals ${D}${sysconfdir}/skel/.config/kdeglobals
}
