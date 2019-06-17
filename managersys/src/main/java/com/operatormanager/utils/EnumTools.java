package com.operatormanager.utils ;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Method;
import java.util.*;

public class EnumTools {
	
	public static String getText(Class<?> ref , Object code){
		return parseEumn(ref).get( String.valueOf(code) ) ;
	}

	public static <T> T parseToEumn(Class<T> ref , Integer data){

		if(data == null){return null;}

		T[] ts = ref.getEnumConstants() ;
		for(T t : ts){
			Enum<?> tempEnum = (Enum<?>) t ;
			int code = NumberUtils.toInt(getInvokeValue(t, "getCode") , -1);
			if(code == -1){
				code = tempEnum.ordinal() ;
			}
			if(code == data){
				return t ;
			}
		}
		return null ;
	}
	
	public static <T> T parseToEumn(Class<T> ref , String message){

		if(message == null){return null;}

		T[] ts = ref.getEnumConstants() ;
		for(T t : ts){
			String data = getInvokeValue(t, "getMessage") ;
			if(message.equalsIgnoreCase(data)){
				return t ;
			}
		}
		return null ;
	}
	
	public static <T> Map<String, String> parseEumn(Class<T> ref){
		Map<String, String> map = new LinkedHashMap<>() ;
		if(ref.isEnum()){
			T[] ts = ref.getEnumConstants() ; 
			for(T t : ts){
				String text = getInvokeValue(t, "getMessage") ;
				Enum<?> tempEnum = (Enum<?>) t ;
				if(text == null){
					text = tempEnum.name() ;
				}
				String code = getInvokeValue(t, "getCode") ; 
				if(code == null){
					code = String.valueOf( tempEnum.ordinal() );
				}
				map.put(code , text ) ; 
			}
		}
		return map ;
	}
	
	public static <T> String getInvokeValue(T t , String methodName){
		try {
			Method method = MethodUtils.getAccessibleMethod( t.getClass() , methodName);
			String text = String.valueOf(method.invoke( t )) ;
			return text ;
		} catch (Exception e) {
			return null ;
		}
	}


}