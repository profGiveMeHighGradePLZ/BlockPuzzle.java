import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        new test4().runApp();
    }
    void runApp(){
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            if (validateInput(input)) {
                System.out.println(1);
            } else System.out.println(0);
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
}
