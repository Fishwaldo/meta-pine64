FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append:riscv64 = " \
    file://0001-add-libatomic-for-help-plugin-on-riscv.patch \
"