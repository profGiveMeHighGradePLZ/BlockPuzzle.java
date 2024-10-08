import java.util.Random;
import java.util.Scanner;

public class test6 {
    char[][][] PUZZLES = {{{'A'}},                       // A

            {{'B'},                        // B
                    {'B'}},                       // B

            {{'C', 'C'},                   // CC
                    {'C', 'C'}},                  // CC

            {{'D', 'D', 'D'},              // DDD
                    {'D', '.', 'D'}},             // D D

            {{'E', 'E', 'E'},              // EEE
                    {'.', 'E'}},                  //  E

            {{'F', 'F', 'F'},              // FFF
                    {'F'}},                       // F

            {{'G', 'G', 'G'},              // GGG
                    {'.', '.', 'G'}},             //   G

            {{'H', 'H', 'H'},              // HHH
                    {'H', 'H', 'H'},              // HHH
                    {'H', 'H', 'H'}},             // HHH

            {{'I', 'I', 'I', 'I', 'I'}}   // IIIII


    };
    public static void main(String[] args) {
        new test6().runApp();
    }
    void runApp(){
        char[][] map = new char[4][5];
        init(map);
        printMap(map);
        char[][][] pullzes = new char[3][][];
        while(true) {
            randomPuzzleIfNeeded(pullzes);
            if(gameOver(map,pullzes)) break;
            printPuzzles(pullzes);
            getInputAndPlacePuzzle(map, pullzes);
            printMap(map);
        }
    }
    void init(char[][] map) {
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map[0].length;j++){
                map[i][j] = '.';
            }
        }
    }
    void printMap(char[][] map) {
        for(int i = 0;i<map[0].length;i++){
            if(i == 0) System.out.print(" ");
            System.out.print(i);
        }//print:  " 012345678"
        System.out.println();
        for(int i = 0;i<map.length;i++){
            System.out.print((char)('a' + i));//print "a"
            for(int j = 0;j<map[i].length;j++){
                System.out.print(map[i][j]);//print element
            }
            System.out.println();
        }
    }
    void getInputAndPlacePuzzle(char[][] map, char[][][] puzzles) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.print("Enter the coordinate:");
            String coordinate = in.next();
            if (validateInput(coordinate)) {
                int[] index = new int[2];
                index = convertInputToRC(coordinate);
                System.out.print("Enter the puzzle:");
                int place = in.nextInt();
                if (place >= 0 && place <= 2 && puzzles[place] != null && canPlace(map, puzzles[place], index[0], index[1])){
                    place(map, puzzles[place], index[0], index[1]);
                    flag = false;
                    puzzles[place] = null;
                }
                else if(!(place >= 0 && place <= 2)){
                    System.out.println("Error! the puzzle don't exist! Input Again");
                }
                else if(puzzles[place] == null){
                    System.out.println("Error! the puzzle is used! Input Again");
                }
                else{
                    System.out.println("Error! the place is used! Input Again!");
                }
            }
            else {
                System.out.println("Error! Illegal coordinate! Input Again!");
            }
        }while(flag);


    }
    boolean canPlace(char[][] map, char[][] puzzle, int r, int c) {
        if(r + puzzle.length <= map.length && c + puzzle[0].length <= map[0].length){
            for(int i = 0;i<puzzle.length;i++){
                for(int j = 0;j<puzzle[i].length;j++){
                    if(map[i+r][j+c] != '.'){
                        return false;
                    }
                }
            }
            return true;
        }
        else return false;
    }
    void place(char[][] map, char[][] puzzle, int r, int c) {
        if(canPlace(map, puzzle, r, c)){
            for(int i = 0;i<puzzle.length;i++){
                for(int j = 0;j<puzzle[i].length;j++){
                    map[r+i][c+j] = puzzle[i][j];
                }
            }
        }
    }
    boolean validateInput(String input) {
        if(input.length()!= 2) return false;
        if((int)(input.charAt(0)-'a') >= 0 && (int)(input.charAt(0)-'z') <= 0){
            if((int)(input.charAt(1)-'0') >= 0 && (int)(input.charAt(1)-'9') <= 0){
                return true;
            }
        }
        return false;
    }
    int[] convertInputToRC(String input) {
        int[] array = new int[2];
        array[0] = (int)(input.charAt(0)-'a')%8;
        array[1] = (int)(input.charAt(1)-'0')%8;
        return array;
    }
    void printPuzzles(char[][][] puzzles) {
        //example: puzzles[2] = {{'C', 'C'}, {'C', 'C'}}
        for(int i = 0;i<puzzles.length;i++){
            System.out.println("Puzzles " + i);
            //print: Puzzle 2
            if(puzzles[i] != null) {
                for(int a1 = 0;a1<puzzles[i].length;a1++){
                    for(int a2 = 0;a2<puzzles[i][a1].length;a2++){
                        System.out.print(puzzles[i][a1][a2]);
                        //print: cc
                    }
                    System.out.println();
                }
            }
            else System.out.println("used");
        }
    }
    void randomPuzzleIfNeeded(char[][][] puzzles) {
        boolean isEmpty = true;
        for(int i = 0;i<puzzles.length;i++){
            if(puzzles[i] != null){
                isEmpty = false;
                break;
            }//check whether puzzles is null
        }
        if(isEmpty){
            Random Rand = new Random();
            for(int i = 0;i<puzzles.length;i++){
                int RandomNum = Rand.nextInt(9);
                puzzles[i] = PUZZLES[RandomNum];
            }
        }
    }
    boolean gameOver(char[][] map, char[][][] puzzlesToPlace) {
        for(int i = 0;i<puzzlesToPlace.length;i++){
            for(int r = 0;r< map.length;r++){
                for(int c = 0;c<map[i].length;c++){
                    if(puzzlesToPlace[i] != null && canPlace(map,puzzlesToPlace[i],r,c)) return false;
                }
            }
        }
        return true;
    }
}
