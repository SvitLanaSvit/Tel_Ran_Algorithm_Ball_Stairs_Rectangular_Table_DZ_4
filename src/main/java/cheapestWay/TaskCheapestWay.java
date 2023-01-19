package cheapestWay;

import java.util.Random;

public class TaskCheapestWay {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        System.out.println(fWay(17, 17));
        System.out.println("Time_1 : " + (System.nanoTime() - start1));

        long start2 = System.nanoTime();
        System.out.println(fWayMemo(17, 17));
        System.out.println("Time_2 : " + (System.nanoTime() - start2));

        long start3 = System.nanoTime();
        System.out.println(fWayTab(17, 17));
        System.out.println("Time_3 : " + (System.nanoTime() - start3));

        System.out.println("-------WAY------");
        System.out.println("Sum of way :" + " " + fWayMinPay(3,3));
    }

    private static int minCost(int[][] costs, int i, int j){
        if(i == costs.length - 1 && j == costs[0].length - 1) return 1_000_000;
        if(i >= costs.length || j >= costs[0].length - 1) return costs[i][j];
        return costs[i][j] + Math.min(minCost(costs, i + 1, j), minCost(costs, i, j + 1));
    }

    static private int fWay(int n, int m){
        if(n == 1 || m == 1) return 1;
        return fWay(n - 1, m) + fWay(n, m - 1);
    }

    static long[][] arrWay = new long[100][100];
    static private long fWayMemo(int n, int m){
        if(n == 1 || m == 1) return 1;
        arrWay[n][m] = fWayMemo(n - 1, m) + fWayMemo(n, m - 1);
        return arrWay[n][m];
    }

    static long[][] arrWayTab = new long[100][100];
    static private long fWayTab(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || j ==0){
                    arrWayTab[i][j] = 1;
                }
                else{
                    arrWayTab[i][j] = arrWayTab[i - 1][j] + arrWayTab[i][j - 1];
                }
            }
        }
        return arrWayTab[n - 1][m - 1];
    }

    static long fWayMinPay(int n, int m){
        Random rand = new Random(10);
        long[][] dp = new long[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                dp[i][j] = rand.nextInt(0,10);
                System.out.print(dp[i][j] + "/");
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                }else{
                    if(i>0){
                        dp[i][j] += dp[i-1][j];
                    }else if(j>0){
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        return dp[n -1][m -1];
    }
}
