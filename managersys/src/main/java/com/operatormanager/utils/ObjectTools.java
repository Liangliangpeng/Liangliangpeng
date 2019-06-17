package com.operatormanager.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.ObjectUtils;


public class ObjectTools {

	public static Object readDeclaredField(Object target, String fieldName) {
		try {
			return FieldUtils.readDeclaredField(target, fieldName, true);
		} catch (IllegalAccessException e) {
		}
		return null;
	}

	public static Map<String, Object> listToMap(List<?> datas, String key, String value) {
		Map<String, Object> dataMap = new HashMap<>();
		if (ObjectUtils.isEmpty(datas)) {
			return dataMap;
		}
		for (Object data : datas) {
			if (data instanceof Map<?, ?>) {
				Map<?, ?> row = (Map<?, ?>) data;
				dataMap.put(toString(row.get(key)), toString(row.get(value)));
			} else {
				dataMap.put(toString(readDeclaredField(dataMap, key)), toString(readDeclaredField(dataMap, value)));
			}
		}
		
		return dataMap ;  
	}

	public static void writeDeclaredField(Object target, String fieldName, Object value) {
		try {

			Field field = FieldUtils.getField(target.getClass(), fieldName, true);
			Object objValue = null;
			if (field.getType().isAssignableFrom(Date.class)) {
				objValue = DateUtils.parseDate(toString(value), "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
			} else if (field.getType().isAssignableFrom(Double.class)) {
				objValue = NumberUtils.toDouble(toString(value));
			} else {
				objValue = value;
			}
			FieldUtils.writeDeclaredField(target, fieldName, objValue, true);

		} catch (Exception e) {
		}
	}

	public static int toInt(Object obj) {
		return NumberUtils.toInt(toString(obj));
	}

	public static double toDouble(Object obj) {
		return NumberUtils.toDouble(toString(obj));
	}

	public static long toLong(Object obj) {

		return NumberUtils.toLong(toString(obj));
	}

	public static Integer[] toInts(String[] array) {
		Integer[] ints = null;
		if (ObjectUtils.isEmpty(array)) {
			return ints;
		}
		for (String a : array) {
			ints = ArrayUtils.add(ints, toInt(a));
		}
		return ints;
	}

	public static Long[] toLongs(String[] array) {
		Long[] longs = null;
		if (ObjectUtils.isEmpty(array)) {
			return longs;
		}
		for (String a : array) {
			longs = ArrayUtils.add(longs, toLong(a));
		}
		return longs;
	}

	public static String toString(Object obj) {

		return null == obj ? StringUtils.EMPTY : obj.toString().trim();
	}

	public static String format(Object obj, int len) {
		String string = toString(obj);
		while (string.length() < len) {
			string = "0" + string;
		}
		return string;
	}
	

	public static int getLength(Object obj) {
		if (null == obj) {
			return 0;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj);
		} else if (obj instanceof Collection<?>) {
			Collection<?> coll = (Collection<?>) obj;
			return coll.size();
		}
		return 0;
	}

	public static Object getObj(Object obj, int index) {
		if (null == obj) {
			return null;
		}
		if (obj.getClass().isArray()) {
			return Array.get(obj, index);
		} else if (obj instanceof List<?>) {
			List<?> coll = (List<?>) obj;
			return coll.get(index);
		}
		return 0;
	}

	public static Date toDate(Object object) {
		String str = toString(object);
		try {
			return DateUtils.parseDate(str, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
		}
		return null;
	}
	
	public static boolean isNull(Object object) {
		
		if(null == object) {
			return true ;
		}
		
		return StringUtils.isBlank(toString(object));
	}

	public static int getTimeLength(String time) {
		return (int) toDouble(toString(time).replaceAll("天", "").replaceAll("小时", ""));
	}

}
