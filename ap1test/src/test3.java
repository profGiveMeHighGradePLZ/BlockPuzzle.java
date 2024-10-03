public class test3 {
    public static void main(String[] args) {
        char[][] map = {{'.', '.', '.'},{'.', '.', '.'},{'.', '.', '.'},{'.', '.', '.'}};
        char[][] puzzle = {{'*','*'},{'*'}};
        place(map,puzzle,2,2);
        printMap(map);
    }
    static void printMap(char[][] map) {
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
    static boolean canPlace(char[][] map, char[][] puzzle, int r, int c) {
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
    static void place(char[][] map, char[][] puzzle, int r, int c) {
        if(canPlace(map, puzzle, r, c)){
            for(int i = 0;i<puzzle.length;i++){
                for(int j = 0;j<puzzle[i].length;j++){
                    map[r+i][c+j] = puzzle[i][j];
                }
            }
        }
        else System.out.println("Invalid Input!");
    }
}
