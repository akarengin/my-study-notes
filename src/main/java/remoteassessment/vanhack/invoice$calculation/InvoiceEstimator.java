package remoteassessment.vanhack.invoice$calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

record Discount(LocalDate start, LocalDate end, BigDecimal amount) {
}

public class InvoiceEstimator {

    public static void main(String[] args) {
        // Prepare test data
        LocalDate startDate = LocalDate.of(2025, 8, 10);
        LocalDate endDate = LocalDate.of(2025, 8, 20);
        BigDecimal monthlyFee = BigDecimal.valueOf(120.00);

        List<Discount> discounts = List.of(
                new Discount(
                        LocalDate.of(2025, 8, 1),
                        LocalDate.of(2025, 8, 15),
                        BigDecimal.valueOf(10.00)
                ),
                new Discount(
                        LocalDate.of(2025, 8, 16),
                        LocalDate.of(2025, 8, 31),
                        BigDecimal.valueOf(5.00)
                )
        );

        // Calculate invoice
        BigDecimal invoiceAmount = calculateInvoice(startDate, endDate, monthlyFee, discounts);
        System.out.println("Invoice amount: " + invoiceAmount);


    }

    public static BigDecimal calculateInvoice(
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal monthlyFee,
            List<Discount> discounts
    ) {
        // 1. If endDate is null, set it to the last day of startDate's month
        YearMonth month = YearMonth.from(startDate);
        LocalDate lastDayOfMonth = month.atEndOfMonth();
        LocalDate invoiceEnd = (endDate == null || endDate.isAfter(lastDayOfMonth))
                ? lastDayOfMonth
                : endDate;


        // 2. Compute total days in month and active subscription days
        long billedDays = ChronoUnit.DAYS.between(startDate, invoiceEnd) + 1;
        int totalDaysInMonth = month.lengthOfMonth();

        // 3. Calculate prorated fee
        BigDecimal proratedFee = monthlyFee.multiply(BigDecimal.valueOf(billedDays))
                .divide(BigDecimal.valueOf(totalDaysInMonth), 2, RoundingMode.HALF_UP);

        // 3. Apply overlapping discounts (sum them up)
        BigDecimal discount = discounts.stream().filter(v -> !invoiceEnd.isBefore(v.start()) && !startDate.isAfter(v.end()))
                .map(Discount::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return proratedFee.subtract(discount).max(java.math.BigDecimal.ZERO);
    }

}

