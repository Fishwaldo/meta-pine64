# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Wings Themes For Plasma Desktop"
SUMMARY = "Wings Themes For Plasma Desktop"
HOMEPAGE = "https://github.com/L4ki/Wings-Plasma-Themes"
LICENSE = "GPL-3.0-only "

SRC_URI += " \
   git://github.com/L4ki/Wings-Plasma-Themes.git;protocol=https;branch=main \
   file://metadata.json \
"
SRCREV="17300100e0ae82749e0f86cb5ec2e3af2315e76b"

PV = "1.1+git${SRCPV}"

S="${WORKDIR}/git"

LIC_FILES_CHKSUM=" \
    file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
"

RDEPENDS:${PN} = " \
    kvantum \
"

do_install() {
    install -m 0755 -d ${D}${datadir}/color-schemes/
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Color Schemes'/* ${D}${datadir}/color-schemes/
    install -m 0755 -d ${D}${datadir}/plasma/look-and-feel
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Global Themes'/* ${D}${datadir}/plasma/look-and-feel/
    install -m 0755 -d ${D}${datadir}/icons
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Icons Themes'/* ${D}${datadir}/icons/
    install -m 0755 -d ${D}${datadir}/konsole
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Konsole Color Schemes'/* ${D}${datadir}/konsole/
    install -m 0755 -d ${D}${datadir}/Kvantum
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Kvantum Themes'/* ${D}${datadir}/Kvantum/
    install -m 0755 -d ${D}${datadir}/plasma/desktoptheme
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Plasma Themes'/* ${D}${datadir}/plasma/desktoptheme/
    install -m 0755 -d ${D}${datadir}/sddm/themes
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings SDDM Themes'/* ${D}${datadir}/sddm/themes/
    install -m 0755 -d ${D}${datadir}/wallpapers/Wings/
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Wallpapers'/* ${D}${datadir}/wallpapers/Wings/
    install -m 0755 -d ${D}${datadir}/aurorae/themes/
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Window Decorations'/* ${D}${datadir}/aurorae/themes/
    install -m 0755 -d ${D}${datadir}/wallpapers/WingsDark/contents/images/
    cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/metadata.json ${D}${datadir}/wallpapers/WingsDark/
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Wallpapers/Wings-Wallpaper-Without Plasma Logo.png' ${D}${datadir}/wallpapers/WingsDark/contents/images/2560x1600.jpg
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Wallpapers/Wings-Wallpaper-Without Plasma Logo.png' ${D}${datadir}/wallpapers/WingsDark/contents/preview.jpg
    install -d ${D}${sysconfdir}/skel/.config/Kvantum/Wings-Kvantum
    cp -R --no-dereference --preserve=mode,links -v ${S}/'Wings Kvantum Themes'/Wings-Kvantum/* ${D}${sysconfdir}/skel/.config/Kvantum/Wings-Kvantum/
    sed -i 's/Image=.*/Image=WingsDark/g' ${D}${datadir}/plasma/look-and-feel/Wings-Dark-Global/contents/defaults
}

FILES:${PN} = " \
    ${datadir}/plasma/desktoptheme \
    ${datadir}/wallpapers/Wings/ \
    ${datadir}/wallpapers/WingsDark/ \
    ${datadir}/aurorae/themes/ \
    ${datadir}/sddm/themes/ \
    ${datadir}/Kvantum/ \
    ${datadir}/konsole/ \
    ${datadir}/icons/ \
    ${datadir}/plasma/look-and-feel/ \
    ${datadir}/color-schemes/ \
    ${sysconfdir}/skel/.config/Kvantum/Wings-Kvantum \
"