package interviewAsked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ScorpV1 {

    private String makePayments(String str) {
        HashMap<String, Integer> map = new HashMap<>();

        getStream(str,0)
                .map(s -> s.replace("Total:", ""))
                .forEach(s -> {
                    String currency = s.substring(0,1);
                    String numericValue = s.replaceAll("[^0-9]", "");
                    if (!numericValue.isEmpty()) {
                        map.put(currency, map.getOrDefault(currency, 0) + Integer.parseInt(numericValue));
                    }
                });

        process(str, map);

        String fund = map.entrySet().stream()
                .map(entry -> entry.getKey() + entry.getValue())
                .collect(Collectors.joining("|"));

        String requests = getStream(str, 1)
                .map(s -> s.split(":"))
                .sorted(Comparator.comparing(
                        a -> a[0]
                ))
                .map(a -> a[0] + ":" + a[1])
                .collect(Collectors.joining("|"));

        return "Balance:" + fund + "&" + requests;
    }

    private void process(String str, HashMap<String, Integer> map) {
        getStream(str, 1)
                .map(s -> s.split(":"))
                .sorted(Comparator.comparingInt(
                        a -> Integer.parseInt(a[1].substring(1))
                ))
                .forEach(a -> { // Proceed to protected route
                    try {
                        String currency = a[1].substring(0, 1);
                        int amount = Integer.parseInt(a[1].substring(1));

                        if (amount <= 0) {
                            System.out.println("Error: Amount must be positive (" + amount + ")");
                            return;  // Skip invalid amounts
                        }

                        if (!map.containsKey(currency)) {
                            System.out.println("Error: Currency " + currency + " not found");
                            return;  // Skip unknown currencies
                        }

                        int availableAmount = map.get(currency);
                        if (amount > availableAmount) {
                            System.out.println("Error: Insufficient funds for " + currency);
                            return;  // Skip if balance is too low
                        }

                        // Deduct amount and update map
                        map.put(currency, availableAmount - amount);
                        System.out.println("Deducted: " + amount + " " + currency);

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount format for " + a[0]);
                    }
                });
    }

    private Stream<String> getStream(String str, int part) {
        /*The string "\\|" actually represents the regex \|.
        The \| in regex means a literal pipe character | (because | is a special character in regex normally meaning "or").
        So, the double backslash ensures that the pipe is treated as a literal character, not as a regex operator.*/
        return Arrays.stream(str.split("&", 2)[part].split("\\|"));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new InputStreamReader(new FileInputStream("./src/main/resources/Scorp.txt")));
        String input = sc.next();
        ScorpV1 scorp = new ScorpV1();
        System.out.println(scorp.makePayments(input));
    }

}
