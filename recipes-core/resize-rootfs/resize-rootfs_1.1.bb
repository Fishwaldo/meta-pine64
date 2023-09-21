SUMMARY = "Resize rootfs to fill userdata partition."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
    file://resize-rootfs.sh \
    file://resize-rootfs.service \
"
inherit systemd

S = "${WORKDIR}"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}${systemd_unitdir}/system
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/resize-rootfs.sh ${D}${bindir}
}

SYSTEMD_SERVICE:${PN} = "resize-rootfs.service"

RDEPENDS:${PN} += "e2fsprogs-resize2fs parted util-linux gptfdisk"

FILES:${PN} += "${systemd_unitdir}/system/resize-rootfs.service \
                ${bindir}/resize-rootfs.sh \
"