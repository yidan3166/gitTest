package com.example.y_share_preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
/**
 * 通过修改配置启动不同的activity
 * sharePreference 的activity
 * @author syyandi
 *
 */
public class MainActivity extends Activity {

	
	private CheckBox cb;
	private SharedPreferences sp;
	public final static  String status ="status";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cb = (CheckBox) findViewById(R.id.cb);
		sp = getSharedPreferences("mykey", MODE_PRIVATE);//mykey作为一个标示 用的是内部存储
		cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Editor e = sp.edit();
				e.putBoolean(status, isChecked);
				e.commit();
				
			}
		});
		cb.setChecked(sp.getBoolean(status, false));
		if(cb.isChecked()){
			new AlertDialog.Builder(MainActivity.this).setTitle("welcome").setMessage("欢迎使用").setPositiveButton("关闭", null).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
