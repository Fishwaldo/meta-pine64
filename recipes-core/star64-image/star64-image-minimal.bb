SUMMARY = "A small commandline only image for Star64"

inherit core-image extrausers

P64_PACKAGES_MINIMAL = "resize-rootfs \
                        mc \
                        joe \
                        ca-certificates \
                        networkmanager \
                        wpa-supplicant \
                        avahi-daemon \
                        networkmanager-nmtui \
                        "

IMAGE_INSTALL = "packagegroup-core-boot \
                packagegroup-core-full-cmdline \
                ${CORE_IMAGE_EXTRA_INSTALL} \
                ${P64_PACKAGES_MINIMAL} \
                "

IMAGE_FEATURES += " splash \
                    package-management \
"

IMAGE_VERSION_SUFFIX = "-${DISTRO_VERSION}"

LICENSE = "MIT"

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_FSTYPES = "wic.bz2"

#password is "pine64"
PASSWD = "\$5\$svJwM1eWQPV5bb\$CgKgw8mrSVcZEBPR1re37qeShy/scdk5GMbKZaSln74"

EXTRA_USERS_PARAMS = "\
    useradd -p '${PASSWD}' pine64; \
    usermod -p '${PASSWD}' root; \
    "