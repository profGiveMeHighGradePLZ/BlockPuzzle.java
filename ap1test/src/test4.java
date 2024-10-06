import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        new test4().runApp();
    }
    void runApp(){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int[] array = new int[2];
        do {
            flag = false;
            System.out.print("Enter a coordinate: ");
            String input = in.nextLine();
            if (validateInput(input)) {
                array = convertInputToRC(input);
            }
            else {
                System.out.println("Invalid input! Enter Again");
                flag = true;
            }
        }while(flag);
        System.out.println("coordinate is: ");
        for(int i:array) System.out.print(i+ " ");
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



//        int[] array = new int[2];
//        if((int)(input.charAt(0)-'a') >8 || (int)(input.charAt(1)-'0') >8){
//            System.out.println("Invalid Input!Enter Again");
//            return array;
//        }
//        array[0] = (int)(input.charAt(0)-'a');
//        array[1] = (int)(input.charAt(1)-'0');
//        return array;
    }
}
