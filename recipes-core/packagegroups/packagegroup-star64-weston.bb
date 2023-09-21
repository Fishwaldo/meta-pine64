DESCRIPTION = "Weston Star64 Packages"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = " \
    packagegroup-star64-weston \
"

RDEPENDS:packagegroup-star64-weston = " \
    packagegroup-star64-minimal \
    gtk+3-demo \
    weston \
    sddm \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)} \
    firefox \
    refined-h264ify \
    mesa-demos \
"

COMPATIBLE_MACHINE = "star64"
