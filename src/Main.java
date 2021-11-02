public class Main {
    public static void main(String[] args){
        while(true){//infinite loop of the game
            char option=Input.Char(
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
                    Game.ControlGame();
                    break;
                }
                case 'R': { //go to rank board
                    Rank.main();
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
            char goback=Input.Char("Please enter any character to go back to menu: ");
        }
    }
}
