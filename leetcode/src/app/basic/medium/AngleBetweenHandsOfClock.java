package app.basic.medium;

/**
 * 1344. Angle Between Hands of a Clock
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
    Answers within 10-5 of the actual value will be accepted as correct.
 * 
 * ********************* Analysis:
 * Algorithm
    Initialize the constants: one_min_angle = 360/60 = 6, one_hour_angle = 360/12 = 30.
    The angle between minute hand and 0-minutes vertical line is minutes_angle = one_min_angle * minutes.
    The angle between hour hand and 12-hour vertical line is hour_angle = (hour % 12 + minutes / 60) * one_hour_angle.
    Find the difference: diff = abs(hour_angle - minutes_angle).
    Return the smallest angle: min(diff, 360 - diff).
 * 
 */

public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;
    
        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;
    
        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
      }
}
