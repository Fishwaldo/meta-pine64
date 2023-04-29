SRC_URI:append:jh7110 = " \
    file://0001-Use-VisionFive2-specific-MESA-Fork.patch \
"

#The Cmake files include the sysroot directory to pipewire and spa, delete the actual sysroot from the path. 
do_install:prepend() {
    if [ "0" -ne $(find . -name \*.cmake | grep '_usr\|Export' | wc -l) ]; then
        echo sed -i 's#'${RECIPE_SYSROOT}/usr'#\$\{_IMPORT_PREFIX\}#g' $(find . -name "*.cmake" | grep '_usr\|Export' )
        sed -i 's#'${RECIPE_SYSROOT}/usr'#\$\{_IMPORT_PREFIX\}#g' $(find . -name "*.cmake" | grep '_usr\|Export' )
    fi
}