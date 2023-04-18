This is a Yocto Image/Layer for the Star64/PineTabV devices from Pine64
Please see the corresponding sections below for details.

QuickStart
==========

Pre-built SD/MMC images can be downloaded from https://pine64.my-ho.st:8443/

The images are configured with deb package management. Additional packages can 
be installed via the apt tool (you should first run ```apt update```). packages 
are hosted at the same above site. 

Do burn these images, us [Balena Etcha](https://github.com/balena-io/etcher) or 
dd.

For additional packages not present, please submit a issue request, i'll do my 
best to find a recipe to include those packages.

The Following Images are currently provided:
 * star64-image-minimal - A CommandLine only image
 * star64-image-weston - A Weston/Wayland "Demo" image. 
 * star64-image-xfce - A XFCE Based Image.
 * star64-image-gnome - A Gnome Based Image.

 All Images contain the necessary patches to the kernel/userspace to support 
 GPU/VPU Acceleration. 

 The Kernel used is 5.15 - This is due to the GPU Model used in Star64 (BXE-4-32 GPU) (img-rouge) driver not 
 available for more recent kernels yet
 
*Warning* - Right now, these images might be a bit unstable as we finetune the image configurations. 
Running apt upgrade *might* break things. 

Usernames
=========
 * root
   password: pine64

 * pine64
   password: pine64

Table of Contents
=================

  1. Layer Dependancies
  2. Patches
  3. Adding the meta-pine64 layer to your build
  4. Misc


1. Dependencies
===============

  URI: https://git.yoctoproject.org/poky
  branch: mickledore

  URI: https://github.com/riscv/meta-riscv
  branch: master 
  (this is pending patches to be upstreamed - For the moment, please use 
  https://github.com/Fishwaldo/meta-riscv - star64 branch)

  https://github.com/openembedded/meta-openembedded
  branch: mickledore
  layers:
    * meta-oe
    * meta-networking
    * meta-python
    * meta-gnome
    * meta-multimedia
    * meta-xfce

2. Patches
==========

This repository will accept patches that are for specific configurations of the Star64/PineTabV
If your patches are to fix builds, they should be submitted upstream to either the Yocto Project, 
or the meta-riscv if they are riscv related. 

These images have "default" configuration of the upstream sources. These upstream configurations 
might not work well on Star64 or PineTabV. If you find a configuration that is incompatible with 
these devices, please submit a issue (or better yet, add a bbappend recipe with fixes)


3. Adding the meta-pine64 layer to your build
=================================================

Run 'bitbake-layers add-layer meta-pine64'

4. Misc
=======

Discussions around these images takes place in the Star64 Channel on the Pine64 community 
(discord, telegram, matrix, IRC). Please see the Pine64 website for links to join these
online chat. 
