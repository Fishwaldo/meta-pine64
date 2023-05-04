# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Menu Editor for Plasma Workspaces"
SUMMARY = "KMenuEdit allows editing the menu of KDE application launchers."
HOMEPAGE = "https://invent.kde.org/plasma/kmenuedit"
LICENSE = "CC0-1.0 & GPL-2.0-or-later & GPL-2.0-only"

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/kmenuedit-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "37abb72d193ae1273b9a5265e8decfeeebee12811eb9977ba69af8850c8ca7b3"


inherit cmake_plasma
inherit ki18n
inherit reuse_license_checksums


DEPENDS = " \
    kxmlgui \
    kdbusaddons \
    kiconthemes \
    kitemviews \
    sonnet \
    kglobalaccel \
    kwindowsystem \
"
KF5_REUSE_LICENSECHECK_ENABLED="1"

