package com.serenegiant.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.serenegiant.app.databinding.ActivityMainBinding;
import com.serenegiant.uvccamera.NativeLib;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "console";

	// Used to load the 'app' library on application startup.
	static {
		System.loadLibrary("app");
	}

	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		NativeLib nativeLib = new NativeLib();
		String str = nativeLib.stringFromJNI();
		Log.d(TAG, str);
		str = nativeLib.getUsb();
		Log.d(TAG, str);

		// Example of a call to a native method
		TextView tv = binding.sampleText;
		//tv.setText(stringFromJNI());
		tv.setText(str);
	}

	/**
	 * A native method that is implemented by the 'app' native library,
	 * which is packaged with this application.
	 */
	public native String stringFromJNI();
}