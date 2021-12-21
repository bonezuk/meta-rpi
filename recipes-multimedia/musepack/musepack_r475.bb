SUMMARY = "Musepack library"
DESCRIPTION = "Musepack audio codec library"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://www.blackomega.co.uk/source/musepack/musepack-r475.tar.gz"
SRC_URI[sha256sum] = "7b8dd8e551d0baafc947374965dc714c788fb89a736490999a7b2a25906b2f63"

DEPENDS = "libcuefile libreplaygain"

inherit pkgconfig cmake

do_install_append() {
	install -d ${D}${libdir}
	cp ${B}/libmpcdec/libmpcdec.so ${D}${libdir}
	chmod 755 ${D}${libdir}/libmpcdec.so
	mv ${D}${libdir}/libmpcdec.so ${D}${libdir}/libmpcdec.so.1.0.0
	ln -s ./libmpcdec.so.1.0.0 ${D}${libdir}/libmpcdec.so.1
	ln -s ./libmpcdec.so.1.0.0 ${D}${libdir}/libmpcdec.so

	install -d ${D}${includedir}/mpc
	cp ${S}/include/mpc/*.h ${D}${includedir}/mpc/
}

EXTRA_OECMAKE = " -DCUEFILE_INCLUDE_DIR=${STAGING_DIR_HOST}${includedir} \
  -DCUEFILE_LIBRARY=${STAGING_DIR_HOST}${libdir}/libcuefile.so \
  -DREPLAY_GAIN_INCLUDE_DIR=${STAGING_DIR_HOST}${includedir} \
  -DREPLAY_GAIN_LIBRARY=${STAGING_DIR_HOST}${libdir}/libreplaygain.so \
"
