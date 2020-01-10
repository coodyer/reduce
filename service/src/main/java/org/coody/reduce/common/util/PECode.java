package org.coody.reduce.common.util;

import java.util.Stack;

/**
 * Created By 谭健 2017年6月17日 22:17:04（TEL:15197447018）
 *
 * @version 2.0
 *
 *
 *          加解密算法
 */
public class PECode {

	/**
	 * 打乱改字符数组的组合顺序，可以得到不同的转换结果
	 */
	private static final char[] array = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g',
			'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '8', '5', '2', '7', '3', '6', '4', '0', '9', '1',
			'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X',
			'C', 'V', 'B', 'N', 'M', '+', '-', '@', '!'};

	/**
	 * @param number double类型的10进制数,该数必须大于0
	 */
	public static String encode(Long number) {
		double rest = number;
		// 创建栈
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder(0);
		while (rest >= 1) {
			// 进栈,
			stack.add(array[new Double(rest % array.length).intValue()]);
			rest = rest / array.length;
		}
		for (; !stack.isEmpty();) {
			// 出栈
			result.append(stack.pop());
		}
		return result.toString();

	}

	/**
	 * 支持范围是A-Z,a-z,0-9,+,-
	 *
	 */
	public static Long decode(String str) {
		// 倍数
		int multiple = 1;
		Long result = 0L;
		Character c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(str.length() - i - 1);
			result += decodeChar(c) * multiple;
			multiple = multiple * array.length;
		}
		return result;
	}

	private static int decodeChar(Character c) {
		for (int i = 0; i < array.length; i++) {
			if (c == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(decode(encode(99999999L)));
		System.out.println(encode(8746465L));
	}
}
