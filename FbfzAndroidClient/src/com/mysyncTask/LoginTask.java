package com.mysyncTask;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import com.http.RemoteConnection;
import com.model.AndroidMessage;
import com.model.UserMember;
import com.staticdatas.WholeDatas;
import com.view.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class LoginTask extends AsyncTask<Object, Object, Object>{
	private Context context;
	
	private Intent intent;
	
	

	public LoginTask(Context context) {
		super();
		this.context = context;
		intent=new Intent();
	}



	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		String uri=(String) params[0];
		UserMember user=(UserMember) params[1];
		Type type=new TypeToken<AndroidMessage<UserMember>> (){}.getType();
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		AndroidMessage message=RemoteConnection.postHttp(uri, map, type);
		
		if(message!=null)
		{
			if(message.isSuccess())
			{
				UserMember member=(UserMember) message.getData();
				
				publishProgress("success#"+member.getUsername(),member);
				
			}
			else
			{
				publishProgress("fault#"+(String)message.getData());
			}
		}
		else
		{
			publishProgress("fault#"+"ÏµÍ³´íÎó");
		}
		return null;
	}



	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		String result=(String) values[0];
		String [] s=result.split("#");
		if(s[0].equals("success"))
		{
			WholeDatas.TVSTATUS="»¶Ó­"+s[1];
			Bundle bundle=new Bundle();
			bundle.putSerializable("user", (UserMember)values[1]);
			
			intent.putExtras(bundle);
			intent.setClass(context, MainActivity.class);
			context.startActivity(intent);
			((Activity)context).finish();
		}
		else if(s[0].equals("fault"))
		{
			Toast.makeText(context, s[1], Toast.LENGTH_SHORT).show();
		}
	}
	
	
	
}
