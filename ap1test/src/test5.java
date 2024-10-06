public class test5 {
    public static void main(String[] args) {
        new test5().runApp();
    }
    void runApp(){
        char[][] map = {{'.','A','.','A'},
                        {'A','A','A','A'},
                        {'A','A','A','A'},
                        {'A','A','A','A'},
                        {'A','A','A','A'}
        };
        printMap(map);
        int count = cancelPuzzles(map);
        printMap(map);
        System.out.println(count);
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
    int cancelPuzzles(char[][] map) {
        int count = 0;
        boolean[] cancelRow = new boolean[map.length];
        boolean[] cancelCol = new boolean[map[0].length];

        //whether cancel row
        for(int i = 0;i<map.length;i++){
            boolean cancel = true;
            for(int j = 0;j<map[i].length;j++){
                if(map[i][j] == '.') {
                    cancel = false;
                    break;
                }
            }
            if(cancel){
                cancelRow[i] = true;
            }
        }

        //whether cancel row
        for(int j = 0;j<map[0].length;j++){
            boolean cancel = true;
            for(int i = 0;i<map.length;i++){
                if(map[i][j] == '.'){
                    cancel = false;
                    break;
                }
            }
            if(cancel){
                cancelCol[j] = true;
            }
        }

        //cancel row
        for(int i = 0;i<cancelRow.length;i++){
            if(cancelRow[i]){
                count++;
                for(int c = 0;c<map[0].length;c++){
                    map[i][c] = '.';
                }
            }
        }

        //cancel col
        for(int i = 0;i<cancelCol.length;i++){
            if(cancelCol[i]){
                count++;
                for(int r = 0;r<map.length;r++){
                    map[r][i] = '.';
                }
            }
        }

        return count;
    }
}
