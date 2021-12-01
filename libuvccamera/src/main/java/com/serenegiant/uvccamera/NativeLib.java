package com.serenegiant.uvccamera;

public class NativeLib {

	// Used to load the 'uvccamera' library on application startup.
	static {
		System.loadLibrary("uvccamera");
	}

	/**
	 * A native method that is implemented by the 'uvccamera' native library,
	 * which is packaged with this application.
	 */
	public native String stringFromJNI();

	public native String getUsb();
}