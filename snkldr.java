import java.io.*;
class snkldr
{
    static void printBoard() throws IOException
    {
        for(int i=100; i>0; i--)
        {
            if(main.pos[1]==i) System.out.print("*");
            System.out.print(i);
            if(main.pos[2]==i) System.out.print("^");
            System.out.print("\t");
            if(i%10==1) System.out.println("\n");
        }
        if(main.pos[1]==100 || main.pos[2]==100) gameExit();
        main.starting();
    }
    static void processCommand(String str) throws IOException
    {
        if(str.equals("moves1")) System.out.println("Total moves for "+main.w[1]+" = "+main.moves[1]);
        else if(str.equals("moves2")) System.out.println("Total moves for "+main.w[2]+" = "+main.moves[2]);
        else if(str.startsWith("re")) {cs.clrscr(); main.prestarting();}
        else if(str.startsWith("show")||str.equals("sb"))
        printBoard();
        else if(str.equals("help"))
        showCommands();
        else if(str.equals("quit"))
        gameExit();
        else if(str.equals("clrscr")) 
        {
            cs.clrscr();
            main.starting();
        }
        else if(str.equals("throw dice") || str.equals("td"))
        {
            if(main.moves[main.pr]==0) System.out.println(main.w[main.pr]+" must get 1 or 6 to start the game");
            main.moves[main.pr]++;
            throw_dice1();
            main.winGame();
            if(main.pr==1)
            main.pr=2;
            else
            main.pr=1;
            main.starting();
        }
        else 
        {
            System.out.println("Wrong Command. Enter 'help' for the list of commands.");
            main.starting();
        }
        main.starting();
    }
    static void showCommands() throws IOException
    {
        System.out.print("The Commands are : ");
        /*for(int i=0; i<main.commands.length; i++)
        {
            System.out.print("\""+main.commands[i]+"\""+" ");
        }*/
        for(String s:main.commands)
        System.out.print("\""+s+"\""+" ");
        System.out.println();
        main.starting();
    }
    static void gameExit()
    {
        System.out.println("Thankyou for playing. Hope you have enjoyed yourself. GoodBye!");
        System.exit(0);
    }
    static int randomNo()
    {
        double i=7;
        do
        {
            i=(int)(Math.random()*10);
        }
        while(i>6 || i==0);
        return (int)i;
    }
    static void updatepos1()
    {
        String la="Ladder ", sn="Snake ", enc="encountered by "+main.w[main.pr]+". Moving to ";
        main.pos[main.pr]+=main.dice;
        System.out.println("Moving "+main.dice+" spaces...\nThe new position is "+main.pos[main.pr]+".");
        if(main.pos[main.pr]==6)
        {
            main.pos[main.pr]=36;
            System.out.println(la+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==12)
        {
            main.pos[main.pr]=73;
            System.out.println(la+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==18)
        {
            main.pos[main.pr]=76;
            System.out.println(la+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==25)
        {
            main.pos[main.pr]=17;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==29)
        {
            main.pos[main.pr]=10;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==42)
        {
            main.pos[main.pr]=19;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==55)
        {
            main.pos[main.pr]=32;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==71)
        {
            main.pos[main.pr]=92;
            System.out.println(la+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==78)
        {
            main.pos[main.pr]=97;
            System.out.println(la+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==79)
        {
            main.pos[main.pr]=60;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==88)
        {
            main.pos[main.pr]=76;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
        if(main.pos[main.pr]==99)
        {
            main.pos[main.pr]=9;
            System.out.println(sn+enc+main.pos[main.pr]);
        }
    }
    
    static boolean checkUpdatepos()
    {
        if(main.dice+main.pos[main.pr]>100)
        return false;
        else
        return true;
    }
    static void throw_dice1() throws IOException
    {
        main.dice=randomNo();
        System.out.println(main.w[main.pr]+" is throwing dice now.\nIt reads "+main.dice+".");
        if(main.flag[main.pr]==0)
        {
            if(main.dice==1 || main.dice==6)
            {
                System.out.println("As you've got "+main.dice+", throw the dice again to move forward."); main.flag[main.pr]=1;
                main.starting();
            }
            else
            System.out.println("You remain on 1.");
        }
        else
        {
            if(checkUpdatepos())
            {
                if(main.dice==6 || main.dice==1)
                {
                    System.out.println(main.w[main.pr]+" gets one more chance to throw dice."); main.moves[main.pr]--;
                    updatepos1(); 
                    main.starting();
                }
                else
                updatepos1();
            }
            else
            System.out.println("The position cannot be updated. (You need a value less than or equal to "+(100-main.pos[main.pr])+")");
        }
    }
}
    