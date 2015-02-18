package com.view;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.adapter.MyAdapter;
import com.adapter.MyLvadapter;
import com.controller.DealPic;
import com.example.fbfzandroidclient.R;
import com.google.gson.reflect.TypeToken;
import com.http.RemoteConnection;
import com.model.AndroidMessage;
import com.model.CooperationType;
import com.staticdatas.WholeDatas;

public class MainActivity extends Activity {
	
	private GridView gvMenu;
	public TextView tvStatus;
	public Button btLogin;
	private ViewFlipper filper;
	private int [] images={R.drawable.meishi,R.drawable.yule,R.drawable.meirong,R.drawable.dingwei};
	private String [] texts=null;
	private List<Map<String, Object>> datas=new ArrayList<Map<String,Object>>();
	private MyAdapter adapter;
	
	private ListView lvShopinfo;
	private List<Map<String, Object>> shopdatas=new ArrayList<Map<String,Object>> ();
	private MyLvadapter lvadapter;
	
	private Intent intent=new Intent();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iniUI();
		iniListener();
	}

	private void iniUI ()
	{
		tvStatus=(TextView) findViewById(R.id.tvStatus);
		gvMenu=(GridView) findViewById(R.id.gvMenu);
		btLogin=(Button) findViewById(R.id.btGotologin);
		filper=(ViewFlipper) findViewById(R.id.filper);

		tvStatus.setText(WholeDatas.TVSTATUS);
		btLogin.setText(WholeDatas.BTGOLOGIN);
		
		iniDatas();
		adapter=new MyAdapter(datas, this);
		gvMenu.setAdapter(adapter);
		
		iniShopdatas();
		lvShopinfo=(ListView) findViewById(R.id.lvShops);
		lvadapter=new MyLvadapter(shopdatas, this);
		lvShopinfo.setAdapter(lvadapter);
		filper.setDisplayedChild(0);
		
	}
	private void iniDatas ()
	{
		int screenwidth=getWindowManager().getDefaultDisplay().getWidth();
		Type type = new TypeToken<AndroidMessage<List<CooperationType>>>(){}.getType();
		AndroidMessage message=RemoteConnection.postHttp("adindex!list.action", null, type);
		if(message.isSuccess()){
			List<CooperationType> types=(List<CooperationType>) message.getData();
			this.texts = new String[types.size()+1];
			for(int i=0;i<types.size();i++){
				texts[i]=types.get(i).getTypename();
			}
			texts[types.size()]="附近商家";
		}
		float width=screenwidth/8;
		float length=images.length;
		for(int i=0;i<length;i++)
		{
			HashMap<String, Object> map=new HashMap<String, Object> ();
			Bitmap image=BitmapFactory.decodeResource(getResources(),images[i]);
			image=DealPic.dealwithbitmap(image, width, width);
			map.put(WholeDatas.GVITEM[0], image);
			map.put(WholeDatas.GVITEM[1], texts[i]);
			datas.add(map);
		}
	}
	
	private void iniShopdatas ()
	{
		int screenwidth=getWindowManager().getDefaultDisplay().getWidth();
		float width=screenwidth/8;
		Bitmap image=BitmapFactory.decodeResource(getResources(), R.drawable.shop);
		image=DealPic.dealwithbitmap(image, width, width);
		for(int i=0;i<20;i++)
		{
			
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put(WholeDatas.LVITEM[0], image);
			map.put(WholeDatas.LVITEM[1], WholeDatas.test);
			map.put(WholeDatas.LVITEM[2], WholeDatas.test2);
			shopdatas.add(map);
		}
	}
	private void iniListener ()
	{
		btLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent.setClass(MainActivity.this, LoginActivity.class);
				startActivity(intent);
				
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 0, 0,"关于我们");
		menu.add(0, 1, 0,"登陆");
		menu.add(0, 2, 0,"注册");
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		int id=item.getItemId();
		switch (id)
		{
		case 0:
		{
			
		}
		case 1:
		{
			intent.setClass(this, LoginActivity.class);
			startActivity(intent);
		}
		case 2:
		{
			intent.setClass(this, RegisterActivity.class);
			startActivity(intent);
		}
		
		}
		return true;
	}
}
