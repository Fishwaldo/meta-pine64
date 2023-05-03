# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Wallpapers for Plasma Workspaces"
DESCRIPTION = "Wallpapers for Plasma Workspaces"
HOMEPAGE = "https://invent.kde.org/plasma/plasma-workspace-wallpapers"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = " \
    file://COPYING.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

SRC_URI += "https://download.kde.org/stable/plasma/5.27.4/plasma-workspace-wallpapers-5.27.4.1.tar.xz"
SRC_URI[sha256sum] = "e44d7bc716f99ce13bf034d4eeed99cdd33e12db7068d74ac37d2304ee44656b"

S="${WORKDIR}/plasma-workspace-wallpapers-5.27.4.1"


inherit cmake_plasma
inherit kconfig

FILES:${PN} += " \
    ${datadir}/wallpapers/* \
"
