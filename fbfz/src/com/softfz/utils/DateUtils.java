package com.softfz.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	private DateUtils() {
	}
	/**
	 * 获取第二天凌晨时间
	 * @return
	 */
	public static Date getNextZeroTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.get(Calendar.DAY_OF_MONTH) + 1);// 日期+1
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = dateFormat.format(date);
		try {
			Date zeroDate = dateFormat.parse(datestr);
			return zeroDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(DateUtils.getNextZeroTime());
	}
}
