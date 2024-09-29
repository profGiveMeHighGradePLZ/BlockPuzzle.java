public class test1 {

        //test print puzzles
        public static void main(String[] args) {
            char[][][] puzzles = {{{'A'}},                       // A

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

                    {{'I', 'I', 'I', 'I', 'I'}}
            };
            printPuzzles(puzzles);
        }
        static void printPuzzles(char[][][] puzzles) {
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


}
