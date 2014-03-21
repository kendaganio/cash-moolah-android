package com.sourcepad.cashmoolah.util;

import android.content.Context;
import android.widget.Toast;

public class Toaster {

	public static void toast(Context context, String text) {
		Toast t = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		t.show();
	}
}
