# SPDX-FileCopyrightText: 2023 Justin Hammond <justin@dynam.ac>
#
# SPDX-License-Identifier: MIT


#The Cmake files include the sysroot directory to pipewire and spa, delete the actual sysroot from the path. 
do_install:prepend:class-target() {
    if [ "0" -ne $(find . -name \*.cmake | grep '_usr\|Export' | wc -l) ]; then
        echo sed -i 's#'${RECIPE_SYSROOT}/usr'#\$\{_IMPORT_PREFIX\}#g' $(find . -name "*.cmake" | grep '_usr\|Export' )
        sed -i 's#'${RECIPE_SYSROOT}/usr'#\$\{_IMPORT_PREFIX\}#g' $(find . -name "*.cmake" | grep '_usr\|Export' )
    fi
}
