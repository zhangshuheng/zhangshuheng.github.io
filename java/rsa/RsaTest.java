package io.github.zhangshuheng;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

public class RsaTest {

	public static void testRsa() {
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			String strpk = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJPSsAm9Po08VtGKQx86TuOYu/7BTOtwYlFQvjQCEs3aTeUOH3p9pgd3pw14Num0n/l3Sk3d1av4hzZJvlODfScCAwEAAQ==";
			String strprivk = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAk9KwCb0+jTxW0YpDHzpO45i7/sFM63BiUVC+NAISzdpN5Q4fen2mB3enDXg26bSf+XdKTd3Vq/iHNkm+U4N9JwIDAQABAkAch9iUOKNfDRtQnBfyagWZ5fu64sIe2vUO7r+XOCM6+a/BvKV+5aMRpR6ts8OyEz9F+KCagc8eSEO0DAFjurQ5AiEA72jh09XwAHpvUONQu8JyziZtB5Cpf/y2iCC3ucxJ510CIQCeEQ+2sd4jC7P+wdCB0K1HxXtslxD3Bq50yVtsyI3CUwIhAJUpQ4o4QNALeE9tUV+qRt0qE8Qi3Xhge1lVCSM5pNIBAiACY0OXgOxYHy8i5A6gR2S2ttb8dvO8p48vGHOXGxh5HQIgfiKMcSTfflaQBBgzDFvaVnsfs2ajbv9tNcWuAP7u6aA=";

			X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decodeBase64(strpk.getBytes()));
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(strprivk.getBytes()));

			KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
			PublicKey pubKey = keyf.generatePublic(pubX509);
			PrivateKey privKey = keyf.generatePrivate(priPKCS8);

			RsaUtil rsaUtil = new RsaUtil();
			String data = "luoguohui";
			System.out.println("加密前字符串：data=" + data);
			String encryptData = null;
			if (pubKey != null && (data != null && !data.equals(""))) {
				
				encryptData = rsaUtil.encryptData(data, privKey);
//				encryptData = rsaUtil.encryptData(data, pubKey);
				System.out.println("加密后字符串：encryptData=" + encryptData);
			}
			String descryptData = null;
			if (privKey != null && (encryptData != null && !encryptData.equals(""))) {
//				descryptData = rsaUtil.decryptData(encryptData, privKey);
				descryptData = rsaUtil.decryptData(encryptData, pubKey);
				System.out.println("解密后字符串：descryptData=" + descryptData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		testRsa();
	}

}
