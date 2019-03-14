import java.util.Arrays;
/**
 * Write a description of class CountRank here.
 *
 * @author (Dan Sedano)
 * @version (11/6/18)
 */
public class CountRank 
{
    //Instance varable
    private int rankCount[];
    //Constants
    private static final int RANKS = 15; //14 ranks plus index 0
    private static final int CARDS = 5;  // amount of cards in hand
    private static final int PAIR = 2;
    private static final int TOAK = 3;
    private static final int STRAIGHT = 5;
    private static final int FOAK = 4;
    
    /**
     * Constructor - Fills an array of with the ranks of cards from a Hand in corresponding order (i.e., Queen is put in the 12th index).
     */
    public CountRank(Hand h)
    {
        rankCount = new int [RANKS];
        for(int x = 0; x < CARDS; x++)
        {
            rankCount[h.getCard(x).getRank()] += 1;
        }
       
    }
    
    /**
     * Returns the rankCount.
     * @return The rankCount.
     */
    public int[] getRankCount()
    {
        return rankCount;
    }
    
    /**
     * Checks if a hand has one pair. 
     * @return True or false.
     */
    public Boolean onePair()
    {
        //final int PAIR = 2;
        final int onePair = 1;
        int count = 0;
        
        for (int x = 0; x < rankCount.length; x++)
            if(rankCount[x] == PAIR)
                count++;
                
        if (count == onePair)
               return true;
        return false;      
    }
    /**
     * Checks if a hand has two pairs.
     * @return True or false.
     */
    public Boolean twoPair()
    {
        //final int PAIR = 2;
        int count = 0;
        
        for (int x = 0; x < rankCount.length; x++)
            if(rankCount[x] == PAIR)
                count++;
                
        if (count == PAIR)
            return true;
            
        return false;            
    }
    
    /**
     * Checks if a hand has three cards of the same rank.
     * @return True or false.
     */
    public Boolean threeOfAKind()
    {
        //final int TOAK = 3;
        
        for (int x = 0; x < rankCount.length; x++)
            if(rankCount[x] == TOAK)
                return true;
        return false;
    }
    
    /**
     * Checks if a hand has five cards with consecutive ranks (i.e., 8,9,10,J,Q).
     * @return True or false.
     */
    public Boolean straight(int min,int max)
    {
        final int COUNT = 1;
        //final int STRAIGHT = 5;
        final int CONSEC = 4;
        int card = 0;
        
        if (max - min == CONSEC)
        {
            //System.out.println("yes: " + (max-min));
            for(int x = 0; x < rankCount.length; x++)
                if(rankCount[x] == COUNT)
                    card++;
        }
      
        if(card == STRAIGHT)
            return true;
            
        return false;
    }
    
    /**
     * Checks a hand for a full house (three of a kind and a pair).
     * @return True or false.
     */
    public Boolean fullHouse()
    {
        if(threeOfAKind() == true && onePair() == true)
            return true;  
            
        return false;
    }
    
    /**
     * Checks a hand for four cards of the same rank (i.e., four Kings).
     * @return True or false.
     */
    public Boolean fourOfAKind()
    {
        //final int FOAK = 4;
     
        for (int x = 0; x < rankCount.length; x++)
            if(rankCount[x] == FOAK)
                return true;
                
        return false; 
    }
    
    /**
     * Formats the rankCount array (e.g., [0][1][2]...).
     */
    public String toString()
    {
        final int BEFORE = 2;
        final int AFTER = 3;
        final int SPACES = 3;
        //Converts the array of ints to an array of Strings.
        String rankString = Arrays.toString(rankCount);
        //Converts to StringBuilder
        StringBuilder sb = new StringBuilder(rankString);
        //Applies format
        for (int x = BEFORE; x <sb.length(); x+=SPACES)
            sb.setCharAt(x,']');
        for (int x = AFTER; x < sb.length(); x+=SPACES)
            sb.setCharAt(x,'[');
        // returns to String      
        return sb.toString();
    }
}
