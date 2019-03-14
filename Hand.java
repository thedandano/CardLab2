import java.util.ArrayList;
import java.util.Arrays;  
/**
 * Represents an hand of cards.
 *
 * @author (Dan Sedano)
 * @version (11/06/18)
 */
public class Hand
{
    //Instance Variable
    private ArrayList<Card>cards;
    //Constants
    private static final int AMOUNT_CARDS = 5;
    private static final int SUITS = 4;
    //Used to count suits
    private int suitCount[];
    //Constants for category method
    public static final int NO_PAIR = 0;
    public static final int ONE_PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH = 8;
    public static final int ROYAL_FLUSH = 9;
    
    /**
     * Creates an ArrayList of empty hands.
     */
    public Hand(Card first, Card second, Card third, Card fourth, Card fifth)
    {
        // Creates an empty hand
        cards = new ArrayList<>();
        //adds cards to array list
        addCard(first);
        addCard(second);
        addCard(third);
        addCard(fourth);
        addCard(fifth);
        //checks for duplicate cards
        getDuplicates(cards);
    }
    
    /**
     * Adds a card to the end of a hand.
     */
    public void addCard(Card c)
    {
        cards.add(c);
    }
    
    /**
     * Returns a specific card
     */
    public Card getCard(int i)
    {
        return cards.get(i); 
    }
    
    /**
     * Fills the suitCount array with a count of suits (i.e., how many of each suit)
     */
    public void countSuits()
    {
        suitCount = new int [SUITS];
        //Counts the number of each suit and adds the count to the suitCount array.
        for(int x = 0; x < AMOUNT_CARDS; x++)
            suitCount[getCard(x).getSuit()] += 1;
    }
    
    /**
     * Calls to test each method of a hand and will return the first "true" category.
     * @return category
     */
    public int category()
    {      
        int category = NO_PAIR;
        
            if(royalFlush())
                category = ROYAL_FLUSH;
            else if(straightFlush())
                category = STRAIGHT_FLUSH;
            else if(fourOfAKind())
                category = FOUR_OF_A_KIND;
            else if(fullHouse())
                category = FULL_HOUSE;
            else if(flush())
                category = FLUSH;
            else if(straight())
                category = STRAIGHT;
            else if(threeOfAKind())
                category = THREE_OF_A_KIND;
            else if(twoPair())
                category = TWO_PAIR;
            else if(onePair())
                category = ONE_PAIR;
            else
                category = NO_PAIR;

        return category;
    }
    
    /**
     * Tests a hand for no pair.
     * @return noPair result.
     */
    public boolean noPair()
    {
        //Will return true if all other methods are false.
        if(onePair() == false && twoPair() == false && threeOfAKind() == false && straight() == false && flush() == false && fullHouse() == false && fourOfAKind() == false && royalFlush() == false) 
            return true;
        return false;
    }
    
    /**
     * Calls to test the onePair method from the CountRank class.
     * @return The test result.
     */
    public boolean onePair()
    {
        CountRank cr = new CountRank(this);
        
        return cr.onePair();
    }
    
    /**
     * Calls to test the twoPair() function from the CountRank Class.
     * @return The test result of twoPair().
     */
    public boolean twoPair()
    {
        CountRank cr = new CountRank(this);
        
        return cr.twoPair();
    }
    
    /**
     * Calls to test the threeOfAKind() function from the CountRank Class.
     * @return The test result of threeOfAKind().
     */
    public boolean threeOfAKind()
    {
        CountRank cr = new CountRank(this);
        
        return cr.threeOfAKind();
    }
    
