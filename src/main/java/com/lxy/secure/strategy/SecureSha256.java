package com.lxy.secure.strategy;

import cn.hutool.crypto.SecureUtil;
import com.lxy.secure.Secure;

import java.util.Map;

public class SecureSha256 implements Secure {
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		return SecureUtil.sha256(content);
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		return null;
	}
}
