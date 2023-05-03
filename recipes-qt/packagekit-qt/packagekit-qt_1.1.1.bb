HOMEPAGE = "https://www.freedesktop.org/software/PackageKit/index.html"
SUMMARY = "QT5 binding for PackageKit "
DESCRIPTION = "PackageKit is a system designed to make installing and updating \
software on your computer easier. The primary design goal is to unify all the \
software graphical tools used in different distributions, and use some of the \
latest technology like PolicyKit. "


LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    https://www.freedesktop.org/software/PackageKit/releases/PackageKit-Qt-1.1.1.tar.xz \
"

S = "${WORKDIR}/PackageKit-Qt-1.1.1"

SRC_URI[sha256sum] = "8ad57523dbfd5a4b2086fa420b8ded63024e12efb8ca0ac42db767842e506212"

inherit cmake_qt5 pkgconfig

DEPENDS = " \
    qtbase \
    packagekit \
"