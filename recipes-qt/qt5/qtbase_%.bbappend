PACKAGECONFIG:append:class-target = " \
    gles2 \
    sm \
    openssl \
    fontconfig \
    freetype \
    harfbuzz \
    sql-sqlite \
    zlib \
    jpeg \
    libpng \
    gif \
    dbus \
    udev \
    accessibility \
    cups \
    gbm \
    kms \
    eglfs \
"
#PACKAGECONFIG:remove = "tests"
OPENSSL_LINKING_MODE = "-linked"