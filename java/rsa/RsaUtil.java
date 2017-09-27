package io.github.zhangshuheng;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
public class RsaUtil {

    public String encryptData(String data, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] dataToEncrypt = data.getBytes("utf-8");
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);
            String encryptString = Base64.encodeBase64String(encryptedData);
            return encryptString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String encryptData(String data, PrivateKey privateKey) {
    	try {
    		Cipher cipher = Cipher.getInstance("RSA");
    		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
    		byte[] dataToEncrypt = data.getBytes("utf-8");
    		byte[] encryptedData = cipher.doFinal(dataToEncrypt);
    		String encryptString = Base64.encodeBase64String(encryptedData);
    		return encryptString;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public String decryptData(String data, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] descryptData = Base64.decodeBase64(data);
            byte[] descryptedData = cipher.doFinal(descryptData);
            String srcData = new String(descryptedData, "utf-8");
            return srcData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

    public String decryptData(String data, PublicKey publicKey) {
    	try {
    		Cipher cipher = Cipher.getInstance("RSA");
    		cipher.init(Cipher.DECRYPT_MODE, publicKey);
    		byte[] descryptData = Base64.decodeBase64(data);
    		byte[] descryptedData = cipher.doFinal(descryptData);
    		String srcData = new String(descryptedData, "utf-8");
    		return srcData;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
