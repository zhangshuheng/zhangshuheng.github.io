package io.github.zhangshuheng;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;

//import java.security.Security;
import org.apache.commons.codec.binary.Base64;

public class RSAKeyCreater {

	public static void createKeyPairs2() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

		keyPairGenerator.initialize(1024);
		KeyPair pair = keyPairGenerator.generateKeyPair();
		
		PublicKey pubKey = pair.getPublic();
		PrivateKey privKey = pair.getPrivate();
		byte[] pk = pubKey.getEncoded();
		byte[] privk = privKey.getEncoded();
		String strpk = new String(Base64.encodeBase64(pk));
		String strprivk = new String(Base64.encodeBase64(privk));

		System.out.println("公钥Base64编码:" + strpk);
		System.out.println("私钥Base64编码:" + strprivk);
	}
	public static void createKeyPairs() {
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = new SecureRandom();//SecureRandom.getInstance("SHA1PRNG", "SUN");
			
			random.setSeed((new Date().getTime()+"").getBytes());
			generator.initialize(1024,random);
			KeyPair pair = generator.generateKeyPair();
			PublicKey pubKey = pair.getPublic();
			PrivateKey privKey = pair.getPrivate();
			byte[] pk = pubKey.getEncoded();
			byte[] privk = privKey.getEncoded();
			String strpk = new String(Base64.encodeBase64(pk));
			String strprivk = new String(Base64.encodeBase64(privk));

			System.out.println("公钥Base64编码:" + strpk);
			System.out.println("私钥Base64编码:" + strprivk);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public static void main(String args[]) throws NoSuchAlgorithmException {
		createKeyPairs();
	}
}
