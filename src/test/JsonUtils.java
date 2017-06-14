package test;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.ObjectMorpher;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tsc.util.BeanUtil;

/**
 * 
 * 
 * 
 * @author shentuwy
 * @date 2012-7-26
 * 
 */
public final class JsonUtils {

	//private static final Logger	LOG	= LoggerFactory.getLogger(JsonUtils.class);
	
	private static final JsonConfig DEFAULT_JSON_CONFIG = new JsonConfig();
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static{
		DEFAULT_JSON_CONFIG.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor(){
			 @SuppressWarnings("rawtypes")
			public Object getDefaultValue( Class type ) {
				 if (BigDecimal.class.isAssignableFrom(type)) {
					 return "";
				 }
				 return super.getDefaultValue(type);
			 }
		});
		DEFAULT_JSON_CONFIG.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
			
			@Override
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				if (value != null) {
					if (value instanceof Date) {
						return DATE_FORMAT.format((Date)value);
					}else{
						return value;
					}
				}
				return null;
			}
			
			@Override
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				return null;
			}
		});
		
		DEFAULT_JSON_CONFIG.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessor() {
			
			@Override
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				if (value != null) {
					if (value instanceof java.sql.Date) {
						return DATE_FORMAT.format((Date)value);
					}else{
						return value;
					}
				}
				return null;
			}
			
			@Override
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				return null;
			}
		});
		
		DEFAULT_JSON_CONFIG.registerJsonValueProcessor(Timestamp.class, new JsonValueProcessor() {
			
			@Override
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				if (value != null) {
					if (value instanceof Timestamp) {
						return DATE_FORMAT.format((Date)value);
					}else{
						return value;
					}
				}
				return null;
			}
			
			@Override
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				return null;
			}
		});
		
		DEFAULT_JSON_CONFIG.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor(){
			 @SuppressWarnings("rawtypes")
			public Object getDefaultValue( Class type ) {
				 if (Long.class.isAssignableFrom(type)) {
					 return null;
				 }
				 return super.getDefaultValue(type);
			 }
		});
		
		DEFAULT_JSON_CONFIG.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor(){
			 @SuppressWarnings("rawtypes")
			public Object getDefaultValue( Class type ) {
				 if (Integer.class.isAssignableFrom(type)) {
					 return null;
				 }
				 return super.getDefaultValue(type);
			 }
		});
		
		DEFAULT_JSON_CONFIG.registerDefaultValueProcessor(Byte.class, new DefaultDefaultValueProcessor(){
			 @SuppressWarnings("rawtypes")
			public Object getDefaultValue( Class type ) {
				 if (Byte.class.isAssignableFrom(type)) {
					 return null;
				 }
				 return super.getDefaultValue(type);
			 }
		});
		
		DEFAULT_JSON_CONFIG.registerDefaultValueProcessor(String.class, new DefaultDefaultValueProcessor(){
			 @SuppressWarnings("rawtypes")
			public Object getDefaultValue( Class type ) {
				 if (String.class.isAssignableFrom(type)) {
					 return null;
				 }
				 return super.getDefaultValue(type);
			 }
		});
		
		JSONUtils.getMorpherRegistry().registerMorpher(new ObjectMorpher() {

			@Override
			public Class<Date> morphsTo() {
				return Date.class;
			}

			@Override
			public boolean supports(Class clazz) {
				return true;
			}

			@Override
			public Object morph(Object value) {
				Object ret = value;
				if (value != null && value instanceof String) {
					try{
						ret = DATE_FORMAT.parse((String)value);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				return ret;
			}
		
		});
	}
	
	
	private static final JsonConfig getJsonConfig(Class<?> beanClass){
		JsonConfig result = DEFAULT_JSON_CONFIG.copy();
		result.setRootClass(beanClass);
		if (beanClass != null) {
			try{
				Map classMap = new HashMap();
				PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanClass).getPropertyDescriptors();
				for (PropertyDescriptor pd : pdArray) {
					if (List.class.isAssignableFrom(pd.getPropertyType())) {
						Field field = BeanUtil.getBeanField(beanClass, pd.getName());
						if (ParameterizedType.class.isAssignableFrom(field.getGenericType().getClass())) {
							Class<?> genericType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
							classMap.put(pd.getName(), genericType);
						}
					}
				}
				if (!classMap.isEmpty()) {
					result.setClassMap(classMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String objectToJsonString(Object obj) {
		String ret = null;
		if (obj != null) {
			Object jsonObj = null;
			if (obj instanceof JSON) {
				jsonObj = obj;
			} else if (obj instanceof Collection<?> || obj.getClass().isArray()) {
				jsonObj = JSONArray.fromObject(obj,DEFAULT_JSON_CONFIG);
			} else {
				try {
					if (JSONUtils.isNumber( obj ) || JSONUtils.isBoolean( obj )
				            || JSONUtils.isString( obj )) {
						ret = String.valueOf(obj);
					}else{
						jsonObj = JSONObject.fromObject(obj,DEFAULT_JSON_CONFIG);
					}
				} catch (Exception e) {
//					log.error(e.getMessage(), e);
					ret = String.valueOf(obj);
				}
			}
			if (jsonObj != null) {
				ret = jsonObj.toString();
			}
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public static Collection<Map<String, Object>> stringToCollection(String str) {
		Collection<Map<String, Object>> ret = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			if (jsonStr.startsWith("[")) {
				JSONArray ja = JSONArray.fromObject(jsonStr);
				JsonConfig jsonConfig = DEFAULT_JSON_CONFIG.copy();
				jsonConfig.setRootClass(HashMap.class);
				ret = JSONArray.toCollection(ja, jsonConfig);
			}
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> stringToCollection(String str, Class<T> clazz) {
		Collection<T> ret = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			if (jsonStr.startsWith("[")) {
				JSONArray ja = JSONArray.fromObject(jsonStr);
				JsonConfig jsonConfig = DEFAULT_JSON_CONFIG.copy();
				jsonConfig.setRootClass(clazz);
				ret = JSONArray.toCollection(ja, jsonConfig);
			}
		}
		return ret;
	}

	public static final Object stringToObject(String str, Class<?> clazz) {
		Object t = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			JsonConfig jsonConfig = DEFAULT_JSON_CONFIG.copy();
			jsonConfig.setRootClass(clazz);
			if (jsonStr.startsWith("[")) {
				JSONArray jsonArray = JSONArray.fromObject(jsonStr);
				t = JSONArray.toCollection(jsonArray, jsonConfig);
			} else if (jsonStr.startsWith("{")) {
				JSONObject jsonObject = JSONObject.fromObject(jsonStr);
				t = JSONObject.toBean(jsonObject, jsonConfig);
			}
		}
		return t;
	}
	
	public static final Object string2Object(String str, Class<?> clazz){
		Object result = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			if (jsonStr.startsWith("[")) {
				JSONArray jsonArray = JSONArray.fromObject(jsonStr);
				JsonConfig jsonConfig = getJsonConfig(clazz);
				result = JSONArray.toCollection(jsonArray, jsonConfig);
			} else if (jsonStr.startsWith("{")) {
				JSONObject jsonObject = JSONObject.fromObject(jsonStr);
				JsonConfig jsonConfig = getJsonConfig(clazz);
				result = JSONObject.toBean(jsonObject, jsonConfig);
			}
		}
		return result;
	}

	public static final Object string2ObjectWithOutNullValue(String str, Class<?> clazz){
		Object result = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			if (jsonStr.startsWith("[")) {
				JSONArray jsonArray = JSONArray.fromObject(jsonStr);
				JSONArray jsonArrayWithoutNull = new JSONArray();
				for(int i = 0; i < jsonArray.size(); i ++){
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					JSONObject jsonObjectWithoutNull = getJsonObjectWithoutNULL(jsonObject);

					jsonArrayWithoutNull.add(jsonObjectWithoutNull);
				}
				JsonConfig jsonConfig = getJsonConfig(clazz);
				result = JSONArray.toCollection(jsonArrayWithoutNull, jsonConfig);
			} else if (jsonStr.startsWith("{")) {
				JSONObject jsonObject = JSONObject.fromObject(jsonStr);
				JSONObject  jsonObjectWithoutNull = getJsonObjectWithoutNULL(jsonObject);

				JsonConfig jsonConfig = getJsonConfig(clazz);
				result = JSONObject.toBean(jsonObjectWithoutNull, jsonConfig);
			}
		}
		return result;
	}

	private static JSONObject getJsonObjectWithoutNULL(JSONObject jsonObject){
		JSONObject  jsonObjectWithoutNull = new JSONObject();
		Iterator it = jsonObject.keys();
		while(it.hasNext()){
			Object key = it.next();
			Object value = jsonObject.get(key);
			if(!value.equals(null) && !value.equals("null")){
				if(value.getClass().getName().equals("java.lang.Integer")){
					value = "\""+value+"\"";
				}

				jsonObjectWithoutNull.put(key, value);
			}
		}

		return jsonObjectWithoutNull;
	}

	public static final Object stringToObject(String str, Class<?> clazz,Map<String, Class> classMap) {
		Object t = null;
		if (StringUtils.isNotBlank(str)) {
			String jsonStr = str.trim();
			if (jsonStr.startsWith("[")) {
				JSONArray jsonArray = JSONArray.fromObject(jsonStr);
				Object[] objs = (Object[])JSONArray.toArray(jsonArray, clazz, classMap);
				List ls = new ArrayList(objs.length);
				for(int i=0;i<objs.length;i++)
				{
					ls.add(objs[i]);
				}
				return ls;
			} else if (jsonStr.startsWith("{")) {
				JSONObject jsonObject = JSONObject.fromObject(jsonStr);
				t = JSONObject.toBean(jsonObject, clazz,classMap);
			}
		}
		return t;
	}
}
