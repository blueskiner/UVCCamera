#include <jni.h>
#include <string>

#include "libusb.h"

#include <android/log.h>
#define TAG "libusb" // 这个是自定义的LOG的标识
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__) // 定义LOGD类型

#ifndef __cpluscplus
extern "C" {
#endif

JNIEXPORT jstring JNICALL
Java_com_serenegiant_uvccamera_NativeLib_stringFromJNI(JNIEnv *env, jobject thiz) {
	std::string hello = "Hello from libuvccamera";
	return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_serenegiant_uvccamera_NativeLib_getUsb(JNIEnv *env, jobject thiz) {
	return env->NewStringUTF("111");
}

#ifndef __cpluscplus
}
#endif
