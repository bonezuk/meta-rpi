SUMMARY = "Musepack replay-gain library"
DESCRIPTION = "Library for replay-gain for Musepack"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://www.blackomega.co.uk/source/musepack/libreplaygain-r475.tar.gz"
SRC_URI[sha256sum] = "85a7503b22da10d78ada1ad99308995466f67f6baf281e8003f8b861fd853b7b"

inherit pkgconfig cmake

FILES_${PN} = "${libdir}/*.so.*"

do_install_append() {
	install -d ${D}${includedir}
	install -d ${D}${includedir}/replaygain
	cp -r ${S}/include/replaygain* ${D}${includedir}/replaygain
}
