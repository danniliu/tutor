package app.ztest;

import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Subscription {
  public Subscription() {}
  public Subscription(int id, int customerId, int monthlyPriceInDollars) {
    this.id = id;
    this.customerId = customerId;
    this.monthlyPriceInDollars = monthlyPriceInDollars;
  }

  public int id;
  public int customerId;
  public int monthlyPriceInDollars;
}

class User {
  public User() {}
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
  public static double billFor(String month, Subscription activeSubscription, User[] users) {
    // your code here!
    //1. Calculate a daily rate for the active subscription tier
    
    //get how many days in this month
    String dateStr = month + "-01";
    LocalDate billDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate firstDayOfMonth = Challenge.firstDayOfMonth(billDate);
    LocalDate lastDayOfMonth = Challenge.lastDayOfMonth(billDate);
    int daysInMonth = lastDayOfMonth.getDayOfMonth() - firstDayOfMonth.getDayOfMonth() + 1;
    
    double dailyRate = activeSubscription.monthlyPriceInDollars / daysInMonth;
    
    //2. For each day of the month, identify which users were active that day
    
    int totalActiveDays = 0;
    for (User user : users){
      LocalDate startDayForTheMonth = firstDayOfMonth, endDayForTheMonth = lastDayOfMonth;
      if (user.customerId == activeSubscription.customerId){
        if (user.activatedOn != null && user.activatedOn.isAfter(firstDayOfMonth)){
          startDayForTheMonth = user.activatedOn;
        }
        if(user.deactivatedOn != null && user.deactivatedOn.isBefore(lastDayOfMonth)){
          endDayForTheMonth = user.deactivatedOn;
        }
        totalActiveDays = totalActiveDays + endDayForTheMonth.getDayOfMonth() - startDayForTheMonth.getDayOfMonth() + 1;
      }
    }
    
    //calc the total bill
    return dailyRate * totalActiveDays;
  }

  /*******************
  * Helper functions *
  *******************/

  /**
  Takes a LocalDate object and returns a LocalDate which is the first day
  of that month. For example:

  firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
  **/
  private static LocalDate firstDayOfMonth(LocalDate date) {
    return date.withDayOfMonth(1);
  }

  /**
  Takes a LocalDate object and returns a LocalDate which is the last day
  of that month. For example:

  lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
  **/
  private static LocalDate lastDayOfMonth(LocalDate date) {
    return date.withDayOfMonth(date.lengthOfMonth());
  }

  /**
  Takes a LocalDate object and returns a LocalDate which is the next day.
  For example:

  nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
  nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
  **/
  private static LocalDate nextDay(LocalDate date) {
     return date.plusDays(1);
  }
}
