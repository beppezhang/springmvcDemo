package bz.beppe.common;

import java.util.HashMap;
import java.util.Map;

public class CacheUtil {
 
     public static Map<String,String> cacheMap=new HashMap<String,String>();
     
     public static void setCache(String key,String value){
    	 cacheMap.put(key, value);
     }
     
     public static String getValue(String key){
    	return  cacheMap.get(key);
     }
}
