/*****************************\
 * McKayl U. & Toby S.
 * Our goal is to create a
 * program that simulates a
 * rubiks cube using a single
 * array.
 * Feb 2024
\*****************************/

// import scanner class //
import java.util.Scanner;

// import arraylist class //
import java.util.ArrayList;

// import random class //
import java.util.Random;

// Define the thecube class //
public class thecube {
    static int[] cubefaces = { // One Array to Rule them all //
        0, 1, 2,
        3, 4, 5,
        6, 7, 8,
        // Front //

        9, 10, 11,
        12, 13, 14,
        15, 16, 17,
        // Right //

        18, 19, 20,
        21, 22, 23,
        24, 25, 26,
        // Back //

        27, 28, 29,
        30, 31, 32,
        33, 34, 35,
        // Left //

        36, 37, 38,
        39, 40, 41,
        42, 43, 44,
        // Top //

        45, 46, 47,
        48, 49, 50,
        51, 52, 53,
        // Bottom //
    };

    static String[] maincube = {
        "w", "w", "w",
        "w", "w", "w",
        "w", "w", "w",
        // Front //

        "g", "g", "g",
        "g", "g", "g",
        "g", "g", "g",
        // Right //

        "y", "y", "y",
        "y", "y", "y",
        "y", "y", "y",
        // Back //

        "b", "b", "b",
        "b", "b", "b",
        "b", "b", "b",
        // Left //

        "r", "r", "r",
        "r", "r", "r",
        "r", "r", "r",
        // Top //

        "o", "o", "o",
        "o", "o", "o",
        "o", "o", "o",
        // Bottom //
    };

    // Get method //
    public int[] getCubefaces() {
        return cubefaces;
    }

    // Set method //
    public void setCubefaces(int[] cubefaces) {
        this.cubefaces = cubefaces;
    }
    
    // clockwise face rotation method //
    static void clockwise(int[] cubefaces, int i, int j) {
        int temp = cubefaces[0 + i];
        cubefaces[0 + i] = cubefaces[6 + i];
        cubefaces[6 + i] = cubefaces[8 + i];
        cubefaces[8 + i] = cubefaces[2 + i];
        cubefaces[2 + i] = temp;
        temp = cubefaces[1 + i];
        cubefaces[1 + i] = cubefaces[3 + i];
        cubefaces[3 + i] = cubefaces[7 + i];
        cubefaces[7 + i] = cubefaces[5 + i];
        cubefaces[5 + i] = temp;
    }
    
    // U, D, R, L, F, B methods //
    static void U(){
        clockwise(cubefaces, 36, 44);
        int[] temparray = {cubefaces[0], cubefaces[1], cubefaces[2]};
        cubefaces[0] = cubefaces[9];
        cubefaces[1] = cubefaces[10];
        cubefaces[2] = cubefaces[11];
        cubefaces[9] = cubefaces[18];
        cubefaces[10] = cubefaces[19];
        cubefaces[11] = cubefaces[20];
        cubefaces[18] = cubefaces[27];
        cubefaces[19] = cubefaces[28];
        cubefaces[20] = cubefaces[29];
        cubefaces[27] = temparray[0];
        cubefaces[28] = temparray[1];
        cubefaces[29] = temparray[2];
    }

    static void D(){
        clockwise(cubefaces, 45, 53);
        int[] temparray = {cubefaces[6], cubefaces[7], cubefaces[8]};
        cubefaces[6] = cubefaces[33];
        cubefaces[7] = cubefaces[34];
        cubefaces[8] = cubefaces[35];
        cubefaces[33] = cubefaces[24];
        cubefaces[34] = cubefaces[25];
        cubefaces[35] = cubefaces[26];
        cubefaces[24] = cubefaces[15];
        cubefaces[25] = cubefaces[16];
        cubefaces[26] = cubefaces[17];
        cubefaces[15] = temparray[0];
        cubefaces[16] = temparray[1];
        cubefaces[17] = temparray[2];
    }

