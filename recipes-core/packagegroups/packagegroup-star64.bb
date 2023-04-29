DESCRIPTION = "Minimal Star64 Packages"

inherit packagegroup

PACKAGES = " \
    packagegroup-star64-minimal \
    packagegroup-star64-weston \
    packagegroup-star64-plasma \
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
    openssh \
    wget \
    curl \
"

RDEPENDS:packagegroup-star64-weston = " \
    packagegroup-star64-minimal \
    gtk+3-demo \
    weston \
    sddm \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)} \
"

RDEPENDS:packagegroup-star64-plasma = " \
    packagegroup-star64-minimal \
    wayland \
    dbus \
    sddm \
    systemd \
    liberation-fonts \
    ttf-noto \
    packagegroup-kde-frameworks5 \
    bluedevil \
    breeze \
    kactivitymanagerd \
    kde-cli-tools \
    kdecoration \
    kscreen \
    kscreenlocker \
    kwayland-integration \
    kwin \
    libkscreen \
    libksysguard \
    milou \
    plasma-integration \
    plasma-nano \
    plasma-nm \
    plasma-pa \
    plasma-workspace \
    polkit-kde-agent-1 \
    plasma-settings \
    plasma-systemmonitor \
    xdg-desktop-portal-kde \
    kclock \
    kweather \
    plasma-desktop \
    kdeconnect-kde \
    konsole \
    discover \
    konqueror \
    xserver-xorg-extension-glx \
    xf86-video-modesetting \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \                                
"