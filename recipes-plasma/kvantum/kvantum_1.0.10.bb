# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "A Linux SVG-based theme engine for Qt and KDE "
SUMMARY = "A Linux SVG-based theme engine for Qt and KDE "
HOMEPAGE = "https://github.com/tsujan/Kvantum"
LICENSE = "LGPL-3.0-only"

SRC_URI += "git://github.com/tsujan/Kvantum.git;protocol=https;branch=master \
           file://0001-fix-install-prefix.patch;patchdir=.. \
           "
SRCREV = "a868cd0b4f98bc5f72d15dafbebd0cdc8dd11f2e"

LIC_FILES_CHKSUM=" \
    file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a \
"

S="${WORKDIR}/git/Kvantum"

inherit cmake_plasma

DEPENDS = " \
    qtbase \
"

FILES:${PN} += " \
    ${datadir}/Kvantum/ \
    ${datadir}/color-schemes \
    ${datadir}/kvantumpreview \
    ${datadir}/kvantummanager \
"