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
layers['poky']='git://git.yoctoproject.org/poky|kirkstone|fc697fe87412b9b179ae3a68d266ace85bb1fcc6'
layers['meta-openembedded']='https://github.com/openembedded/meta-openembedded|kirkstone|529620141e773080a6a7be4615fb7993204af883'
layers['meta-riscv']='https://github.com/Fishwaldo/meta-riscv.git|master|7832236b10f9861307e2b47665df938d374b3d85'
layers['meta-qt5']='https://github.com/meta-qt5/meta-qt5.git|master|cf6ffcbad5275a3428f6046468a0c9d572e813d1'
layers['yocto-meta-kf5']='https://github.com/Fishwaldo/yocto-meta-kf5.git|master|185899c499a8377aa0f304b3760238658438dd1d'
layers['yocto-meta-kde']='https://github.com/Fishwaldo/yocto-meta-kde.git|master|898ad0cd1139d5d0a7d923267357117d55baec72'
layers['meta-python2']='https://git.openembedded.org/meta-python2|kirkstone|f02882e2aa9279ca7becca8d0cedbffe88b5a253'
layers['meta-kde-gear']='https://github.com/Fishwaldo/meta-kde-gear.git|master|e660c69a255cf66bc9d4092e6e0c3a271d1e22ca'
layers['meta-clang']='https://github.com/kraj/meta-clang.git|kirkstone|71321ddf78ea522b87a6b4bffefb14c988a6d921'
layers['meta-lts-rust']='https://git.yoctoproject.org/git/meta-lts-mixins|kirkstone/rust-1.68|feed1bb0eb4aefb701d582156d7defb0c1fc0473'

if [ -f .nosync ]; then
	echo "Checking Layers... (not syncing)"
	NOSYNC=1
else 
	echo "Checking Layers... (syncing)"
	NOSYNC=0
fi
echo ""

for layer in ${!layers[@]};
do
	IFS=$'|' read -r repo branch srcrev <<< "${layers[$layer]}"
	echo "Checking: $layer"
	if [ ! -d layers/$layer/.git ]
	then
		echo "Cloning $layer"
		git clone -q $repo layers/$layer && cd layers/$layer && git checkout -q $branch  && git checkout -q $srcrev && cd ../..
	else
		if [ $NOSYNC -eq 0 ]; then
			echo "Updating $layer to $srcrev"
			cd layers/$layer && git fetch -q && git checkout -q $branch && git checkout -q $srcrev && cd ../..
		fi
	fi
done

echo ""
# rustpatch=`md5sum layers/poky/meta/lib/oe/rust.py | awk '{print $1;}'`
# if [ ! $rustpatch = "717271b44ab7b5eb803d088591a82157" ]; then
# 	echo "Patching Rust Support in Poky"
# 	patch -p1 < patches/rust.patch
# 	echo ""
# fi

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
