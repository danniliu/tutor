package app;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class Temp {

    public static void test() {
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        System.out.println(yesterday);

        LocalDate date2 = LocalDate.of(2022, Month.JANUARY, 8);
        date.getDayOfMonth();
        

        //Default pattern is yyyy-MM-dd
        LocalDate date3 = LocalDate.parse("2020-03-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date4 = LocalDate.parse("08-Mar-2020", DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    //Handling floating-point numbers, especially around addition, multiplication, and rounding,
    //Our tests allow an error boundary of $0.01 to avoid most complications involving floats.
    public static void testCalc(){
        double dollar = 1.00;
        double dime = 0.10;
        int num = 7;
        double res = dollar - num * dime;
        System.out.println("Use double: " + res);

        BigDecimal bd = new BigDecimal("1.0");
        BigDecimal bdi = new BigDecimal("0.1");
        

        BigDecimal bRes = bd.subtract(new BigDecimal(num).multiply(bdi));
        System.out.println ("A dollar less " + num + " dimes is $" + bRes );

    }

    public static void main (String[] args) {
        Temp.test();
        Temp.testCalc();
    }
}






