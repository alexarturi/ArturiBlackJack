public class Blackjack {
    private int startAmount; //amount of money to begin with to bet
    private boolean broke = false; //boolean that will determine when the game is over
    private int score = 0;


    public Blackjack(){
        startAmount = 500;
    }
    //constructor with a parameter for start amount
    public Blackjack(int a){
        startAmount = a;
    }
    public void intro(){
        System.out.println("Welcome to Blackjack!");
        System.out.println("This is a game of both reasoning and luck.");
        System.out.println("You will first be asked how much money you want to bet.");
        System.out.println("Then, you will be dealt your hand and will be asked to either hit or stand.");
        System.out.println("The person closest to 21 wins!");
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
            String s = Integer.toString(randomize);
            if (randomize2 == 0){
                return s + ".Spades";
            } else if (randomize2 == 1){
                return s+ ".Clubs";
            } else if (randomize2 == 2){
                return s+ ".Hearts";
            } else {
                return s + ".Diamonds";
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

    public String getCard(String s){
        return s.substring(0, s.indexOf("."));
    }

    public String getSuit(String s){
        return s.substring(s.indexOf(".")+1);
    }

    public void play(int risk){
        intro();


    }
}
