SUMMARY = "dot.conf configuration file parser "
HOMEPAGE = "https://github.com/williamh/dotconf"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=155b66f2dc258f05886f9886a60fd870 \
    "

SRC_URI = "git://github.com/williamh/dotconf.git;branch=master;protocol=https \
           "
SRCREV = "4cd7b3a6e89b7f1269851caea8374a8f137ea1c0"
S = "${WORKDIR}/git"

inherit pkgconfig
inherit autotools


