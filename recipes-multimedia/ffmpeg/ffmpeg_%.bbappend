FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:riscv64 = "\
    file://0001-fix-chromium.patch \
"