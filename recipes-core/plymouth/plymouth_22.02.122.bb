SUMMARY = "Plymouth is a project from Fedora providing a flicker-free graphical boot process."

DESCRIPTION = "Plymouth is an application that runs very early in the boot process \
    (even before the root filesystem is mounted!) that provides a \
    graphical boot animation while the boot process happens in the background. \
"

HOMEPAGE = "http://www.freedesktop.org/wiki/Software/Plymouth"
SECTION = "base"

LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "libcap libpng cairo dbus udev cantarell-fonts"
DEPENDS:append:libc-musl = " musl-rpmatch"
PROVIDES = "virtual/psplash"
RPROVIDES:${PN} = "virtual-psplash virtual-psplash-support"
RDEPENDS:${PN} += " cantarell-fonts"

SRC_URI = "http://www.freedesktop.org/software/plymouth/releases/${BPN}-${PV}.tar.xz \
           file://0001-Make-full-path-to-systemd-tty-ask-password-agent-con.patch \
           file://0001-plymouth-Add-the-retain-splash-option.patch \
           file://0001-ignore-serial-ports-whene-starting-plymouthd.patch \
           file://display-manager.conf \
           "

PR="r2"

SRC_URI[sha256sum] = "100551442221033ce868c447ad6c74d831d209c18ae232b98ae0207e34eadaeb"

EXTRA_OECONF += " --enable-shared --disable-static --disable-gtk --disable-documentation \
    --with-logo=${LOGO} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '--enable-systemd-integration --with-systemd-tty-ask-password-agent=${base_bindir}/systemd-tty-ask-password-agent', '--disable-systemd-integration', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'usrmerge','--without-system-root-install','--with-system-root-install',d)} \
"

PACKAGECONFIG ??= "pango initrd"
PACKAGECONFIG:append:x86 = " drm"
PACKAGECONFIG:append:x86-64 = " drm"
PACKAGECONFIG:append:jh7110 = " drm"
PACKAGECONFIG:remove:jh7110 = "initrd"

PACKAGECONFIG[drm] = "--enable-drm,--disable-drm,libdrm"
PACKAGECONFIG[pango] = "--enable-pango,--disable-pango,pango"
PACKAGECONFIG[gtk] = "--enable-gtk,--disable-gtk,gtk+3"
PACKAGECONFIG[initrd] = ",,,"

LOGO ??= "${datadir}/plymouth/bizcom.png"

inherit autotools pkgconfig systemd gettext

LDFLAGS:append:libc-musl = " -lrpmatch"

do_install:append() {
    # Remove /var/run from package as plymouth will populate it on startup
    rm -fr "${D}${localstatedir}/run"

    if ! ${@bb.utils.contains('PACKAGECONFIG', 'initrd', 'true', 'false', d)}; then
        rm -rf "${D}${libexecdir}"
    fi
}

do_install:append:jh7110() {
    install -d ${D}${sysconfdir}/systemd/system/display-manager.service.d
    install -m 0644 ${WORKDIR}/display-manager.conf ${D}${sysconfdir}/systemd/system/display-manager.service.d
}

PACKAGES =. "${@bb.utils.contains('PACKAGECONFIG', 'initrd', '${PN}-initrd ', '', d)}"
PACKAGES =+ "${PN}-set-default-theme"

FILES:${PN}-initrd = "${libexecdir}/plymouth/*"
FILES:${PN}-set-default-theme = "${sbindir}/plymouth-set-default-theme"

FILES:${PN} += "${systemd_unitdir}/system/*"
CONFFILES:${PN} += "${sysconfdir}/plymouth/plymouthd.conf"
FILES:${PN}-dbg += "${libdir}/plymouth/renderers/.debug"


RDEPENDS:${PN}-initrd = "bash dracut"
RDEPENDS:${PN}-set-default-theme = "bash"

SYSTEMD_SERVICE:${PN} = "plymouth-start.service"

pkg_postinst_ontarget:${PN}() {
    if [ -f /boot/uEnv.txt ]; then 
        if [ $(grep -c "rootwait splash quiet" /boot/uEnv.txt) -eq 0 ]; then
            sed -i 's/rootwait/rootwait splash quiet/g' /boot/uEnv.txt
        fi
    fi
    if [ -f /boot/vf5_uEnv.txt ]; then 
        if [ $(grep -c "rootwait splash quiet" /boot/vf5_uEnv.txt) -eq 0 ]; then
            sed -i 's/rootwait/rootwait splash quiet/g' /boot/vf5_uEnv.txt
        fi
    fi
}


RREPLACES:${PN} += " \
    psplash \
"
RCONFLICTS:${PN} += " \
    psplash \
"