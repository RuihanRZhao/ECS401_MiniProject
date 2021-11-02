public class Result{
    public boolean End;//the Sentinel value for break infinite loop of Tic Tac Toe Game
    public int Player;//0: when draw - 1 & 2; 1: P1; 2: P2
    public String state;//"Win": someone won; "Draw": they are draw; " ": nothing

    public static Result Set(boolean $End, int $Player, String $state){
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
}
