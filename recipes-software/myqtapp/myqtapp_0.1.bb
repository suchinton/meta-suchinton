SUMMARY = "My Qt5 App recipe"
DESCRIPTION = "My Qt5 App recipe"
LICENSE = "CLOSED"

DEPENDS += " qtbase wayland "

SRC_URI = "file://AGL_Quiz_Application.cpp \
	  file://AGL_Quiz_Application.pro \
	  "
	  
S = "${WORKDIR}"

do_install:append() {
	install -d ${D}${bindir} 
	install -m 0775 AGL_Quiz_Application ${D}${bindir}
}

FILES_${PN} += "${bindir}/AGL_Quiz_Application"

inherit qmake5
