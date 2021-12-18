SUMMARY = "Musepack CUE file library"
DESCRIPTION = "Library for reading CUE files for Musepack"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://www.blackomega.co.uk/source/musepack/libcuefile-r475.tar.gz"
SRC_URI[sha256sum] = "ef6bed7b52560b4821eefed9aece6d8a9660d29156dacbf646422cbfc2f0bcb0"

inherit pkgconfig cmake

FILES_${PN} = "${libdir}/*.so.*"

do_install_append() {
	install -d ${D}${libdir}
	cp ${B}/src/libcuefile.s* ${D}${libdir}
	chmod 755 ${D}${libdir}/libcuefile.s*

	install -d ${D}${includedir}
	cp -r ${S}/include/* ${D}${includedir}
}
