#cmake files include sysroot paths
inherit cmake_sysroot

DEPENDS:append = " \
    qtwebengine \
    libcap \
"