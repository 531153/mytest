package com.lxy.secure.strategy;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * AES加密
 * map.key 秘钥
 * map.charset 编码
 */
public class SecureAes implements Secure {
	/**
	 *  默认AES/ECB/PKCS5Padding，默认utf-8
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		String          aeskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		SymmetricCrypto aes     = null;
		try {
			aes = new SymmetricCrypto(SymmetricAlgorithm.AES, aeskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return aes.encryptHex(content);
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		String          aeskey  = MapUtils.getString(argumentMap, "key", "");
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		SymmetricCrypto aes     = null;
		try {
			aes = new SymmetricCrypto(SymmetricAlgorithm.AES, aeskey.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return aes.decryptStr(content);
	}
}
