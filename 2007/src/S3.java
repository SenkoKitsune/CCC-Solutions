import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfStudents = in.nextInt();
        int[] friends = new int[10000];

        // Friends[i] = friend of student i
        for(int i = 0; i < numberOfStudents; i++){
            friends[in.nextInt()] = in.nextInt();
        }

        int startFriend = in.nextInt();
        int friend = in.nextInt();


        //start at student startFriend, go to his friend, friend [startFriend]
        //continue until startFriend gets to friend or you revisit a number: visited[location] = true;
        while(startFriend != 0 && friend != 0){
            int location = startFriend;

            //resets visited
            boolean[] visited = new boolean[10000];
            int separation = -1;

            //changes Location based on friend at position
            while (!visited [location] && location != friend)
            {
                visited [location] = true;
                separation++;
                location = friends[location];
            }

            //check location and friend 2: if equal, return value, else return no
            if(location == friend){
                System.out.println("Yes " + separation);
            }
            else{
                System.out.println("No");
            }
            startFriend = in.nextInt();
            friend = in.nextInt();
        }
    }
}
