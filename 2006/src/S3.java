import java.util.ArrayList;
import java.util.Scanner;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Point Romy = new Point(in.nextInt(), in.nextInt());
        Point Jules = new Point(in.nextInt(), in.nextInt());

        int buildings = in.nextInt();
        ArrayList<Point>[] buildingLocations = new ArrayList[buildings];
        for(int i = 0; i < buildings; i++){
            int corners = in.nextInt();
            ArrayList<Point> building = new ArrayList<>();
            for(int j = 0; j < corners; j++){
                int X = in.nextInt();
                int Y = in.nextInt();

                Point buildingCorner = new Point(X, Y);
                building.add(buildingCorner);
            }
        }


    }
}

class Point{
    int X;
    int Y;

    public Point(int x, int y){
        X = x;
        Y = y;
    }
}
