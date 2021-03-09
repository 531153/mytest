package com.lxy.secure.strategy;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

public class SecureHmacSha256 implements Secure {
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		String key = MapUtils.getString(argumentMap,"key","");
		HMac hMac =  SecureUtil.hmac(HmacAlgorithm.HmacSHA256,key);
		return hMac.digestHex(content);
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		return null;
	}
}
