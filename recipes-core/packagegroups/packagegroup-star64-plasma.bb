DESCRIPTION = "Plasma Star64 Packages"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = " \
    packagegroup-star64-plasma \
"
RDEPENDS:packagegroup-star64-plasma = " \
    packagegroup-star64-minimal \
    packagegroup-kde-gear \
    wayland \
    dbus \
    drkonqi \
    firewalld-applet \
    sddm \
    sddm-kcm \
    systemd \
    liberation-fonts \
    ttf-noto \
    packagegroup-kde-frameworks5 \
    bluedevil \
    breeze \
    kactivitymanagerd \
    kde-cli-tools \
    kdecoration \
    kdeplasma-addons \
    kinfocenter \
    kgamma5 \
    khotkeys \
    kmenuedit \
    kscreen \
    kscreenlocker \
    kwayland-integration \
    kwin \
    kdeplasma-addons \
    kpipewire \
    kirigami-addons \
    ksystemstats \
    kvantum \
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
    plasma-vault \
    plasma-workspace-wallpapers \
    plasma-firewall \
    plasma-sdk \
    plasma-disks \
    plasma-browser-integration \
    plasma-welcome \
    pulseaudio \
    pulseaudio-server \
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
    udisks2 \
    cups \
    wings-theme \
    systemsettings \                              
"