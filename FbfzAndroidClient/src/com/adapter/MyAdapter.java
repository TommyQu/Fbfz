package com.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fbfzandroidclient.R;
import com.holder.ViewHolder;
import com.staticdatas.WholeDatas;

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

public class MyAdapter extends BaseAdapter {

	private List<Map<String, Object>> datas;
	private Context context;
	private LayoutInflater flater;
	private LinearLayout layout;
	
	
	
	public MyAdapter(List<Map<String, Object>> datas, Context context) {
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
		ViewHolder holder;
		ImageView iv;
		TextView tv;
		if(convertView==null)
		{
			layout=(LinearLayout) flater.inflate(R.layout.gridview_unit, null);
			iv=(ImageView) layout.findViewById(R.id.imgvpic);
			tv=(TextView) layout.findViewById(R.id.tvcontent);
			convertView=layout;
			holder=new ViewHolder();
			holder.setIv(iv);
			holder.setTv(tv);
			convertView.setTag(holder);
		}
		else 
		{
			holder=(ViewHolder) convertView.getTag();
			iv=holder.getIv();
			tv=holder.getTv();
		}
		Map<String,Object> map=datas.get(position);
		Bitmap image=(Bitmap) map.get(WholeDatas.GVITEM[0]);
		String text=(String) map.get(WholeDatas.GVITEM[1]);
		iv.setImageBitmap(image);
		tv.setText(text);
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		convertView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction()==MotionEvent.ACTION_DOWN)
				{
					v.setBackgroundColor(context.getResources().getColor(R.color.white));
				}
				else
					v.setBackgroundColor(context.getResources().getColor(R.color.orange));
				return true;
			}
		});
		return convertView;
	}

}
