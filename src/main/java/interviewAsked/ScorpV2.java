package interviewAsked;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScorpV2 {
    private String makePayments(String str) {
        Map<String, Integer> map = getStream(str, 0)
                .map(s -> s.replace("Total:", ""))
                .collect(Collectors.toMap(
                        s -> s.substring(0, 1),
                        s -> Integer.parseInt(s.replaceAll("[^0-9]", "")),
                        Integer::sum
                ));

        getStream(str, 1)
                .map(s -> s.split(":"))
                .sorted(Comparator.comparingInt(a -> Integer.parseInt(a[1].substring(1))))
                .forEach(a -> {
                    String c = a[1].substring(0, 1);
                    int amt = Integer.parseInt(a[1].substring(1));
                    if (amt > 0 && map.getOrDefault(c, 0) >= amt) map.put(c, map.get(c) - amt);
                });

        String fund = map.entrySet().stream()
                .map(e -> e.getKey() + e.getValue())
                .collect(Collectors.joining("|"));

        String requests = getStream(str, 1)
                .map(s -> s.split(":"))
                .sorted(Comparator.comparing(a -> a[0]))
                .map(a -> a[0] + ":" + a[1])
                .collect(Collectors.joining("|"));

        return "Balance:" + fund + "&" + requests;
    }

    private Stream<String> getStream(String str, int part) {
        return Arrays.stream(str.split("&", 2)[part].split("\\|"));
    }

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(new InputStreamReader(new FileInputStream("./src/main/resources/Scorp.txt")))) {
            String input = sc.next();
            ScorpV2 scorpV2 = new ScorpV2();
            System.out.println(scorpV2.makePayments(input));
        }
    }
}
