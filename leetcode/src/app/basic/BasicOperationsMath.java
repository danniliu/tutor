package app.basic;

import java.util.*;

public class BasicOperationsMath {
    /** https://www.baeldung.com/java-generating-random-numbers-in-range
     * Math.random gives a random double value that is greater than or equal to 0.0 and less than 1.0.
        Let's use the Math.random method to generate a random number in a given range [min, max):
    */
    int min = 10, max =20;
    int r = (int) ((Math.random() * (max - min)) + min);;
    // the other way
    Random random = new Random();
    int r1= random.nextInt(max - min) + min;

}
