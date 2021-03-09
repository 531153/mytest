package com.lxy.secure.strategy;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Des加密
 * map.key 秘钥
 * map.charset 编码
 */
public class SecureDes implements Secure {
	/**
	 *  默认DES/CBC/PKCS5Padding，默认utf-8
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		String          deskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		SymmetricCrypto des     = null;
		try {
			des = new SymmetricCrypto(SymmetricAlgorithm.DES, deskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return des.encryptHex(content);
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		String          deskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		SymmetricCrypto des     = null;
		try {
			des = new SymmetricCrypto(SymmetricAlgorithm.DES, deskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return des.decryptStr(content);
	}
}
