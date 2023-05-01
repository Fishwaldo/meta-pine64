DESCRIPTION = "Weston Star64 Packages"

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
"