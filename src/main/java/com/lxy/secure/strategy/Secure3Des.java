package com.lxy.secure.strategy;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 3Des加密
 * map.key 秘钥
 * map.charset 编码
 * map.returnType 加密返回类型 1：hex 16进制，2：base64
 */
public class Secure3Des implements Secure {
	/**
	 *  默认DESede/CBC/PKCS5Padding，默认utf-8
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		String          deskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		int             returnType = MapUtils.getIntValue(argumentMap, "returnType", 1);
		SymmetricCrypto des     = null;
		try {
			des = new SymmetricCrypto(SymmetricAlgorithm.DESede, deskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String result = "";
		try {
			result = returnType == 1 ? des.encryptHex(content.getBytes(charset)) : des.encryptBase64(content.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		String          deskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		SymmetricCrypto des     = null;
		try {
			des = new SymmetricCrypto(SymmetricAlgorithm.DESede, deskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return des.decryptStr(content);
	}
}
