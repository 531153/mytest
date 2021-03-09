package com.lxy.secure.strategy;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import com.lxy.secure.Secure;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

public class SecureBase64 implements Secure {
	@Override
	public String encrypt(String content, Map<String, Object> argumentMap) {
        int times = MapUtils.getIntValue(argumentMap,"times",1);
        String result = content;
		for (int i = 0; i < times; i++) {
			result = Base64.encode(result);
		}
		return result;
	}

	@Override
	public String decrypt(String content, Map<String, Object> argumentMap) {
		int times = MapUtils.getIntValue(argumentMap,"times",1);
		String result = content;
		for (int i = 0; i < times; i++) {
			result = Base64.decodeStr(result);
		}
		return result;
	}
}