    /**
     * Finds the min and max rank values from a hand, and calls Straight() from the CountRank class with the min and max values.
     * @return The result of straight().
     */
    public boolean straight()
    {
        CountRank cr = new CountRank(this);
        int min = 14;
        int max = 0;
        // extracts the maximum number and minimum numbers from the hand.
        for (int x = 0; x < cards.size(); x++)
        {
            if(getCard(x).getRank() > max)
                max = getCard(x).getRank();
            if (getCard(x).getRank() < min) 
                min = getCard(x).getRank();
        }  

        //calls the straight method from the CountRank class and inputs the minimum and maximum values.
        return cr.straight(min,max);
    }
    
    /**
     * Tests a Hand for a flush (i.e., 5 cards of the same suit).
     * @return True or false.
     */
    public boolean flush()
    {
        final int FLUSH = 5;
        //Brings in an array of the current hands suit
        countSuits();
        //If the suit count equals FLUSh then flush() is true.
        for(int x = 0; x < suitCount.length; x++)
            if(suitCount[x] == FLUSH) 
                return true;

        return false;    
    }
    
    /**
     * Calls to test the fullHouse() function from the CountRank Class.
     * @return The test result.
     */
    public boolean fullHouse()
    {
        CountRank cr = new CountRank(this);
        
        return cr.fullHouse();
    }
    
    /**
     * Calls to test a Hand for Four-of-a-kind from the CountRank Class.
     * @return True or false.
     */
    public boolean fourOfAKind()
    {
        CountRank cr = new CountRank(this);
        
        return cr.fourOfAKind();
    }
    /**
     * Calls to test a Hand for a straight flush from the CountRank Class.
     * @return True or false.
     */
    public boolean straightFlush()
    {
       //If flush and straight are true, then straightFlush must be true.
       if(flush() == true && straight() == true)
           return true;
           
       return false;
    }
    
    /**
     * Tests a hand for a royal flush.
     * @return True or false.
     */
    public boolean royalFlush()
    {
        CountRank cr = new CountRank(this);
        final int ROYAL_FLUSH = 5;
        final int CARD = 1;
        int count = 0;
        final int LAST_FIVE = cr.getRankCount().length; //length is 15
        
        //Brings in an array of the current hands suit
        countSuits();
        //Traverses the array backwards and looks at the last 5 elements. Checks for an Ace, King, Queen, Jack and 10.
        for(int x = LAST_FIVE - 1; x >= LAST_FIVE - ROYAL_FLUSH; x--)
            if(cr.getRankCount()[x] == CARD)
                count++;
        //If flush is true and the above is true, then royalFlush() must be true.    
        if(flush() == true && count == ROYAL_FLUSH)
            return true;
        
        return false;
    }
    //switch to private
    /**
     * Checks a hand for an Ace.
     * @return True or false.
     */
    private boolean hasAce()
    {
        final int ACE = 14;

        return findRank(ACE);
    }
    
    /**
     * Finds a specific rank in a hand.
     * @return True if the card is found or false if not found.
     */
    private boolean findRank(int rank)
    {
        CountRank cr = new CountRank(this);
        cr.getRankCount();
        
        if(cr.getRankCount()[rank]>= 1)
            return true;
        
        return false;
    }
    
    /**
     * Checks a hand for duplicate cards. Prints "Invalid..." if a duplicate is found.
     * @return True or false.
     */
    public void getDuplicates(ArrayList<Card> array)
    {
        int count = 0;
        //Travereses the array by comparing the first element to the rest of the array.
        //Then does the same with the second element and so on until all elements have been compared.
        for(int x = 0; x < array.size(); x++)
            for(int y = x+1; y < array.size(); y++)
            //If two ranks match and the suits match aswell getDuplicates will be true, thus adding to the counter.
                if(array.get(x).getRank() == array.get(y).getRank() && array.get(x).getSuit() == array.get(y).getSuit())
                    count++;     
        //Used count to avoid printing message multiple times.            
        if(count > 0)
        System.out.println("Duplicate cards found!!!");      
    }
    
    /**
     * Returns the cards to toString().
     * @return Returns the cards to toString().
     */
    public String toString()
    {
        return cards.toString();
    }
}
