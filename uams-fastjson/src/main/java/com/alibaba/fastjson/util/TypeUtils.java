/*
 * Copyright 1999-2017 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.fastjson.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author wenshao[szujobs@hotmail.com]
 */
public class TypeUtils {

    public static boolean   compatibleWithJavaBean      = false;
    
    /** 根据field name的大小写输出输入数据*/
    public static boolean   compatibleWithFieldName      = false;
    
    private static boolean  setAccessibleEnable         = true;

    private static boolean  oracleTimestampMethodInited = false;
    private static Method   oracleTimestampMethod;

    private static boolean  oracleDateMethodInited      = false;
    private static Method   oracleDateMethod;

    private static boolean  optionalClassInited         = false;
    private static Class<?> optionalClass;

    private static boolean transientClassInited         = false;
    private static Class<? extends Annotation> transientClass;

    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;

    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;

    static {
        try {
            TypeUtils.compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            TypeUtils.compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable e) {
            // skip
        }
    }


    public static String castToString(Object value) {
        if (value == null) {
            return null;
        }

        return value.toString();
    }

    public static Byte castToByte(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).byteValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            return Byte.parseByte(strVal);
        }

        throw new JSONException("can not cast to byte, value : " + value);
    }

    public static Character castToChar(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Character) {
            return (Character) value;
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0) {
                return null;
            }

            if (strVal.length() != 1) {
                throw new JSONException("can not cast to char, value : " + value);
            }

            return strVal.charAt(0);
        }

        throw new JSONException("can not cast to char, value : " + value);
    }

    public static Short castToShort(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            return Short.parseShort(strVal);
        }

        throw new JSONException("can not cast to short, value : " + value);
    }

    public static BigDecimal castToBigDecimal(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }

        if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value);
        }

        String strVal = value.toString();
        if (strVal.length() == 0) {
            return null;
        }

        if (value instanceof Map && ((Map) value).size() == 0) {
            return null;
        }

        return new BigDecimal(strVal);
    }

    public static BigInteger castToBigInteger(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }

        if (value instanceof Float || value instanceof Double) {
            return BigInteger.valueOf(((Number) value).longValue());
        }

        String strVal = value.toString();
        if (strVal.length() == 0 //
            || "null".equals(strVal) //
            || "NULL".equals(strVal)) {
            return null;
        }

        return new BigInteger(strVal);
    }

    public static Float castToFloat(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }

        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }
            
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Float.parseFloat(strVal);
        }

        throw new JSONException("can not cast to float, value : " + value);
    }

    public static Double castToDouble(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }

        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Double.parseDouble(strVal);
        }

        throw new JSONException("can not cast to double, value : " + value);
    }

    public static Date castToDate(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Date) { // 使用频率最高的，应优先处理
            return (Date) value;
        }

        if (value instanceof Calendar) {
            return ((Calendar) value).getTime();
        }

        long longValue = -1;

        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
            return new Date(longValue);
        }

        if (value instanceof String) {
            String strVal = (String) value;
            
            JSONScanner dateLexer = new JSONScanner(strVal);
            try {
                if (dateLexer.scanISO8601DateIfMatch(false)) {
                    Calendar calendar = dateLexer.getCalendar();
                    return calendar.getTime();
                }
            } finally {
                dateLexer.close();
            }
            
            if (strVal.startsWith("/Date(") && strVal.endsWith(")/")) {
                String dotnetDateStr = strVal.substring(6, strVal.length() - 2);
                strVal = dotnetDateStr;
            }

            if (strVal.indexOf('-') != -1) {
                String format;
                if (strVal.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    format = JSON.DEFFAULT_DATE_FORMAT;
                } else if (strVal.length() == 10) {
                    format = "yyyy-MM-dd";
                } else if (strVal.length() == "yyyy-MM-dd HH:mm:ss".length()) {
                    format = "yyyy-MM-dd HH:mm:ss";
                } else if (strVal.length() == 29
                        && strVal.charAt(26) == ':'
                        && strVal.charAt(28) == '0') {
                    format = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                } else {
                    format = "yyyy-MM-dd HH:mm:ss.SSS";
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat(format, JSON.defaultLocale);
                dateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return (Date) dateFormat.parse(strVal);
                } catch (ParseException e) {
                    throw new JSONException("can not cast to Date, value : " + strVal);
                }
            }

            if (strVal.length() == 0) {
                return null;
            }

            longValue = Long.parseLong(strVal);
        }

        if (longValue < 0) {
            Class<?> clazz = value.getClass();
            if ("oracle.sql.TIMESTAMP".equals(clazz.getName())) {
                if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                    try {
                        oracleTimestampMethod = clazz.getMethod("toJdbc");
                    } catch (NoSuchMethodException e) {
                        // skip
                    } finally {
                        oracleTimestampMethodInited = true;
                    }
                }

                Object result;
                try {
                    result = oracleTimestampMethod.invoke(value);
                } catch (Exception e) {
                    throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
                }
                return (Date) result;
            }

            if ("oracle.sql.DATE".equals(clazz.getName())) {
                if (oracleDateMethod == null && !oracleDateMethodInited) {
                    try {
                        oracleDateMethod = clazz.getMethod("toJdbc");
                    } catch (NoSuchMethodException e) {
                        // skip
                    } finally {
                        oracleDateMethodInited = true;
                    }
                }

                Object result;
                try {
                    result = oracleDateMethod.invoke(value);
                } catch (Exception e) {
                    throw new JSONException("can not cast oracle.sql.DATE to Date", e);
                }
                return (Date) result;
            }

            throw new JSONException("can not cast to Date, value : " + value);
        }

        return new Date(longValue);
    }

    public static java.sql.Date castToSqlDate(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof java.sql.Date) {
            return (java.sql.Date) value;
        }

        if (value instanceof Date) {
            return new java.sql.Date(((Date) value).getTime());
        }

        if (value instanceof Calendar) {
            return new java.sql.Date(((Calendar) value).getTimeInMillis());
        }

        long longValue = 0;

        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            if (isNumber(strVal)) {
                longValue = Long.parseLong(strVal);
            } else {
                JSONScanner scanner = new JSONScanner(strVal);
                if (scanner.scanISO8601DateIfMatch(false)) {
                    longValue = scanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + strVal);
                }
            }
        }

        if (longValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + value); // TODO 忽略 1970-01-01 之前的时间处理？
        }

        return new java.sql.Date(longValue);
    }

    public static java.sql.Timestamp castToTimestamp(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Calendar) {
            return new java.sql.Timestamp(((Calendar) value).getTimeInMillis());
        }

        if (value instanceof java.sql.Timestamp) {
            return (java.sql.Timestamp) value;
        }

        if (value instanceof Date) {
            return new java.sql.Timestamp(((Date) value).getTime());
        }

        long longValue = 0;

        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            if (isNumber(strVal)) {
                longValue = Long.parseLong(strVal);
            } else {
                JSONScanner scanner = new JSONScanner(strVal);
                if (scanner.scanISO8601DateIfMatch(false)) {
                    longValue = scanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + strVal);
                }
            }
        }

        if (longValue <= 0) {
            throw new JSONException("can not cast to Timestamp, value : " + value);
        }

        return new java.sql.Timestamp(longValue);
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-') {
                if (i != 0) {
                    return false;
                } else {
                    continue;
                }
            } else if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }

    public static Long castToLong(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).longValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }
            
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            try {
                return Long.parseLong(strVal);
            } catch (NumberFormatException ex) {
                //
            }

            JSONScanner dateParser = new JSONScanner(strVal);
            Calendar calendar = null;
            if (dateParser.scanISO8601DateIfMatch(false)) {
                calendar = dateParser.getCalendar();
            }
            dateParser.close();

            if (calendar != null) {
                return calendar.getTimeInMillis();
            }
        }

        if (value instanceof Map) {
            Map map = (Map) value;
            if (map.size() == 2
                    && map.containsKey("andIncrement")
                    && map.containsKey("andDecrement")) {
                Iterator iter = map.values().iterator();
                iter.next();
                Object value2 = iter.next();
                return castToLong(value2);
            }
        }

        throw new JSONException("can not cast to long, value : " + value);
    }

    public static Integer castToInt(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Integer) {
            return (Integer) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }
            
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Integer.parseInt(strVal);
        }

        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue() ? 1 : 0;
        }

        if (value instanceof Map) {
            Map map = (Map) value;
            if (map.size() == 2
                    && map.containsKey("andIncrement")
                    && map.containsKey("andDecrement")) {
                Iterator iter = map.values().iterator();
                iter.next();
                Object value2 = iter.next();
                return castToInt(value2);
            }
        }

        throw new JSONException("can not cast to int, value : " + value);
    }

    public static byte[] castToBytes(Object value) {
        if (value instanceof byte[]) {
            return (byte[]) value;
        }

        if (value instanceof String) {
            return IOUtils.decodeBase64((String) value);
        }
        throw new JSONException("can not cast to int, value : " + value);
    }

    public static Boolean castToBoolean(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue() == 1;
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            if ("true".equalsIgnoreCase(strVal) //
                || "1".equals(strVal)) {
                return Boolean.TRUE;
            }
            
            if ("false".equalsIgnoreCase(strVal) //
                || "0".equals(strVal)) {
                return Boolean.FALSE;
            }

            if ("Y".equalsIgnoreCase(strVal) //
                    || "T".equals(strVal)) {
                return Boolean.TRUE;
            }

            if ("F".equalsIgnoreCase(strVal) //
                    || "N".equals(strVal)) {
                return Boolean.FALSE;
            }
        }

        throw new JSONException("can not cast to boolean, value : " + value);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> clazz) {
        return cast(obj, clazz, ParserConfig.getGlobalInstance());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T cast(Object obj, Class<T> clazz, ParserConfig config) {
        if (obj == null) {
            if (clazz == int.class) {
                return (T) Integer.valueOf(0);
            } else if (clazz == long.class) {
                return (T) Long.valueOf(0);
            } else if (clazz == short.class) {
                return (T) Short.valueOf((short) 0);
            } else if (clazz == byte.class) {
                return (T) Byte.valueOf((byte) 0);
            } else if (clazz == float.class) {
                return (T) Float.valueOf(0);
            } else if (clazz == double.class) {
                return (T) Double.valueOf(0);
            } else if (clazz == boolean.class) {
                return (T) Boolean.FALSE;
            }
            return null;
        }

        if (clazz == null) {
            throw new IllegalArgumentException("clazz is null");
        }

        if (clazz == obj.getClass()) {
            return (T) obj;
        }

        if (obj instanceof Map) {
            if (clazz == Map.class) {
                return (T) obj;
            }

            Map map = (Map) obj;
            if (clazz == Object.class && !map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                return (T) obj;
            }

            return castToJavaBean((Map<String, Object>) obj, clazz, config);
        }

        if (clazz.isArray()) {
            if (obj instanceof Collection) {

                Collection collection = (Collection) obj;
                int index = 0;
                Object array = Array.newInstance(clazz.getComponentType(), collection.size());
                for (Object item : collection) {
                    Object value = cast(item, clazz.getComponentType(), config);
                    Array.set(array, index, value);
                    index++;
                }

                return (T) array;
            }

            if (clazz == byte[].class) {
                return (T) castToBytes(obj);
            }
        }

        if (clazz.isAssignableFrom(obj.getClass())) {
            return (T) obj;
        }

        if (clazz == boolean.class || clazz == Boolean.class) {
            return (T) castToBoolean(obj);
        }

        if (clazz == byte.class || clazz == Byte.class) {
            return (T) castToByte(obj);
        }

        if (clazz == char.class || clazz == Character.class) {
            return (T) castToChar(obj);
        }

        if (clazz == short.class || clazz == Short.class) {
            return (T) castToShort(obj);
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) castToInt(obj);
        }

        if (clazz == long.class || clazz == Long.class) {
            return (T) castToLong(obj);
        }

        if (clazz == float.class || clazz == Float.class) {
            return (T) castToFloat(obj);
        }

        if (clazz == double.class || clazz == Double.class) {
            return (T) castToDouble(obj);
        }

        if (clazz == String.class) {
            return (T) castToString(obj);
        }

        if (clazz == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }

        if (clazz == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }

        if (clazz == Date.class) {
            return (T) castToDate(obj);
        }

        if (clazz == java.sql.Date.class) {
            return (T) castToSqlDate(obj);
        }

        if (clazz == java.sql.Timestamp.class) {
            return (T) castToTimestamp(obj);
        }

        if (clazz.isEnum()) {
            return (T) castToEnum(obj, clazz, config);
        }

        if (Calendar.class.isAssignableFrom(clazz)) {
            Date date = castToDate(obj);
            Calendar calendar;
            if (clazz == Calendar.class) {
                calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            } else {
                try {
                    calendar = (Calendar) clazz.newInstance();
                } catch (Exception e) {
                    throw new JSONException("can not cast to : " + clazz.getName(), e);
                }
            }
            calendar.setTime(date);
            return (T) calendar;
        }

        if (clazz.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
            Date date = castToDate(obj);
            Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
            calendar.setTime(date);

            return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar);
        }

        if (obj instanceof String) {
            String strVal = (String) obj;

            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }

            if (clazz == Currency.class) {
                return (T) Currency.getInstance(strVal);
            }

            if (clazz == Locale.class) {
                return (T) toLocale(strVal);
            }
        }

        throw new JSONException("can not cast to : " + clazz.getName());
    }

    public static Locale toLocale(String strVal) {
        String[] items = strVal.split("_");

        if (items.length == 1) {
            return new Locale(items[0]);
        }

        if (items.length == 2) {
            return new Locale(items[0], items[1]);
        }

        return new Locale(items[0], items[1], items[2]);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T castToEnum(Object obj, Class<T> clazz, ParserConfig mapping) {
        try {
            if (obj instanceof String) {
                String name = (String) obj;
                if (name.length() == 0) {
                    return null;
                }

                return (T) Enum.valueOf((Class<? extends Enum>) clazz, name);
            }

            if (obj instanceof Number) {
                int ordinal = ((Number) obj).intValue();
                Object[] values = clazz.getEnumConstants();
                if (ordinal < values.length) {
                    return (T) values[ordinal];
                }
            }
        } catch (Exception ex) {
            throw new JSONException("can not cast to : " + clazz.getName(), ex);
        }

        throw new JSONException("can not cast to : " + clazz.getName());
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj, Type type, ParserConfig mapping) {
        if (obj == null) {
            return null;
        }

        if (type instanceof Class) {
            return (T) cast(obj, (Class<T>) type, mapping);
        }

        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, mapping);
        }

        if (obj instanceof String) {
            String strVal = (String) obj;
            if (strVal.length() == 0 //
                || "null".equals(strVal) //
                || "NULL".equals(strVal)) {
                return null;
            }
        }

        if (type instanceof TypeVariable) {
            return (T) obj;
        }

        throw new JSONException("can not cast to : " + type);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T cast(Object obj, ParameterizedType type, ParserConfig mapping) {
        Type rawTye = type.getRawType();

        if (rawTye == Set.class || rawTye == HashSet.class //
            || rawTye == TreeSet.class //
            || rawTye == List.class //
            || rawTye == ArrayList.class) {
            Type itemType = type.getActualTypeArguments()[0];

            if (obj instanceof Iterable) {
                Collection collection;
                if (rawTye == Set.class || rawTye == HashSet.class) {
                    collection = new HashSet();
                } else if (rawTye == TreeSet.class) {
                    collection = new TreeSet();
                } else {
                    collection = new ArrayList();
                }

                for (Iterator it = ((Iterable) obj).iterator(); it.hasNext();) {
                    Object item = it.next();
                    collection.add(cast(item, itemType, mapping));
                }

                return (T) collection;
            }
        }

        if (rawTye == Map.class || rawTye == HashMap.class) {
            Type keyType = type.getActualTypeArguments()[0];
            Type valueType = type.getActualTypeArguments()[1];

            if (obj instanceof Map) {
                Map map = new HashMap();

                for (Map.Entry entry : ((Map<?, ?>) obj).entrySet()) {
                    Object key = cast(entry.getKey(), keyType, mapping);
                    Object value = cast(entry.getValue(), valueType, mapping);

                    map.put(key, value);
                }

                return (T) map;
            }
        }

        if (obj instanceof String) {
            String strVal = (String) obj;
            if (strVal.length() == 0) {
                return null;
            }
        }

        if (type.getActualTypeArguments().length == 1) {
            Type argType = type.getActualTypeArguments()[0];
            if (argType instanceof WildcardType) {
                return (T) cast(obj, rawTye, mapping);
            }
        }

        throw new JSONException("can not cast to : " + type);
    }

    @SuppressWarnings({ "unchecked" })
    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> clazz, ParserConfig config) {
        try {
            if (clazz == StackTraceElement.class) {
                String declaringClass = (String) map.get("className");
                String methodName = (String) map.get("methodName");
                String fileName = (String) map.get("fileName");
                int lineNumber;
                {
                    Number value = (Number) map.get("lineNumber");
                    if (value == null) {
                        lineNumber = 0;
                    } else {
                        lineNumber = value.intValue();
                    }
                }

                return (T) new StackTraceElement(declaringClass, methodName, fileName, lineNumber);
            }

            {
                Object iClassObject = map.get(JSON.DEFAULT_TYPE_KEY);
                if (iClassObject instanceof String) {
                    String className = (String) iClassObject;

                    Class<?> loadClazz;
                    if (config == null) {
                        config = ParserConfig.global;
                    }
                    loadClazz = config.checkAutoType(className, null);

                    if (loadClazz == null) {
                        throw new ClassNotFoundException(className + " not found");
                    }

                    if (!loadClazz.equals(clazz)) {
                        return (T) castToJavaBean(map, loadClazz, config);
                    }
                }
            }

            if (clazz.isInterface()) {
                JSONObject object;

                if (map instanceof JSONObject) {
                    object = (JSONObject) map;
                } else {
                    object = new JSONObject(map);
                }

                if (config == null) {
                    config = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = config.getDeserializers().get(clazz);
                if (deserializer != null) {
                    String json = JSON.toJSONString(object);
                    return (T) JSON.parseObject(json, clazz);
                }

                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                                  new Class<?>[] { clazz }, object);
            }

            if (clazz == Locale.class) {
                Object arg0 = map.get("language");
                Object arg1 = map.get("country");
                if (arg0 instanceof String) {
                    String language = (String) arg0;
                    if (arg1 instanceof String) {
                        String country = (String) arg1;
                        return (T) new Locale(language, country);
                    } else if (arg1 == null) {
                        return (T) new Locale(language);
                    }
                }
            }

            if (clazz == String.class && map instanceof JSONObject) {
                return (T) map.toString();
            }

            if (config == null) {
                config = ParserConfig.getGlobalInstance();
            }

            JavaBeanDeserializer javaBeanDeser = null;
            ObjectDeserializer deserizer = config.getDeserializer(clazz);
            if (deserizer instanceof JavaBeanDeserializer) {
                javaBeanDeser = (JavaBeanDeserializer) deserizer;
            }
            
            if (javaBeanDeser == null) {
                throw new JSONException("can not get javaBeanDeserializer. " + clazz.getName());
            }
            
            return (T) javaBeanDeser.createInstance(map, config);
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap<String, Class<?>>(16, 0.75f, 1);

    static {
        addBaseClassMappings();
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", byte.class);
        mappings.put("short", short.class);
        mappings.put("int", int.class);
        mappings.put("long", long.class);
        mappings.put("float", float.class);
        mappings.put("double", double.class);
        mappings.put("boolean", boolean.class);
        mappings.put("char", char.class);

        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);

        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);

        Class<?>[] classes = new Class[] {
                Object.class,
                Cloneable.class,
                loadClass("java.lang.AutoCloseable"),
                Exception.class,
                RuntimeException.class,
                IllegalAccessError.class,
                IllegalAccessException.class,
                IllegalArgumentException.class,
                IllegalMonitorStateException.class,
                IllegalStateException.class,
                IllegalThreadStateException.class,
                IndexOutOfBoundsException.class,
                InstantiationError.class,
                InstantiationException.class,
                InternalError.class,
                InterruptedException.class,
                LinkageError.class,
                NegativeArraySizeException.class,
                NoClassDefFoundError.class,
                NoSuchFieldError.class,
                NoSuchFieldException.class,
                NoSuchMethodError.class,
                NoSuchMethodException.class,
                NullPointerException.class,
                NumberFormatException.class,
                OutOfMemoryError.class,
                SecurityException.class,
                StackOverflowError.class,
                StringIndexOutOfBoundsException.class,
                TypeNotPresentException.class,
                VerifyError.class,
                StackTraceElement.class,
                HashMap.class,
                Hashtable.class,
                TreeMap.class,
                IdentityHashMap.class,
                WeakHashMap.class,
                LinkedHashMap.class,
                HashSet.class,
                LinkedHashSet.class,
                TreeSet.class,
                java.util.concurrent.TimeUnit.class,
                ConcurrentHashMap.class,
                loadClass("java.util.concurrent.ConcurrentSkipListMap"),
                loadClass("java.util.concurrent.ConcurrentSkipListSet"),
                java.util.concurrent.atomic.AtomicInteger.class,
                java.util.concurrent.atomic.AtomicLong.class,
                Collections.EMPTY_MAP.getClass(),
                BitSet.class,
                Calendar.class,
                Date.class,
                Locale.class,
                UUID.class,
                java.sql.Time.class,
                java.sql.Date.class,
                java.sql.Timestamp.class,
                SimpleDateFormat.class,
                com.alibaba.fastjson.JSONObject.class,
        };

        for (Class clazz : classes) {
            if (clazz == null) {
                continue;
            }
            mappings.put(clazz.getName(), clazz);
        }

        String[] awt = new String[] {
                "java.awt.Rectangle",
                "java.awt.Point",
                "java.awt.Font",
                "java.awt.Color"};
        for (String className : awt) {
            Class<?> clazz = loadClass(className);
            if (clazz == null) {
                break;
            }
            mappings.put(clazz.getName(), clazz);
        }

        String[] spring = new String[] {
                "org.springframework.util.LinkedMultiValueMap",
                "org.springframework.util.LinkedCaseInsensitiveMap",
                "org.springframework.remoting.support.RemoteInvocation",
                "org.springframework.remoting.support.RemoteInvocationResult"
        };
        for (String className : spring) {
            Class<?> clazz = loadClass(className);
            if (clazz == null) {
                break;
            }
            mappings.put(clazz.getName(), clazz);
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static Class<?> loadClass(String className) {
        return loadClass(className, null);
    }
    
    private static Class<?> pathClass;
    private static boolean pathClass_error = false;
    public static boolean isPath(Class<?> clazz) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Class.forName("java.nio.file.Path");
            } catch (Throwable ex) {
                pathClass_error = true;
            }
        }
        
        if (pathClass != null) {
            return pathClass.isAssignableFrom(clazz);
        }
        
        return false;
    }

    public static Class<?> getClassFromMapping(String className) {
        return mappings.get(className);
    }

    public static Class<?> loadClass(String className, ClassLoader classLoader) {
        if (className == null || className.length() == 0) {
            return null;
        }

        Class<?> clazz = mappings.get(className);

        if (clazz != null) {
            return clazz;
        }

        if (className.charAt(0) == '[') {
            Class<?> componentType = loadClass(className.substring(1), classLoader);
            return Array.newInstance(componentType, 0).getClass();
        }

        if (className.startsWith("L") && className.endsWith(";")) {
            String newClassName = className.substring(1, className.length() - 1);
            return loadClass(newClassName, classLoader);
        }

        try {
            if (classLoader != null) {
                clazz = classLoader.loadClass(className);
                mappings.put(className, clazz);

                return clazz;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            // skip
        }

        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

            if (contextClassLoader != null && contextClassLoader != classLoader) {
                clazz = contextClassLoader.loadClass(className);
                mappings.put(className, clazz);

                return clazz;
            }
        } catch (Throwable e) {
            // skip
        }

        try {
            clazz = Class.forName(className);
            mappings.put(className, clazz);

            return clazz;
        } catch (Throwable e) {
            // skip
        }

        return clazz;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> beanType //
            , Map<String, String> aliasMap //
            , PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(beanType, aliasMap, propertyNamingStrategy, false);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> beanType //
            , Map<String, String> aliasMap //
            , PropertyNamingStrategy propertyNamingStrategy //
            , boolean fieldBased //
    ) {
        
        JSONType jsonType = beanType.getAnnotation(JSONType.class);
        String[] orders = null;

        final int features;
        String typeName = null, typeKey = null;
        if (jsonType != null) {
            orders = jsonType.orders();
            typeName = jsonType.typeName();
            if (typeName.length() == 0) {
                typeName = null;
            }
            features = SerializerFeature.of(jsonType.serialzeFeatures());
            for (Class<?> supperClass = beanType.getSuperclass()
                 ; supperClass != null && supperClass != Object.class
                    ; supperClass = supperClass.getSuperclass()) {
                JSONType superJsonType = supperClass.getAnnotation(JSONType.class);
                if (superJsonType == null) {
                    break;
                }

                typeKey = superJsonType.typeKey();
                if (typeKey.length() != 0) {
                    break;
                }
            }

            for (Class<?> interfaceClass : beanType.getInterfaces()) {
                JSONType superJsonType = interfaceClass.getAnnotation(JSONType.class);
                if (superJsonType != null) {
                    typeKey = superJsonType.typeKey();
                    if (typeKey.length() != 0) {
                        break;
                    }
                }
            }
            if (typeKey != null && typeKey.length() == 0) {
                typeKey = null;
            }
        } else {
            features = 0;
        }

        // fieldName,field ，先生成fieldName的快照，减少之后的findField的轮询
        Map<String, Field> fieldCacheMap = new HashMap<String, Field>();
        ParserConfig.parserAllFieldToCache(beanType, fieldCacheMap);

        List<FieldInfo> fieldInfoList = fieldBased
                ? computeGettersWithFieldBase(beanType, aliasMap, false, propertyNamingStrategy) //
                : computeGetters(beanType, jsonType, aliasMap, fieldCacheMap, false, propertyNamingStrategy);
        FieldInfo[] fields = new FieldInfo[fieldInfoList.size()];
        fieldInfoList.toArray(fields);
        
        FieldInfo[] sortedFields;
        List<FieldInfo> sortedFieldList;
        if (orders != null && orders.length != 0) {
            sortedFieldList = fieldBased
                    ? computeGettersWithFieldBase(beanType, aliasMap, true, propertyNamingStrategy) //
                    : computeGetters(beanType, jsonType, aliasMap,fieldCacheMap, true, propertyNamingStrategy);
        } else {
            sortedFieldList = new ArrayList<FieldInfo>(fieldInfoList);
            Collections.sort(sortedFieldList);
        }
        sortedFields = new FieldInfo[sortedFieldList.size()];
        sortedFieldList.toArray(sortedFields);
        
        if (Arrays.equals(sortedFields, fields)) {
            sortedFields = fields;
        }
        
        return new SerializeBeanInfo(beanType, jsonType, typeName, typeKey, features, fields, sortedFields);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(
            Class<?> clazz, //
            Map<String, String> aliasMap, //
            boolean sorted, //
            PropertyNamingStrategy propertyNamingStrategy) {
        Map<String, FieldInfo> fieldInfoMap = new LinkedHashMap<String, FieldInfo>();

        for (Class<?> currentClass = clazz; currentClass != null; currentClass = currentClass.getSuperclass()) {
            Field[] fields = currentClass.getDeclaredFields();

            computeFields(currentClass, aliasMap, propertyNamingStrategy, fieldInfoMap, fields);
        }

        return getFieldInfos(clazz, sorted, fieldInfoMap);
    }

    public static List<FieldInfo> computeGetters(Class<?> clazz, Map<String, String> aliasMap) {
        return computeGetters(clazz, aliasMap, true);
    }

    public static List<FieldInfo> computeGetters(Class<?> clazz, Map<String, String> aliasMap, boolean sorted) {
        JSONType jsonType = clazz.getAnnotation(JSONType.class);
        Map<String, Field> fieldCacheMap = new HashMap<String, Field>();
        ParserConfig.parserAllFieldToCache(clazz, fieldCacheMap);

        return computeGetters(clazz, jsonType, aliasMap, fieldCacheMap, sorted, PropertyNamingStrategy.CamelCase);
    }

    public static List<FieldInfo> computeGetters(Class<?> clazz, //
                                                 JSONType jsonType, //
                                                 Map<String, String> aliasMap, //
                                                 Map<String, Field> fieldCacheMap, //
                                                 boolean sorted, //
                                                 PropertyNamingStrategy propertyNamingStrategy //
    ) {
        Map<String, FieldInfo> fieldInfoMap = new LinkedHashMap<String, FieldInfo>();

        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            int ordinal = 0, serialzeFeatures = 0, parserFeatures = 0;
            String label = null;

            if (Modifier.isStatic(method.getModifiers())) {
                continue;
            }

            if (method.getReturnType().equals(Void.TYPE)) {
                continue;
            }

            if (method.getParameterTypes().length != 0) {
                continue;
            }

            if (method.getReturnType() == ClassLoader.class) {
                continue;
            }

            if (method.getName().equals("getMetaClass")
                && method.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                continue;
            }

            JSONField annotation = method.getAnnotation(JSONField.class);

            if (annotation == null) {
                annotation = getSuperMethodAnnotation(clazz, method);
            }

            if (annotation != null) {
                if (!annotation.serialize()) {
                    continue;
                }

                ordinal = annotation.ordinal();
                serialzeFeatures = SerializerFeature.of(annotation.serialzeFeatures());
                parserFeatures = Feature.of(annotation.parseFeatures());

                if (annotation.name().length() != 0) {
                    String propertyName = annotation.name();

                    if (aliasMap != null) {
                        propertyName = aliasMap.get(propertyName);
                        if (propertyName == null) {
                            continue;
                        }
                    }

                    FieldInfo fieldInfo = new FieldInfo(propertyName, method, null, clazz, null, ordinal,
                                                        serialzeFeatures, parserFeatures, annotation, null, label);
                    fieldInfoMap.put(propertyName, fieldInfo);
                    continue;
                }

                if (annotation.label().length() != 0) {
                    label = annotation.label();
                }
            }

            if (methodName.startsWith("get")) {
                if (methodName.length() < 4) {
                    continue;
                }

                if (methodName.equals("getClass")) {
                    continue;
                }

                if (methodName.equals("getDeclaringClass") && clazz.isEnum()) {
                    continue;
                }

                char c3 = methodName.charAt(3);

                String propertyName;
                if (Character.isUpperCase(c3) //
                    || c3 > 512 // for unicode method name
                ) {
                   if (compatibleWithJavaBean) {
                        propertyName = decapitalize(methodName.substring(3));
                    } else {
                        propertyName = Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4);
                    }
                    propertyName = getPropertyNameByCompatibleFieldName(fieldCacheMap, methodName,  propertyName,3);
                } else if (c3 == '_') {
                    propertyName = methodName.substring(4);
                } else if (c3 == 'f') {
                    propertyName = methodName.substring(3);
                } else if (methodName.length() >= 5 && Character.isUpperCase(methodName.charAt(4))) {
                    propertyName = decapitalize(methodName.substring(3));
                } else {
                    continue;
                }

                boolean ignore = isJSONTypeIgnore(clazz, propertyName);

                if (ignore) {
                    continue;
                }
                //假如bean的field很多的情况一下，轮询时将大大降低效率
                Field field = ParserConfig.getFieldFromCache(propertyName, fieldCacheMap);

                if (field == null && propertyName.length() > 1) {
                    char ch = propertyName.charAt(1);
                    if (ch >= 'A' && ch <= 'Z') {
                        String javaBeanCompatiblePropertyName = decapitalize(methodName.substring(3));
                        field = ParserConfig.getFieldFromCache(javaBeanCompatiblePropertyName, fieldCacheMap);
                    }
                }

                JSONField fieldAnnotation = null;
                if (field != null) {
                    fieldAnnotation = field.getAnnotation(JSONField.class);

                    if (fieldAnnotation != null) {
                        if (!fieldAnnotation.serialize()) {
                            continue;
                        }

                        ordinal = fieldAnnotation.ordinal();
                        serialzeFeatures = SerializerFeature.of(fieldAnnotation.serialzeFeatures());
                        parserFeatures = Feature.of(fieldAnnotation.parseFeatures());

                        if (fieldAnnotation.name().length() != 0) {
                            propertyName = fieldAnnotation.name();

                            if (aliasMap != null) {
                                propertyName = aliasMap.get(propertyName);
                                if (propertyName == null) {
                                    continue;
                                }
                            }
                        }

                        if (fieldAnnotation.label().length() != 0) {
                            label = fieldAnnotation.label();
                        }
                    }
                }

                if (aliasMap != null) {
                    propertyName = aliasMap.get(propertyName);
                    if (propertyName == null) {
                        continue;
                    }
                }

                if (propertyNamingStrategy != null) {
                    propertyName = propertyNamingStrategy.translate(propertyName);
                }

                FieldInfo fieldInfo = new FieldInfo(propertyName, method, field, clazz, null, ordinal, serialzeFeatures, parserFeatures,
                                                    annotation, fieldAnnotation, label);
                fieldInfoMap.put(propertyName, fieldInfo);
            }

            if (methodName.startsWith("is")) {
                if (methodName.length() < 3) {
                    continue;
                }

                if (method.getReturnType() != Boolean.TYPE
                        && method.getReturnType() != Boolean.class) {
                    continue;
                }

                char c2 = methodName.charAt(2);

                String propertyName;
                if (Character.isUpperCase(c2)) {
                    if (compatibleWithJavaBean) {
                        propertyName = decapitalize(methodName.substring(2));
                    } else {
                        propertyName = Character.toLowerCase(methodName.charAt(2)) + methodName.substring(3);
                    }
                    propertyName = getPropertyNameByCompatibleFieldName(fieldCacheMap, methodName,  propertyName,2);
                } else if (c2 == '_') {
                    propertyName = methodName.substring(3);
                } else if (c2 == 'f') {
                    propertyName = methodName.substring(2);
                } else {
                    continue;
                }

                boolean ignore = isJSONTypeIgnore(clazz, propertyName);

                if (ignore) {
                    continue;
                }

                Field field = ParserConfig.getFieldFromCache(propertyName,fieldCacheMap);

                if (field == null) {
                    field = ParserConfig.getFieldFromCache(methodName,fieldCacheMap);
                }

                JSONField fieldAnnotation = null;
                if (field != null) {
                    fieldAnnotation = field.getAnnotation(JSONField.class);

                    if (fieldAnnotation != null) {
                        if (!fieldAnnotation.serialize()) {
                            continue;
                        }

                        ordinal = fieldAnnotation.ordinal();
                        serialzeFeatures = SerializerFeature.of(fieldAnnotation.serialzeFeatures());
                        parserFeatures = Feature.of(fieldAnnotation.parseFeatures());

                        if (fieldAnnotation.name().length() != 0) {
                            propertyName = fieldAnnotation.name();

                            if (aliasMap != null) {
                                propertyName = aliasMap.get(propertyName);
                                if (propertyName == null) {
                                    continue;
                                }
                            }
                        }

                        if (fieldAnnotation.label().length() != 0) {
                            label = fieldAnnotation.label();
                        }
                    }
                }

                if (aliasMap != null) {
                    propertyName = aliasMap.get(propertyName);
                    if (propertyName == null) {
                        continue;
                    }
                }

                if (propertyNamingStrategy != null) {
                    propertyName = propertyNamingStrategy.translate(propertyName);
                }

                //优先选择get
                if (fieldInfoMap.containsKey(propertyName)) {
                    continue;
                }

                FieldInfo fieldInfo = new FieldInfo(propertyName, method, field, clazz, null, ordinal, serialzeFeatures, parserFeatures,
                                                    annotation, fieldAnnotation, label);
                fieldInfoMap.put(propertyName, fieldInfo);
            }
        }

        Field[] fields = clazz.getFields();
        computeFields(clazz, aliasMap, propertyNamingStrategy, fieldInfoMap, fields);

        return getFieldInfos(clazz, sorted, fieldInfoMap);
    }

    private static List<FieldInfo> getFieldInfos(Class<?> clazz, boolean sorted, Map<String, FieldInfo> fieldInfoMap) {
        List<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();

        boolean containsAll = false;
        String[] orders = null;

        JSONType annotation = clazz.getAnnotation(JSONType.class);
        if (annotation != null) {
            orders = annotation.orders();

            if (orders != null && orders.length == fieldInfoMap.size()) {
                containsAll = true;
                for (String item : orders) {
                    if (!fieldInfoMap.containsKey(item)) {
                        containsAll = false;
                        break;
                    }
                }
            } else {
                containsAll = false;
            }
        }

        if (containsAll) {
            for (String item : orders) {
                FieldInfo fieldInfo = fieldInfoMap.get(item);
                fieldInfoList.add(fieldInfo);
            }
        } else {
            for (FieldInfo fieldInfo : fieldInfoMap.values()) {
                fieldInfoList.add(fieldInfo);
            }

            if (sorted) {
                Collections.sort(fieldInfoList);
            }
        }

        return fieldInfoList;
    }

    private static void computeFields(
            Class<?> clazz, //
            Map<String, String> aliasMap, //
            PropertyNamingStrategy propertyNamingStrategy, //
            Map<String, FieldInfo> fieldInfoMap, //
            Field[] fields) {

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            JSONField fieldAnnotation = field.getAnnotation(JSONField.class);

            int ordinal = 0, serialzeFeatures = 0, parserFeatures = 0;
            String propertyName = field.getName();
            String label = null;
            if (fieldAnnotation != null) {
                if (!fieldAnnotation.serialize()) {
                    continue;
                }

                ordinal = fieldAnnotation.ordinal();
                serialzeFeatures = SerializerFeature.of(fieldAnnotation.serialzeFeatures());
                parserFeatures = Feature.of(fieldAnnotation.parseFeatures());

                if (fieldAnnotation.name().length() != 0) {
                    propertyName = fieldAnnotation.name();
                }

                if (fieldAnnotation.label().length() != 0) {
                    label = fieldAnnotation.label();
                }
            }

            if (aliasMap != null) {
                propertyName = aliasMap.get(propertyName);
                if (propertyName == null) {
                    continue;
                }
            }

            if (propertyNamingStrategy != null) {
                propertyName = propertyNamingStrategy.translate(propertyName);
            }

            if (!fieldInfoMap.containsKey(propertyName)) {
                FieldInfo fieldInfo = new FieldInfo(propertyName, null, field, clazz, null, ordinal, serialzeFeatures, parserFeatures,
                                                    null, fieldAnnotation, label);
                fieldInfoMap.put(propertyName, fieldInfo);
            }
        }
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> fieldCacheMap, String methodName,
                                                               String propertyName,int fromIdx) {
        if (compatibleWithFieldName){
               if (!fieldCacheMap.containsKey(propertyName)){
                   String tempPropertyName=methodName.substring(fromIdx);
                   return  fieldCacheMap.containsKey(tempPropertyName)?tempPropertyName:propertyName;
               }
           }
        return propertyName;
    }

    public static JSONField getSuperMethodAnnotation(final Class<?> clazz, final Method method) {
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] types = method.getParameterTypes();
            for (Class<?> interfaceClass : interfaces) {
                for (Method interfaceMethod : interfaceClass.getMethods()) {
                    Class<?>[] interfaceTypes = interfaceMethod.getParameterTypes();
                    if (interfaceTypes.length != types.length) {
                        continue;
                    }
                    if (!interfaceMethod.getName().equals(method.getName())) {
                        continue;
                    }
                    boolean match = true;
                    for (int i = 0; i < types.length; ++i) {
                        if (!interfaceTypes[i].equals(types[i])) {
                            match = false;
                            break;
                        }
                    }

                    if (!match) {
                        continue;
                    }

                    JSONField annotation = interfaceMethod.getAnnotation(JSONField.class);
                    if (annotation != null) {
                        return annotation;
                    }
                }
            }
        }

        Class<?> superClass = clazz.getSuperclass();
        if (superClass == null) {
            return null;
        }

        if (Modifier.isAbstract(superClass.getModifiers())) {
            Class<?>[] types = method.getParameterTypes();

            for (Method interfaceMethod : superClass.getMethods()) {
                Class<?>[] interfaceTypes = interfaceMethod.getParameterTypes();
                if (interfaceTypes.length != types.length) {
                    continue;
                }
                if (!interfaceMethod.getName().equals(method.getName())) {
                    continue;
                }
                boolean match = true;
                for (int i = 0; i < types.length; ++i) {
                    if (!interfaceTypes[i].equals(types[i])) {
                        match = false;
                        break;
                    }
                }

                if (!match) {
                    continue;
                }

                JSONField annotation = interfaceMethod.getAnnotation(JSONField.class);
                if (annotation != null) {
                    return annotation;
                }
            }
        }

        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> clazz, String propertyName) {
        JSONType jsonType = clazz.getAnnotation(JSONType.class);

        if (jsonType != null) {
            // 1、新增 includes 支持，如果 JSONType 同时设置了includes 和 ignores 属性，则以includes为准。
            // 2、个人认为对于大小写敏感的Java和JS而言，使用 equals() 比 equalsIgnoreCase() 更好，改动的唯一风险就是向后兼容性的问题
            // 不过，相信开发者应该都是严格按照大小写敏感的方式进行属性设置的
            String[] fields = jsonType.includes();
            if (fields.length > 0) {
                for (int i = 0; i < fields.length; i++) {
                    if (propertyName.equals(fields[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                fields = jsonType.ignores();
                for (int i = 0; i < fields.length; i++) {
                    if (propertyName.equals(fields[i])) {
                        return true;
                    }
                }
            }
        }

        if (clazz.getSuperclass() != Object.class && clazz.getSuperclass() != null) {
            if (isJSONTypeIgnore(clazz.getSuperclass(), propertyName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }

        if (type instanceof Class) {
            Type superType = ((Class<?>) type).getGenericSuperclass();
            if (superType == Object.class) {
                return false;
            }
            return isGenericParamType(superType);
        }

        return false;
    }

    public static Type getGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return type;
        }

        if (type instanceof Class) {
            return getGenericParamType(((Class<?>) type).getGenericSuperclass());
        }

        return type;
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception e) {
                // skip
            } finally {
                optionalClassInited = true;
            }
        }

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getRawType() == optionalClass) {
                return parameterizedType.getActualTypeArguments()[0];
            }
        }
        return type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class<?>) type;
        }

        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }

        if (type instanceof TypeVariable) {
            Type boundType = ((TypeVariable<?>) type).getBounds()[0];
            return (Class<?>) boundType;
        }

        return Object.class;
    }

    public static Field getField(Class<?> clazz, String fieldName, Field[] declaredFields) {
        for (Field field : declaredFields) {
            if (fieldName.equals(field.getName())) {
                return field;
            }
        }

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            return getField(superClass, fieldName, superClass.getDeclaredFields());
        }

        return null;
    }

    public static int getSerializeFeatures(Class<?> clazz) {
        JSONType annotation = clazz.getAnnotation(JSONType.class);

        if (annotation == null) {
            return 0;
        }

        return SerializerFeature.of(annotation.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> clazz) {
        JSONType annotation = clazz.getAnnotation(JSONType.class);

        if (annotation == null) {
            return 0;
        }

        return Feature.of(annotation.parseFeatures());
    }

    public static String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) && Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    static void setAccessible(AccessibleObject obj) {
        if (!setAccessibleEnable) {
            return;
        }

        if (obj.isAccessible()) {
            return;
        }

        try {
            obj.setAccessible(true);
        } catch (AccessControlException error) {
            setAccessibleEnable = false;
        }
    }

    public static Type getCollectionItemType(Type fieldType) {
        Type itemType = null;
        Class<?> clazz = null;
        if (fieldType instanceof ParameterizedType) {
            Type actualTypeArgument = ((ParameterizedType) fieldType).getActualTypeArguments()[0];

            if (actualTypeArgument instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) actualTypeArgument;
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (upperBounds.length == 1) {
                    actualTypeArgument = upperBounds[0];
                }
            }

            itemType = actualTypeArgument;
        } else if (fieldType instanceof Class<?> //
                && !(clazz = (Class<?>) fieldType).getName().startsWith("java.")) {
            Type superClass = clazz.getGenericSuperclass();
            itemType = TypeUtils.getCollectionItemType(superClass);
        }

        if (itemType == null) {
            itemType = Object.class;
        }

        return itemType;
    }

    public static Class<?> getCollectionItemClass(Type fieldType) {
        if (fieldType instanceof ParameterizedType) {
            Class<?> itemClass;
            Type actualTypeArgument = ((ParameterizedType) fieldType).getActualTypeArguments()[0];

            if (actualTypeArgument instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) actualTypeArgument;
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (upperBounds.length == 1) {
                    actualTypeArgument = upperBounds[0];
                }
            }

            if (actualTypeArgument instanceof Class) {
                itemClass = (Class<?>) actualTypeArgument;
                if (!Modifier.isPublic(itemClass.getModifiers())) {
                    throw new JSONException("can not create ASMParser");
                }
            } else {
                throw new JSONException("can not create ASMParser");
            }
            return itemClass;
        }

        return Object.class;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Collection createCollection(Type type) {
        Class<?> rawClass = getRawClass(type);

        Collection list;
        if (rawClass == AbstractCollection.class //
            || rawClass == Collection.class) {
            list = new ArrayList();
        } else if (rawClass.isAssignableFrom(HashSet.class)) {
            list = new HashSet();
        } else if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            list = new LinkedHashSet();
        } else if (rawClass.isAssignableFrom(TreeSet.class)) {
            list = new TreeSet();
        } else if (rawClass.isAssignableFrom(ArrayList.class)) {
            list = new ArrayList();
        } else if (rawClass.isAssignableFrom(EnumSet.class)) {
            Type itemType;
            if (type instanceof ParameterizedType) {
                itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                itemType = Object.class;
            }
            list = EnumSet.noneOf((Class<Enum>) itemType);
        } else {
            try {
                list = (Collection) rawClass.newInstance();
            } catch (Exception e) {
                throw new JSONException("create instance error, class " + rawClass.getName());
            }
        }
        return list;
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        } else {
            throw new JSONException("TODO");
        }
    }

    public static boolean isProxy(Class<?> clazz) {
        for (Class<?> item : clazz.getInterfaces()) {
            String interfaceName = item.getName();
            if (interfaceName.equals("net.sf.cglib.proxy.Factory") //
                    || interfaceName.equals("org.springframework.cglib.proxy.Factory")) {
                return true;
            }

            if (interfaceName.equals("javassist.util.proxy.ProxyObject") //
                    || interfaceName.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")
                    ) {
                return true;
            }
        }

        return false;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }

        if (!transientClassInited) {
            try {
                transientClass = (Class<? extends Annotation>) Class.forName("java.beans.Transient");
            } catch (Exception e) {
                // skip
            } finally {
                transientClassInited = true;
            }
        }

        if (transientClass != null) {
            Annotation annotation = method.getAnnotation(transientClass);
            return annotation != null;
        }

        return false;
    }

    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }

        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = (Class<? extends Annotation>) Class.forName("javax.persistence.OneToMany");
            } catch (Throwable e) {
                // skip
                class_OneToMany_error = true;
            }
        }

        if (class_OneToMany == null) {
            return false;
        }

        return method.isAnnotationPresent(class_OneToMany);
    }

    public static boolean isHibernateInitialized(Object object) {
        if (object == null) {
            return false;
        }

        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                Class<?> class_Hibernate = (Class<? extends Annotation>) Class.forName("org.hibernate.Hibernate");
                method_HibernateIsInitialized = class_Hibernate.getMethod("isInitialized", Object.class);
            } catch (Throwable e) {
                // skip
                method_HibernateIsInitialized_error = true;
            }
        }

        if (method_HibernateIsInitialized != null) {
            try {
                Boolean initialized = (Boolean) method_HibernateIsInitialized.invoke(null, object);
                return initialized.booleanValue();
            } catch (Throwable e) {
                // skip
            }
        }

        return true;
    }
}
