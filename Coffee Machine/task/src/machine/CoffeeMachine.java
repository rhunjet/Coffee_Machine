package machine;
import java.util.Scanner;

public class CoffeeMachine {

    final public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Coffee coffee = new Coffee(400, 540, 120, 9, 550);
        coffee.Choice();

    }
}

class Coffee{
    private int cups;
    private final int water = 200;
    private final int milk = 50;
    private final int beans = 15;

    private int maxCups = 0;
    protected int waterRemain;
    protected int milkRemain;
    protected int beansRemain;
    protected int money;

    public Coffee(int cups){
        this.cups = cups;
    }
    public Coffee(int water, int milk, int beans, int cups){
        this.waterRemain = water;
        this.milkRemain = milk;
        this.beansRemain = beans;
        this.cups = cups;
    }

    public Coffee(int water, int milk, int beans, int cups, int money){
        this(water, milk, beans, cups);
        this.money = money;
    }

    public void PrintCoffeeMachine(){
        System.out.println(String.format("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money

                """, this.waterRemain, this.milkRemain, this.beansRemain, this.cups, this.money));
    }

    public void Choice(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            var choice = sc.next();
            switch (choice) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    var coffee = sc.next();
                    switch (coffee) {
                        case "1":
                            Espresso();
                            break;
                        case "2":
                            Latte();
                            break;
                        case "3":
                            Cappuccino();
                            break;
                    }
                    break;

                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water you want to add:");
                    this.waterRemain += sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    this.milkRemain += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    this.beansRemain += sc.nextInt();
                    System.out.println("Write how many disposable cups you want to add: ");
                    this.cups += sc.nextInt();
                    break;

                case "take":
                    System.out.println(String.format("I gave you $%d", this.money));
                    this.money = 0;
                    break;

                case "exit":
                    flag = false;
                    break;

                case "remaining":
                    System.out.println();
                    PrintCoffeeMachine();
            }
        }
    }

    public void Espresso(){

        if (this.waterRemain < 250) {
            System.out.println("Sorry, not enough water!");
        }

        else if (this.beansRemain < 16) {
            System.out.println("Sorry, not enough beans!");
        }

        else if (this.cups <= 0) {
            System.out.println("Sorry, not enough cups!");
        }

        else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.waterRemain -= 250;
            this.beansRemain -= 16;
            this.money += 4;
            this.cups--;
        }
    }

    public void Latte() {

        if (this.waterRemain < 350) {
            System.out.println("Sorry, not enough water!");
        }

        else if (this.beansRemain < 20) {
            System.out.println("Sorry, not enough beans!");
        }

        else if (this.cups <= 0) {
            System.out.println("Sorry, not enough cups!");
        }

        else if (this.milkRemain < 75) {
            System.out.println("Sorry, not enough milk!");
        }

        else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.waterRemain -= 350;
            this.beansRemain -= 20;
            this.money += 7;
            this.milkRemain -= 75;
            this.cups--;
        }
    }

    public void Cappuccino() {

        if (this.waterRemain < 200) {
            System.out.println("Sorry, not enough water!");
        }

        else if (this.beansRemain < 12) {
            System.out.println("Sorry, not enough beans!");
        }

        else if (this.cups <= 0) {
            System.out.println("Sorry, not enough cups!");
        }

        else if (this.milkRemain < 100) {
            System.out.println("Sorry, not enough milk!");
        }

        else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.waterRemain -= 200;
            this.beansRemain -= 12;
            this.milkRemain -= 100;
            this.money += 6;
            this.cups--;
        }
    }
}
