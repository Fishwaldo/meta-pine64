# SPDX-FileCopyrightText: 2017-2020 Volker Krause <vkrause@kde.org>
# SPDX-FileCopyrightText: 2018 Alistair Francis <alistair.francis@wdc.com>
# SPDX-FileCopyrightText: 2020-2022 Andreas Cord-Landwehr <cordlandwehr@kde.org>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "KWin"
HOMEPAGE = ""
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-only.txt;md5=93e64b4a83c7e441e48bbdeeea05c977"
PR = "r0"

DEPENDS:class-target = " \
    qtdeclarative \
    qtsensors \
    qtwayland-native \
    kpackage-native \
    qtscript \
    kconfigwidgets \
    kcrash \
    kglobalaccel \
    kinit \
    knotifications \
    kpackage \
    kwin-native \
    wayland \
    wayland-protocols \
    plasma-framework \
    kwindowsystem \
    kiconthemes \
    kidletime \
    kwayland \
    kcompletion \
    kdeclarative \
    kio \
    ktextwidgets \
    knewstuff \
    kservice \
    kxmlgui \
    kdecoration \
    krunner \
    kscreenlocker \
    libxcb \
    xcb-util-cursor \
    fontconfig \
    lcms \
    libepoxy \
    libinput \
    pipewire \
    libxcvt \
    hwdata \
"

DEPENDS:class-native = " \
    qtbase-native \
    extra-cmake-modules-native \
"

SRC_URI:append = " \
    file://kwinrc \
    file://0002-Include-missing-header-for-std-round.patch \
    file://0003-Add-missing-cmath-include-for-std-ceil.patch \
"

SRC_URI:append:class-native = " \
    file://0001-Add-install-operation-for-native-build.patch \
"

OECMAKE_SOURCEPATH:class-native = "${S}/src/wayland/tools"
EXTRA_OECMAKE:append:class-target = " \
    -DQTWAYLANDSCANNER_KDE_EXECUTABLE=${STAGING_DIR_NATIVE}/${bindir}/qtwaylandscanner_kde \
    -DBUILD_TESTING=OFF \
"

inherit kauth
inherit kcmutils
inherit kconfig
inherit kdoctools
inherit cmake_qt5
inherit pkgconfig
# TODO skip inherit of cmake_plasma for now because it leads to build errors for native package


FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/config.kcfg/*.kcfg \
    ${datadir}/icons/hicolor \
    ${datadir}/kconf_update/* \
    ${datadir}/knotifications5/*.notifyrc \
    ${datadir}/knsrcfiles/* \
    ${datadir}/kpackage \
    ${datadir}/krunner/dbusplugins/*.desktop \
    ${datadir}/kservices5/*.desktop \
    ${datadir}/kservices5/kwin/*.desktop \
    ${datadir}/kservicetypes5/*.desktop \
    ${datadir}/kwincompositing/qml/*.qml \
    ${datadir}/qlogging-categories5 \
    ${libdir}/kconf_update_bin/kwin5_update_default_rules \
    ${libdir}/plugins/*.so \
    ${libdir}/plugins/kf5/org.kde.kidletime.platforms/*.so \
    ${libdir}/plugins/kpackage/packagestructure/*.so \
    ${libdir}/plugins/kwin/effects/configs/*.so \
    ${libdir}/plugins/kwin/plugins/*.so \
    ${libdir}/plugins/org.kde.kdecoration2/*.so \
    ${libdir}/plugins/org.kde.kglobalaccel5.platforms/*.so \
    ${libdir}/plugins/org.kde.kwin.platforms/*.so \
    ${libdir}/plugins/org.kde.kwin.scenes/*.so \
    ${libdir}/plugins/org.kde.kwin.waylandbackends/*.so \
    ${libdir}/plugins/plasma/kcms/systemsettings/*.so \
    ${libdir}/plugins/plasma/kcms/systemsettings_qwidgets/*.so \
    ${libdir}/plugins/platforms/*.so \
    ${libdir}/qml/org/kde/kwin.2/* \
    ${libdir}/qml/org/kde/kwin/decoration/* \
    ${libdir}/qml/org/kde/kwin/decorations/plastik/* \
    ${libdir}/qml/org/kde/kwin/effects/* \
    ${libdir}/qml/org/kde/kwin/private/effects/* \
    ${libdir}/qml/org/kde/kwin/private/kdecoration/* \
    ${libdir}/qml/org/kde/plasma/quicksetting/nightcolor/* \
    ${libdir}/systemd/user/*.service \
"

FILES:${PN}-dev += " \
    ${libdir}/libkwin*.so \
    ${datadir}/dbus-1/interfaces/*.xml \
"

RDEPENDS:${PN}:append:class-target = " \
    maliit-keyboard-qt5 \
    qtwayland-plugins \
    xwayland \
    perl \
"

BBCLASSEXTEND = "native"
