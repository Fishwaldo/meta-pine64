FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:riscv64 = "\
            file://0001-add-riscv64-support.patch \
            file://0002-don-t-try-to-link-gn-statically.patch \
            file://0003-add-riscv64-support-chromium.patch;patchdir=src/3rdparty \
            file://0004-add-riscv64-sandbox-support-chromium.patch;patchdir=src/3rdparty \
            file://0005-add-risc64-crashpad-support-chromium.patch;patchdir=src/3rdparty \
            file://0006-add-risc64-breakpad-support-chromium.patch;patchdir=src/3rdparty \
            file://0007-riscv64-add-support-to-chromium-v8.patch;patchdir=src/3rdparty \
            file://0008-some-fixes-for-external-ffmpeg-and-riscv64-builds.patch;patchdir=src/3rdparty \
            file://0009-fix-riscv64-build.patch;patchdir=src/3rdparty \
"

PACKAGECONFIG:append = " icu ffmpeg harfbuzz opus libwebp libvpx libevent libpng glib zlib pulseaudio"

#due to broken pkgconfig detection in v8/chromium, it searches the host sysroot and not the target sysroot. Ugly hack.
DEPENDS:append:riscv64 = " libwebp-native harfbuzz-native"

COMPATIBLE_MACHINE:riscv64 = "(jh7110)"

PARALLEL_MAKE:pn-qtwebengine = "-j 10"
