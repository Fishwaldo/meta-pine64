do_copy_rustlib() {
    # we need to copy the riscv64gc-unknown-linux-gnu sysroot to the
    # the native sysroot so rust can pick it up
    cp -r ${STAGING_DIR_HOST}/usr/lib/rustlib/riscv64gc-* ${STAGING_DIR_NATIVE}/usr/lib/rustlib/
}

addtask copy_rustlib before do_configure after do_patch do_prepare_recipe_sysroot

do_configure() {
    cd ${B}
    python3 ${S}/configure.py \
        --enable-project=js \
        --target=${RUST_HOST_SYS} \
        --host=${BUILD_SYS} \
        --prefix=${prefix} \
        --libdir=${libdir} \
        --disable-jemalloc \
        --disable-strip \
        ${JIT} \
        ${ICU}
}