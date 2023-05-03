# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Monitors S.M.A.R.T. capable devices for imminent failure."
DESCRIPTION = "Monitors S.M.A.R.T. capable devices for imminent failure."
HOMEPAGE = "https://invent.kde.org/plasma/plasma-disks"
LICENSE = "GPL-2.0 | GPL-3.0 | LicenseRef-KDE-Accepted-GPL"
LIC_FILES_CHKSUM = " \
    file://LICENSES/GPL-2.0-only.txt;md5=93e64b4a83c7e441e48bbdeeea05c977 \
    file://LICENSES/GPL-3.0-only.txt;md5=1c76c4cc354acaac30ed4d5eefea7245 \
    file://LICENSES/LicenseRef-KDE-Accepted-GPL.txt;md5=b4c280013bbbadfbe92219498dc5228c \
"

SRC_URI += "https://download.kde.org/stable/plasma/5.27.4/plasma-disks-5.27.4.tar.xz" 
SRC_URI[sha256sum] = "97f4aee2e2db0ce2dbc1bfbe4b5ad85253f435f58af5f402916ff2d1e0e98323"


DEPENDS = " \
    qtbase \
    qtdeclarative \
    ki18n \
    plasma-framework \
    kio \
    kauth \
    kservice \
"

inherit cmake_plasma
inherit cmake_kf5
inherit kconfig

FILES:${PN} = " \
    ${libexecdir}/kauth/kded-smart-helper \
    ${datadir}/kpackage/kcms/plasma_disks/* \
"

