public class test2 {
    public static void main(String[] args) {
        char[][] map = new char[9][9];
        init(map);
        printMap(map);
    }
    static void init(char[][] map) {
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map[0].length;j++){
                map[i][j] = '.';
            }
        }
    }
    static void printMap(char[][] map) {
        for(int i = 0;i<map[0].length;i++){
            if(i == 0) System.out.print(" ");
            System.out.print(i);
        }//print:   012345678
        System.out.println();
        for(int i = 0;i<map.length;i++){
            System.out.print((char)('a' + i));
            for(int j = 0;j<map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
