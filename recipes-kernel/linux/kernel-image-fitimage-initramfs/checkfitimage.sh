#!/bin/sh
cd /boot/
CURVER=`dumpimage -l fitImage | grep "FIT description" | grep -Eo '[0-9]+\.[0-9]+\.[0-9]+'`
LATEST=`ls fitImage-initramfs-* | awk -F"-" '{ print $3 }' | sort -t '.' -k 1,1 -k 2,2 -k 3,3 -g | tail -n 1`
echo "Current Version is '$CURVER'"
echo "Latest Version is '$LATEST'"
cp fitImage-initramfs-$LATEST fitImage
