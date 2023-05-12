PACKAGECONFIG:append = " \
    wireplumber \
    pipewire-alsa \
"
PACKAGECONFIG:remove = " \
    systemd-system-service \
"

pkg_postinst_ontarget:${PN}() {
    systemctl --global enable pipewire-pulse.socket pipewire.socket
}