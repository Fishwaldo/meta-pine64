# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Crash handler for KDE software"
SUMMARY = "Crash handler for KDE software"
HOMEPAGE = "https://invent.kde.org/plasma/drkonqi"
LICENSE = "BSD-3-Clause & BSD-2-Clause & CC0-1.0 & GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.1-only & LGPL-3.0-only & LGPL-3.0-or-later & LicenseRef-KDE-Accepted-LGPL & LicenseRef-KDE-Accepted-GPL"

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/drkonqi-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "d63ace5da89cc628e0a411f9636fb067d0478caa1e2e6f32532688aa196f91d1"

DEPENDS = " \
    kidletime  \
    syntax-highlighting \
    kuserfeedback \
    kirigami \
    kitemmodels \
    kuserfeedback \
    qtdeclarative-native \
    qttools-native \
    systemd \
    qttools \
"

inherit cmake_plasma
inherit reuse_license_checksums
inherit kcmutils 

KF5_REUSE_LICENSECHECK_ENABLED="1"

FILES:${PN} += " \
    ${libdir}/systemd/system/ \
"