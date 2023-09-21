# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT

DESCRIPTION = "Wings Themes For Plasma Desktop"
SUMMARY = "Wings Themes For Plasma Desktop"
HOMEPAGE = "https://github.com/L4ki/Wings-Plasma-Themes"
LICENSE = "GPL-3.0-only "

SRC_URI += " \
   git://github.com/adi1090x/plymouth-themes.git;protocol=https;branch=master \
"
SRCREV="5d8817458d764bff4ff9daae94cf1bbaabf16ede"

S="${WORKDIR}/git"

LIC_FILES_CHKSUM=" \
    file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
"

inherit allarch

RDEPENDS:${PN} = " \
    plymouth \
"

do_install() {
    install -m 0755 -d ${D}${datadir}/plymouth/themes
    cp -R --no-dereference --preserve=mode,links -v ${S}/pack_1/* ${D}${datadir}/plymouth/themes/
    cp -R --no-dereference --preserve=mode,links -v ${S}/pack_2/* ${D}${datadir}/plymouth/themes/
    cp -R --no-dereference --preserve=mode,links -v ${S}/pack_3/* ${D}${datadir}/plymouth/themes/
    cp -R --no-dereference --preserve=mode,links -v ${S}/pack_4/* ${D}${datadir}/plymouth/themes/
}

pkg_postinst:${PN}() {
    sed -i 's/Theme=spinner/Theme=pixels/g' $D/${datadir}/plymouth/plymouthd.defaults
}


FILES:${PN} = " \
    ${datadir}/plymouth/themes \
"

