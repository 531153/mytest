package com.lxy.secure.strategy;

import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * DSA加密
 * map.privateKey 私钥
 * map.publicKey 公钥
 * map.charset 编码
 * map.keyType 1:公钥加密，私钥解密；2:私钥加密，公钥解密
 * @author lxy
 */
public class SecureDsa implements Secure {
	/**
	 *  默认utf-8
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap){
		return "";
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		return "";
	}
}
