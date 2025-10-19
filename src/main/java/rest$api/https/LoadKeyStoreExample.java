package rest$api.https;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class LoadKeyStoreExample {
    public static void main(String[] args) throws Exception {
        loadKeyStore();
    }

    static void loadKeyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        String keystorePassword = "changeit";
        String alias = "mykey";

        KeyStore ks = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream("mykeystore.p12")) {
            ks.load(fis, keystorePassword.toCharArray());
        }

        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, keystorePassword.toCharArray());
        Certificate cert = ks.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();

        System.out.println("Private Key: " + privateKey);
        System.out.println("Public Key: " + publicKey);
        System.out.println("Certificate: " + cert);
    }
}
