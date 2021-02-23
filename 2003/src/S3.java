import java.util.Scanner;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();

        int[][] roomNumber = new int[r][c];
        for(int i = 0; i < r; i++){
            String input = in.next();
            for(int j = 0; j < c; j++){
                char currentChar = input.charAt(j);
                if(currentChar == '.'){
                    roomNumber[i][j] = 0;
                }
                else{
                    roomNumber[i][j] = -1;
                }
            }
        }

        int k = 1;
        for (int i = 0 ; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                if (roomNumber[i][j] == 0) {
                    check(i, j, k, r, c, roomNumber);
                    k++;
                }
            }
        }


    }
    // sets the house grid are current location to k, and recursively
    // sets all connected square to k as well.
    public static void check (int i, int j, int k, int r, int c, int[][] floorPlan) {
        if (i >= 0 && i < r && j >= 0 && j < c && floorPlan[i][j] == 0)
        {
            floorPlan[i][j] = k;
            check (i - 1, j, k, r, c, floorPlan);
            check (i + 1, j, k, r, c, floorPlan);
            check (i, j + 1, k, r, c, floorPlan);
            check (i, j - 1, k, r ,c, floorPlan);
        }
    }
}
