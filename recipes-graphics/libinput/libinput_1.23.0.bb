SUMMARY = "Library to handle input devices in Wayland compositors"
DESCRIPTION = "libinput is a library to handle input devices in Wayland \
compositors and to provide a generic X.Org input driver. It provides \
device detection, device handling, input device event processing and \
abstraction so minimize the amount of custom input code compositors need to \
provide the common set of functionality that users expect."
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/libinput/"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bab4ac7dc1c10bc0fb037dc76c46ef8a"

DEPENDS = "libevdev udev mtdev libcheck"

SRC_URI = "git://gitlab.freedesktop.org/libinput/libinput.git;protocol=https;branch=main \
        file://50-system-pinetab.quirks \
"

SRCREV = "0b005eb64b12603e65a620a77c67ec62fd03f413"
S = "${WORKDIR}/git"

UPSTREAM_CHECK_REGEX = "libinput-(?P<pver>\d+\.\d+\.(?!9\d+)\d+)"

inherit meson pkgconfig lib_package ptest

# Patch out build directory, otherwise it leaks into ptest binary
do_configure:append() {
    sed -i -e "s,${WORKDIR},,g" config.h
    if [ -e "litest-config.h" ]; then
        sed -i -e "s,${WORKDIR},,g" litest-config.h
    fi
}

PACKAGECONFIG ??= ""
PACKAGECONFIG[libwacom] = "-Dlibwacom=true,-Dlibwacom=false,libwacom"
PACKAGECONFIG[gui] = "-Ddebug-gui=true,-Ddebug-gui=false,cairo gtk+3"

UDEVDIR = "`pkg-config --variable=udevdir udev`"

EXTRA_OEMESON += "-Dudev-dir=${UDEVDIR} \
                  -Ddocumentation=false \
                  ${@bb.utils.contains('PTEST_ENABLED', '1', '-Dtests=true -Dinstall-tests=true', '-Dtests=false -Dinstall-tests=false', d)} \
                  -Dzshcompletiondir=no"

do_install:append() {
    install -m 0644 ${WORKDIR}/50-system-pinetab.quirks ${D}${datadir}/libinput/
}

# package name changed in 1.8.1 upgrade: make sure package upgrades work
RPROVIDES:${PN} = "libinput"
RREPLACES:${PN} = "libinput"
RCONFLICTS:${PN} = "libinput"

FILES:${PN}-ptest += "${libexecdir}/libinput/libinput-test-suite"