
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

Building The Images
===================
The images are built using the Yocto Project. 

I recommend you build the images in a docker container as there are some dependencies that 
are dependant upon the host system build tool versions. 

There is a docker container at https://github.com/Fishwaldo/yoctobuilder/pkgs/container/yoctobuilder
that I used to build the images. To use this container ensure you have podman or docker installed and 
execute the following command from the meta-pine64 directory on your host system:

```bash
podman run -it --privileged --mount type=bind,source=$(pwd)/,target=/home/yoctouser/ --userns=keep-id --group-add keep-groups ghcr.io/fishwaldo/yoctobuilder:main
```

You will end up inside the container. From there, you can execute the bitbake commands such as:

```bash
bitbake star64-image-minimal
```

*Note: This image depends upon your userid/groupid being 1000, if it is not, you would have to rebuild the image with your custom userid*

## Usernames

 * root/pine64
 * pine64/pine64


## Discussions/Help

Discussions around these images takes place in the Star64 Channel on the Pine64 community 
(discord, telegram, matrix, IRC). Please see the Pine64 website for links to join these
online chat. 
