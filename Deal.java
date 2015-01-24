/**
 * Deal.java
 * A Program that runs
 * the Let's Make A Deal show.
 * 
 * @author Huy Tu
 * @version 1/21/2014
 */
public class Deal
{
    //variable that tracks the curtain storing the prize
    private int prize;
    //variable that tracks the curtain that the contestant pick
    private int pick;
    //arrays storing all the names of the contestants
    private String[] contestants = {"Jane", "Betty", "Frank", "Fred"};
    
    /**
     * No parameter constructor.
     */
    public Deal()
    {

    }
    
    /**
     * Picking the prize curtain of Let's Make A Deal.
     * @return Command Line Argument.
     */
    public int prizeDeal()
    {
        prize = (int) (Math.random() * 3 + 1);
        return prize;
    }
    
    /**
     * Generating a different number from 
     * the two input numbers.  
     * 
     * @param prize Command Line Argument.
     * @param pick Command Line Argument.
     * @return Command Line Argument.
     */
    public int pickDif(int prize, int pick)
    {
        int rand;
        do
        {
            rand = (int) (Math.random() * 3 + 1);
        }  
        while (rand == prize || rand == pick);
        return rand;
    }
    
    /**
     * Facilitate the Let's Make a Deal.
     * 
     */
    public void play()
    {
        for (int i = 0; i <  contestants.length; i++)
        {
            prizeDeal();
            System.out.println("The winning curtain is " + prize);
            stragP(contestants[i]);
            System.out.println(contestants[i] + " selects curtain " + pick);
            int opened = pickDif(prize, pick);
            System.out.println("Monty opens curtain " + opened);
            String strag = stragS(contestants[i], pick, opened);
            System.out.println("" + contestants[i] + strag);
            if (prize == pick)
            {
                System.out.println(contestants[i] + " wins " + "\n");
            }
            else
            {
                System.out.println(contestants[i] + " loses " + "\n");
            }
        }
    }
    
    /**
     * Strategy of each contestant in originally picking. 
     * 
     * @param name Command Line Argument.
     * @return Command Line Argument.
     */
    public int stragP(String name)
    {
        if (name.equals("Jane") || name.equals("Betty"))
        {
            pick = 1;
        }
        else
        {
            pick = (int) (Math.random() * 3 + 1);
        }
        return pick;
    }
    
    /**
     * Strategy from each contestant 
     * for switching. 
     * 
     * @param name Command Line Argument.
     * @param current Command Line Argument.
     * @param opened Command Line Argument.
     * @return Command Line Argument.
     */
    public String stragS(String name, int current, int opened)
    {
        String s = "";
        if (name.equals("Jane") || name.equals("Frank"))
        {
            s += " does not switch";
        }
        else
        {
            pick = pickDif(current, opened);
            s += " switches to " + pick;
        }
        return s;
    }
    
    /**
     * @param args Command Line Argument
     */
    public static void main(String[] args)
    {
        Deal a = new Deal();
        a.play();
    }
}
