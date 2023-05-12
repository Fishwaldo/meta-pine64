SUMMARY = "Common high-level interface to speech synthesis"
HOMEPAGE = "https://freebsoft.org/speechd"
LICENSE = "GPL-2.0-only & GPL-3.0-only & LGPL-2.1-only"
LIC_FILES_CHKSUM = " \
    file://COPYING.GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.GPL-3;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
    "

SRC_URI = "git://github.com/brailcom/speechd.git;branch=speech-dispatcher-0-11;protocol=https \
           file://0001-fix-include-paths-and-disable-NAS.patch \
           "
SRCREV = "4a1203287ba0a1ff9e9164ec06a19c9b3be53d8f"
S = "${WORKDIR}/git"

inherit pkgconfig
inherit autotools-brokensep
inherit gettext 

DEPENDS = " \
    glib-2.0 \
    libdotconf \
    libsndfile1 \
    systemd \
    pipewire \
"

FILES:${PN} += " \
    ${datadir}/speech-dispatcher \
    ${libdir}/python3.11/site-packages \
    ${libdir}/speech-dispatcher \
    ${systemd_system_unitdir}/speech-dispatcherd.service \
"
INSANE_SKIP:${PN} = "file-rdeps"