# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("UVCCamera")

#add_subdirectory(libjpeg-turbo)

include_directories(${CMAKE_SOURCE_DIR})

include_directories(libjpeg-turbo)
include_directories(libjpeg-turbo/include)

include_directories(libusb-support)
include_directories(libusb-support/libusb)
include_directories(libusb-support/libusb/os)

include_directories(libuvc)
include_directories(libuvc/include)
include_directories(libuvc/include/libuvc)

include_directories(rapidjson)
include_directories(rapidjson/include)

include_directories(UVCCamera)
include_directories(UVCCamera/pipeline)


#SET (SRC_LIST uvccamera.cpp)
# abiFilters "armeabi", "armeabi-v7a" , "arm64-v8a", "x86", "x86_64", "mips", "mips64"
#if(${ANDROID_ABI} MATCHES "arm64-v8a")
#    add_definitions(-DSIZEOF_SIZE_T=8)
#    SET (SRC_LIST ${SRC_LIST}
#        libjpeg-turbo-1.5.0/simd/jsimd_arm64.c
#        libjpeg-turbo-1.5.0/simd/jsimd_arm64_neon.S
#    )
#elseif(${ANDROID_ABI} MATCHES "armeabi-v7a")
#    add_definitions(-DSIZEOF_SIZE_T=4)
#    SET (SRC_LIST ${SRC_LIST}
#        libjpeg-turbo-1.5.0/simd/jsimd_arm.c
#        libjpeg-turbo-1.5.0/simd/jsimd_arm_neon.S
#    )
#elseif(${ANDROID_ABI} MATCHES "armeabi")
#    add_definitions(-DSIZEOF_SIZE_T=4)
#    SET (SRC_LIST ${SRC_LIST}
#        libjpeg-turbo-1.5.0/simd/jsimd_arm.c
#        libjpeg-turbo-1.5.0/simd/jsimd_arm_neon.S
#    )
#elseif(${ANDROID_ABI} MATCHES "x86")
#    add_definitions(-DSIZEOF_SIZE_T=4)
#    SET (SRC_LIST ${SRC_LIST}
#        libjpeg-turbo-1.5.0/simd/jsimd_i386.c
#        libjpeg-turbo-1.5.0/simd/jsimdcpu.asm
#        libjpeg-turbo-1.5.0/simd/jfdctflt-3dn.asm
#        libjpeg-turbo-1.5.0/simd/jidctflt-3dn.asm
#        libjpeg-turbo-1.5.0/simd/jquant-3dn.asm
#        libjpeg-turbo-1.5.0/simd/jccolor-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jcgray-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jcsample-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jdcolor-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jdmerge-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jdsample-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jfdctfst-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jfdctint-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jidctfst-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jidctint-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jidctred-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jquant-mmx.asm
#        libjpeg-turbo-1.5.0/simd/jfdctflt-sse.asm
#        libjpeg-turbo-1.5.0/simd/jidctflt-sse.asm
#        libjpeg-turbo-1.5.0/simd/jquant-sse.asm
#        libjpeg-turbo-1.5.0/simd/jccolor-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jcgray-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jcsample-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jdcolor-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jdmerge-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jdsample-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jfdctfst-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jfdctint-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jidctflt-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jidctfst-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jidctint-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jidctred-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jquantf-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jquanti-sse2.asm
#        libjpeg-turbo-1.5.0/simd/jchuff-sse2.asm
#    )
#else()
#    SET (SRC_LIST ${SRC_LIST} libjpeg-turbo-1.5.0/jsimd_none.c)
#endif()


add_definitions(-DLOG_NDEBUG)
add_definitions(-DACCESS_RAW_DESCRIPTORS)
add_definitions(-DUVC_DEBUGGING)
#add_definitions(-DANDROID_ARM_NEON=FALSE)

# 设置链接静态库的目录.
set(lib_path "${CMAKE_SOURCE_DIR}/../../../libs/${CMAKE_ANDROID_ARCH_ABI}")
set(jniLibs_path "${CMAKE_SOURCE_DIR}/../jniLibs/${CMAKE_ANDROID_ARCH_ABI}")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${lib_path}" -L${jniLibs_path})

