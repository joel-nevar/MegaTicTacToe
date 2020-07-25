package org.academiadecodigo.felinux.mvc.view.textIO;

public class DrawBoardText {

    //Grid separators (When using supergrid)
    public static String cellVerticalSeparator =  DrawColors.BLUE + " ||" + DrawColors.RESET;
    public static String cellHorizontalSeparator =  DrawColors.CYAN_BACKGROUND + "     " + DrawColors.RESET + DrawColors.BLUE + "   ========================================================================" + DrawColors.RESET;

    public static String bigHeader = DrawColors.YELLOW_BACKGROUND  + "     " + DrawColors.RESET + DrawColors.CYAN_BACKGROUND + "            _                        ___                       ___         " + DrawColors.RESET + "\n" +
                                     DrawColors.GREEN_BACKGROUND   + "     " + DrawColors.RESET + DrawColors.CYAN_BACKGROUND + "           /_\\                      | _ )                     / __|        " + DrawColors.RESET + "\n" +
                                     DrawColors.BLUE_BACKGROUND    + "     " + DrawColors.RESET + DrawColors.CYAN_BACKGROUND + "          / _ \\                     | _ \\                     | (__        " + DrawColors.RESET + "\n" +
                                     DrawColors.RED_BACKGROUND     + "     " + DrawColors.RESET + DrawColors.CYAN_BACKGROUND + "         /_/ \\_\\                    |___/                     \\___|        " + DrawColors.RESET;

    public static String smallHeader = DrawColors.YELLOW + "    A      B      C      " + DrawColors.RESET;

    public static String leftHeader1 =    DrawColors.CYAN_BACKGROUND + "  _  " + DrawColors.RESET + " ";
    public static String leftHeader11 =   DrawColors.CYAN_BACKGROUND + " / | " + DrawColors.RESET + " ";
    public static String leftHeader111 =  DrawColors.CYAN_BACKGROUND + " | | " + DrawColors.RESET + " ";
    public static String leftHeader1111 = DrawColors.CYAN_BACKGROUND + " |_| " + DrawColors.RESET + " ";

    public static String leftHeader2 =    DrawColors.CYAN_BACKGROUND + " ___ " + DrawColors.RESET + " ";
    public static String leftHeader22 =   DrawColors.CYAN_BACKGROUND + "|_  )" + DrawColors.RESET + " ";
    public static String leftHeader222 =  DrawColors.CYAN_BACKGROUND + " / / " + DrawColors.RESET + " ";
    public static String leftHeader2222 = DrawColors.CYAN_BACKGROUND + "/___|" + DrawColors.RESET + " ";

    public static String leftHeader3 =    DrawColors.CYAN_BACKGROUND + " ___ " + DrawColors.RESET + " ";
    public static String leftHeader33 =   DrawColors.CYAN_BACKGROUND + "|__ /" + DrawColors.RESET + " ";
    public static String leftHeader333 =  DrawColors.CYAN_BACKGROUND +  " |_ \\" + DrawColors.RESET + " ";
    public static String leftHeader3333 = DrawColors.CYAN_BACKGROUND + "|___/" + DrawColors.RESET + " ";
}
