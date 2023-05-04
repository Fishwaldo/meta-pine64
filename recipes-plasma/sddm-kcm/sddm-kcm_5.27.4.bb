# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Login Screen (SDDM) System Settings Module"
SUMMARY = "sddm-kcm is a KConfig Module (KCM) that integrates itself into KDE's System Settings and serves the purpose of configuring the Simple Desktop Display Manager (SDDM) - the recommended display manager for KDE Plasma."
HOMEPAGE = "https://invent.kde.org/plasma/sddm-kcm"
LICENSE = "CC0-1.0 & GPL-2.0-or-later & GPL-3.0-only & LicenseRef-KDE-Accepted-GPL"

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/sddm-kcm-5.27.4.1.tar.xz \
"
SRC_URI[sha256sum] = "977a526713fed18483234e6dd33347eece8bd02c7ca46fd473e50d59d1ac0551"

S="${WORKDIR}/sddm-kcm-5.27.4.1"

inherit cmake_plasma
inherit kcoreaddons
inherit ki18n
inherit kauth
inherit kconfig
inherit reuse_license_checksums
inherit kcmutils 


DEPENDS = " \
    knewstuff \
    kconfigwidgets \
    kio \
"

RDEPENDS:${PN} = " \
    sddm \
"

KF5_REUSE_LICENSECHECK_ENABLED="1"

FILES:${PN} += " \
    ${datadir}/kpackage/kcms/kcm_sddm/ \
"
