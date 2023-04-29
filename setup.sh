#!/bin/sh

#Simple Setup Script for PinIx Yocto Builds

if [ ! -f $(pwd)/poky/oe-init-build-env ]; then
	echo "Error: Build Repo Layout Invalid"
	echo "Please check the Readme"
	return 1
fi

if [ ! -f $(pwd)/meta-pine64/conf/templates/pinix/local.conf.sample ]; then
	echo "Error: Can't Find pinix configuration templates"
	return 1
fi
	

TEMPLATECONF=$(pwd)/meta-pine64/conf/templates/pinix . poky/oe-init-build-env $1
