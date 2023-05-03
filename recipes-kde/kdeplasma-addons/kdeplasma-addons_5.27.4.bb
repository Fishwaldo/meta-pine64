# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "kdeplasma-addons"
SUMMARY = "All kind of add-ons to improve your Plasma experience"
HOMEPAGE = "https://invent.kde.org/plasma/kdeplasma-addons"
LICENSE = "BSD-3-Clause &  GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.0-only & LGPL-2.0-or-later & LGPL-2.1-or-later & LGPL-3.0-only"

SRC_URI += " \
    https://download.kde.org/stable/plasma/5.27.4/kdeplasma-addons-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "6a82a57988f336345738630217f49b191a379eeea586565a802bcebed7941f89"

DEPENDS = " \
    qtbase \
    kdeclarative \
    kio \
    knewstuff \
    plasma-framework \
    krunner \
    kunitconversion \
    kholidays \
    networkmanager-qt \
    qtwebengine \
"

inherit cmake_kdeapp
inherit cmake_plasma
inherit kcoreaddons
inherit kconfig
inherit kauth
inherit mime-xdg
inherit kcmutils
inherit reuse_license_checksums
inherit cmake_qt5

KF5_REUSE_LICENSECHECK_ENABLED="1"

FILES:${PN} = " \
    ${libdir}/plugins/plasmacalendarplugins/* \
    ${libdir}/plugins/kf5/krunner/kcms/kcm* \
    ${datadir}/plasma/wallpapers/* \
    ${datadir}/plasma/desktoptheme/* \
    ${datadir}/plasma/plasmoids/* \
    ${datadir}/kwin/tabbox/* \
    ${datadir}/kwin/desktoptabbox/* \
    ${libdir}/libplasma* \
"