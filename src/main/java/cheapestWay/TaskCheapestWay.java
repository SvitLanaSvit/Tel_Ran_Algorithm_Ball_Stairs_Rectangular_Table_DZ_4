package cheapestWay;

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
}
