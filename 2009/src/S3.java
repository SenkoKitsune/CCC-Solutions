import java.util.HashSet;
import java.util.Scanner;


public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] friends = new int[50][50];

        {
            friends [1] [6] = 1;
            friends [6] [1] = 1;
            friends [2] [6] = 1;
            friends [6] [2] = 1;
            friends [3] [6] = 1;
            friends [6] [3] = 1;
            friends [4] [6] = 1;
            friends [6] [4] = 1;
            friends [5] [6] = 1;
            friends [6] [5] = 1;
            friends [7] [6] = 1;
            friends [6] [7] = 1;
            friends [3] [4] = 1;
            friends [4] [3] = 1;
            friends [4] [5] = 1;
            friends [5] [4] = 1;
            friends [3] [5] = 1;
            friends [5] [3] = 1;
            friends [3] [15] = 1;
            friends [15] [3] = 1;
            friends [13] [15] = 1;
            friends [15] [13] = 1;
            friends [14] [13] = 1;
            friends [13] [14] = 1;
            friends [12] [13] = 1;
            friends [13] [12] = 1;
            friends [7] [8] = 1;
            friends [8] [7] = 1;
            friends [8] [9] = 1;
            friends [9] [8] = 1;
            friends [9] [10] = 1;
            friends [10] [9] = 1;
            friends [9] [12] = 1;
            friends [12] [9] = 1;
            friends [10] [11] = 1;
            friends [11] [10] = 1;
            friends [11] [12] = 1;
            friends [12] [11] = 1;
            friends [16] [17] = 1;
            friends [17] [16] = 1;
            friends [16] [18] = 1;
            friends [18] [16] = 1;
            friends [18] [17] = 1;
            friends [17] [18] = 1;
        }

        String input = in.next();
        while(!input.equals("q")){
            switch(input.charAt(0)){
                case 'i':
                    int x = in.nextInt();
                    int y = in.nextInt();
                    friends[x][y] = 1;
                    friends[y][x] = 1;
                    break;

                case 'd':
                    x = in.nextInt();
                    y = in.nextInt();
                    friends[x][y] = 0;
                    friends[y][x] = 0;
                    break;

                case 'n':
                    x = in.nextInt();
                    int counter = 0;
                    for(int i = 0; i < friends[x].length; i++){
                        if(friends[x][i] > 0){
                            counter++;
                        }
                    }
                    System.out.println(counter);
                    break;

                case 'f':
                    x = in.nextInt();
                    System.out.println(friendsOfFriends(friends, x));
                    break;

                case 's':
                    x = in.nextInt();
                    y = in.nextInt();
                    int path = shortestRoute(friends,x,y);
                    if(path == -1){
                        System.out.println("Not connected");
                    }
                    else{
                        System.out.println(path);
                    }
                    break;
            }
            input = in.next();
        }
    }

    private static int friendsOfFriends(int[][] friends, int x){
        int[][] temp = new int[50][50];
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends[i].length; j++){
                temp[i][j] = friends[i][j];
            }
        }
        HashSet<Integer> FoF = new HashSet<>();
        for(int i = 0; i < friends[x].length; i++){
            if(friends[x][i] == 1){
                for(int j = 0; j < friends[i].length; j++){
                    if(friends[i][j] == 1 && friends[x][j] == 0 && j != x){
                        FoF.add(j);
                    }
                }
            }
        }
        return FoF.size();
    }


    private static int shortestRoute(int[][] friends, int x, int y){
        int[][] temp = new int[friends.length][friends[x].length];
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                if(friends[i][j] == 1){
                    temp[i][j] = friends[i][j];
                }
                else {
                    temp[i][j] = 3000;
                }
            }
        }
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++) {
                if (temp[i][j] > 0) {
                    for (int k = 0; k < 50; k++) {
                        if ((temp[j][k] > 0) && (temp[i][j] + temp[j][k] < temp[i][k])) {
                            temp[i][k] = (temp[i][j] + temp[j][k]);
                            temp[k][i] = (temp[i][j] + temp[j][k]);
                        }
                    }
                }
            }
        }

        if(temp[x][y] == 3000){
            return -1;
        }
        else{
            return temp[x][y];
        }
    }

}