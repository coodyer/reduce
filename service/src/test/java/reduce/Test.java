package reduce;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("mchId", "xxx");
		map.put("appSecret", "xxx");
		System.out.println(JSON.toJSONString(map));
		System.out.println(generateSignature(map));
	}

	/**
	  * 生成签名，使用MD5加密方式
	  */
	public static String generateSignature(final Map<String, String> data) {
	    Set<String> keySet = data.keySet();
	    String[] keyArray = keySet.toArray(new String[0]);
	    Arrays.sort(keyArray);
	    StringBuilder sb = new StringBuilder();
	    for (String key : keyArray) {
	        if ("sign".equals(key)) {
	            continue;
	        }
	        sb.append(key).append(data.get(key).trim());
	    }
	    System.out.println(sb.toString());
	    return md5(sb.toString()).toUpperCase();
	}
	/**
	  * 不使用盐值的md5加密
	  * @param str 明文
	  * @param hashEncodeEnum 指定的编码方式
	  * @return 使用MD5加密算法得到的密文
	  */
	public static String md5(String str) {
	    String encryptStr = null;
	    try {
	        encryptStr = oneWayEncrypt(str, "",  "MD5");
	    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return encryptStr;
	}
	/**
	  * 单向加密，可指定编码方式，如果未指定编码方式，则默认使用十六进制编码
	  * @param str 需要加密的明文
	  * @param salt 加密所使用的盐值
	  * @param type 加密或消息摘要算法名称
	  * @return 通过指定加密算法和盐值得到的密文
	  * @throws NoSuchAlgorithmException 未知的算法
	  * @throws UnsupportedEncodingException 不支持的编码方式
	  */
	public static String oneWayEncrypt(String str, String salt, String type) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    MessageDigest md = MessageDigest.getInstance(type);
	    byte[] bytes = md.digest((str + salt).getBytes("UTF-8"));
	    return toHex(bytes);
	}
	private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	/**
	  * 字节数组以十六进制的形式编码成字符串
	  * @param bytes 字节数组
	  * @return 十六进制编码后的字符串
	  */
	public static String toHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    int index = 0;
	    for(byte b : bytes) {
	        hexChars[index++] = HEX_CHAR[b >>> 4 & 0xF];
	        hexChars[index++] = HEX_CHAR[b & 0xF];
	    }
	    return new String(hexChars);
	}
}

