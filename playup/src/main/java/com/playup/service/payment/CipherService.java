//Refered https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;
import com.playup.constants.ApplicationConstants;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Service
public class CipherService implements ICipherService {
    @Override
    public String encrypt(String messageToEncrypt) {

        try {
            String cipherSecretKey = ApplicationConstants.CIPHER_SECRET_KEY;
            byte[]  key = cipherSecretKey.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(messageToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    @Override
    public String decrypt(String messageToDecrypt) {
        try {
            String cipherSecretKey = ApplicationConstants.CIPHER_SECRET_KEY;
            byte[] key = cipherSecretKey.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
