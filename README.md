# meta-suchinton

This is a custom yocto-layer to embed the [***AGL_Quiz_Application***](https://github.com/suchinton/AGL_Quiz_Application) into AGL's demo image

Link to the sucessfully built [***agl-demo-platform***](https://drive.google.com/file/d/1MsM9rQoEAkOTWKIS-bl5Y0T6u0TuYQdN/view?usp=sharing) image

To boot the image follow the [***guide***](https://docs.automotivelinux.org/en/master/#01_Getting_Started/01_Quickstart/01_Using_Ready_Made_Images/)

## ScreenShots

<img src="https://user-images.githubusercontent.com/75079303/232209064-d283739f-f519-48c8-b720-a5ae50b19315.png" width=330> <img src="https://user-images.githubusercontent.com/75079303/232209074-2fe7ac9d-3f10-4262-bff2-b10ebefbf912.png" width=330> <img src="https://user-images.githubusercontent.com/75079303/232209076-ba75cb91-8fd3-4d1d-86bc-ed841a175967.png" width=330>

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
cd $AGL_TOP/build
bitbake-layers add-layer ../meta-suchinton
```

### To check if `meta-suchinton` was added as a custom layer

```
bitbake-layers show-layers
```

### Try to bitbake `myqtapp`

```
source agl-init-build-env
bitbake myqtapp
```

### To add desktop entry edit the `packagegroup-agl-demo-platform.bb` file 

```
nano $AGL_TOP/master/meta-agl-demo/recipes-platform/packagegroups/packagegroup-agl-demo-platform.bb
```

add the myqtapp entry to AGL_APPS to create desktop entry for AGL_Quiz_Application as such

```
AGL_APPS = " \
    dashboard \
    hvac \
    ondemandnavi \
    settings \
    mediaplayer \
    messaging \
    phone \
    radio \
    window-management-client-grpc \
    myqtapp \
    "
```


### Build Agl-demo image
```
cd $AGL_TOP
source build/agl-init-build-env
bitbake agl-demo-platform
```
