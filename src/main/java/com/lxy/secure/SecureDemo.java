package com.lxy.secure;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SecureDemo {

	public static void main(String[] args) throws IOException {
//		//摘要算法
		String message = "我是要加密的内容";
//		String key     = "i am key";
//		SecureContext secureContext = new SecureContext("md5",message);
//		System.out.println("md5加密："+secureContext.encrypt());
//		//对称加密
//		Map<String,Object> map = new HashMap<String, Object>(){{
//			put("key","0CoJUm6Qyw8W8jud");
//		}};
//		SecureContext secureContext1 = new SecureContext("aes",message,map);
//		String encypt1 = secureContext1.encrypt();
//		System.out.println("aes加密：" + encypt1);
//
//		//des
//		//解密为字符串
//		SecureContext secureContext2 = new SecureContext("aes",encypt1,map);
//		System.out.println("aes解密：" + secureContext2.decrypt());
//		SecureContext secureContext3 = new SecureContext("des",message,map);
//		String encypt3 = secureContext3.encrypt();
//		System.out.println("des加密：" + encypt3);
//		//解密为字符串
//		SecureContext secureContext4 = new SecureContext("des",encypt3,map);
//		System.out.println("des解密：" + secureContext4.decrypt());
//		//3des
////		byte[] key1 =SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
////		System.out.println(new String(key1));
//		Map<String,Object> map1 = new HashMap<String, Object>(){{
//			put("key","W8jud0CoJUm6Qyw8W8judyw8");
//		}};
//		SecureContext secureContext5 = new SecureContext("3des",message,map1);
//		String encypt5 = secureContext5.encrypt();
//		System.out.println("3des加密：" + encypt5);
//		//解密为字符串
//		SecureContext secureContext6 = new SecureContext("3des",encypt5,map1);
//		System.out.println("3des解密：" + secureContext6.decrypt());


		//rsa

		RSA    rsa        = new RSA();
		String privatekey = rsa.getPrivateKeyBase64();
		String publickey = rsa.getPublicKeyBase64();
		Map<String, Object> map2 = new HashMap<String, Object>() {{
			put("privateKey", privatekey);
			put("publicKey", publickey);
			put("keyType", 1);
		}};
		SecureContext secureContext7 = new SecureContext("rsa",message,map2);
		String encypt7 = secureContext7.encrypt();
		System.out.println("rsa加密：" + encypt7);
		//解密为字符串
		SecureContext secureContext8 = new SecureContext("rsa",encypt7,map2);
		System.out.println("rsa解密：" + secureContext8.decrypt());

        String tDoc = "tDoc";
		Map<String, Object> map3 = new HashMap<String, Object>() {{
			put("key", "12dc293d43db3b237849");
		}};
		SecureContext secureContext9 = new SecureContext("des",tDoc,map3);
		String encypt9 = secureContext9.encrypt();
		System.out.println("des加密：" + encypt9);
       //解密为字符串
		SecureContext secureContext10 = new SecureContext("des",encypt9,map3);
		System.out.println("des解密：" + secureContext10.decrypt());
	}
}
