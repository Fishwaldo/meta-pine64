# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Applications useful for Plasma development"
DESCRIPTION = "Applications useful for Plasma development"
HOMEPAGE = "https://invent.kde.org/plasma/plasma-sdk"
LICENSE = "BSD-2 | CC0-1 | GPL-2.0 | GPL-2.0+ | LGPL-2.0 | LGPL-2.0+ "
LIC_FILES_CHKSUM = " \
    file://LICENSES/BSD-2-Clause.txt;md5=63d6ee386b8aaba70b1bf15a79ca50f2 \
    file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
    file://LICENSES/GPL-2.0-only.txt;md5=93e64b4a83c7e441e48bbdeeea05c977 \
    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
    file://LICENSES/LGPL-2.0-only.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7 \
    file://LICENSES/LGPL-2.0-or-later.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7 \
"

SRC_URI += "https://download.kde.org/stable/plasma/5.27.4/plasma-sdk-5.27.4.tar.xz"
SRC_URI[sha256sum] = "f98849e361c19b192998bb4966f561ea8539d6ceb98fc967e783edb36c36db21"


DEPENDS = " \
    qtbase \
    kirigami \
    karchive \
    plasma-framework \
    ktexteditor \
    kdoctools-native \
    kdoctools \
    docbook-xsl-stylesheets-native \
"

inherit cmake_plasma
inherit cmake_kf5
inherit kdoctools
inherit kconfig

FILES:${PN} += " \
    ${datadir}/plasma/shells/org.kde.plasma.plasmoidviewershell/* \
    ${datadir}/zsh/site-functions/_plasmoidviewer \
    ${datadir}/kpackage/genericqml \
"
