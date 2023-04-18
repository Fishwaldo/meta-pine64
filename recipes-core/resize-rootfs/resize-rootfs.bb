SUMMARY = "Resize rootfs to fill userdata partition."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY:${PN} = "1"

pkg_postinst_ontarget:${PN}() {
    root=`lsblk -o NAME,LABEL -r | grep root | awk -F' ' '{print $1}'`
    if [[ "$root" == *"mmcblk"* ]]; then
        echo "Resizing $root partition to fill SDCard..."
        psplash-write "MSG Resizing $root partition to fill SDCard..." || true
        sgdisk -e /dev/${root:0:-2}
        partprobe
        echo yes  | parted ---pretend-input-tty /dev/${root:0:-2} resizepart ${root:0-1} 100%
        partprobe
        resize2fs /dev/$root
    fi
}

RDEPENDS:${PN} += "e2fsprogs-resize2fs parted util-linux gptfdisk"