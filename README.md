
This is a Yocto Image/Layer for the Star64/PineTabV devices from Pine64
Please see the corresponding sections below for details.

QuickStart
==========

Pre-built SD/MMC images can be downloaded from https://pine64.my-ho.st:8443/

The images are configured with deb package management. Additional packages can 
be installed via the apt tool (you should first run ```apt update```). packages 
are hosted at the same above site. 

To burn these images, us [Balena Etcha](https://github.com/balena-io/etcher) or 
dd.

For additional packages not present, please submit a issue request, i'll do my 
best to find a recipe to include those packages.

The Following Images are currently provided:
 * star64-image-minimal - A CommandLine only image
 * star64-image-weston - A Weston/Wayland "Demo" image. 
 * star64-image-plasma- A Plasma Based Image.

 All Images contain the necessary patches to the kernel/userspace to support 
 GPU/VPU Acceleration. 

 The Kernel used is 5.15.107 - This is due to the GPU Model used in Star64 (BXE-4-32 GPU) (img-rouge) driver not available for more recent kernels yet
 
*Warning* - Right now, these images might be a bit unstable as we finetune the image configurations. 
Running apt upgrade *might* break things. 

## Usernames

 * root/pine64
 * pine64/pine64


## Discussions/Help

Discussions around these images takes place in the Star64 Channel on the Pine64 community 
(discord, telegram, matrix, IRC). Please see the Pine64 website for links to join these
online chat. 
