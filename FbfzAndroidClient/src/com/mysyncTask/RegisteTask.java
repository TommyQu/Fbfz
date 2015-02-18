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

public class RegisteTask extends AsyncTask<Object, Object, Object>{

	private Context context;
	private Intent intent;
	
	
	public RegisteTask(Context context) {
		super();
		this.context = context;
		intent=new Intent();
	}

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		
		String uri=(String)params[0];
		UserMember user=(UserMember)params[1];
		String seconduri=(String) params[2];
		HashMap<String, Object> map=new HashMap<String, Object>();
		String name=user.getUsername();
		String psw=user.getPassword();
		map.put("username",name );
		map.put("password", psw);
		map.put("usersex", user.getUsersex());
		map.put("email",user.getEmail());
		map.put("qq", user.getQq());
		Type type1=new TypeToken<AndroidMessage<String>> (){}.getType();
		Type type2=new TypeToken<AndroidMessage<UserMember>>(){}.getType();
		AndroidMessage message=RemoteConnection.postHttp(uri, map, type1);
		if(message!=null && message.isSuccess())
		{
			String result=(String) message.getData();
			if(result!=null && !result.equals(""))
			{
				if(result.equals("success"))
				{
					HashMap<String, Object> map2=new HashMap<String, Object>();
					map2.put("username", name);
					map2.put("password", psw);
					AndroidMessage message2=RemoteConnection.postHttp(seconduri, map2, type2);
					if(message2!=null && message2.isSuccess())
					{
						UserMember member=(UserMember) message2.getData();
						publishProgress("success#"+member.getUsername(),member);
					}
				}
				
			}
		}
		else if(message!=null && !message.isSuccess())
		{
			String result=(String)message.getData();
			publishProgress("fault#"+result);
		}
		return "mine";
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		String result=(String) values[0];
		String s[] =result.split("#");
		if(s[0].endsWith("success"))
		{
			UserMember member=(UserMember) values[1];
			Toast.makeText(context, "×¢²á³É¹¦", Toast.LENGTH_SHORT).show();
			
			Bundle bundle=new Bundle();
			bundle.putSerializable("user", member);
			intent.putExtras(bundle);
			
		WholeDatas.TVSTATUS="»¶Ó­"+s[1];
		WholeDatas.BTGOLOGIN="ÍË³öµÇÂ¼";
		
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
