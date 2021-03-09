package com.lxy.secure.strategy;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * RSA加密
 * map.privateKey 私钥
 * map.publicKey 公钥
 * map.charset 编码
 * map.keyType 1:公钥加密，私钥解密；2:私钥加密，公钥解密
 * @author lxy
 */
public class SecureRsa implements Secure {
	/**
	 *  默认utf-8
	 * @param content     加密内容
	 * @param argumentMap 加密参数
	 * @return
	 */
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap){
		String          privateKey  = MapUtils.getString(argumentMap, "privateKey", "");
		String          publicKey  = MapUtils.getString(argumentMap, "publicKey", "");
		int          keyType  = MapUtils.getIntValue(argumentMap, "keyType", 1);
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		AsymmetricCrypto rsa     = null;
		rsa = new AsymmetricCrypto(AsymmetricAlgorithm.RSA,privateKey,publicKey);
		String result = "";
		if(keyType==1){
			try {
				result= rsa.encryptHex(content.getBytes(charset), KeyType.PublicKey);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			try {
				result= rsa.encryptHex(content.getBytes(charset), KeyType.PrivateKey);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		String          privateKey  = MapUtils.getString(argumentMap, "privateKey", "");
		String          publicKey  = MapUtils.getString(argumentMap, "publicKey", "");
		int          keyType  = MapUtils.getIntValue(argumentMap, "keyType", 1);
		String          charset = MapUtils.getString(argumentMap, "charset", "utf-8");
		AsymmetricCrypto rsa     = null;
		rsa = new AsymmetricCrypto(AsymmetricAlgorithm.RSA,privateKey,publicKey);
		String result = "";
		if(keyType==1){
			result= rsa.decryptStr(content, KeyType.PrivateKey);
		}else{
			result= rsa.decryptStr(content, KeyType.PublicKey);
		}
		return result;
	}
}
