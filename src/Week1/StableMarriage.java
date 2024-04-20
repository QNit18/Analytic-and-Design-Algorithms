package Week1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StableMarriage {
    public static int[][] stableMarriageAlgo(int[][] manPref, int[][] womanPref, int n) {

        Queue<Integer> freeMan = new LinkedList<>(); //Queue to track single men

        // Currently, all men are single
        for (int i = 0; i < n; i++) {
            freeMan.add(i);
        }

        int[] fallInLove = new int[n]; // Array to store current partners of women

        Arrays.fill(fallInLove, -1); // Initialize all women as single, fallinLove[i] == -1 =>

        int[] next = new int[n]; // Array to track next preferred woman for each man

        Arrays.fill(next, 0); // Initialize the first value of women preference is 0

        // 2D Array ranking: Woman preference ranking based on man index
        int[][] ranking = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ranking[i][womanPref[i][j]] = j;
            }
        }



        // m=man, w=women
        int m, w;

        // Start
        while (!freeMan.isEmpty()) // Condition: Leaest 1 m single
        {
            m = freeMan.poll(); // Get the first free man
            w = manPref[m][next[m]++];  // Get the next woman in preference list for m

            // If w is single
            if (fallInLove[w] == -1) {
                // m and w engage
                fallInLove[w] = m;
            } else {
                // If w prefer m2 than m1
                if (ranking[w][m] < ranking[w][fallInLove[w]]) {
                    // Woman w prefers m over her current partner, update matching
                    freeMan.add(fallInLove[w]); // m1
                    fallInLove[w] = m;
                } else{     // If w prefer m1 than m2
                    freeMan.add(m);
                }
            }
        }

        // Prepare the result in the required format [man, woman]
        int[][] stableMarriage = new int[n][2];
        for (int i = 0; i < n; i++) {
            stableMarriage[i][0] = i;
            stableMarriage[i][1] = fallInLove[i];
        }

        // Return result
        return stableMarriage;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] manPref = {
                {1, 0, 2, 3}, // is the women of the first man
                {3, 0, 1, 2},
                {0, 2, 1, 3},
                {1, 2, 0, 3}
        };
        int[][] womanPref = {
                {0, 2, 1, 3},
                {2, 3, 0, 1},
                {3, 1, 2, 0},
                {2, 1, 0, 3}
        };

        int[][] result = stableMarriageAlgo(manPref, womanPref, n);

        // Print result
        System.out.println(Arrays.deepToString(result));
    }
}
