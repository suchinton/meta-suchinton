# meta-suchinton

This is a custom yocto-layer to embed the [***AGL_Quiz_Application***](https://github.com/suchinton/AGL_Quiz_Application) into AGL's demo image

Link to the sucessfully built [***agl-demo-platform***](https://drive.google.com/file/d/1Bk1bsHDEg9JTm5gXALjq7kz4rtOfkrzM/view?usp=sharing) image

To boot the image follow the [***guide***](https://docs.automotivelinux.org/en/master/#01_Getting_Started/01_Quickstart/01_Using_Ready_Made_Images/)

To run the application, Open the Wayland terminal and run

```
/bin/AGL_Quiz_Application
```
---

## To replicate the build, follow these steps,

### Define Your Top-Level Directory

```
export AGL_TOP=$HOME/AGL
echo 'export AGL_TOP=$HOME/AGL' >> $HOME/.bashrc
mkdir -p $AGL_TOP
```

### Download the repo Tool and Set Permissions

```
mkdir -p $HOME/bin
export PATH=$HOME/bin:$PATH
echo 'export PATH=$HOME/bin:$PATH' >> $HOME/.bashrc
curl https://storage.googleapis.com/git-repo-downloads/repo > $HOME/bin/repo
chmod a+x $HOME/bin/repo
```

### Download the AGL Source Files

```
cd $AGL_TOP
mkdir master
cd master
repo init -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo
repo sync
```

### Initialize the build environment using aglsetup.sh Script

```
$ cd $AGL_TOP
$ source master/meta-agl/scripts/aglsetup.sh -m qemux86-64 agl-demo agl-devel
```

### Clone this repo

```
git clone https://github.com/suchinton/meta-suchinton.git
```

### Add meta-suchinton to build/conf/local.conf

```
bitbake-layers add-layer meta-suchinton
```

### To check if meta-suchinton was added as a custom layer

```
bitbake-layers show-layers
```

### Try to bitbake meta-suchinton

```
bitbake meta-suchinton
```

### Build Agl-demo image
```
source build/agl-init-build-env
bitbake agl-demo-platform
```
