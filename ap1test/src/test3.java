public class test3 {
    public static void main(String[] args) {
        char[][] map = {{'.', '.', '.'}};
        char[][] puzzle = {{'.'}};
        if(canPlace(map,puzzle,0,0)){
            System.out.println(1);
        }
        else System.out.println(0);
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
}