    static void R(){
        clockwise(cubefaces, 9, 17);
        int[] temparray = {cubefaces[2], cubefaces[5], cubefaces[8]};
        cubefaces[2] = cubefaces[47];
        cubefaces[5] = cubefaces[50];
        cubefaces[8] = cubefaces[53];
        cubefaces[47] = cubefaces[24];
        cubefaces[50] = cubefaces[21];
        cubefaces[53] = cubefaces[18];
        cubefaces[24] = cubefaces[38];
        cubefaces[21] = cubefaces[41];
        cubefaces[18] = cubefaces[44];
        cubefaces[38] = temparray[0];
        cubefaces[41] = temparray[1];
        cubefaces[44] = temparray[2];
    }

    static void L(){
        clockwise(cubefaces, 27, 35);
        int[] temparray = {cubefaces[0], cubefaces[3], cubefaces[6]};
        cubefaces[0] = cubefaces[36];
        cubefaces[3] = cubefaces[39];
        cubefaces[6] = cubefaces[42];
        cubefaces[36] = cubefaces[26];
        cubefaces[39] = cubefaces[23];
        cubefaces[42] = cubefaces[20];
        cubefaces[26] = cubefaces[45];
        cubefaces[23] = cubefaces[48];
        cubefaces[20] = cubefaces[51];
        cubefaces[45] = temparray[0];
        cubefaces[48] = temparray[1];
        cubefaces[51] = temparray[2];
    }

    static void F(){
        clockwise(cubefaces, 0, 8);
        int[] temparray = {cubefaces[9], cubefaces[12], cubefaces[15]};
        cubefaces[9] = cubefaces[42];
        cubefaces[12] = cubefaces[43];
        cubefaces[15] = cubefaces[44];
        cubefaces[42] = cubefaces[35];
        cubefaces[43] = cubefaces[32];
        cubefaces[44] = cubefaces[29];
        cubefaces[35] = cubefaces[47];
        cubefaces[32] = cubefaces[46];
        cubefaces[29] = cubefaces[45];
        cubefaces[47] = temparray[0];
        cubefaces[46] = temparray[1];
        cubefaces[45] = temparray[2];
    }

    static void B(){
        clockwise(cubefaces, 18, 26);
        int[] temparray = {cubefaces[11], cubefaces[14], cubefaces[17]};
        cubefaces[11] = cubefaces[53];
        cubefaces[14] = cubefaces[52];
        cubefaces[17] = cubefaces[51];
        cubefaces[53] = cubefaces[33];
        cubefaces[52] = cubefaces[30];
        cubefaces[51] = cubefaces[27];
        cubefaces[33] = cubefaces[36];
        cubefaces[30] = cubefaces[37];
        cubefaces[27] = cubefaces[38];
        cubefaces[36] = temparray[0];
        cubefaces[37] = temparray[1];
        cubefaces[38] = temparray[2];
    }

    // counter clockwise face rotation method //
    static void counterclockwise(int[] cubefaces, int i, int j) {
        int temp = cubefaces[0 + i];
        cubefaces[0 + i] = cubefaces[2 + i];
        cubefaces[2 + i] = cubefaces[8 + i];
        cubefaces[8 + i] = cubefaces[6 + i];
        cubefaces[6 + i] = temp;
        temp = cubefaces[1 + i];
        cubefaces[1 + i] = cubefaces[5 + i];
        cubefaces[5 + i] = cubefaces[7 + i];
        cubefaces[7 + i] = cubefaces[3 + i];
        cubefaces[3 + i] = temp;
    }   

