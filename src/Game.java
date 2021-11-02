public class Game {
    public static void Analyse(char[][] borad, Result result, Player[] P, int BoradSize) {
        for (int i0 = 0; i0 < BoradSize; i0++) {
            if (borad[i0][0] == borad[i0][1] && borad[i0][0] == borad[i0][2] && borad[i0][1] == borad[i0][2]) {//analyse each line
                if (borad[i0][0] == P[0].Symbol()) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;// Once fitted! function break!
                } else if (borad[i0][0] == P[1].Symbol()) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            } else if (borad[0][i0] == borad[1][i0] && borad[0][i0] == borad[2][i0] && borad[1][i0] == borad[2][i0]) {//analyse each row
                if (borad[0][i0] == P[0].Symbol()) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[0][i0] == P[1].Symbol()) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            }
            if (borad[0][0] == borad[1][1] && borad[0][0] == borad[2][2]) {//analyse one diagonal
                if (borad[1][1] == P[0].Symbol()) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[1][1] == P[1].Symbol()) {
                    result.End = true;
                    result.Player = 2;
                    result.state = "Win";
                    return;
                }
            } else if (borad[0][2] == borad[1][1] && borad[0][2] == borad[2][0]) {//another diagonal
                if (borad[1][1] == P[0].Symbol()) {
                    result.End = true;
                    result.Player = 1;
                    result.state = "Win";
                    return;
                } else if (borad[1][1] == P[1].Symbol()) {
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
                P.Name() + " Move: "
        );
        int x = Input.Int("X value in 1-3: ");//input x
        int y = Input.Int("Y value in 1-3: ");//input y
        if (borad[y - 1][x - 1] == ' ') {//check if the place is empty
            borad[y - 1][x - 1] = P.Symbol();//check which chessman should be used
            return PrintBorad(borad, BoradSize);
        } else {
            System.out.print("The place is occupied. Please try again.");//if not empty, let the user change other p
            return PlayChess(borad, P, BoradSize);
        }
    }

    public static void main() {
        //initialize all global varibles
        char[][] borad = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int round = 0;
        final int BoradSize=3;
        Result result = Result.Set(false,0," ");
        //Start Game, choose chessman as a symbal.
        System.out.println("Player 1: ");
        Player[] player={
            new Player(Input.String("Please input your username:"), Input.Char("Please pick a character as your chessmen (Any letters and symbols can be your chessmen!): ")),
            new Player(Input.String("Player 2:\nPlease input your username:"), Input.Char("Please pick a character as your chessmen (Any letters and symbols can be your chessmen!): "))
        };
        //inifinity loop for the main game
        while (!Result.Get_End(result)) {
            round += 1;//count and output round number
            System.out.print("Round " + round + "\n");
            PrintBorad(borad,BoradSize);//show the borad situation
            PlayChess(borad, player[0],BoradSize);//Player1 play
            Analyse(borad, result, player, BoradSize);// Check if win or draw, if yes, game end
            if (Result.Get_End(result)) break;
            PlayChess(borad, player[1], BoradSize);//Player2 play
            Analyse(borad, result, player, BoradSize);
            if (Result.Get_End(result)) break;
        }
        if(result.Player==0) {//analyse the result type and output
            System.out.print(player[0].Name() + " and " + player[1].Name() + " Draw");
        }
        else System.out.print(player[result.Player-1].Name()+" Win!");
    }
}
