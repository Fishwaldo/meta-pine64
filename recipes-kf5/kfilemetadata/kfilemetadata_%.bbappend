inherit kconfig

DEPENDS += " \
    libkexiv2 \
    ffmpeg \
    poppler \
    taglib \
"

FILES:${PN} += " \
    ${libdir}/plugins/kf5/kfilemetadata/writers/ \
"