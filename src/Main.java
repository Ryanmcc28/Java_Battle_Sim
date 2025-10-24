import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    int playerMode = 0;
    Scanner scanner = new Scanner(System.in);
    String type = "";
    String name = "";
    Player player;
    Player opponent;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    private void start(){
        System.out.print("Enter 1 to play against AI, enter 0 to play against friend: ");
        playerMode = scanner.nextInt();
        if (playerMode == 1) AIMode();
        else couchMode();
    }

    private void couchMode(){
        System.out.println();
        System.out.println("Player 1, select your class:");
        System.out.println("Warrior! - Has High health and damage but no quirks");
        System.out.println("Mage! - Low health, but high damage and awesome abilities");
        System.out.println("Archer! - High speed with evasive abilities but low damage");
        System.out.println();
        System.out.print("Chosen Class: ");
        type = scanner.next();
        System.out.print("Enter your champions name: ");
        name = scanner.next();

        switch (type.toLowerCase()){
            case "warrior":
                player = new Warrior(name);
                break;
            case "mage":
                player = new Mage(name);
                break;
            case "archer":
                player = new Archer(name);
                break;
        }

        System.out.println();
        System.out.println("Player 2, select your class:");
        System.out.println("Warrior! - Has High health and damage but no quirks");
        System.out.println("Mage! - Low health, but high damage and awesome abilities");
        System.out.println("Archer! - High speed with evasive abilities but low damage");
        System.out.println();
        System.out.print("Chosen Class: ");
        type = scanner.next();
        System.out.print("Enter your champions name: ");
        name = scanner.next();

        switch (type.toLowerCase()){
            case "warrior":
                opponent = new Warrior(name);
                break;
            case "mage":
                opponent = new Mage(name);
                break;
            case "archer":
                opponent = new Archer(name);
                break;
        }

        System.out.println();
        System.out.println("Starting Game......");
        pause(1000);
        System.out.println();
        System.out.println("Player one is " + player.getName() + " the " + player.getClass().getSimpleName() + "!!!");
        pause(1500);
        System.out.println("Player two is " + opponent.getName() + " the " + opponent.getClass().getSimpleName()+ "!!!");
        pause(1500);
        System.out.println("FIGHT!!!!");
        System.out.println();
        pause(1000);

        gameLoop(player,opponent);
    }


    int turnCount = 0;
    String ability1 = "";
    String ability2 = "";
    boolean turn = false;

    private void gameLoop(Player player1, Player player2){
        turn = true;

        while (true) {

            if(player1.getSpeed() > player2.getSpeed()){
                player1Turn(ability1, player1,player2);
                player2Turn(ability2,player1,player2);
            }else {
                player2Turn(ability2,player1,player2);
                player1Turn(ability1, player1,player2);
            }
        }
    }


    private void AIMode(){

    }
    private void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void player1Turn(String ability, Player player1, Player player2){
        pause(2000);
        System.out.println();
        player1.printStats();
        System.out.println();
        System.out.print(player1.getName() + " choose an ability - Attack / Defend: ");
        ability1 = scanner.next();
        System.out.println();
        switch (ability1.toLowerCase()) {
            case "attack":
                player1.useAttackAbility(player2);
                turn = false;
                break;
            case "defend":
                player1.useDefenceAbility();
                turn = false;
                break;
        }
        if(player2.getHealth() <= 0){
            player1.won();
        }
    }

    private void player2Turn(String ability, Player player1, Player player2){
        pause(2000);
        System.out.println();
        player2.printStats();
        System.out.println();
        System.out.print(player2.getName() + " choose an ability - Attack / Defend: ");
        ability2 = scanner.next();
        System.out.println();
        switch (ability2.toLowerCase()) {
            case "attack":
                player2.useAttackAbility(player1);
                turn = false;
                break;
            case "defend":
                player2.useDefenceAbility();
                turn = false;
                break;
            default:
                System.out.println();
                player2.printStats();
                System.out.println();
                player2Turn(ability, player1,player2);
        }
        if(player1.getHealth() <= 0){
            player2.won();
        }
    }
}