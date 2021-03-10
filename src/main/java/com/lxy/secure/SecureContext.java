package com.lxy.secure;

import com.lxy.secure.strategy.Secure3Des;
import com.lxy.secure.strategy.SecureAes;
import com.lxy.secure.strategy.SecureBase64;
import com.lxy.secure.strategy.SecureDes;
import com.lxy.secure.strategy.SecureDsa;
import com.lxy.secure.strategy.SecureHmacMd5;
import com.lxy.secure.strategy.SecureHmacSha1;
import com.lxy.secure.strategy.SecureHmacSha256;
import com.lxy.secure.strategy.SecureMd5;
import com.lxy.secure.strategy.SecureRsa;
import com.lxy.secure.strategy.SecureSha1;
import com.lxy.secure.strategy.SecureSha256;

import java.util.Map;

public class SecureContext {
	private Secure secure;
	private String content;
	private Map<String, Object> argumentMap;
	private static  Secure secureMd5 = new SecureMd5();

	public SecureContext(String strategy, String content) {
		this(strategy, content, null);
	}

	public SecureContext(String strategy, String content, Map<String, Object> argumentMap) {
		this.content     = content;
		this.argumentMap = argumentMap;
		switch (strategy) {
			case "md5":
				this.secure = secureMd5;
				break;
			case "base64":
				this.secure = new SecureBase64();
				break;
			case "sha1":
				this.secure = new SecureSha1();
				break;
			case "sha256":
				this.secure = new SecureSha256();
				break;
			case "hmac-md5":
				this.secure = new SecureHmacMd5();
				break;
			case "hmac-sha1":
				this.secure = new SecureHmacSha1();
				break;
			case "hmac-sha256":
				this.secure = new SecureHmacSha256();
				break;
			case "aes":
				this.secure = new SecureAes();
				break;
			case "des":
				this.secure = new SecureDes();
				break;
			case "3des":
				this.secure = new Secure3Des();
				break;
			case "rsa":
				this.secure = new SecureRsa();
				break;
			case "dsa":
				this.secure = new SecureDsa();
				break;
			default:
				break;
		}
	}

	public String encrypt() {
		return secure.encrypt(content, argumentMap);
	}

	public String decrypt() {
		return secure.decrypt(content, argumentMap);
	}

}
