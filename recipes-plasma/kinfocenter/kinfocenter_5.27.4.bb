# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "View information about your computer's hardware"
SUMMARY = "KInfocenter gives you a host of information about your hardware and its capabilities"
HOMEPAGE = "https://invent.kde.org/plasma/kinfocenter"
LICENSE = "BSD-2-Clause & BSD-3-Clause & CC0-1.0 & FSFAP & GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.1-or-later & LGPL-3.0-only & LicenseRef-KDE-Accepted-LGPL & LicenseRef-KDE-Accepted-GPL"

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/kinfocenter-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "6875ca14c4fc139f007bc4b318fa3812f7d73ef26fa2ae54a49bd48bda67e495"

inherit cmake_plasma
inherit kcoreaddons
inherit ki18n
inherit kauth
inherit kconfig
inherit reuse_license_checksums
inherit kcmutils
inherit kdoctools  


DEPENDS = " \
    kio \
    kservice \
    solid \
    systemsettings \
    pciutils \ 
"

KF5_REUSE_LICENSECHECK_ENABLED="1"

FILES:${PN} += " \
    ${datadir}/kpackage/kcms/ \
    ${datadir}/desktop-directories/ \
    ${libdir}/qml/org/kde/kinfocenter \
    ${libdir}/libKInfoCenterInternal.so \
"

FILES:${PN}-dev = ""