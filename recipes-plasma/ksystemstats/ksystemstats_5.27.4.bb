# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "A plugin based system monitoring daemon."
SUMMARY = "A plugin based system monitoring daemon."
HOMEPAGE = "https://invent.kde.org/plasma/ksystemstats"
LICENSE = "CC0-1.0 & GPL-2.0-or-later & GPL-2.0-only"

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/ksystemstats-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "1fd68961450fb8c37c6969a3a9b927a59aa7d13e0820898f2fe73d6fdc9edece"


inherit cmake_plasma
inherit ki18n
inherit kcoreaddons
inherit reuse_license_checksums


DEPENDS = " \
    kio \
    kdbusaddons \
    libksysguard \
    networkmanager-qt \
    lmsensors \
    udev \
    libnl \
"

KF5_REUSE_LICENSECHECK_ENABLED="1"

