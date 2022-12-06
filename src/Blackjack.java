import java.util.Scanner;

public class Blackjack {
    private int startAmount;
    private boolean bust = false;
    private int  winnings = 0;


    public Blackjack(){
        startAmount = (int)(Math.random()*1000+1);
    }
    //constructor with a parameter for start amount
    public Blackjack(int a){
        startAmount = a;
    }
    public void intro(){
        System.out.println("Welcome to Blackjack!\nThis is a game of both reasoning and luck.\nYou will first be asked how much money you want to bet.\nThen, you will be dealt your hand and will be asked to either hit or stand.\nIn this game, Aces are only worth 1 point.\nThe person closest to 21 wins!");
    }

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
    public int getStartAmount(){
        return startAmount;
    }

    public int getWinnings(){
        return winnings;
    }

    public void subtractFromStartAmount(int s){
        startAmount-=s;
    }

    public void changeWinnings(int s){
        winnings +=s;
    }
    public String getCard(String s){
        return s.substring(0, s.indexOf("."));
    }

    public String getSuit(String s){
        return s.substring(s.indexOf(".")+1);
    }

    public int valueConverter(String s){
        if (s.equals("Ace")){
            return 1;
        } else if (s.equals("Queen") || s.equals("King") || s.equals("Jack")){
            return 10;
        } else {
            return Integer.parseInt(s);
        }
    }

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

    public String toString(){
        return "Winnings: $" + winnings + "\nTotal Money: $" + startAmount;
    }
}