    // U', D', R', L', F', B' methods //
    static void Uprime(){
        counterclockwise(cubefaces, 36, 44);
        int[] temparray = {cubefaces[0], cubefaces[1], cubefaces[2]};
        cubefaces[0] = cubefaces[27];
        cubefaces[1] = cubefaces[28];
        cubefaces[2] = cubefaces[29];
        cubefaces[27] = cubefaces[18];
        cubefaces[28] = cubefaces[19];
        cubefaces[29] = cubefaces[20];
        cubefaces[18] = cubefaces[9];
        cubefaces[19] = cubefaces[10];
        cubefaces[20] = cubefaces[11];
        cubefaces[9] = temparray[0];
        cubefaces[10] = temparray[1];
        cubefaces[11] = temparray[2];
    }

    static void Dprime(){
        counterclockwise(cubefaces, 45, 53);
        int[] temparray = {cubefaces[6], cubefaces[7], cubefaces[8]};
        cubefaces[6] = cubefaces[15];
        cubefaces[7] = cubefaces[16];
        cubefaces[8] = cubefaces[17];
        cubefaces[15] = cubefaces[24];
        cubefaces[16] = cubefaces[25];
        cubefaces[17] = cubefaces[26];
        cubefaces[24] = cubefaces[33];
        cubefaces[25] = cubefaces[34];
        cubefaces[26] = cubefaces[35];
        cubefaces[33] = temparray[0];
        cubefaces[34] = temparray[1];
        cubefaces[35] = temparray[2];
    }

    static void Rprime(){
        counterclockwise(cubefaces, 9, 17);
        int[] temparray = {cubefaces[2], cubefaces[5], cubefaces[8]};
        cubefaces[2] = cubefaces[38];
        cubefaces[5] = cubefaces[41];
        cubefaces[8] = cubefaces[44];
        cubefaces[38] = cubefaces[24];
        cubefaces[41] = cubefaces[21];
        cubefaces[44] = cubefaces[18];
        cubefaces[24] = cubefaces[47];
        cubefaces[21] = cubefaces[50];
        cubefaces[18] = cubefaces[53];
        cubefaces[47] = temparray[0];
        cubefaces[50] = temparray[1];
        cubefaces[53] = temparray[2];
    }

    static void Lprime(){
        counterclockwise(cubefaces, 27, 35);
        int[] temparray = {cubefaces[0], cubefaces[3], cubefaces[6]};
        cubefaces[0] = cubefaces[45];
        cubefaces[3] = cubefaces[48];
        cubefaces[6] = cubefaces[51];
        cubefaces[45] = cubefaces[26];
        cubefaces[48] = cubefaces[23];
        cubefaces[51] = cubefaces[20];
        cubefaces[26] = cubefaces[36];
        cubefaces[23] = cubefaces[39];
        cubefaces[20] = cubefaces[42];
        cubefaces[36] = temparray[0];
        cubefaces[39] = temparray[1];
        cubefaces[42] = temparray[2];
    }

    static void Fprime(){
        counterclockwise(cubefaces, 0, 8);
        int[] temparray = {cubefaces[9], cubefaces[12], cubefaces[15]};
        cubefaces[9] = cubefaces[47];
        cubefaces[12] = cubefaces[46];
        cubefaces[15] = cubefaces[45];
        cubefaces[47] = cubefaces[35];
        cubefaces[46] = cubefaces[32];
        cubefaces[45] = cubefaces[29];
        cubefaces[35] = cubefaces[42];
        cubefaces[32] = cubefaces[43];
        cubefaces[29] = cubefaces[44];
        cubefaces[42] = temparray[0];
        cubefaces[43] = temparray[1];
        cubefaces[44] = temparray[2];
    }

    static void Bprime(){
        counterclockwise(cubefaces, 18, 26);
        int[] temparray = {cubefaces[11], cubefaces[14], cubefaces[17]};
        cubefaces[11] = cubefaces[36];
        cubefaces[14] = cubefaces[37];
        cubefaces[17] = cubefaces[38];
        cubefaces[36] = cubefaces[33];
        cubefaces[37] = cubefaces[30];
        cubefaces[38] = cubefaces[27];
        cubefaces[27] = cubefaces[51];
        cubefaces[30] = cubefaces[52];
        cubefaces[33] = cubefaces[53];
        cubefaces[53] = temparray[0];
        cubefaces[52] = temparray[1];
        cubefaces[51] = temparray[2];
    }
    
