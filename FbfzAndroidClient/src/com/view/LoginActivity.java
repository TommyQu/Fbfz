package com.view;

import com.example.fbfzandroidclient.R;
import com.model.UserMember;
import com.mysyncTask.LoginTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText etusername;
	private EditText etPassword;
	private Button btLogin;
	private Button btCancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		iniUI();
		iniListener();
	}
	
	private void iniUI ()
	{
		etusername=(EditText) findViewById(R.id.etLgname);
		etPassword=(EditText) findViewById(R.id.etLgpsw);
		btLogin=(Button) findViewById(R.id.btLogin);
		btCancel=(Button) findViewById(R.id.btLgcancel);
		
	}
	
	private void iniListener ()
	{
		btLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String uri="mylogin!login.action";
				UserMember member=new UserMember ();
				member.setUsername(etusername.getText().toString());
				member.setPassword(etPassword.getText().toString());
				LoginTask task=new LoginTask(LoginActivity.this);
				task.execute(uri,member);
			}
		});
		
		btCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
