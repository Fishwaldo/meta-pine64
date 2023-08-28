#needed by libreoffice, but the included recipe is pointing to a non-existant download (0.3.21)

SUMMARY = "A library for import of many old Mac document formats"
HOMEPAGE = "http://sourceforge.net/projects/libmwaw"
LICENSE = " LGPL-2.1-only & MPL-2.0"
LIC_FILES_CHKSUM = " \
    file://COPYING.LGPL;md5=a049c5e22d3bd7bc3c9a2e9135a6d104 \
    file://COPYING.MPL;md5=cce0d89a18de69e7f51f693182ac4a3e \
"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${BPN}-${PV}/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "fea4773ff24344814c7501a4b5fc3beecd94d25c180f812330e0974cab941235"

inherit autotools-brokensep pkgconfig

DEPENDS = "librevenge"
