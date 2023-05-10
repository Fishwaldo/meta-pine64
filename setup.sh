#!/bin/bash

#Simple Setup Script for PinIx Yocto Builds

if [ -n "$BASH_SOURCE" ]; then
    THIS_SCRIPT=$BASH_SOURCE
elif [ -n "$ZSH_NAME" ]; then
    THIS_SCRIPT=$0
else
    THIS_SCRIPT="$(pwd)/setup.sh"
    if [ ! -e "$THIS_SCRIPT" ]; then
        echo "Error: $THIS_SCRIPT doesn't exist!" >&2
        echo "Please run this script in oe-init-build-env's directory." >&2
        exit 1
    fi
fi

if [ -z "$ZSH_NAME" ] && [ "$0" = "$THIS_SCRIPT" ]; then
    echo "Error: This script needs to be sourced. Please run as '. $THIS_SCRIPT'" >&2
    exit 1
fi

echo "Setting up PinIx Yocto Build"

declare -A layers
layers['poky']='git://git.yoctoproject.org/poky|kirkstone|4cc0e9438b450b43749730e128b6b9adb30f9663'
layers['meta-openembedded']='https://github.com/openembedded/meta-openembedded|kirkstone|571e36e20e9d1f27af0eb4545291beeb64f280e2'
layers['meta-riscv']='https://github.com/Fishwaldo/meta-riscv.git|master|579e8e113be29d2e2a84c7409c4eaead6a8a3bed'
layers['meta-qt5']='https://github.com/meta-qt5/meta-qt5.git|master|cf6ffcbad5275a3428f6046468a0c9d572e813d1'
layers['yocto-meta-kf5']='https://github.com/KDE/yocto-meta-kf5.git|master|288288033137c19b72948a91d74b82b66c788fe3'
layers['yocto-meta-kde']='https://github.com/KDE/yocto-meta-kde.git|master|e533c2bf3133cc3fec6f78104ed0839fd84e2165'
layers['meta-python2']='https://git.openembedded.org/meta-python2|kirkstone|f02882e2aa9279ca7becca8d0cedbffe88b5a253'
layers['meta-java']='https://github.com/meta-java/meta-java.git|kirkstone|8bf79fc2002bb83c6439d25bb63e4206894c2d10'
layers['meta-kde-gear']='https://github.com/Fishwaldo/meta-kde-gear.git|master|d684eb323b972627858e7a7daadd30dd52d23761'
#layers['meta-clang']='https://github.com/davidlt/meta-clang.git|langdale|aa46b8e9599c1d3cc165b79355100adbc4c8effa'

echo "Checking Layers..."
echo ""

for layer in ${!layers[@]};
do
	IFS=$'|' read -r repo branch srcrev <<< "${layers[$layer]}"
	echo "Checking: $layer"
	if [ ! -d layers/$layer/.git ]
	then
		echo "Cloning $layer"
		git clone -q $repo layers/$layer && cd layers/$layer && git checkout -q $branch  && git checkout -q $srcrev && cd ../..
	fi
done

if [ ! -f layers/poky/oe-init-build-env ]; then
	echo "Error: Build Repo Layout Invalid"
	echo "Please check the Readme"
	return 1
fi

if [ ! -d $(pwd)/conf/templates/pinix/ ]; then
	echo "Error: Can't Find pinix configuration templates"
	return 1
fi
PWD=$(pwd)	
TEMPLATECONF="$PWD/conf/templates/pinix"

echo "Setting Up Yocto Build Scripts"

. $(pwd)/layers/poky/oe-init-build-env $1
