package com.lxy.secure;

import java.util.Map;

public interface Secure {
	/**
	 * 加密
	 *
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	String encrypt(String content, Map<String, Object> argumentMap);

	/**
	 * 解密
	 *
	 * @param content     解密内容
	 * @param argumentMap 解密参数
	 * @return
	 */
	String decrypt(String content, Map<String, Object> argumentMap);
}
