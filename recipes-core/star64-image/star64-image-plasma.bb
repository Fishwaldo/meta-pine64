SUMMARY = "A small weston gtk3 demo image for Star64"

require star64-image-minimal.bb


IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston"

LICENSE = "MIT"


IMAGE_INSTALL += " wayland \
                   weston \
                   dbus \
                   sddm \
                   sddm-config-plasma-bigscreen \
                   packagegroup-plasma-bigscreen-workspace \
                   packagegroup-core-x11-utils \
                   systemd \                    
"
