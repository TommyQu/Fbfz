package com.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.model.AndroidMessage;
import com.staticdatas.WholeDatas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class RemoteConnection {
	
	public static Bitmap getRemotePic (String uri)
	{
		HttpClient client=new DefaultHttpClient();
		HttpGet get=new HttpGet(WholeDatas.REMOTEADDRESS+uri);
		
		try {
			HttpResponse response=client.execute(get);
			if(response.getStatusLine().getStatusCode()==400)
			{
			InputStream is=response.getEntity().getContent();
			Bitmap picture=BitmapFactory.decodeStream(is);
			
			return picture;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String getRemoteText (String uri,Map<String, Object> paramMap)
	{
		HttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(WholeDatas.REMOTEADDRESS+uri);
		List<NameValuePair> pairs=new ArrayList<NameValuePair>();
		if(paramMap!=null)
		{
		for(Entry<String, Object> entry:paramMap.entrySet())
		{
			String key=entry.getKey();
			NameValuePair pair=new BasicNameValuePair(entry.getKey(),  String.valueOf( entry.getValue()));
			String name=pair.getName();
			String value=pair.getValue();
			Log.v("haha", name+"  "+value);
			pairs.add(pair);
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			HttpResponse response=client.execute(post);
			if(response.getStatusLine().getStatusCode()==200)
			{
				HttpEntity entity=response.getEntity();
				String result=EntityUtils.toString(entity,"UTF-8");
				return result;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param uri
	 * @param paramMap
	 * @param type new TypeToke<AndroidMessage<T>>(){}.getType();
	 * @return
	 */
	public static AndroidMessage postHttp (String uri,Map<String,Object> paramMap,Type type)
	{
		String result=getRemoteText(uri, paramMap);
		Gson gson=new Gson();
		AndroidMessage am=null;
		if(result!=null)
		{
			am=gson.fromJson(result, AndroidMessage.class);
			
			if(am.isSuccess())
			{
				am=gson.fromJson(result, type);
			}
			return am;
		}
		
		return null;
	}

}