    // fliparray method //
    static void fliparray(ArrayList<String> moves) {
        int start = 0;
        int end = moves.size() - 1;

        while (start < end) {
            // Swap elements at start and end indices
            String temp = moves.get(start);
            moves.set(start, moves.get(end));
            moves.set(end, temp);

            // Move indices toward the center
            start++;
            end--;
        }
    }

    static void shorten(ArrayList<String> moves) {
        for (int i = 0; i < moves.size(); i++) {
            if (i < moves.size() - 1) {
                if (moves.get(i).equals(moves.get(i + 1)) && moves.get(i).equals(moves.get(i + 2))) {
                    moves.remove(i);
                    moves.remove(i);
                    if (moves.get(i).equals("U"))
                        moves.set(i, "U'");
                    else if (moves.get(i).equals("D"))
                        moves.set(i, "D'");
                    else if (moves.get(i).equals("R"))
                        moves.set(i, "R'");
                    else if (moves.get(i).equals("L"))
                        moves.set(i, "L'");
                    else if (moves.get(i).equals("F"))
                        moves.set(i, "F'");
                    else if (moves.get(i).equals("B"))
                        moves.set(i, "B'");
                    i = 0;
                }
            }
        }
    }

    // Sort of like that one Wilco song... but with numbers //
    static int generateRandomNumber() {
        // Create a Random object
        Random rand = new Random();
    
        // Generate a random number between 0 and 11 //
        int randomNumber = rand.nextInt(12); // Generates a number between 0 (inclusive) and 12 (exclusive) //
    
        // Return the random number //
        return randomNumber;
    }
      

