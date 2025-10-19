package rest$api.ratelimiting$throttling;

public class TokenBucket {
    private final int bucketCapacity;
    private final int refillRate;
    private int tokens;
    private long lastRefillTimestamp;

    public TokenBucket(int bucketCapacity, int refillRate) {
        this.bucketCapacity = bucketCapacity;
        this.refillRate = refillRate;
        this.tokens = bucketCapacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        // Implement the logic to refill tokens and check if a request can be allowed
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTimestamp;
        int tokensToAdd = (int) (elapsedTime / 1000) * refillRate;
        if (tokensToAdd > 0) {
            tokens = Math.min(bucketCapacity, tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
        if (tokens > 0) {
            tokens--;
            return true; // Request allowed
        }
        return false; // Request denied
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(10, 1);

        // Simulate requests
        for (int i = 0; i < 50; i++) {
            System.out.println("Request " + (i + 1) + ": " + tokenBucket.allowRequest());
            try {
                Thread.sleep(500); // Simulate time between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}