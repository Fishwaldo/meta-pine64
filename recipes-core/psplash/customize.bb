SUMMARY = "A psplash customization recipe"
DESCRIPTION ="This recipe allows personalization of pshlash colors and image"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0"

# Logo image file name as in /files folder
SPLASH_IMAGE_NAME = "logo.png"

# Color values in R,G,B format "0x00,0x00, 0x00"
BACKGROUND_COLOR = "0xff,0xff,0xff"
TEXT_COLOR  = "0xff,0x00,0x00"
BAR_COLOR = "0x6d,0x6d,0x70"
BAR_BACKGROUND_COLOR = "0xff,0xff,0xff"

# Overide MACHINE_PSPLASH_PKG name
# add you own override if misssing
MACHINE_PSPLASH_PKG:qemuall = "default"
MACHINE_PSPLASH_PKG:qemux86-64 = "default"
MACHINE_PSPLASH_PKG:rpi = "raspberrypi"
