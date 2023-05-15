KERNEL_SPLIT_MODULES = "0"

KERNEL_PRIORITY ?= "${@int(d.getVar('PV',1).split('-')[0].split('+')[0].split('.')[0]) * 10000 + \
                       int(d.getVar('PV',1).split('-')[0].split('+')[0].split('.')[1]) * 100 + \
                       int(d.getVar('PV',1).split('-')[0].split('+')[0].split('.')[-1])}"

pkg_postinst_ontarget:kernel-image-fitimage () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel:kernel-image-fitimage () {
	update-alternatives --remove ${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE}-${KERNEL_VERSION} || true
}
