SUMMARY = "A small commandline only image for Star64"

inherit core-image extrausers


IMAGE_INSTALL = "packagegroup-core-boot \
                packagegroup-core-full-cmdline \
                ${CORE_IMAGE_EXTRA_INSTALL} \
                packagegroup-star64-minimal \
                "

IMAGE_FEATURES += " splash \
                    package-management \
                    ssh-server-openssh \
"

IMAGE_VERSION_SUFFIX = "-${DISTRO_VERSION}"

LICENSE = "MIT"

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_FSTYPES = "wic.bz2 wic"

#password is "pine64"
PASSWD = "\$5\$svJwM1eWQPV5bb\$CgKgw8mrSVcZEBPR1re37qeShy/scdk5GMbKZaSln74"

EXTRA_USERS_PARAMS = "\
    useradd -p '${PASSWD}' pine64; \
    usermod -p '${PASSWD}' root; \
    "