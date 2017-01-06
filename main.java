import java.util.Scanner;
import java.io.*;
class main
{
    static String[] w=new String[3];
    static int moves[]=new int[3];
    static int pos[]=new int[3];
    static int flag[]=new int[3];
    static int dice, pr;
    static String input_command;
    static String[] commands={"help","show board","throw dice","quit","restart"};
    static char ref[]=new char[3];
    
    //moves=pos=new int[3];
    public static void main(String args[]) throws IOException
    {
        prestarting();
    }
    static void prestarting() throws IOException
    {
        //flag=moves=pos=new int[3];
        moves[1]=0;
        moves[2]=0;
        flag[1]=0;
        flag[2]=0;
        dice=0;
        ref[1]='*'; ref[2]='^';
        pos[1]=1;
        pos[2]=1;
        pr=1;
        w[1]="Player1"+ref[1]; w[2]="Player2"+ref[2];
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to MMR's Snake & Ladder Game");
        System.out.println("Player1, enter your name: ");
        w[1]=sc.nextLine();
        System.out.println("Player2, enter your name: ");
        w[2]=sc.nextLine();
        System.out.println("Welcome "+w[1]+" and "+w[2]+"!");
        System.out.println("Type 'help' to see the list of commands");
        System.out.println(w[1]+", you will be denoted by "+ref[1]+" and "+w[2]+" by "+ref[2]);
        w[1]+=ref[1]; w[2]+=ref[2];
        starting();
    }
    static void starting() throws IOException
    {
        
        System.out.println();
        System.out.print(w[pr]+" ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input_command=br.readLine();
        snkldr.processCommand(input_command);
    }
    static void winGame() throws IOException
    {
        if(pos[1]==100 || pos[2]==100)
        {
            System.out.println("CONGRATULATIONS!!! "+w[pr]+" beats the game in "+moves[pr]+" moves.");
            snkldr.printBoard();
            System.out.println("Quit (Y/N) ?");
            BufferedReader chr=new BufferedReader(new InputStreamReader(System.in));
            char c;
            c=(char)chr.read();
            c=Character.toUpperCase(c);
            if(c=='Y') 
            {
                //snkldr.printBoard();
                snkldr.gameExit();
            }
            BufferedReader chrr=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("You dont want to quit. So, I am reinitializing this game."+
            "\nPress any key to continue...");
            c=(char)chrr.read();
            cs.clrscr();
            prestarting();
        }
    }
}