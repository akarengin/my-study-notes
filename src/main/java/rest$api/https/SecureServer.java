package rest$api.https;

import javax.net.ssl.*;
import java.io.*;
import java.security.*;

public class SecureServer {
    public static void main(String[] args) {
        try {

            // Load the keystore containing the server certificate
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream("mykeystore.p12"), "changeit".toCharArray());

            // Initialize the key manager factory with the keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "changeit".toCharArray());

            // Create an SSL context and initialize it with the key managers
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create an SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create an SSL server socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

            // Accept connections
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                // Handle the connection
                handleClient(sslSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(SSLSocket sslSocket) {
        try (sslSocket;
             BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
             PrintWriter out = new PrintWriter(sslSocket.getOutputStream())
        ) {
            // Read the client's request
            String requestLine = in.readLine();

            // Check if it's a GET request to /api/hello
            if (requestLine != null && requestLine.startsWith("GET /api/hello")) {
                // Respond with "Hello, Secure World!"
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println();
                out.println("Hello, Secure Worlds!");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Test case
// Run the server and send a GET request to https://localhost:8443/api/hello
// Expected output: Hello, Secure World!
