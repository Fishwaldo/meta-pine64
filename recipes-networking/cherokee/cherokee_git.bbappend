FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-fix-configure.ac-calling-AM_INIT_AUTOMAKE-twice.patch \
"

INSANE_SKIP:${PN} = "empty-dirs"