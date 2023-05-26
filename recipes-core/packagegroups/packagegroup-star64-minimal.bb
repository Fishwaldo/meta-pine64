DESCRIPTION = "Minimal Star64 Packages"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

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
    packagekit \
    firewalld \
    pciutils \
    packagefeed \
    alsa-utils \
    gnupg \
    linux-firmware-rtl8852 \
    libgpiod-tools \
    bluez5 \
    u-boot-tools \
    kernel-image-fitimage-initramfs \
    xz \
    usbutils \
"