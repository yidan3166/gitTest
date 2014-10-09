package com.example.y_share_preference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class ExternalStore extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		File dir = Environment.getExternalStorageDirectory();
		File file = new File(dir, "data.txt");
		
		try {
			FileInputStream fos = new FileInputStream(file);
			byte[] data = new byte[fos.available()];
			fos.read(data);
			fos.close();
			System.out.println(new String(data,"utf-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		try {
//			FileOutputStream fos = new FileOutputStream(file);
//			fos.write(new String("hello world").getBytes("utf-8"));
//			fos.flush();
//			fos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
