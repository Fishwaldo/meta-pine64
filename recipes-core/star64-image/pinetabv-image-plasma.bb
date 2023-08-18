SUMMARY = "KDE Plasma image for PineTabV"

require star64-image-minimal.bb


IMAGE_FEATURES += "splash \
    package-management \
    ssh-server-openssh \
    hwcodecs \
"

LICENSE = "MIT"


IMAGE_INSTALL:append = " \
    packagegroup-pinetabv-plasma \
"

COMPATIBLE_MACHINE = "pinetabv"