    static void cubescramble(ArrayList<String> moves){
        // Array of Moves to "choose" from //
        String[] movesarray = {"U", "D", "R", "L", "F", "B", "U'", "D'", "R'", "L'", "F'", "B'"};
        // Creates the moves array //
        for (int i = 0; i < 6; i++)
            moves.add(movesarray[generateRandomNumber()]);
        // Prints Array Item by Item //
        for (int i = 0; i < moves.size(); i++)
            System.out.print(moves.get(i) + " ");
        System.out.println();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).equals("U")) {
                U();
            } else if (moves.get(i).equals("D")) {
                D();
            } else if (moves.get(i).equals("R")) {
                R();
            } else if (moves.get(i).equals("L")) {
                L();
            } else if (moves.get(i).equals("F")) {
                F();
            } else if (moves.get(i).equals("B")) {
                B();
            } else if (moves.get(i).equals("U'")) {
                Uprime();
            } else if (moves.get(i).equals("D'")) {
                Dprime();
            } else if (moves.get(i).equals("R'")) {
                Rprime();
            } else if (moves.get(i).equals("L'")) {
                Lprime();
            } else if (moves.get(i).equals("F'")) {
                Fprime();
            } else if (moves.get(i).equals("B'")) {
                Bprime();
            }
        }
    }

    // Main method //
    public static void main(String[] args) {
        // Creates instance of thecube //
        thecube cube = new thecube();

        System.out.println("Welcome to the Rubik's Cube Simulator!");
        System.out.println("Enter A to scramble the cube or M to solve the cube: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("A")) {
            ArrayList<String> moves = new ArrayList<String>();
            cubescramble(moves);// Access the cubefaces array //
            int[] cubefaces = cube.getCubefaces();
            System.out.println("Your Cube:");
            for (int i = 0; i < cubefaces.length; i++) {
                System.out.print(maincube[cubefaces[i]] + " ");
                if ((i + 1) % 3 == 0) { // Print newline every three characters //
                    System.out.println();
                    if ((i + 1) % 9 == 0) { // Another if statement to print out --- every third line to make it a bit easier to read //
                        System.out.println("-----");
                    }
                }
            }
            // output the solution //
            System.out.println("Your solution is: ");

            fliparray(moves);
            shorten(moves);

            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).equals("U")) {
                    System.out.print("U'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("D")) {
                    System.out.print("D'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("R")) {
                    System.out.print("R'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("L")) {
                    System.out.print("L'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("F")) {
                    System.out.print("F'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("B")) {
                    System.out.print("B'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("U'")) {
                    System.out.print("U");
                    System.out.print(" ");
                } else if (moves.get(i).equals("D'")) {
                    System.out.print("D");
                    System.out.print(" ");
                } else if (moves.get(i).equals("R'")) {
                    System.out.print("R");
                    System.out.print(" ");
                } else if (moves.get(i).equals("L'")) {
                    System.out.print("L");
                    System.out.print(" ");
                } else if (moves.get(i).equals("F'")) {
                    System.out.print("F");
                    System.out.print(" ");
                } else if (moves.get(i).equals("B'")) {
                    System.out.print("B");
                    System.out.print(" ");
                }
            }
        } else if (choice.equals("M")) {
            
            //Create an array of the input moves //
            ArrayList<String> moves = new ArrayList<String>();

            System.out.println("Your move options are: U, D, R, L, F, B, U', D', R', L', F', B'");
            System.out.println("Enter Q to quit");
            System.out.println("Enter the next move: ");

            //get user input for each move
            Scanner nextmove = new Scanner(System.in);
            
            String move = nextmove.nextLine();

            //call the method for the move
            while(!move.equals("Q")){
                moves.add(move);
                if (move.equals("U")) {
                    U();
                } else if (move.equals("D")) {
                    D();
                } else if (move.equals("R")) {
                    R();
                } else if (move.equals("L")) {
                    L();
                } else if (move.equals("F")) {
                    F();
                } else if (move.equals("B")) {
                    B();
                } else if (move.equals("U'")) {
                    Uprime();
                } else if (move.equals("D'")) {
                    Dprime();
                } else if (move.equals("R'")) {
                    Rprime();
                } else if (move.equals("L'")) {
                    Lprime();
                } else if (move.equals("F'")) {
                    Fprime();
                } else if (move.equals("B'")) {
                    Bprime();
                } else {
                    System.out.println("Invalid move");
                }
                System.out.println("Enter the next move: ");
                move = nextmove.nextLine();
            }
            
            // Access the cubefaces array //
            int[] cubefaces = cube.getCubefaces();
            System.out.println("Your Cube:");
            for (int i = 0; i < cubefaces.length; i++) {
                System.out.print(maincube[cubefaces[i]] + " ");
                if ((i + 1) % 3 == 0) { // Print newline every three characters //
                    System.out.println();
                    if ((i + 1) % 9 == 0) { // Another if statement to print out --- every third line to make it a bit easier to read //
                        System.out.println("-----");
                    }
                }
            }

            // output the solution //
            System.out.println("Your solution is: ");

            fliparray(moves);
            shorten(moves);

            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).equals("U")) {
                    System.out.print("U'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("D")) {
                    System.out.print("D'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("R")) {
                    System.out.print("R'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("L")) {
                    System.out.print("L'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("F")) {
                    System.out.print("F'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("B")) {
                    System.out.print("B'");
                    System.out.print(" ");
                } else if (moves.get(i).equals("U'")) {
                    System.out.print("U");
                    System.out.print(" ");
                } else if (moves.get(i).equals("D'")) {
                    System.out.print("D");
                    System.out.print(" ");
                } else if (moves.get(i).equals("R'")) {
                    System.out.print("R");
                    System.out.print(" ");
                } else if (moves.get(i).equals("L'")) {
                    System.out.print("L");
                    System.out.print(" ");
                } else if (moves.get(i).equals("F'")) {
                    System.out.print("F");
                    System.out.print(" ");
                } else if (moves.get(i).equals("B'")) {
                    System.out.print("B");
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}