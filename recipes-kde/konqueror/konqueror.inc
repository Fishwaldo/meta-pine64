# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Konqueror"
SUMMARY = "A Webbrowser for KDE"
HOMEPAGE = "https://invent.kde.org/network/konqueror"
LICENSE = "BSD-3-Clause &  GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-only & LGPL-2.0-only & LGPL-2.0-or-later & LGPL-2.1-or-later & LGPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSES/BSD-3-Clause.txt;md5=f225922a2c12dfa5218fb70c49db3ea6 \
    file://LICENSES/GPL-2.0-only.txt;md5=9e2385fe012386d34dcc5c9863070881 \
    file://LICENSES/GPL-2.0-or-later.txt;md5=9e2385fe012386d34dcc5c9863070881 \
    file://LICENSES/GPL-3.0-only.txt;md5=49fc03046e56a282c0c743b5d3a55b7c \
    file://LICENSES/LGPL-2.0-only.txt;md5=da48810c4ddf8e49efa031294a26b98c \
    file://LICENSES/LGPL-2.0-or-later.txt;md5=da48810c4ddf8e49efa031294a26b98c \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=147a320ed8b16b036829a0c71d424153 \
    file://LICENSES/LGPL-3.0-only.txt;md5=8d51f5b5fd447f7a1040c3dc9f0a8de6 \
"

S = "${WORKDIR}/git"

DEPENDS = " \
    qtwebengine \
    kwindowsystem \
    kparts \
    kcrash \
    kinit \
    kiconthemes \
    kdbusaddons \
    kguiaddons \
    kactivities \
    kdesu \
    qtbase \
"

inherit cmake_kdeapp
inherit kcoreaddons
inherit kconfig
inherit kauth
inherit mime-xdg
inherit kcmutils

EXTRA_OECMAKE:append = " \
    -DBUILD_TESTING=OFF \
    -DOE_KF5_PATH_HOST_ROOT=${STAGING_DIR_HOST} \
"

FILES:${PN} += " \
    ${datadir}/k* \
    ${datadir}/webenginepart \
    ${datadir}/akregator \
    ${libdir}/plugins/khtml \
    ${libdir}/plugins/kwebkitpart \
    ${libdir}/plugins/webenginepart \
    ${libdir}/libkdeinit5_konqueror.so \
    ${libdir}/libkdeinit5_kfmclient.so \
    ${libdir}/libkwebenginepart.so \
    ${libdir}/libKF5Konq.so \
    ${libdir}/libkonqsidebarplugin.so \
"
FILES:${PN}-dev = " \
    ${includedir}/konqsidebarplugin.h \
    ${includedir}/KF5/konq* \
    ${includedir}/KF5/libkonq* \
"

INSANE_SKIP:${PN} = "dev-so"