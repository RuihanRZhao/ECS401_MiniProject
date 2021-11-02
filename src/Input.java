import java.util.Scanner;
public class Input {//To Input varibles
    public static int Int(String InputPrompt) {//intege varible input function
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.nextInt();
    }
    public static String String(String InputPrompt){
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.next();
    }

    public static char Char(String InputPrompt) {//float varible input function
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.next().charAt(0);
    }
}
