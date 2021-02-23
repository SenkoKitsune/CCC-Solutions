import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trains = new LinkedList<>();
        int maxWeight = in.nextInt();
        int trainCount = in.nextInt();

        for (int i = 0; i < trainCount; i++) {
            trains.add(in.nextInt());
        }

        boolean overweight = false;
        int counter = 0;
        int weight = 0;
        while (!overweight) {
            if (trains.size() > 0) {
                if (bridge.size() == 4) {
                    if (weight - bridge.peek() + trains.peek() > maxWeight) {
                        overweight = true;
                        counter += bridge.size();
                        break;
                    }
                    else {
                        weight -= bridge.peek();
                        bridge.poll();
                        counter++;
                        weight += trains.peek();
                        bridge.add(trains.poll());
                    }
                }

                else{
                    if(weight + trains.peek() > maxWeight){
                        overweight = true;
                        counter += bridge.size();
                        break;
                    }
                    else{
                        weight += trains.peek();
                        bridge.add(trains.poll());
                    }
                }
            }

            else {
                counter += bridge.size();
                break;
            }
        }


        System.out.println(counter);
    }

}
