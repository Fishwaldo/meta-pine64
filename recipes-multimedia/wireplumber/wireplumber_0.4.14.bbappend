PACKAGECONFIG:append = " \
    systemd-user-service \
"
PACKAGECONFIG:remove = " \
    systemd-system-service \
"

pkg_postinst_ontarget:${PN}() {
    systemctl --global add-wants pipewire.service wireplumber.service
}