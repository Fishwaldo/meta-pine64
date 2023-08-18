SECTION = "base"
DESCRIPTION = "IIO accelerometer sensor to input device proxy."

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
    git://gitlab.freedesktop.org/hadess/iio-sensor-proxy.git;branch=master;protocol=https \
"

SRCREV = "cd6d5e653ef33f6e824e2f7f2ee61e330d4932ac"

S = "${WORKDIR}/git"


inherit meson 
inherit gettext 
inherit pkgconfig 
inherit systemd 

DEPENDS = " \
    udev \
    systemd \
    libgudev \
    polkit \
"


#EXTRA_OEMESON = "--disable-gtk-doc --disable-gtk-tests"

FILES:${PN} += " \
    ${systemd_unitdir} \
    ${datadir}/polkit-1/actions/ \
"