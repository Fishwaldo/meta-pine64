require ${PN}.inc
SRC_URI += " \
    git://invent.kde.org/network/konqueror.git;protocol=https;branch=release/23.04 \
    file://0001-Fix-linking-with-QtPrintSupport.patch \
"
SRCREV = "fac551bcfbf8cc75c11f994b6f920f1273094461"
