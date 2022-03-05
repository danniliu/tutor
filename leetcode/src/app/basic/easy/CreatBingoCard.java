package app.basic.easy;

import java.util.Random;

/**
 * https://leetcode.com/discuss/interview-question/557982/bingo-card

Given a 5x5 grid, create a bingo card with the folliwing condtions.
-the middle square in the middle column must have a free space
-it must generate random numbers per column as follows below:
-col1 1-15
-col2 16-30
-col3 31-45
-col4 46-60
-col5 61-75

so essentially

2 17 37 49 62
5 22 41 52 70
6 23 U 59 68
9 18 42 60 69
8 29 40 55 63

Follow up: create k different bingo cards. Bingo card 1 and bingo card 2 are different if each row of bingo card 1 is different than that of bingo card2.

Any algorihtm better than rejection sampling?
 */

public class CreatBingoCard {

    private static int size = 5;
    private static int randomSize = 15;
    
    static  int[][] createBingoCard(){
        int[][] gameCard = new int[5][5];
        int[] randomArray = new int[15];
        for(int i = 0; i < 15; i++) {
            randomArray[i] = i+1;
        }
        for(int i = 0; i < size ; i++) {
            randomize(randomArray, randomArray.length);
            for(int j = 0; j < size ; j++) {
                gameCard[j][i] = randomArray[j] + i*randomSize;
            }
        }
        gameCard[2][2] = -1;
        return gameCard;
    }
    
    // update the array with ramdom number of 0 to 15
    static void randomize( int arr[], int n)
    {
        Random r = new Random();
        for (int i = n-1; i > 0; i--) {
            int j = r.nextInt(i+1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[][] bingoCard = createBingoCard();
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size ; j++){
               System.out.print(bingoCard[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
}