add_library(jpeg STATIC IMPORTED)
set_target_properties(jpeg PROPERTIES IMPORTED_LOCATION ${jniLibs_path}/libjpeg.a)
add_library(turbojpeg STATIC IMPORTED)
set_target_properties(turbojpeg PROPERTIES IMPORTED_LOCATION ${jniLibs_path}/libturbojpeg.a)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        UVCCamera

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        # libjpeg-turbo-1.5.0
#        libjpeg-turbo-1.5.0/jcapimin.c
#        libjpeg-turbo-1.5.0/jcapistd.c
#        libjpeg-turbo-1.5.0/jccoefct.c
#        libjpeg-turbo-1.5.0/jccolor.c
#        libjpeg-turbo-1.5.0/jcdctmgr.c
#        libjpeg-turbo-1.5.0/jchuff.c
#        libjpeg-turbo-1.5.0/jcinit.c
#        libjpeg-turbo-1.5.0/jcmainct.c
#        libjpeg-turbo-1.5.0/jcmarker.c
#        libjpeg-turbo-1.5.0/jcmaster.c
#        libjpeg-turbo-1.5.0/jcomapi.c
#        libjpeg-turbo-1.5.0/jcparam.c
#        libjpeg-turbo-1.5.0/jcphuff.c
#        libjpeg-turbo-1.5.0/jcprepct.c
#        libjpeg-turbo-1.5.0/jcsample.c
#        libjpeg-turbo-1.5.0/jctrans.c
#        libjpeg-turbo-1.5.0/jdapimin.c
#        libjpeg-turbo-1.5.0/jdapistd.c
#        libjpeg-turbo-1.5.0/jdatadst.c
#        libjpeg-turbo-1.5.0/jdatasrc.c
#        libjpeg-turbo-1.5.0/jdcoefct.c
#        libjpeg-turbo-1.5.0/jdcolor.c
#        libjpeg-turbo-1.5.0/jddctmgr.c
#        libjpeg-turbo-1.5.0/jdhuff.c
#        libjpeg-turbo-1.5.0/jdinput.c
#        libjpeg-turbo-1.5.0/jdmainct.c
#        libjpeg-turbo-1.5.0/jdmarker.c
#        libjpeg-turbo-1.5.0/jdmaster.c
#        libjpeg-turbo-1.5.0/jdmerge.c
#        libjpeg-turbo-1.5.0/jdphuff.c
#        libjpeg-turbo-1.5.0/jdpostct.c
#        libjpeg-turbo-1.5.0/jdsample.c
#        libjpeg-turbo-1.5.0/jdtrans.c
#        libjpeg-turbo-1.5.0/jerror.c
#        libjpeg-turbo-1.5.0/jfdctflt.c
#        libjpeg-turbo-1.5.0/jfdctfst.c
#        libjpeg-turbo-1.5.0/jfdctint.c
#        libjpeg-turbo-1.5.0/jidctflt.c
#        libjpeg-turbo-1.5.0/jidctfst.c
#        libjpeg-turbo-1.5.0/jidctint.c
#        libjpeg-turbo-1.5.0/jidctred.c
#        libjpeg-turbo-1.5.0/jquant1.c
#        libjpeg-turbo-1.5.0/jquant2.c
#        libjpeg-turbo-1.5.0/jutils.c
#        libjpeg-turbo-1.5.0/jmemmgr.c
#        libjpeg-turbo-1.5.0/jmemnobs.c
#
#        libjpeg-turbo-1.5.0/jaricom.c
#        libjpeg-turbo-1.5.0/jcarith.c
#        libjpeg-turbo-1.5.0/jdarith.c
#
#        libjpeg-turbo-1.5.0/turbojpeg.c
#        libjpeg-turbo-1.5.0/transupp.c
#        libjpeg-turbo-1.5.0/jdatadst-tj.c
#        libjpeg-turbo-1.5.0/jdatasrc-tj.c

        # libusb source files
        libusb-support/libusb/core.c
        libusb-support/libusb/descriptor.c
        libusb-support/libusb/hotplug.c
        libusb-support/libusb/io.c
        libusb-support/libusb/sync.c
        libusb-support/libusb/strerror.c
        libusb-support/libusb/os/android_usbfs.c
        libusb-support/libusb/os/poll_posix.c
        libusb-support/libusb/os/threads_posix.c
        libusb-support/libusb/os/android_netlink.c

        # libuvc source files
        libuvc/src/ctrl.c
        libuvc/src/device.c
        libuvc/src/diag.c
        libuvc/src/frame.c
        libuvc/src/frame-mjpeg.c
        libuvc/src/init.c
        libuvc/src/stream.c

        # UVCCamera
        UVCCamera/_onload.cpp
        UVCCamera/utilbase.cpp
        UVCCamera/UVCCamera.cpp
        UVCCamera/UVCPreview.cpp
        UVCCamera/UVCButtonCallback.cpp
        UVCCamera/UVCStatusCallback.cpp
        UVCCamera/Parameters.cpp
        UVCCamera/serenegiant_usb_UVCCamera.cpp

        uvccamera.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        UVCCamera

        android
        jnigraphics

        # libjpeg-turbo
        jpeg
        turbojpeg

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})