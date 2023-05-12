DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://doc/readme.html;beginline=307;endline=330;md5=9385b9b86b20cc4490b6c53968f91eec"
HOMEPAGE = "http://www.lua.org/"

SRC_URI = "http://www.lua.org/ftp/lua-${PV}.tar.gz \
           file://lua52.pc.in \
           "
S= "${WORKDIR}/lua-${PV}"
V = "5.2"

SRC_URI[sha256sum] = "b9e2e4aad6789b3b63a056d442f7b39f0ecfca3ae0f1fc0ae4e9614401b69f4b"

inherit pkgconfig binconfig

TARGET_CC_ARCH += " -fPIC ${LDFLAGS}"
EXTRA_OEMAKE = "'CC=${CC} -fPIC' 'MYCFLAGS=${CFLAGS} -fPIC' MYLDFLAGS='${LDFLAGS}' 'AR=ar rcD' 'RANLIB=ranlib -D'"

DEPENDS += " \
    readline \
"

do_configure:prepend() {
    sed -i -e s:/usr/local:${prefix}:g src/luaconf.h
    sed -i -e s:lib/lua/:${baselib}/lua/:g src/luaconf.h
}

do_compile () {
    oe_runmake linux
}

do_install () {
    oe_runmake \
        'INSTALL_TOP=${D}${prefix}' \
        'INSTALL_BIN=${D}${bindir}' \
        'INSTALL_INC=${D}${includedir}/${BPN}' \
        'INSTALL_MAN=${D}${mandir}/man1' \
        'INSTALL_SHARE=${D}${datadir}/lua' \
        'INSTALL_LIB=${D}${libdir}' \
        'INSTALL_CMOD=${D}${libdir}/lua/${V}' \
        install
    install -d ${D}${libdir}/pkgconfig

    sed -e s/@VERSION@/${PV}/ -e s#@LIBDIR@#${libdir}# -e s#@INCLUDEDIR@#${includedir}# ${WORKDIR}/lua52.pc.in > ${WORKDIR}/lua52.pc
    install -m 0644 ${WORKDIR}/lua52.pc ${D}${libdir}/pkgconfig/
    mv ${D}${bindir}/lua ${D}${bindir}/lua${V}
    mv ${D}${bindir}/luac ${D}${bindir}/luac${V}
    mv ${D}${libdir}/liblua.a ${D}${libdir}/lib${BPN}.a
    rmdir ${D}${datadir}/lua/5.2
    rmdir ${D}${datadir}/lua
}

FILES:${PN} += " \
    ${libdir}/lua/5.2 \
    ${libdir}/lib${BPN}.a \
"


BBCLASSEXTEND = "native nativesdk"

ALTERNATIVE_TARGET[lua] = "${bindir}/lua${V}"
ALTERNATIVE_TARGET[luac] = "${bindir}/luac${V}"