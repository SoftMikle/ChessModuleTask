import java.util.Scanner;

public class Chess {
    void mainMethod(){
        int[] startPosition = new int[2];
        int[] targetPosition = new int[2];
        do {
            startPosition = init();
        } while (startPosition[0] < 0 || startPosition[1] < 0);
        System.out.println("OK, now enter target position of the Knight (Horse):");
        do {
            targetPosition = init();
        } while (targetPosition[0] < 0 || targetPosition[1] < 0);
        if(checkingOfStep(startPosition, targetPosition)){
            System.out.println("Yeah, the Knight goes such way");
        }
        else {
            System.out.println("Wow, that is wrong way to step by Knight");
        }
    }
    int[] init(){
        int[] pos = new int[2];
        String c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the Knight (Horse) (at format \"6 D\")");
        pos[0] = scanner.nextInt() - 1;
        c = scanner.next();
        if(pos[0] < 0 || pos[0] > 7){
            pos[0] = -1;
            System.out.println("Wrong entering, try again");
        }
        switch (c.toLowerCase()){
            case "a":
                pos[1] = 1;
                break;
            case "b":
                pos[1] = 2;
                break;
            case "c":
                pos[1] = 3;
                break;
            case "d":
                pos[1] = 4;
                break;
            case "e":
                pos[1] = 5;
                break;
            case "f":
                pos[1] = 6;
                break;
            case "g":
                pos[1] = 7;
                break;
            case "h":
                pos[1] = 8;
                break;
            default:
                pos[1] = -1;
                System.out.println("Wrong entering, try again");
                break;
        }
        return pos;
    }
    boolean checkingOfStep(int[] pos1, int[] pos2){
        int[][] variants = new int[2][8];
        int k;
        variants [0][0] = pos1[0] + 1;
        variants [1][0] = pos1[1] + 2;
        variants [0][1] = pos1[0] + 2;
        variants [1][1] = pos1[1] + 1;
        variants [0][2] = pos1[0] + 2;
        variants [1][2] = pos1[1] - 1;
        variants [0][3] = pos1[0] + 1;
        variants [1][3] = pos1[1] - 2;
        variants [0][4] = pos1[0] - 1;
        variants [1][4] = pos1[1] - 2;
        variants [0][5] = pos1[0] - 2;
        variants [1][5] = pos1[1] - 1;
        variants [0][6] = pos1[0] + 1;
        variants [1][6] = pos1[1] - 2;
        variants [0][7] = pos1[0] + 2;
        variants [1][7] = pos1[1] - 1;
        for (int i = 0; i < 8; i++) {
            if(pos2[0] == variants[0][i] && pos2[1] == variants[1][i]){
                return true;
            }
        }
        return false;
    }

}
