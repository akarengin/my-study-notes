package remoteassessment.vanhack.invoice$calculation;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class InvoiceCalculator {

    public static void main(String[] args) {

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = null; // ongoing subscription
        BigDecimal monthlyFee;
        BigDecimal discount;

        BigDecimal invoiceAmount;

        // Test case 1
        startDate = LocalDate.of(2025, 8, 10);
        endDate = null; // ongoing subscription
        monthlyFee = new BigDecimal("120.00");
        discount = new BigDecimal("15.00");

        invoiceAmount = calculateInvoiceI(startDate, endDate, monthlyFee, discount);
        System.out.println("Invoice amount: $" + invoiceAmount);

        // Test case 2
/*        startDate = LocalDate.of(2025, 8, 10);
        //endDate = LocalDate.of(2025, 8, 31);
        monthlyFee = new BigDecimal("120.00");
        discount = new BigDecimal("15.00");*/

        try {
            invoiceAmount = calculateInvoiceII(startDate, endDate, monthlyFee, discount);
            System.out.println("Invoice amount: $" + invoiceAmount);
        } catch (IllegalArgumentException e) {
            System.err.println("You must choose an end date for your invoice!");
            // Handle the error case
        }
    }

    public static BigDecimal calculateInvoiceI(
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal monthlyFee,
            BigDecimal discount
    ) {
        LocalDate invoiceStart = LocalDate.of(startDate.getYear(), startDate.getMonth(), 1);
        LocalDate invoiceEnd = invoiceStart.withDayOfMonth(invoiceStart.lengthOfMonth());
        System.out.println("Invoice period: " + invoiceStart + " to " + invoiceEnd);

        // Determine overlap period
        LocalDate effectiveStart = startDate.isAfter(invoiceStart) ? startDate : invoiceStart;
        LocalDate effectiveEnd = (endDate != null && endDate.isBefore(invoiceEnd)) ? endDate : invoiceEnd;

        long daysInPeriod = ChronoUnit.DAYS.between(effectiveStart, effectiveEnd.plusDays(1));
        long totalDaysInMonth = startDate.lengthOfMonth(); // OR ----> ChronoUnit.DAYS.between(invoiceStart, invoiceEnd.plusDays(1));

        // Prorate monthly fee
        BigDecimal proratedFee = monthlyFee
                .multiply(BigDecimal.valueOf(daysInPeriod))
                .divide(BigDecimal.valueOf(totalDaysInMonth), 2, RoundingMode.HALF_UP);

        // Apply discount
        BigDecimal total = proratedFee.subtract(discount);
        return total.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : total;
    }

    public static BigDecimal calculateInvoiceII(
            @NotNull LocalDate startDate,
            LocalDate endDate,
            @NotNull BigDecimal monthlyFee,
            BigDecimal discount
    ) {
        YearMonth month = YearMonth.from(startDate);
        LocalDate lastDayOfMonth = month.atEndOfMonth();

        // If endDate is null → subscription is ongoing → invoice through end of month
        LocalDate invoiceEnd = (endDate == null || endDate.isAfter(lastDayOfMonth))
                ? lastDayOfMonth
                : endDate;

        // Billable days = inclusive
        long billableDays = ChronoUnit.DAYS.between(startDate, invoiceEnd) + 1;
        long totalDaysInMonth = month.lengthOfMonth();

        // Prorated fee
        BigDecimal proratedFee = monthlyFee
                .multiply(BigDecimal.valueOf(billableDays))
                .divide(BigDecimal.valueOf(totalDaysInMonth), 2, RoundingMode.HALF_UP);

        // Apply discount
        BigDecimal total = proratedFee.subtract(discount != null ? discount : BigDecimal.ZERO);

        return total.max(BigDecimal.ZERO);
    }


}
