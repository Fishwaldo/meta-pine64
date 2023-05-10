HOMEPAGE = "https://code.qt.io/cgit/qt/qtspeech.git/"
SUMMARY = "Qt Speech support "
DESCRIPTION = "Qt Speech support"


LICENSE = "GPL-2.0-only & LGPL-3.0-only & FDL"
LIC_FILES_CHKSUM = " \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
    file://LICENSE.GPLv2;md5=05832301944453ec79e40ba3c3cfceec \
    file://LICENSE.LGPLv3;md5=c4fe8c6de4eef597feec6e90ed62e962 \    
"

SRC_URI = " \
    git://code.qt.io/qt/qtspeech.git;protocol=https;branch=5.15 \
"
SRCREV="b2fdbe275f558893096356d152162df9f67cd22d"

S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

DEPENDS = " \
    qtbase \
    speechd \
"

FILES:${PN}-dev += " \
    ${libdir}/libQt5TextToSpeech.prl \
    ${libdir}/mkspecs/modules/ \
"