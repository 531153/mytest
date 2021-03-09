package com.lxy.secure.strategy;

import cn.hutool.crypto.SecureUtil;
import com.lxy.secure.Secure;

import java.util.Map;

public class SecureMd5 implements Secure {
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
		return SecureUtil.md5(content);
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		return null;
	}
}
