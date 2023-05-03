# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Plasma Control Panel for your system firewall"
DESCRIPTION = "Plasma Control Panel for your system firewall"
HOMEPAGE = "https://invent.kde.org/plasma/plasma-firewall"
LICENSE = "GPL-2.0 | GPL-3.0 | LicenseRef-KDE-Accepted-GPL"
LIC_FILES_CHKSUM = " \
    file://LICENSES/GPL-2.0-only.txt;md5=93e64b4a83c7e441e48bbdeeea05c977 \
    file://LICENSES/GPL-3.0-only.txt;md5=1c76c4cc354acaac30ed4d5eefea7245 \
    file://LICENSES/LicenseRef-KDE-Accepted-GPL.txt;md5=b4c280013bbbadfbe92219498dc5228c \
"

SRC_URI += " \
    https://download.kde.org/stable/plasma/5.27.4/plasma-firewall-5.27.4.tar.xz \
    file://0001-hardcode-python3-path.patch \
"
SRC_URI[sha256sum] = "349db4a0908d7a6565eb8b80971eb2ed4f6d4f1730ee65de2fd23f2b1343a3ac"

inherit cmake_plasma
inherit cmake_kf5
inherit kdoctools
inherit kconfig
inherit kcoreaddons
inherit kcmutils

DEPENDS = " \
    qtbase \
    qtdeclarative \
    ki18n \
    plasma-framework \
    firewalld \
"

RDEPENDS:${PN} = " \
    python3-core \
"


FILES:${PN} += " \
    ${datadir}/kcm_ufw/defaults \
    ${datadir}/kpackage/kcms/kcm_firewall/* \
    ${libdir}/libkcm_firewall_core.so \
"
FILES:${PN}-dev = ""

