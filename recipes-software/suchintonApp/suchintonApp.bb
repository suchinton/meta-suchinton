SUMMARY = "suchintonApp recipe"
DESCRIPTION = "suchintonApp recipe for GS0C 2024 at AGL"
# HOMEPAGE = "https://github.com/suchinton/AGL_Quiz_Application"
LICENSE = "CLOSED"
SECTION     = "apps"

PV = "1.0+git${SRCREV}"

SRC_URI = "git://github.com/suchinton/AGL_Quiz_Application;protocol=https;branch=main \
           file://suchintonapp \
"

DEPENDS = " libqtappfw "

SRCREV = "bc17c8a4a8a636501e7103f392e3a0394ea82c1f"
	  
S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${libexecdir}/${BPN}
    cp -drv ${S}/* ${D}${libexecdir}/${BPN}

	install -d ${D}${bindir} 
	install -m 0775 ${WORKDIR}/suchintonapp ${D}${bindir}
}

inherit qmake5 agl-app

AGL_APP_NAME = "suchintonApp"

RDEPENDS:${PN} += " \
    python3 \
    python3-modules \
    python3-packaging \
    python3-qtwidgets \
    weston \
    libqtappfw \
"

FILES_${PN} += "${libexecdir}/${BPN}/*"
