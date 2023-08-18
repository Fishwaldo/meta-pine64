
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
 * star64-image-plasma - A Plasma Based Image.
 * pinetabv-image-plasma - A Plasma Image for the PineTabV

 All Images contain the necessary patches to the kernel/userspace to support 
 GPU/VPU Acceleration. 

 The [Kernel used is 5.15.107](https://github.com/Fishwaldo/Star64_linux/) - This is due to the GPU Model used in Star64 (BXE-4-32 GPU) (img-rouge) driver not available for more recent kernels yet
 
*Warning* - Right now, these images might be a bit unstable as we finetune the image configurations. 
Running apt upgrade *might* break things. 

Building The Images
===================
The images are built using the Yocto Project. 

By Default, the images produced are for Star64. You can select different machines by specifing the MACHINE variable as such:

```bash
export MACHINE=<name>
```
where <name> can be:
 * star64
 * pinetabv

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

or

```bash
MACHINE=pinetabv bitbake pinetabv-image-plasma
```

*Note: This image depends upon your userid/groupid being 1000, if it is not, you would have to rebuild the image with your custom userid*

## Installing/Building Additional Packages
The images produced have a apt repository configured to allow you to install additional packages not included in the image. (There is currently around 10000+ aditional packages available)
First run
```bash
apt update
```
and then you can search and install additional packages using apt search/apt install.

*NOTE* These additional packages are not well tested. If you find a package that does not work, please submit a issue request.

You can locally build additional packages (if they are included in any of the BitBake Layers we use) with the command:

```bash
bitbake <packagename>
```

To see what packages are available, you can use the command

```bash
bitbake-layers show-recipes 
```
or
```bash
bitbake-layers show-recipes | grep <name>
```

if a Package is not included, you can see if there are any available reciepes already created at https://layers.openembedded.org/layerindex/branch/master/recipes/

If you find a suitable recipe, depending upon its complexity, requirements, dependancies etc, you can either copy the recipe into the meta-pine64 layer, or add the 
layer that contains the reciepe using bitbake-layers command. Please consult the Yocto Documentation for more info here. 




## Usernames

 * root/pine64
 * pine64/pine64


## Discussions/Help

Discussions around these images takes place in the Star64 Channel on the Pine64 community 
(discord, telegram, matrix, IRC). Please see the Pine64 website for links to join these
online chat. 
