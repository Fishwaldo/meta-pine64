DESCRIPTION = "Plasma Star64 Packages"

inherit packagegroup

PACKAGES = " \
    packagegroup-star64-plasma \
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