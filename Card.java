
/**
 * Represents a single card.
 *
 * @author (Dan Sedano)
 * @version (11/10/18)
 */
public class Card
{
    //Instance variables rank and suit
    private final int rank;
    private final int suit;
    //Constants
    private static final int LOW_RANK = 2;
    private static final int HIGH_RANK = 14;
    private static final int CLUBS = 0;
    private static final int SPADES = 3;

    /**
     * Initializes instance variables and checks for invalid card and suit entries.
     * @param Rank
     * @param Suit
     */
    public Card(int rankIn, int suitIn)
    {
        //Initialises instance variables
        rank = rankIn;
        suit = suitIn;
        //Checks for error individually and prints message accordingly
        if(rank > HIGH_RANK || rank < LOW_RANK )
        {
          System.out.println(rankIn + " is an invalid rank...exiting...");
          //System.err.println(rankIn + " is an invalid rank...exiting...");
          //System.exit(1);
        }
        if(suit > SPADES || suit < CLUBS)
        {
          System.out.println(suitIn + " is an invalid suit...exiting...");
          //System.err.println(suitIn + " is an invalid rank...exiting...");
          //System.exit(2);
        }
    }
    
    /**
     * Returns Rank
     * @returns Rank 
     */
    public int getRank(){
        return rank;
    }
    
    /**
     * Returns Suit
     * @return Suit
     */
    public int getSuit()
    {
        return suit;
    }
    
    /**
     * Applies appropriate String to Rank.
     * @returns string variant of Rank.
     */
    private String getStringRank()
    {
        String rOut = Integer.toString(rank);
        
        //Switch statement to apply proper String rank above 10
        switch(rank)
        {
            case 11:
            rOut = "J";
            break;
            case 12:
            rOut = "Q";
            break;
            case 13:
            rOut = "K";
            break;
            case 14:
            rOut = "A";
            break;            
        }
        
        return rOut;
    }
    
    /**
     * Applies appropriate unicode Char to Suit.
     * @return unicode Char.
     */
    private String getStringSuit()
    {
        String sOut = "";
        
        switch(suit)
        {
            case 0:
            sOut += '\u2663';
            break;
            case 1:
            sOut += '\u2662';
            break;
            case 2:
            sOut += '\u2661';
            break;
            case 3:
            sOut += '\u2660';
            break;
        }
        
        return sOut;
    }
    
    /**
     * Formats the output of a card.
     * @return String format. 
     */
     public String toString()
    {
         return String.format("%2s", getStringRank()) + String.format("%1s", getStringSuit());
    }
 }
