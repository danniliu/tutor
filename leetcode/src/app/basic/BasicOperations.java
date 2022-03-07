package app.basic;

import java.util.*;
import java.math.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class BasicOperations {
    
    public static void  main (String[] args){
        //String to int
        int test1 = Integer.parseInt("123");

        //int to String
        String test2 = String.valueOf(1);

        // char array to String
        char data[] = {'a', 'b', 'c'};
        String str = new String(data);
        //String and Characters
        char[] chars = "123".toCharArray();
        if (Character.isLetter(chars[0])) {} 
        if (Character.isLetterOrDigit(chars[0])) {} 

        //StringBuilder:
        StringBuilder builder = new StringBuilder();
        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();

        //HashMap to store value and count
        int[] nums = new int[]{1,2,3};
        HashMap<Integer, Integer> valCount =  
                     new HashMap<Integer, Integer>(); 
        
        for (int i=0; i<nums.length; i++){
            valCount.put(nums[i], valCount.getOrDefault(nums[i], 0) + 1);
        }

        // BigDecimal
        double dollar = 1.00;
        double dime = 0.10;
        int num = 7;
        double res = dollar - num * dime;
        System.out.println("Use double: " + res);

        BigDecimal bd = new BigDecimal("1.0");
        BigDecimal bdi = new BigDecimal("0.1");

        BigDecimal bRes = bd.subtract(new BigDecimal(num).multiply(bdi));
        System.out.println ("A dollar less " + num + " dimes is $" + bRes );


        // Java LocalDate
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        System.out.println(yesterday);

        LocalDate date2 = LocalDate.of(2022, Month.JANUARY, 8);
        date.getDayOfMonth();
        

        //Default pattern is yyyy-MM-dd
        LocalDate date3 = LocalDate.parse("2020-03-03");
        LocalDate date4 = LocalDate.parse("08-Mar-2020", DateTimeFormatter.ofPattern("dd-MMM-yyy"));

    }
}
