package taskBall;

public class TaskBall {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        System.out.println(fBall(35));
        System.out.println("Time_1 : " + (System.nanoTime() - start1));

        long start2 = System.nanoTime();
        System.out.println(fBallMemo(35));
        System.out.println("Time_2 : " + (System.nanoTime() - start2));

        long start3 = System.nanoTime();
        System.out.println(fBallTab(35));
        System.out.println("Time_3 : " + (System.nanoTime() - start3));
    }

    private static int fBall(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        return fBall(n - 1) +  fBall(n - 2) +  fBall(n - 3);
    }

    static int[] arrBall = new int[100];
    private static int fBallMemo(int n){
        arrBall[0] = 0;
        arrBall[1] = 1;
        arrBall[2] = 2;
        arrBall[3] = 4;

        arrBall[n] = fBall(n - 1) +  fBall(n - 2) +  fBall(n - 3);
        return arrBall[n];
    }

    static int[] arrBallTab = new int[3];
    private static int fBallTab(int n){
        arrBallTab[0] = 1;
        arrBallTab[1] = 2;
        arrBallTab[2] = 4;

        for (int i = 3; i < n; i++) {
            arrBallTab[i % 3] = arrBallTab[0] + arrBallTab[1] +  arrBallTab[2];
        }
        return arrBallTab[(n - 1) % 3];
    }
}
