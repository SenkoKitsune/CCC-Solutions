import java.util.ArrayList;
import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Y = in.nextInt();
        int X = in.nextInt();
        char[][] Map = new char[Y][X];
        int[][] movesToPosition = new int[Y][X];
        Point start = new Point(0, 0);
        ArrayList<Point> cameras = new ArrayList<>();
        for (int i = 0; i < Y; i++) {
            String line = in.next();
            for (int j = 0; j < X; j++) {
                Map[i][j] = line.charAt(j);
                if (Map[i][j] == 'S') {
                    start = new Point(i, j);
                } else if (Map[i][j] == 'C') {
                    cameras.add(new Point(i, j));
                } else if (Map[i][j] == '.') {
                    movesToPosition[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < cameras.size(); i++) {
            fill(Map, movesToPosition, cameras.get(i));
        }

        getMoves(Map, movesToPosition, start, 0, 'N');

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (movesToPosition[i][j] != 0) {
                    if (movesToPosition[i][j] == Integer.MAX_VALUE) {
                        System.out.println(-1);
                    } else {
                        System.out.println(movesToPosition[i][j]);
                    }
                }
            }
        }

    }

    private static void getMoves(char[][] layout, int[][] map, Point location, int movesToLocation, char previousMove) {
        int X = location.X;
        int Y = location.Y;
        if (X >= map[0].length || Y >= map.length || map[Y][X] == -1 || map[Y][X] < movesToLocation && layout[Y][X] != 'U' && layout[Y][X] != 'D' && layout[Y][X] != 'L' && layout[Y][X] != 'R') {

        }

        else {
            if (map[Y][X] > movesToLocation) {
                map[Y][X] = movesToLocation;
            }

            //Up
            if (Y - 1 >= 0 && previousMove != 'D') {
                Point newPoint = new Point(Y - 1, X);
                if (layout[Y][X] == 'U') {
                    getMoves(layout, map, newPoint, movesToLocation, 'N');
                } else {
                    getMoves(layout, map, newPoint, movesToLocation + 1, 'U');
                }
            }

            //Down
            if (Y + 1 <= map.length && previousMove != 'U') {
                Point newPoint = new Point(Y + 1, X);
                if (layout[Y][X] == 'D') {
                    getMoves(layout, map, newPoint, movesToLocation, 'N');
                } else {
                    getMoves(layout, map, newPoint, movesToLocation + 1, 'D');
                }
            }

            //Right
            if (X + 1 <= map[0].length && previousMove != 'L') {
                Point newPoint = new Point(Y, X + 1);
                if (layout[Y][X] == 'R') {
                    getMoves(layout, map, newPoint, movesToLocation, 'N');
                } else {
                    getMoves(layout, map, newPoint, movesToLocation + 1, 'R');
                }
            }


            //Left
            if (X - 1 >= 0 && previousMove != 'R') {
                Point newPoint = new Point(Y, X - 1);
                if (layout[Y][X] == 'L') {
                    getMoves(layout, map, newPoint, movesToLocation, 'N');
                } else {
                    getMoves(layout, map, newPoint, movesToLocation + 1, 'L');
                }
            }
        }

    }

    private static void fill(char[][] MAP, int[][] map, Point camera) {
        int X = camera.X;
        int Y = camera.Y;

        for (int i = 0; i < 4; i++) {
            int addition = 1;
            loop:
            while (true) {
                switch (i) {
                    //Down
                    case 0:
                        if(Y + addition >= map.length){
                            break loop;
                        }
                        else if(MAP[Y + addition][X] == 'W'){
                            break loop;
                        }
                        else{
                            if(MAP[Y + addition][X] == '.'){
                                map[Y + addition][X] = -1;
                            }
                        }
                        break;

                    //Up
                    case 1:
                        if(Y - addition < 0){
                            break loop;
                        }
                        else if(MAP[Y - addition][X] == 'W'){
                            break loop;
                        }
                        else{
                            if(MAP[Y - addition][X] == '.'){
                                map[Y - addition][X] = -1;
                            }
                        }
                        break;
                    //Right
                    case 2:
                        if(X + addition >= map[0].length){
                            break loop;
                        }
                        else if(MAP[Y][X + addition] == 'W'){
                            break loop;
                        }
                        else{
                            if(MAP[Y][X + addition] == '.'){
                                map[Y][X + addition] = -1;
                            }
                        }
                        break;
                    //Left
                    case 3:
                        if(X - addition < 0){
                            break loop;
                        }
                        else if(MAP[Y][X - addition] == 'W'){
                            break loop;
                        }
                        else{
                            if(MAP[Y][X - addition] == '.'){
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

class Point {
    public int X;
    public int Y;

    public Point(int y, int x) {
        X = x;
        Y = y;
    }
}

