package com.example.y_share_preference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 内部存储的activity
 * 
 * @author syyandi
 * 
 */
public class InnerStoreActivity extends Activity {

	private Button btn;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inner_store);
		btn = (Button) findViewById(R.id.save);
		tv = (TextView) findViewById(R.id.tv);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				saveText();
				Toast.makeText(InnerStoreActivity.this, "保存成功", 1000).show();
			}

		});
		String text = getTextFromFile();
		if(text != null){
			tv.setText(text);
		}
		
	}

	private String getTextFromFile() {
		FileInputStream fin = null;
		try {
			fin = openFileInput("data");
			//只适合小文件，大文件容易让程序卡死
			byte[] textBytes = new byte[fin.available()];
			fin.read(textBytes);
			return new String(textBytes);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fin != null) {

				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@SuppressLint("NewApi")
	private void saveText() {
		try {
			FileOutputStream os = openFileOutput("data", Context.MODE_PRIVATE);
			String text = tv.getText().toString();
			if (!text.isEmpty()) {

				os.write(text.getBytes());
			}
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
