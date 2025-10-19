package remoteassessment.vanhack.invoice$calculation;

import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Subscription {
    public Subscription() {
    }

    public Subscription(int id, int customerId, int monthlyPriceInCents) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInCents = monthlyPriceInCents;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInCents;
}

class User {
    public User() {
    }

    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {
    /// Computes the monthly charge for a given subscription.
    ///
    /// @param month        - Always present
    ///                       Has the following structure:
    ///                       "2022-04"  // April 2022 in YYYY-MM format
    /// @param subscription - May be null
    ///                       If present, has the following structure (see Subscription class):
    ///                       {
    ///                         Id: 763,
    ///                         CustomerId: 328,
    ///                         MonthlyPriceInCents: 359  // price per active user per month
    ///                       }
    /// @param users        - May be empty, but not null
    ///                       Has the following structure (see User class):
    ///                       [
    ///{
    ///                           id: 1,
    ///                           name: "Employee #1",
    ///                           customerId: 1,
    ///
    ///                           // when this user started
    ///                           activatedOn: new Date("2021-11-04"),
    ///
    ///                           // last day to bill for user
    ///                           // should bill up to and including this date
    ///                           // since user had some access on this date
    ///                           deactivatedOn: new Date("2022-04-10")
    ///                         },
    ///                         {
    ///                           id: 2,
    ///                           name: "Employee #2",
    ///                           customerId: 1,
    ///
    ///                           // when this user started
    ///                           activatedOn: new Date("2021-12-04"),
    ///
    ///                           // hasn't been deactivated yet
    ///                           deactivatedOn: null
    ///                         },
    ///                       ]
    /// @returns The total monthly bill for the customer in cents, rounded
    /// to the nearest cent. For example, a bill of $20.00 should return 2000.
    /// If there are no active users or the subscription is null, returns 0.
    public static int monthlyCharge(String month, Subscription subscription, User[] users) {
        return -1;
    }

    /*******************
     * Helper functions *
     *******************/

    /**
     * Takes a LocalDate object and returns a LocalDate which is the first day
     * of that month. For example:
     * <p>
     * firstDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the last day
     * of that month. For example:
     * <p>
     * lastDayOfMonth(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 31)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the next day.
     * For example:
     * <p>
     * nextDay(LocalDate.of(2022, 3, 17)) // => LocalDate.of(2022, 3, 18)
     * nextDay(LocalDate.of(2022, 3, 31)) // => LocalDate.of(2022, 4, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}