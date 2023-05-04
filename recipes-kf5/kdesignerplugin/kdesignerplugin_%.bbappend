do_install:append:class-target() {
    if [ "0" -ne $(find . -name \*.cmake | grep '_usr\|Export' | grep 'noconfig' | wc -l) ]; then
        echo sed -i 's#'\$\{_IMPORT_PREFIX\}'#\$\{OE_KF5_PATH_HOST_ROOT\}/usr/#g' $(find . -name "*.cmake" | grep '_usr\|Export' | grep 'noconfig' )
        sed -i 's#'\$\{_IMPORT_PREFIX\}'#\$\{OE_KF5_PATH_HOST_ROOT\}/usr/#g' $(find . -name "*.cmake" | grep '_usr\|Export' | grep 'noconfig' )
    fi
}

RDEPENDS:${PN}:class-native += " \
    kconfig \
    kcoreaddons \
"
