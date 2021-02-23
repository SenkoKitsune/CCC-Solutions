import java.util.Scanner;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; i++){

            char[][] intersections = inputChars(in);

            int[][] intMap = new int[intersections.length][intersections[0].length];
            fillArray(intMap);
            Point start = new Point(0,0);
            getMoves(intersections, intMap, start, 1);
            if(intMap[intersections.length - 1][intersections[0].length - 1] == Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else {
                System.out.println(intMap[intersections.length - 1][intersections[0].length - 1]);
            }
        }
    }

    private static char[][] inputChars(Scanner in){
        int Y = in.nextInt();
        int X = in.nextInt();
        char[][] intersections = new char[Y][X];
        for(int i = 0; i < Y; i++){
            String inputLine = in.next();
            for(int j = 0; j < X; j++){
                intersections[i][j] = inputLine.charAt(j);
            }
        }
        return intersections;
    }

    private static void fillArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void getMoves(char[][] layout, int[][] map, Point position, int moves){
        int Y = position.Y;
        int X = position.X;

        if(map[Y][X] < moves){

        }
        else if(Y == map.length - 1 && X == map[0].length - 1){
            if(map[Y][X] > moves){
                map[Y][X] = moves;
            }
        }
        else if (layout[Y][X] != '*') {
            if(map[Y][X] > moves){
                map[Y][X] = moves;
            }

            switch(layout[Y][X]){
                case '+':
                    if(Y - 1 >= 0){
                        Point newPosition = new Point(Y - 1, X);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    if(Y + 1 < layout.length){
                        Point newPosition = new Point(Y + 1, X);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    if(X - 1 >= 0){
                        Point newPosition = new Point(Y, X - 1);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    if(X + 1 < layout[0].length){
                        Point newPosition = new Point(Y, X + 1);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    break;

                case '|':
                    if(Y - 1 >= 0){
                        Point newPosition = new Point(Y - 1, X);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    if(Y + 1 < layout.length){
                        Point newPosition = new Point(Y + 1, X);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    break;

                case '-':
                    if(X - 1 >= 0){
                        Point newPosition = new Point(Y, X - 1);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
                    if(X + 1 < layout[0].length){
                        Point newPosition = new Point(Y, X + 1);
                        getMoves(layout, map, newPosition, moves + 1);
                    }
            }
        }
    }
}

class Point{
    int Y;
    int X;

    public Point(int y, int x){
        Y = y;
        X = x;
    }
}
