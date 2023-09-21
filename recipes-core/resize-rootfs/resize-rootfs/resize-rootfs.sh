#!/bin/sh
root=$(eval $(lsblk -oMOUNTPOINT,NAME -P -M | grep 'MOUNTPOINT="/"'); echo $NAME)
if [[ "$root" == *"mmcblk"* ]]; then
    echo "Resizing $root partition to fill SD Card..."
    plymouth display-message --text="Resizing $root partition to fill SD Card..." || true
    sgdisk -e /dev/${root:0:-2} || true
    plymouth display-message --text="Resizing $root partition to fill SD Card....." || true
    partprobe || true
    plymouth display-message --text="Resizing $root partition to fill SD Card......." || true
    echo yes  | parted ---pretend-input-tty /dev/${root:0:-2} resizepart ${root:0-1} 100% || true
    plymouth display-message --text="Resizing $root partition to fill SD Card........." || true
    partprobe || true
    plymouth display-message --text="Resizing $root partition to fill SD Card........." || true
    resize2fs /dev/$root || true
    plymouth display-message --text="Resizing $root partition to fill SD Card...........Done!" || true
    touch /etc/.rootfsresized || true
    echo "Resize $root done!"
fi
