FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:jh7110 = "\
    file://0002-add-Starfive-OMX-patches.patch \
"
#file://0001-fix-chromium.patch
 

EXTRA_OECONF:append = " \
    --enable-omx \
    --cpu="rv64imafd" \
    --extra-libs="-lOMX_Core" \
    --extra-cflags="-I${STAGING_DIR_TARGET}/usr/include/khronos/" \
    --enable-ffplay \
"

PACKAGECONFIG:append = " \
    openssl \
    vaapi \
    bzlib \
    libopus \
    libvorbis \
    lzma \
    openssl \
    theora \
    vdpau \
    x264 \
    gpl \
    sdl2 \   
"

DEPENDS:append = " \
    libsf-omxil \
" 

#./configure --enable-nonfree --disable-static --enable-alsa --disable-altivec --enable-avcodec --enable-avdevice --enable-avfilter --enable-avformat --enable-bzlib --disable-libfdk-aac --disable-libgsm --disable-indev=jack --disable-libopus --disable-libvorbis --enable-lzma --disable-libmfx --disable-mipsdsp --disable-mipsdspr2 --disable-libmp3lame --enable-openssl --enable-pic --enable-postproc --enable-pthreads --enable-sdl2 --enable-shared --disable-libspeex --disable-libsrt --disable-stripping --enable-swresample --enable-swscale --enable-libtheora --enable-vaapi --enable-vdpau --disable-libvpx --enable-libx264 --disable-libx265 --enable-libxcb --enable-outdev=xv --enable-zlib --enable-omx --prefix=$CURDIR/target/usr  --arch="riscv64" --target-os="linux" --extra-cflags="-I/usr/include/khronos/" --enable-gpl --extra-libs="-lOMX_Core" --enable-ffplay