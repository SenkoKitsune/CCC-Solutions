import java.util.Scanner;

public class S3_2
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[][] square = new int[5][5];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                String x = in.next();
                if(x.equalsIgnoreCase("X")){
                    square[i][j] = Integer.MAX_VALUE;
                }
                else{
                    square[i][j] = Integer.parseInt(x);
                }
                //Get horizontal D; if no value set D as MIN_VALUE
                {
                    if (j == 2) {
                        boolean F = true;
                        boolean S = true;
                        boolean L = true;

                        //check empty square
                        if (square[i][0] == Integer.MAX_VALUE) {
                            F = false;
                        }
                        if (square[i][1] == Integer.MAX_VALUE) {
                            S = false;
                        }
                        if (square[i][2] == Integer.MAX_VALUE) {
                            L = false;
                        }

                        //get d
                        if (F && S) {
                            square[i][3] = square[i][1] - square[i][0];
                        }
                        else if (F && L) {
                            square[i][3] = ((square[i][2] - square[i][0]) / 2);
                        }
                        else if (S && L) {
                            square[i][3] = square[i][2] - square[i][1];
                        }
                        else if (F && !S && !L || !F && S && !L || !F && !S && L) {
                            square[i][3] = Integer.MIN_VALUE;

                            //input value
                            {
                                if (F) {
                                    square[i][4] = square[i][0];
                                } else if (S) {
                                    square[i][4] = square[i][1];
                                } else if (L) {
                                    square[i][4] = square[i][2];
                                }
                                //Check horizontal side
                                else{

                                }
                            }
                        }
                    }
                }
            }
        }

        //Get vertical D; if no value set D as 0
        {
            for(int i = 0; i < 3; i++){
                boolean T = true;
                boolean M = true;
                boolean B = true;

                //check empty square
                if (square[0][i] == Integer.MAX_VALUE) {
                    T = false;
                }
                if (square[1][i] == Integer.MAX_VALUE) {
                    M = false;
                }
                if (square[2][i] == Integer.MAX_VALUE) {
                    B = false;
                }

                //get D
                if (T && M) {
                    square[3][i] = square[1][i] - square[0][i];
                }
                else if (T && B) {
                    square[3][i] = ((square[2][i] - square[0][i]) / 2);
                }
                else if (M && B) {
                    square[3][i] = square[2][i] - square[1][i];
                }
                else if (T && !M && !B || !T && M && !B || !T && !M && B) {
                    square[3][i] = 0;

                    //input values
                    {
                        if (T) {
                            square[4][i] = square[0][i];
                        } else if (M) {
                            square[4][i] = square[1][i];
                        } else if (B){
                            square[4][i] = square[2][i];
                        }
                    }
                }
                else{
                    square[3][i] = 0;
                    square[4][i] = 0;
                }
            }
        }

        int[] D = returnGreatestD(square);

        int[][] newSquare = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                if(square[i][j] == Integer.MAX_VALUE) {
                    if (square[i][3] == Integer.MIN_VALUE) {
                        //Vertical Check
                        if (square[3][j] == Integer.MIN_VALUE) {
                            if(square[i][4] == Integer.MIN_VALUE){
                                newSquare[i][j] = square[4][j];
                            }
                            else {
                                if(square[i][4] > square[4][j]){
                                    newSquare[i][j] = square[i][4];
                                }
                                else{
                                    newSquare[i][j] = square[4][j];
                                }
                            }
                        }
                        else {
                            //Input vertical D into newSquare[i][j]
                            {
                                switch (i) {
                                    case 0:
                                        newSquare[i][j] = square[1][j] - D[1];
                                        break;
                                    case 1:
                                        //check horizontal sides
                                        if(square[0][j] == Integer.MAX_VALUE) {
                                            newSquare[i][j] = square[2][j] - D[1];
                                        }
                                        else{
                                            newSquare[i][j] = square[0][j] + D[1];
                                        }
                                        break;
                                    case 2:
                                        newSquare[i][j] = square[1][j] + D[1];
                                        break;
                                }
                            }
                        }
                    }
                    else {
                        //Input horizontal D into newSquare
                        if (square[i][1] == Integer.MAX_VALUE) {
                            if(square[i][4] == Integer.MIN_VALUE){
                                newSquare[i][j] = square[4][j];
                            }
                            else {
                                if(square[i][4] > square[4][j]){
                                    newSquare[i][j] = square[i][4];
                                }
                                else{
                                    newSquare[i][j] = square[4][j];
                                }
                            }
                        } else {
                            switch (j) {

                                case 0:
                                    newSquare[i][j] = square[i][1] - D[0];
                                    break;
                                case 1:
                                    //check vertical sides
                                    if(square[i][0] == Integer.MAX_VALUE){
                                        newSquare[i][j] = square[i][2] - D[0];
                                    }
                                    else {
                                        newSquare[i][j] = square[i][0] + D[0];
                                    }
                                    break;
                                case 2:
                                    newSquare[i][j] = square[i][1] + D[0];
                            }
                        }
                    }
                }
                else{
                    newSquare[i][j] = square[i][j];
                }
            }
        }

        //Check Values



        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(newSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] returnGreatestD(int[][] square){
        int[] greatest = new int[2];
        //set D as max D value in array
        {
            int HF = square[0][3];
            int HS = square[1][3];
            int HL = square[2][3];
            int VT = square[3][0];
            int VM = square[3][1];
            int VB = square[3][2];

            if(HF > HS && HF > HL){
                greatest[0] = HF;
            }
            else if(HS > HL){
                greatest[0] = HS;
            }
            else{
                greatest[0] = HL;
            }
            if(VT > VM && VT > VB){
                greatest[1] = VT;
            }
            else if(VM > VB){
                greatest[1] = VM;
            }
            else{
                greatest[1] = VB;
            }
        }
        return greatest;
    }

}
