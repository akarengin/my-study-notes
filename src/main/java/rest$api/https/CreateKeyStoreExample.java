package rest$api.https;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CreateKeyStoreExample {
    public static void main(String[] args) throws Exception {
        String keystorePassword = "CodeWithMe$";
        String alias = "mykey";

        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // Create a self-signed certificate using Bouncy Castle
        X500Name issuer = new X500Name("CN=lnk.slngr.app.cloudfront.net, OU=IT Department, O=Learning Lab, L=Eskisehir, C=Turkey");
        BigInteger serial = new BigInteger(64, new SecureRandom());
        Date notBefore = new Date();
        Date notAfter = new Date(notBefore.getTime() + 365 * 86400000L);

        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                issuer, serial, notBefore, notAfter, issuer, keyPair.getPublic()
        );

        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());
        X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certBuilder.build(signer));

        // Create a KeyStore and save the key
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(null, keystorePassword.toCharArray());
        ks.setKeyEntry(alias, keyPair.getPrivate(), keystorePassword.toCharArray(), new java.security.cert.Certificate[]{cert});
        try (FileOutputStream fos = new FileOutputStream("mykeystore.p12")) {
            ks.store(fos, keystorePassword.toCharArray());
        }

        System.out.println("PKCS12 KeyStore created and key stored.");
    }
}
