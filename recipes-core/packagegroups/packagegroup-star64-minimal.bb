DESCRIPTION = "Minimal Star64 Packages"

inherit packagegroup

PACKAGES = " \
    packagegroup-star64-minimal \
"


RDEPENDS:packagegroup-star64-minimal = " \
    resize-rootfs \
    mc \
    joe \
    ca-certificates \
    networkmanager \
    wpa-supplicant \
    avahi-daemon \
    networkmanager-nmtui \
    ntpdate \
    tzdata \
    udev-rules-star64 \
    wget \
    curl \
"