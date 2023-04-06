SUMMARY = "My Qt5 App recipe"
DESCRIPTION = "My Qt5 App recipe"
LICENSE = "CLOSED"

DEPENDS += " qtbase wayland "

SRC_URI = "file://AGL_Quiz_Application.cpp \
	  file://AGL_Quiz_Application.pro \
	  file://AGL_Quiz_Application.desktop \
	  "
	  
S = "${WORKDIR}"

do_install:append() {
	install -d ${D}${bindir} 
	install -m 0775 AGL_Quiz_Application ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/AGL_Quiz_Application.desktop ${D}${datadir}/applications
}

FILES_${PN} += "${bindir}/AGL_Quiz_Application \
	       ${datadir}/applications/AGL_Quiz_Application.desktop"

inherit qmake5
