SUMMARY    = "Firefox add on to enable youtube to only stream h264 videos"
HOMEPAGE   = "https://addons.mozilla.org/en-US/firefox/addon/refined-h264ify/"
BUGTRACKER = "https://github.com/Edwin-Zarco/refined-h264ify/issues"
AUTHOR     = "George Kiagiadakis <george.kiagiadakis@collabora.com> "
SECTION    = "multimedia"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b869bd8ff2aed59c62bad2a22a821"


SRC_URI = " \
    https://addons.mozilla.org/firefox/downloads/file/4109282/refined_h264ify-3.1.0.xpi;name=extension \
    https://raw.githubusercontent.com/Edwin-Zarco/refined-h264ify/master/LICENSE;name=license \
"
SRC_URI[extension.sha256sum] = "433c3d67e3d0d7d7fd4584cd049105d19daa7a47763b6a6f1a28e3697390ce4a"
SRC_URI[license.sha256sum] = "7c34d28e784b202aa4998f477fd0aa9773146952d7f6fa5971369fcdda59cf48"

S="${WORKDIR}"

do_install() {
    install -d ${D}${libdir}/firefox/distribution/extensions
    install -m 0644 ${WORKDIR}/refined_h264ify-3.1.0.xpi ${D}${libdir}/firefox/distribution/extensions/{ea422457-9756-4444-83f8-8e8d0f29d59c}.xpi
}

FILES:${PN} += " \
    ${libdir}/firefox/distribution/extensions \
"