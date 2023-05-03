HOMEPAGE = "https://www.freedesktop.org/software/PackageKit/index.html"
SUMMARY = "PackageKit"
DESCRIPTION = "PackageKit is a system designed to make installing and updating \
software on your computer easier. The primary design goal is to unify all the \
software graphical tools used in different distributions, and use some of the \
latest technology like PolicyKit. "


LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = " \
    https://www.freedesktop.org/software/PackageKit/releases/PackageKit-1.2.6.tar.xz \
"

S = "${WORKDIR}/PackageKit-1.2.6"

SRC_URI[sha256sum] = "1a0cf173065ce9232c6d5fb044bf6b606147a8702dc6ff4753c2a08331c52e51"

inherit meson pkgconfig gobject-introspection vala

DEPENDS = " \
    pkgconfig-native \
    glib-2.0 \
    apt \
    sqlite3 \
    polkit \
    libxslt-native \
    docbook-xsl-stylesheets-native \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    appstream \
    gtk+3 \
"
RDEPENDS:${PN} = " \
    cronie \
    bash \
"

GIR_MESON_OPTION = "gobject_introspection"

EXTRA_OEMESON = " \
    -Dpackaging_backend=apt \
    -Dgstreamer_plugin=false \
"

FILES:${PN} += " \
    ${systemd_system_unitdir}/packagekit* \
    ${systemd_system_unitdir}/system-update* \
    ${datadir}/dbus-1/system-services/org.freedesktop.PackageKit.service \
    ${datadir}/dbus-1/interfaces/org.freedesktop.PackageKit.* \
    ${datadir}/PackageKit/ \
    ${datadir}/bash-completion/ \
    ${datadir}/polkit-1/* \
    ${libdir}/packagekit-backend/* \
    ${libdir}/gnome-settings-daemon-3.0/* \
    ${libdir}/python3.10/site-packages/packagekit/* \
    ${libdir}/gtk-3.0/modules/libpk-gtk-module.so \
    ${libdir}/systemd/user/pk* \
"