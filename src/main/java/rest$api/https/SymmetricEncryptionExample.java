package rest$api.https;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Arrays;

public class SymmetricEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate a symmetric key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Key size
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt data
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String data = "Sensitive API Data";
        byte[] encryptedData = cipher.doFinal(data.getBytes());

        // Decrypt data
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        System.out.println("Original Data: " + data);
        System.out.println("encryptedData: " + Arrays.toString(encryptedData));
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}