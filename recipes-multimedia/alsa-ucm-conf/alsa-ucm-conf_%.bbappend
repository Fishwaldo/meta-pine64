FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:pinetabv = "\
    file://es8316.conf \
    file://HiFi.conf \
    file://asound.conf \
"

do_install:append:pinetabv() {
    install -d ${D}${datadir}/alsa/ucm2/Pine64/PineTabV
    install -m 0644 ${WORKDIR}/es8316.conf ${D}${datadir}/alsa/ucm2/Pine64/PineTabV/es8316.conf
    install -m 0644 ${WORKDIR}/HiFi.conf ${D}${datadir}/alsa/ucm2/Pine64/PineTabV/HiFi.conf
    install -d ${D}${datadir}/alsa/ucm2/conf.d/simple-card
    cd ${D}${datadir}/alsa/ucm2/conf.d/simple-card
    ln -s ../../Pine64/PineTabV/es8316.conf Pine64,PineTabV.conf
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/asound.conf ${D}${sysconfdir}/asound.conf
}

