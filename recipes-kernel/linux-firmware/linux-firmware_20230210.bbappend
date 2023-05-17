PACKAGES =+ " \
    ${PN}-rtl8852 \
"

LICENSE:${PN}-rtl8852 = "Firmware-rtlwifi_firmware"

FILES:${PN}-rtl8852 = " \
  ${nonarch_base_libdir}/firmware/rtl_bt/rtl8852*.bin \
"

RDEPENDS:${PN}-rtl8852 += "${PN}-rtl-license"