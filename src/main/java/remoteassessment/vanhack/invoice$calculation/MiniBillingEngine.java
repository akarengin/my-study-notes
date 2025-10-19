package remoteassessment.vanhack.invoice$calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MiniBillingEngine {

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
        // 1. Handle end date
        YearMonth month = YearMonth.from(startDate);
        LocalDate lastDayOfMonth = month.atEndOfMonth();
        LocalDate invoiceEnd = (endDate == null || endDate.isAfter(lastDayOfMonth))
                ? lastDayOfMonth
                : endDate;

        // 2. Compute prorated fee
        long billedDays = ChronoUnit.DAYS.between(startDate, invoiceEnd) + 1;
        int totalDaysInMonth = month.lengthOfMonth();
        BigDecimal proratedFee = monthlyFee
                .multiply(BigDecimal.valueOf(billedDays))
                .divide(BigDecimal.valueOf(totalDaysInMonth), 2, RoundingMode.HALF_UP);

        // 3. Apply prorated discounts
        BigDecimal discountTotal = discounts.stream()
                .map(d -> {
                    // Find overlap range
                    LocalDate overlapStart = startDate.isAfter(d.start()) ? startDate : d.start();
                    LocalDate overlapEnd = invoiceEnd.isBefore(d.end()) ? invoiceEnd : d.end();

                    if (overlapStart.isAfter(overlapEnd)) {
                        return BigDecimal.ZERO; // no overlap
                    }

                    long overlapDays = ChronoUnit.DAYS.between(overlapStart, overlapEnd) + 1;
                    long discountDays = ChronoUnit.DAYS.between(d.start(), d.end()) + 1;

                    return d.amount()
                            .multiply(BigDecimal.valueOf(overlapDays))
                            .divide(BigDecimal.valueOf(discountDays), 2, RoundingMode.HALF_UP);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4. Final result
        return proratedFee.subtract(discountTotal).max(BigDecimal.ZERO);
    }

}
