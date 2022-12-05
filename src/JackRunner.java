import java.util.Scanner;

public class JackRunner {
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        int money = 0;
        while (money<=0 || money >1000) {
            System.out.print("Input the amount of money you want to play with(no higher than 1000): ");
            String test = scan.nextLine();
            money = Integer.parseInt(test);
        }

        Blackjack game = new Blackjack(money);
        System.out.println();
        game.intro();
        System.out.println();

        int risk = 0;
        int s = game.getStartAmount();
        while (risk<=0 || risk>s){
            System.out.print("Betting amount(no higher than the amount you have): ");
            risk = scan.nextInt();
        }
        System.out.println("Start amount: "+ s);
        game.play(risk);
        System.out.println("Total Winnings: $" + game.getWinnings());
        System.out.println("Total Amount: $" + game.getStartAmount());
    }
}
