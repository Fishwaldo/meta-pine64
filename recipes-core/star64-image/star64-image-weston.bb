SUMMARY = "A small weston gtk3 demo image for Star64"

require star64-image-minimal.bb


IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston"

LICENSE = "MIT"


IMAGE_INSTALL += "  gtk+3-demo \
                    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)} \
"
