public class Main {
    public static void main(String[] args){
        while(true){
            char option=Input.Char(
                    "            Tic - Tac - Toe\n" +
                               "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"+
                               "          @ Go to PVP ---- P\n"+
                               "          @ Rank board --- R\n"+
                               "          @ Exit game ---- Q\n"+
                               "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
            );
            if (option=='Q')break;
            switch(option){
                case 'P': { Game.main(); break;}
                case 'R': { Rank.main(); break;}
                default: System.out.println("Error input!\nIf you want to exit, please enter 'Q'");
            }
            char goback=Input.Char("Please enter any character to go back to menu: ");
        }
        System.out.println(
                               " Wish I brought a pleasant time to you!\n"+
                               "             Good Bye!\n"+
                               "|||||||||||||||||||||||||||||||||||||||\n"
        );
        System.exit(0);
    }
}
