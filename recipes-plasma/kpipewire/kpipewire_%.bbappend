SRC_URI:append:jh7110 = " \
    file://0001-Use-VisionFive2-specific-MESA-Fork.patch \
"

#The Cmake files include the sysroot directory to pipewire and spa, delete the actual sysroot from the path. 
inherit cmake_sysroot
