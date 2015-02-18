package com.controller;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class DealPic {

	public static Bitmap dealwithbitmap (Bitmap map,float width,float height)
	{
		int fwidth=map.getWidth();
		int fheight=map.getHeight();
		float x=width/fwidth;
		float y=width/fheight;
		Matrix mat=new Matrix();
		mat.setScale(x, y);
		return map.createBitmap(map, 0, 0, fwidth, fheight, mat, true);
	}
}
