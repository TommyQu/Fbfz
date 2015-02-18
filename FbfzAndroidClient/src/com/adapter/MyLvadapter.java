package com.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fbfzandroidclient.R;
import com.holder.ShoplvHolder;
import com.holder.ViewHolder;
import com.staticdatas.WholeDatas;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyLvadapter extends BaseAdapter {

	private List<Map<String, Object>> datas;
	private Context context;
	private LayoutInflater flater;
	private LinearLayout layout;
	
	
	
	public MyLvadapter(List<Map<String, Object>> datas, Context context) {
		super();
		this.datas = datas;
		this.context = context;
		flater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ShoplvHolder holder;
		ImageView iv;
		TextView tv1;
		TextView tv2;
		if(convertView==null)
		{
			layout=(LinearLayout) flater.inflate(R.layout.shopsinfo_listview, null);
			iv=(ImageView) layout.findViewById(R.id.ivShoppic);
			tv1=(TextView) layout.findViewById(R.id.tvShopinfo);
			tv2=(TextView) layout.findViewById(R.id.tvShopGrade);
			convertView=layout;
			holder=new ShoplvHolder();
			holder.setIv(iv);
			holder.setTvinfo(tv1);
			holder.setTvGrade(tv2);
			convertView.setTag(holder);
		}
		else 
		{
			holder=(ShoplvHolder) convertView.getTag();
			iv=holder.getIv();
			tv1=holder.getTvinfo();
			tv2=holder.getTvGrade();
		}
		Map<String,Object> map=datas.get(position);
		Bitmap image=(Bitmap) map.get(WholeDatas.LVITEM[0]);
		String text1=(String) map.get(WholeDatas.LVITEM[1]);
		String text2=(String) map.get(WholeDatas.LVITEM[2]);
		iv.setImageBitmap(image);
		tv1.setText(text1);
		tv2.setText(text2);
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("mine", "caonima");
			}
		});
		
		return convertView;
	}

}
