import java.util.*;
import java.io.*;


public class Main {
    /************ Rank ************/
    public static void ControlRank(){

    }
    /************ GAME ************/
    public static void Analyse(char[][] borad, Result result, Player[] P, int BoradSize) {
        for (int i0 = 0; i0 < BoradSize; i0++) {
            if (borad[i0][0] == borad[i0][1] && borad[i0][0] == borad[i0][2] && borad[i0][1] == borad[i0][2]) {//analyse each line
                if (borad[i0][0] == Get_Symbol(P[0])) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;// Once fitted! function break!
                } else if (borad[i0][0] == Get_Symbol(P[1])) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            } else if (borad[0][i0] == borad[1][i0] && borad[0][i0] == borad[2][i0] && borad[1][i0] == borad[2][i0]) {//analyse each row
                if (borad[0][i0] == Get_Symbol(P[1])) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[0][i0] == Get_Symbol(P[1])) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            }
            if (borad[0][0] == borad[1][1] && borad[0][0] == borad[2][2]) {//analyse one diagonal
                if (borad[1][1] == Get_Symbol(P[0])) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[1][1] == Get_Symbol(P[1])) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            } else if (borad[0][2] == borad[1][1] && borad[0][2] == borad[2][0]) {//another diagonal
                if (borad[1][1] == Get_Symbol(P[0])) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[1][1] == Get_Symbol(P[1])) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            }
        }
        int Full = 1;
        for (int i0 = 0; i0 < BoradSize; i0++) {
            for (int i1 = 0; i1 < BoradSize; i1++) {
                if (borad[i0][i1] == ' ') Full *= 0;
            }
        }
        if (Full == 1) {
            result.End = true;
            result.Player = 0;
            result.state = "Draw";
        }
    }

    public static int PrintBorad(char[][] borad,int BoradSize) {
        for (int i0 = 0; i0 < BoradSize; i0++) {//print borad line by line
            for (int i1 = 0; i1 < BoradSize; i1++) {
                System.out.print("[" + borad[i0][i1] + "]");
            }
            System.out.println();
        }
        return 0;
    }

    public static int PlayChess(char[][] borad, Player P, int BoradSize) {
        System.out.print(//alert Player 1 or 2 to put next move
                Get_Name(P) + " Move: "
        );
        int x = InputInt("X value in 1-3: ");//input x
        int y = InputInt("Y value in 1-3: ");//input y
        if (borad[y - 1][x - 1] == ' ') {//check if the place is empty
            borad[y - 1][x - 1] = Get_Symbol(P);//check which chessman should be used
            return PrintBorad(borad, BoradSize);
        } else {
            System.out.print("The place is occupied. Please try again.");//if not empty, let the user change other p
            return PlayChess(borad, P, BoradSize);
        }
    }

    public static void ControlGame() {
        //initialize all global varibles
        char[][] borad = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int round = 0;
        final int BoradSize=3;
        Result result = SetResult(false,0," ");
        //Start Game, choose chessman as a symbal.
        System.out.println("Player 1: ");
        Player[] player={
                SetPlayer(InputString("Please input your username:"), InputChar("Please pick a character as your chessmen (Any letters and symbols can be your chessmen!): ")),
                SetPlayer(InputString("Player 2:\nPlease input your username:"), InputChar("Please pick a character as your chessmen (Any letters and symbols can be your chessmen!): "))
        };
        //inifinity loop for the main game
        while (!Get_End(result)) {
            round += 1;//count and output round number
            System.out.print("Round " + round + "\n");
            PrintBorad(borad,BoradSize);//show the borad situation
            PlayChess(borad, player[0],BoradSize);//Player1 play
            Analyse(borad, result, player, BoradSize);// Check if win or draw, if yes, game end
            if (Get_End(result)) break;
            PlayChess(borad, player[1], BoradSize);//Player2 play
            Analyse(borad, result, player, BoradSize);
            if (Get_End(result)) break;
        }
        if(result.Player==0) {//analyse the result type and output
            System.out.print(Get_Name(player[0]) + " and " + Get_Name(player[1]) + " Draw");
        }
        else System.out.print(Get_Name(player[result.Player-1])+" Win!");
    }
    /********** Result **************/
    public static Result SetResult(boolean $End, int $Player, String $state){
        Result NewSet=new Result();
        NewSet.End=$End;
        NewSet.Player=$Player;
        NewSet.state=$state;
        return NewSet;
    }

    //accessor methods
    public static boolean Get_End(Result Game){
        return Game.End;
    }
    public static int Get_Player(Result Game){
        return Game.Player;
    }
    public static String Get_state(Result Game){
        return Game.state;
    }
    /****** Player ******/
    public static Player SetPlayer(String N, char S) {
        Player New=new Player();
        New.Name = N;
        New.Symbol = S;
        return New;
    }
    public static String Get_Name(Player N){
        return N.Name;
    }
    public static char Get_Symbol(Player N){
        return N.Symbol;
    }
    /********** Input ***********/
    public static int InputInt(String InputPrompt) {//intege varible input function
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.nextInt();
    }
    public static String InputString(String InputPrompt){
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.next();
    }
    public static char InputChar(String InputPrompt) {//float varible input function
        Scanner INPUT = new Scanner(System.in);//catch data from keyboard
        System.out.print(InputPrompt);
        return INPUT.next().charAt(0);
    }
    /********** Main Control***********/
    public static void main(String[] args){
        while(true){//infinite loop of the game
            char option=InputChar(
                    "            Tic - Tac - Toe\n" +
                            "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"+
                            "          @ Go to PVP ---- P\n"+
                            "          @ Rank board --- R\n"+
                            "          @ Exit game ---- Q\n"+
                            "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
            );
            //measure the input
            if (option=='Q')break;
            switch(option){
                case 'P': { //go to game
                    ControlGame();
                    break;
                }
                case 'R': { //go to rank board
                    ControlRank();
                    break;
                }
                case 'Q': { //quit the game
                    System.out.println(
                            " Wish I brought a pleasant time to you!\n"+
                                    "             Good Bye!\n"+
                                    "|||||||||||||||||||||||||||||||||||||||\n"
                    );
                    System.exit(0);
                }
                default: System.out.println("Error input!\nIf you want to exit, please enter 'Q'");
            }
            char goback=InputChar("Please enter any character to go back to menu: ");
        }
    }
}
/***** Result *****/
class Result {
    public boolean End;//the Sentinel value for break infinite loop of Tic Tac Toe Game
    public int Player;//0: when draw - 1 & 2; 1: P1; 2: P2
    public String state;//"Win": someone won; "Draw": they are draw; " ": nothing
}
class Player {
    String Name;
    char Symbol;
}
class Rank{
    int Rank;
    String Name;
    int Win;
    int Lose;
    int Draw;
}