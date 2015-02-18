package com.view;

import com.example.fbfzandroidclient.R;
import com.model.UserMember;
import com.mysyncTask.RegisteTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private EditText etname;
	private EditText etpsw;
	private EditText etcheckpsw;
	private RadioButton rbmale;
	private RadioButton rbFemale;
	private EditText etmail;
	private EditText etQQ;
	private EditText etchecknum;
	private Button btregister;
	private Button btcancle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		iniUI();
		iniListener();
	}

	private void iniUI ()
	{
		etname=(EditText) findViewById(R.id.etRgname);
		etpsw=(EditText) findViewById(R.id.etRgpsw);
		etcheckpsw=(EditText) findViewById(R.id.etPswAgain);
		rbmale=(RadioButton) findViewById(R.id.rbMale);
		rbFemale=(RadioButton) findViewById(R.id.rbFemale);
		etmail=(EditText) findViewById(R.id.etEmail);
		etQQ=(EditText) findViewById(R.id.etQQ);
		etchecknum=(EditText) findViewById(R.id.etAuth_code);
		btregister=(Button) findViewById(R.id.btRegist);
		btcancle = (Button) findViewById(R.id.btRgcancel);
	}
	
	private void iniListener ()
	{
		btregister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username=etname.getText().toString().trim();
//				String psw=etpsw.getText().toString().trim();
//				String checkpsw=etcheckpsw.getText().toString().trim();
//				String email=etmail.getText().toString().trim();
//				String QQ=etQQ.getText().toString().trim();
//				String checknum=etchecknum.getText().toString().trim();
//				int sex=1;
//				if(rbmale.isChecked())
//				{
//					sex=1;
//				}
//				else if(rbFemale.isChecked())
//				{
//					sex=2;
//				}
//				if(!psw.equals(checkpsw))
//				{
//					Toast.makeText(RegisterActivity.this, "密码验证不一致", Toast.LENGTH_SHORT).show();
//				}
//				else
//				{
					RegisteTask rgtask=new RegisteTask(RegisterActivity.this);
					
					String uri="myregist!register.action";
					UserMember member=new UserMember();
					member.setUsername(username);
//					member.setPassword(psw);
//					member.setUsersex(sex);
//					member.setEmail(email);
//					member.setQq(QQ);
					
					String uri2="mylogin!login.action";
					
					rgtask.execute(uri,member,uri2);
//				}
			}
		});
		btcancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
