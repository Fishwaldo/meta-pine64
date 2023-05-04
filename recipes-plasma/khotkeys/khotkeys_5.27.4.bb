# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Trigger actions when certain keys are pressed"
SUMMARY = "Trigger actions when certain keys are pressed"
HOMEPAGE = "https://invent.kde.org/plasma/khotkeys"
LICENSE = "CC0-1.0 & GPL-2.0-Only & LGPL-2.0-Only & LGPL-2.0-or-later "

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/khotkeys-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "841224dea79b4607ecebe79b5c94e36bfbc290b623d5efe5dbe1cd566a921023"

inherit cmake_plasma
inherit ki18n
inherit reuse_license_checksums
inherit kdoctools  
inherit kcmutils


DEPENDS = " \
    kdbusaddons \
    kglobalaccel \
    kio \
    kxmlgui \
    kdelibs4support \
    ktextwidgets \
    kitemmodels \
    kinit \
    plasma-workspace \
"

KF5_REUSE_LICENSECHECK_ENABLED="1"
