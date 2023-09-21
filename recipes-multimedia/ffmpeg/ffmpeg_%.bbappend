FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:jh7110 = "\
    file://0002-add-Starfive-OMX-patches.patch \
    file://0001-FFmpeg-omxdec-optimize-with-omx-zero-copy-feature.patch \
    file://0002-FFmpeg-omxdec-add-output-buffers-release-callback-to.patch \
    file://0003-FFmpeg-Omxdec-Fix-omx-decoder-fill-frames-pts-incorr.patch \
    file://0004-FFmpeg-Omxdec-Fix-mjpg_omx-buffer-err.patch \
    file://0005-FFmpeg-Omxdec-Add-flush-callback-of-sf-omx-decoder.patch \
    file://0006-FFmpeg-Omxdec-Remove-the-global-variables-in-omxdec.patch \
    file://0007-FFmpeg-Omxdec-no-longer-send-eos-when-processing-zer.patch \
    file://0008-FFmpeg-Omxdec-optimize-buffer-method-for-mjpg-decode.patch \
"

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