# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

SUMMARY = "Components necessary to integrate browsers into the Plasma Desktop"
DESCRIPTION = "Components necessary to integrate browsers into the Plasma Desktop"
HOMEPAGE = "https://invent.kde.org/plasma/plasma-browser-integration/"
LICENSE = "GPL-2.0+ | GPL-3.0+ | CCO-1 | MIT"
LIC_FILES_CHKSUM = " \
    file://LICENSES/GPL-2.0-or-later.txt;md5=9e2385fe012386d34dcc5c9863070881 \
    file://LICENSES/GPL-3.0-or-later.txt;md5=49fc03046e56a282c0c743b5d3a55b7c \
    file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
    file://LICENSES/MIT.txt;md5=4dd71a82d66fd9e3ca0cc65b8be370c0 \
"

SRC_URI += "https://download.kde.org/stable/plasma/5.27.4/plasma-browser-integration-5.27.4.tar.xz" 
SRC_URI[sha256sum] = "d37af781b11ec1622476b51af25ac82c8d2373bb8ff9c23981cb8a1c6d97f466"


DEPENDS = " \
    qtbase \
    qtdeclarative \
    ki18n \
    plasma-framework \
    kio \
    kcrash \
    krunner \
    purpose \
    kfilemetadata \
    kjobwidgets \
    plasma-workspace \
"

inherit cmake_plasma
inherit cmake_kf5
inherit kconfig

FILES:${PN} = " \
    ${sysconfdir}/chromium/native-messaging-hosts/org.kde.plasma.browser_integration.json \
    ${sysconfdir}/opt/edge/native-messaging-hosts/org.kde.plasma.browser_integration.json \
    ${sysconfdir}/opt/chrome/native-messaging-hosts/org.kde.plasma.browser_integration.json \
    ${libdir}/mozilla/native-messaging-hosts/org.kde.plasma.browser_integration.json \
    ${datadir}/applications/org.kde.plasma.browser_integration.host.desktop \
    ${datadir}/krunner/dbusplugins/plasma-runner-* \
    ${bindir}/plasma-browser-integration-host \
"

