# meta-suchinton

This is a custom yocto-layer to embed the [***AGL_Quiz_Application***](https://github.com/suchinton/AGL_Quiz_Application) into AGL's demo image

To boot the image follow the [***guide***](https://docs.automotivelinux.org/en/master/#01_Getting_Started/01_Quickstart/01_Using_Ready_Made_Images/)

## ScreenShots


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

### Add meta-suchinton as a new layer

```
cd $AGL_TOP/build
bitbake-layers add-layer ../meta-suchinton
```

### Verify if `meta-suchinton` was added as a custom layer

```
bitbake-layers show-layers
```

### Try to bitbake `suchintonApp`

```
source agl-init-build-env
bitbake suchintonApp
```

### To add app edit the `packagegroup-agl-demo-platform.bb` file 

```
nano $AGL_TOP/master/meta-agl-demo/recipes-platform/packagegroups/packagegroup-agl-demo-platform.bb
```

Add the suchintonApp entry to AGL_APPS

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
    suchintonApp \
    "
```


### Build Agl-demo image
```
cd $AGL_TOP
source build/agl-init-build-env
bitbake agl-demo-platform
```

Note: Before starting the app, please restart the databroker

```
$ su
$ pkill databroker
$ databroker --address 0.0.0.0.--vss /usr/share/vss/vss.json
$ exit
$ suchintonapp

```
