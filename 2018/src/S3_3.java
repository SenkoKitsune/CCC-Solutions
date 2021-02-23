import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S3_3 {
    static int n, m;
    static char[][] floorPlan;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        floorPlan = new char[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        map = new int[n + 1][m + 1];
        pair start = new pair(0, 0);
        Queue<pair> pairs = new LinkedList<>();
        ArrayList<pair> empty = new ArrayList<>();
        ArrayList<pair> cameras = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = in.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.MAX_VALUE;
                floorPlan[i][j] = input.charAt(j);
                switch (floorPlan[i][j]) {
                    case 'W':
                        map[i][j] = -1;
                        break;

                    case 'S':
                        start = new pair(i, j);
                        pairs.add(start);
                        map[i][j] = 0;
                        break;

                    case '.':
                        empty.add(new pair(i, j));
                        break;

                    case 'C':
                        cameras.add(new pair(i,j));
                        map[i][j] = -1;
                }
            }
        }


        for(int i = 0; i < cameras.size(); i++){
            fill(cameras.get(i));
        }

        if(map[start.Y][start.X] == -1){
            for(int i = 0; i < empty.size(); i++){
                System.out.println(-1);
            }
        }
        else{
            while(pairs.size() != 0){
                pair current = pairs.poll();
                switch (floorPlan[current.Y][current.X]){
                    case 'L':
                        if(checkBoundaries(current.Y,current.X-1)) {
                            visited[current.Y][current.X-1] = true;
                            if(map[current.Y][current.X-1]>map[current.Y][current.X]) {
                                pairs.add(new pair(current.Y,current.X-1));
                                map[current.Y][current.X-1] = map[current.Y][current.X];
                            }
                        }
                        break;
                    case 'R':
                        if(checkBoundaries(current.Y,current.X+1)) {
                            visited[current.Y][current.X+1] = true;
                            if(map[current.Y][current.X+1]>map[current.Y][current.X]) {
                                pairs.add(new pair(current.Y,current.X+1));
                                map[current.Y][current.X+1] = map[current.Y][current.X];
                            }
                        }
                        break;
                    case 'U':
                        if(checkBoundaries(current.Y-1,current.X)) {
                            visited[current.Y-1][current.X] = true;
                            if(map[current.Y-1][current.X]>map[current.Y][current.X]) {
                                pairs.add(new pair(current.Y-1,current.X));
                                map[current.Y-1][current.X] = map[current.Y][current.X];
                            }
                        }
                        break;
                    case 'D':
                        if(checkBoundaries(current.Y+1,current.X)) {
                            visited[current.Y+1][current.X] = true;
                            if(map[current.Y+1][current.X]>map[current.Y][current.X]) {
                                pairs.add(new pair(current.Y+1,current.X));
                                map[current.Y+1][current.X] = map[current.Y][current.X];
                            }
                        }
                        break;
                    case '.', 'S':
                        if(checkBoundaries(current.Y+1,current.X)) {
                            visited[current.Y+1][current.X] = true;
                            if(map[current.Y+1][current.X]>map[current.Y][current.X]+1) {
                                pairs.add(new pair(current.Y+1,current.X));
                                map[current.Y+1][current.X] = map[current.Y][current.X]+1;
                            }
                        }
                        if(checkBoundaries(current.Y-1,current.X)) {
                            visited[current.Y-1][current.X] = true;
                            if(map[current.Y-1][current.X]>map[current.Y][current.X]+1) {
                                pairs.add(new pair(current.Y-1,current.X));
                                map[current.Y-1][current.X] = map[current.Y][current.X]+1;
                            }
                        }
                        if(checkBoundaries(current.Y,current.X+1)) {
                            visited[current.Y][current.X+1] = true;
                            if(map[current.Y][current.X+1]>map[current.Y][current.X]+1) {
                                pairs.add(new pair(current.Y,current.X+1));
                                map[current.Y][current.X+1] = map[current.Y][current.X]+1;
                            }
                        }
                        if(checkBoundaries(current.Y,current.X-1)) {
                            visited[current.Y][current.X-1] = true;
                            if(map[current.Y][current.X-1]>map[current.Y][current.X]+1) {
                                pairs.add(new pair(current.Y,current.X-1));
                                map[current.Y][current.X-1] = map[current.Y][current.X]+1;
                            }
                        }
                        break;

                    default:
                        break;

                }
            }
            for(int i = 0; i < empty.size(); i++){
                if(map[empty.get(i).Y][empty.get(i).X] == Integer.MAX_VALUE){
                    System.out.println(-1);
                }
                else{
                    System.out.println(map[empty.get(i).Y][empty.get(i).X]);
                }
            }
        }
    }

    static boolean checkBoundaries(int y, int x) {
        return (y >= 0 && y < n && x >= 0 && x < m);
    }

    private static void fill(pair camera) {
        int X = camera.X;
        int Y = camera.Y;

        for (int i = 0; i < 4; i++) {
            int addition = 1;
            loop:
            while (true) {
                switch (i) {
                    //Down
                    case 0:
                        if (Y + addition >= map.length) {
                            break loop;
                        } else if (floorPlan[Y + addition][X] == 'W') {
                            break loop;
                        } else {
                            if (floorPlan[Y + addition][X] == '.' || floorPlan[Y + addition][X] == 'S') {
                                map[Y + addition][X] = -1;
                            }
                        }
                        break;

                    //Up
                    case 1:
                        if (Y - addition < 0) {
                            break loop;
                        } else if (floorPlan[Y - addition][X] == 'W') {
                            break loop;
                        } else {
                            if (floorPlan[Y - addition][X] == '.' || floorPlan[Y - addition][X] == 'S') {
                                map[Y - addition][X] = -1;
                            }
                        }
                        break;
                    //Right
                    case 2:
                        if (X + addition >= map[0].length) {
                            break loop;
                        } else if (floorPlan[Y][X + addition] == 'W') {
                            break loop;
                        } else {
                            if (floorPlan[Y][X + addition] == '.' || floorPlan[Y][X + addition] == 'S') {
                                map[Y][X + addition] = -1;
                            }
                        }
                        break;
                    //Left
                    case 3:
                        if (X - addition < 0) {
                            break loop;
                        } else if (floorPlan[Y][X - addition] == 'W') {
                            break loop;
                        } else {
                            if (floorPlan[Y][X - addition] == '.' || floorPlan[Y][X - addition] == 'S') {
                                map[Y][X - addition] = -1;
                            }
                        }
                        break;
                }
                addition++;
            }
        }
    }
}

class pair {
    int Y;
    int X;

    public pair(int y, int x) {
        Y = y;
        X = x;
    }
}
