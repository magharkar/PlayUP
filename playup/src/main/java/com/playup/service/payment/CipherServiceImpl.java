//Refered https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.payment;

import com.playup.constants.ApplicationConstants;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

@Service
public class CipherServiceImpl implements ICipherService {
    @Override
    public String encrypt(String messageToEncrypt) {
        try {
            String cipherSecretKey = ApplicationConstants.CIPHER_SECRET_KEY;
            byte[]  key = cipherSecretKey.getBytes(ApplicationConstants.UTF_FORMAT);
            MessageDigest messageDigest = MessageDigest.getInstance(ApplicationConstants.MESSAGE_DIGEST_INSTANCE);
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, ApplicationConstants.ENCRYPTION_MESSAGE_LENGTH);
            SecretKeySpec secretKey = new SecretKeySpec(key, ApplicationConstants.ENCRYPTION_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ApplicationConstants.CIPHER_INSTANCE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(messageToEncrypt.getBytes(ApplicationConstants.UTF_FORMAT)));
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
            byte[] key = cipherSecretKey.getBytes(ApplicationConstants.UTF_FORMAT);
            MessageDigest messageDigest = MessageDigest.getInstance(ApplicationConstants.MESSAGE_DIGEST_INSTANCE);
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, ApplicationConstants.ENCRYPTION_MESSAGE_LENGTH);
            SecretKeySpec secretKey = new SecretKeySpec(key, ApplicationConstants.ENCRYPTION_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ApplicationConstants.CIPHER_INSTANCE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
