package Cryptographic_Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.util.Base64;

public class CryptographicComparison {

    public static void main(String[] args) throws Exception {
        String inputData = "Hello, Cryptography!";

        // AES Encryption/Decryption
        System.out.println("\n--- AES Encryption/Decryption ---");
        SecretKey aesKey = KeyGenerator.getInstance("AES").generateKey();
        measureSymmetricAlgorithm("AES", aesKey, inputData);

        // DES Encryption/Decryption
        System.out.println("\n--- DES Encryption/Decryption ---");
        SecretKey desKey = KeyGenerator.getInstance("DES").generateKey();
        measureSymmetricAlgorithm("DES", desKey, inputData);

        // RSA Encryption/Decryption
        System.out.println("\n--- RSA Encryption/Decryption ---");
        KeyPair rsaKeyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        measureAsymmetricAlgorithm("RSA", rsaKeyPair, inputData);

        // Hashing with SHA-256
        System.out.println("\n--- SHA-256 Hashing ---");
        measureHashingAlgorithm("SHA-256", inputData);

        // Hashing with MD5
        System.out.println("\n--- MD5 Hashing ---");
        measureHashingAlgorithm("MD5", inputData);
    }

    private static void measureSymmetricAlgorithm(String algorithm, SecretKey key, String data) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);

        // Encryption
        long startTime = System.nanoTime();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        long endTime = System.nanoTime();
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("Encryption Time: " + (endTime - startTime) + " ns");

        // Decryption
        startTime = System.nanoTime();
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        endTime = System.nanoTime();
        System.out.println("Decrypted Data: " + new String(decryptedData));
        System.out.println("Decryption Time: " + (endTime - startTime) + " ns");
    }

    private static void measureAsymmetricAlgorithm(String algorithm, KeyPair keyPair, String data) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);

        // Encryption
        long startTime = System.nanoTime();
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        long endTime = System.nanoTime();
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("Encryption Time: " + (endTime - startTime) + " ns");

        // Decryption
        startTime = System.nanoTime();
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedData = cipher.doFinal(encryptedData);
        endTime = System.nanoTime();
        System.out.println("Decrypted Data: " + new String(decryptedData));
        System.out.println("Decryption Time: " + (endTime - startTime) + " ns");
    }

    private static void measureHashingAlgorithm(String algorithm, String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        long startTime = System.nanoTime();
        byte[] hashedData = digest.digest(data.getBytes());
        long endTime = System.nanoTime();

        System.out.println("Hashed Data: " + bytesToHex(hashedData));
        System.out.println("Hashing Time: " + (endTime - startTime) + " ns");
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
