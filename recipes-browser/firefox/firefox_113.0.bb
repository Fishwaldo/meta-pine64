SUMMARY = "SpiderMonkey is Mozilla's JavaScript engine written in C/C++"
HOMEPAGE = "https://developer.mozilla.org/en-US/docs/Mozilla/Projects/SpiderMonkey"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc9b6ecd19a14a54a628edaaf23733bf"

SRC_URI = "https://archive.mozilla.org/pub/firefox/releases/${PV}esr/source/firefox-${PV}.source.tar.xz \
           file://0001-Cargo.toml-do-not-abort-on-panic.patch \
           file://0003-rust.configure-do-not-try-to-find-a-suitable-upstrea.patch \
           file://0004-use-asm-sgidefs.h.patch \
           file://fix-musl-build.patch \
           file://0001-util.configure-fix-one-occasionally-reproduced-confi.patch \
           file://0001-rewrite-cargo-host-linker-in-python3.patch \
           file://mozconfig \
           file://0001-do-not-use-config.sub-target-sys.patch \
           file://webrtc-riscv64.patch \
           file://0001-Update-some-prefs.patch \
           file://vendor.js \
           file://firefox.sh \
           file://0007-force-useGLes-for-riscv64.patch \
           file://mozilla-firefox.desktop \
           file://mozilla-firefox.png \  
           "

SRC_URI[sha256sum] = "7a266044cb9d0c63079b3453507ea0c80a23389f4cbf6a4f6fd15146c6072627"

S = "${WORKDIR}/firefox-${@d.getVar("PV").replace("esr", "")}"

inherit pkgconfig 
inherit perlnative 
inherit python3native 
inherit rust-common

TOOLCHAIN:pn-firefox = "clang"

DEPENDS += " \
    zlib \
    cargo-native \
    python3 \
    curl \
    startup-notification \
    libevent \
    cairo \
    libnotify \
    virtual/libgl \
    pulseaudio \
    dbus-glib \
    nodejs-native \
    cbindgen-native \
    yasm-native \
    nasm-native \
    unzip-native \
    gtk+3 \
    libstd-rs \
    gnu-config-native \
    virtual/libintl \
    libxt \
    libxi \
    zip-native \
    gtk+ \
    libvpx \
"

B = "${WORKDIR}/build"

DISABLE_STATIC=""

PACKAGECONFIG ??= "${@bb.utils.contains("DISTRO_FEATURES", "alsa", "alsa", "", d)} \
                   ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "wayland", "", d)} \
                   ${@bb.utils.contains_any("TARGET_ARCH", "x86_64 arm aarch64 riscv64", "webrtc", "", d)} \
"
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[wayland] = "--enable-default-toolkit=cairo-gtk3-wayland,--enable-default-toolkit=cairo-gtk3,virtual/egl,"
PACKAGECONFIG[openmax] = "--enable-openmax,,,"
PACKAGECONFIG[webrtc] = "--enable-webrtc,--disable-webrtc,,"

SELECTED_OPTIMIZATION = "-Os -fsigned-char -fno-strict-aliasing"

export HOST_CC = "${BUILD_CC}"
export HOST_CXX = "${BUILD_CXX}"
export HOST_CFLAGS = "${BUILD_CFLAGS}"
export HOST_CPPFLAGS = "${BUILD_CPPFLAGS}"
export HOST_CXXFLAGS = "${BUILD_CXXFLAGS}"

export AS = "${CC}"

export MOZCONFIG = "${B}/mozconfig"

export RUSTFLAGS

#CLEANBROKEN = "1"

do_copy_rustlib() {
    # we need to copy the riscv64gc-unknown-linux-gnu sysroot to the
    # the native sysroot so rust can pick it up
    cp -r ${STAGING_DIR_HOST}/usr/lib/rustlib/riscv64gc-* ${STAGING_DIR_NATIVE}/usr/lib/rustlib/
}

addtask copy_rustlib before do_configure after do_patch do_prepare_recipe_sysroot


do_configure() {
	install -D -m 0644 ${WORKDIR}/mozconfig ${MOZCONFIG}
	if [ ! -z "${EXTRA_OECONF}" ] ; then
		for f in ${EXTRA_OECONF}
		do
			echo ac_add_options $f >> ${MOZCONFIG}
		done
	fi
	if [ ! -z "${PACKAGECONFIG_CONFARGS}" ] ; then
		for f in ${PACKAGECONFIG_CONFARGS}
		do
			echo ac_add_options $f >> ${MOZCONFIG}
		done
	fi
	echo ac_add_options --enable-optimize=\"${SELECTED_OPTIMIZATION}\" \
		>> ${MOZCONFIG}

    cd ${B}

    python3 ${S}/configure.py \
        --enable-project=browser \
        --target=${RUST_HOST_SYS} \
        --host=${BUILD_SYS} \
        --prefix=${prefix} \
        --libdir=${libdir} \
        --disable-jemalloc \
        --disable-strip \
        --without-wasm-sandboxed-libraries \
        --disable-updater \
        --enable-jit 
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install
    
    install -d ${D}${datadir}/applications
    install -d ${D}${datadir}/pixmaps

    install -m 0644 ${WORKDIR}/mozilla-firefox.desktop ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/mozilla-firefox.png ${D}${datadir}/pixmaps/

    install -m 0644 ${WORKDIR}/vendor.js ${D}${libdir}/${PN}/defaults/pref/vendor.js
    install -m 0644 -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/firefox.sh ${D}${sysconfdir}/profile.d/firefox.sh

    chown root:root -R ${D}${libdir}
}

