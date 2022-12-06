import java.util.Scanner;

/**
 * The Blackjack class represents a simulated round of Blackjack. An instance of Blackjack represents a game
 * with a starting amount of money and a total amount of winnings.
 */
public class Blackjack {
    private int startAmount;
    private boolean bust = false;
    private int  winnings = 0;

    /**
     * This creates an instance of the Blackjack class.
     * This default constructor sets the starting money to a random integer from 1 to 1000.
     */
    public Blackjack(){
        startAmount = (int)(Math.random()*1000+1);
    }

    /**
     * This constructor creates an instance of the Blackjack class.
     *
     * @param a represents the starting money for the game
     */
    public Blackjack(int a){
        startAmount = a;
    }

    /**
     * Prints out a sequence of sentences that welcomes the user and provides instructions to the game.
     */
    public void intro(){
        System.out.println("Welcome to Blackjack!\nThis is a game of both reasoning and luck.\nYou will first be asked how much money you want to bet.\nThen, you will be dealt your hand and will be asked to either hit or stand.\nIn this game, Aces are only worth 1 point.\nThe person closest to 21 wins!");
    }

    /**
     * This method returns a string that contains a random card selected from a standard deck of cards.
     *
     * @return returns a String formatted in card type + . + card suit
     */
    public String pickCard(){
        int randomize = (int)(Math.random()*13)+1;
        int randomize2 = (int)(Math.random()*4);
        if (randomize == 1){
            if (randomize2 == 0){
                return "Ace.Spades";
            } else if (randomize2 == 1){
                return "Ace.Clubs";
            } else if (randomize2 == 2){
                return "Ace.Hearts";
            } else {
                return "Ace.Diamonds";
            }
        } else if (randomize>1 && randomize<11){
            if (randomize2 == 0){
                return randomize + ".Spades";
            } else if (randomize2 == 1){
                return randomize + ".Clubs";
            } else if (randomize2 == 2){
                return randomize + ".Hearts";
            } else {
                return randomize + ".Diamonds";
            }
        } else if (randomize==11){
            if (randomize2 == 0){
                return "Jack.Spades";
            } else if (randomize2 == 1){
                return "Jack.Clubs";
            } else if (randomize2 == 2){
                return "Jack.Hearts";
            } else {
                return "Jack.Diamonds";
            }
        } else if (randomize ==12){
            if (randomize2 == 0){
                return "Queen.Spades";
            } else if (randomize2 == 1){
                return "Queen.Clubs";
            } else if (randomize2 == 2){
                return "Queen.Hearts";
            } else {
                return "Queen.Diamonds";
            }
        } else {
            if (randomize2 == 0){
                return "King.Spades";
            } else if (randomize2 == 1){
                return "King.Clubs";
            } else if (randomize2 == 2){
                return "King.Hearts";
            } else {
                return "King.Diamonds";
            }
        }
    }

    /**
     * Getter method for the current amount of money the user has.
     * @return returns the variable 'startAmount'.
     */
    public int getStartAmount(){
        return startAmount;
    }

    /**
     * Getter method for the amount the user has won/lost.
     * @return returns the change of money the user has experienced.
     */
    public int getWinnings(){
        return winnings;
    }

    /**
     * Setter method to change the winnings.
     * @param s represents amount and direction of change.
     */
    public void changeWinnings(int s){
        winnings +=s;
    }

    /**
     * Getter method that returns the type of card.
     * @param s represents the string that the type is being derived from. Uses the pickCard string.
     * @return returns a substring that represents the card type.
     */
    public String getCard(String s){
        return s.substring(0, s.indexOf("."));
    }

    /**
     * Getter method that returns the card's suit.
     * @param s represents the string that the suit is being derived from. Uses the pickCard method.
     * @return returns a substring that represents the card's suit.
     */
    public String getSuit(String s){
        return s.substring(s.indexOf(".")+1);
    }

    /**
     * Method that returns a corresponding value based on the card's type.
     * @param s represents where the value is coming from. Uses the getCard method.
     * @return returns an integer value that corresponds to the card's value.
     */
    public int valueConverter(String s){
        if (s.equals("Ace")){
            return 1;
        } else if (s.equals("Queen") || s.equals("King") || s.equals("Jack")){
            return 10;
        } else {
            return Integer.parseInt(s);
        }
    }

    /**
     * Method that simulates the game from start to finish.
     * Uses print methods to guide the user through the process.
     * @param risk represents the amount of money that the user puts at stake to win or lose.
     */
    public void play(int risk){
        Scanner classScan = new Scanner(System.in);
        String d1 = pickCard();
        int d1Val = valueConverter(getCard(d1));
        String d2 = pickCard();
        int d2Val = valueConverter(getCard(d2));
        String p1 = pickCard();
        int p1Val = valueConverter(getCard(p1));
        String p2 = pickCard();
        int p2Val = valueConverter(getCard(p2));
        int pCombined = p1Val + p2Val;
        int dCombined = d1Val + d2Val;

        System.out.println("Your 1st card is: " + getCard(p1) + " of " + getSuit(p1));
        System.out.println("Your 2nd card is: " + getCard(p2) + " of " + getSuit(p2));
        System.out.println("That is a combined value of " + pCombined);

        System.out.println("The dealer's shown card is: " + getCard(d2) + " of " + getSuit(d2));
        System.out.println("That is a value of: " + d2Val);

        while (!bust){
            String userChoice = "";
            while (!(userChoice.equals("h") || userChoice.equals("s"))){
                System.out.println("Type 'h' to hit or 's' to stand.");
                userChoice = classScan.nextLine();
            }
            if (userChoice.equals("h")){
                String nextCard = pickCard();
                int val = valueConverter(getCard(nextCard));
                System.out.println("Your new card is: " + getCard(nextCard) + " of " + getSuit(nextCard));
                pCombined += val;
                System.out.println("That brings your combined value to: " + pCombined);
                if (pCombined>21){
                    System.out.println("That is a bust! You lose.");
                    startAmount-=risk;
                    winnings-=risk;
                    bust = true;
                }
            } else {
                System.out.println("Ok, your final value is: " + pCombined);
                break;
            }
        }

        if (!bust){
            if (dCombined<17){
                String newCompCard = pickCard();
                int cVal = valueConverter(getCard(newCompCard));
                dCombined += cVal;
                System.out.println("The computer drew a " + getCard(newCompCard) + " of " + getSuit(newCompCard));
            } else {
                System.out.println("The computer will stand as well.");
            }
        }
        System.out.println();
        System.out.println("The computer's combined value is: " + dCombined);
        System.out.println("Your combined value is: " + pCombined);

        if (!bust && dCombined>21){
            System.out.println("You win!");
            winnings += risk;
            startAmount+=risk;
        } else if (!bust && dCombined<pCombined){
            System.out.println("You win!");
            winnings+= risk;
            startAmount += risk;
        } else if (!bust && dCombined>pCombined){
            System.out.println("You lose!");
            winnings -= risk;
            startAmount -= risk;
        } else if (!bust && dCombined == pCombined){
            System.out.println("It is a draw");
        }
    }

    /**
     * toString method for the Blackjack class. This method returns a formatted String representing the user's winnings and their current amount of money.
     * @return returns a string formatted in Winnings: winnings and Amount: amount
     */
    public String toString(){
        return "Winnings: $" + winnings + "\nTotal Money: $" + startAmount;
    }
}
