package rest$api.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@SpringBootApplication
public class SecureApiApplication {
    public static void main(String[] args) throws UnrecoverableKeyException, CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
//        verifyKeystore();
//        loadKeyStore();
        SpringApplication.run(SecureApiApplication.class, args);
    }

    private static void verifyKeystore() {
        File keystoreFile = new File("mykeystore.p12");
        if (!keystoreFile.exists()) {
            throw new RuntimeException("Keystore file 'mykeystore.p12' not found. Please ensure it exists in the 'src/main/resources' directory.");
        }
    }
}

// TODO: Configure SSL/TLS in application.properties or programmatically to enable HTTPS on port 8443.
// Hint: Use a self-signed certificate and configure the keystore.