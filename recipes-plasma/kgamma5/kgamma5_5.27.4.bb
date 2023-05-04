# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Adjust your monitor's gamma settings"
SUMMARY = "Adjust your monitor's gamma settings"
HOMEPAGE = "https://invent.kde.org/plasma/kgamma5"
LICENSE = "CC0-1.0 & GPL-2.0-or-later "

SRC_URI += " \
   https://download.kde.org/stable/plasma/5.27.4/kgamma5-5.27.4.tar.xz \
"
SRC_URI[sha256sum] = "4a81c50b7f96b5a6f0e60b58a1d38fc375f445595e2e349e692d4c40d8355802"

inherit cmake_plasma
inherit ki18n
inherit kconfig
inherit reuse_license_checksums
inherit kdoctools  

DEPENDS = " \
"

do_install:append() {
    # Remove the symlink .so files
    rm -f ${D}${libdir}/plugins/plasma/kcminit/kcm_kgamma_init.so 
    install ${D}${libdir}/plugins/plasma/kcms/systemsettings/kcm_kgamma.so ${D}${libdir}/plugins/plasma/kcminit/kcm_kgamma_init.so 
}

KF5_REUSE_LICENSECHECK_ENABLED="1"

FILES:${PN} += " \
    ${datadir}/kgamma/pics/ \
    ${libdir}/plugins/plasma/ \
"
