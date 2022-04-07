package machine;

import java.util.Scanner;

public class Maker {
    private static final Scanner sc = new Scanner(System.in);
    private int cups;
    private int water;
    private int milk;
    private int beans;
    private int money;

    public Maker() {
        this.cups = 9;
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.money = 550;
    }

    public boolean amount(String item) {

        String waterMsg = "Sorry, not enough water!";
        String beansMsg = "Sorry, not enough coffee beans!";
        String milkMsg = "Sorry, not enough milk!";

        if (this.cups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else if (this.water < 200) {
            System.out.println(waterMsg);
            return false;
        } else if (this.milk < 75) {
            System.out.println(milkMsg);
            return false;
        } else if (this.beans < 12) {
            System.out.println(beansMsg);
            return false;
        } else {
            switch (item) {
                case "1":
                    if (this.water < 250) {
                        System.out.println(waterMsg);
                        return false;
                    } else if (this.beans < 16) {
                        System.out.println(beansMsg);
                        return false;
                    }
                case "2":
                    if (this.water < 350) {
                        System.out.println(waterMsg);
                        return false;
                    } else if (this.beans < 20) {
                        System.out.println(beansMsg);
                        return false;
                    }
                case "3":
                    if (this.milk < 100) {
                        System.out.println(milkMsg);
                        return false;
                    }
                default:
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
            }
        }
    }

    public void stock() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n",
                this.water, this.milk, this.beans, this.cups, this.money);
    }

    public void start() {
        boolean on = true;

        while (on) {

            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = sc.nextLine();

            switch (action) {
                case "buy":
                    this.buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    stock();
                    break;
                case "exit":
                    on = false;
            }
        }

    }

    private void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String buy = sc.nextLine();

        if (this.amount(buy)) {
            switch (buy) {
                case "1":
                    this.water -= 250;
                    this.beans -= 16;
                    this.cups--;
                    this.money += 4;
                    break;
                case "2":
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.cups--;
                    this.money += 7;
                    break;
                case "3":
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.cups--;
                    this.money += 6;
                    break;
            }
        }
    }

    private void fill() {
        System.out.println("\nWrite how many ml of water you want to add:");
        this.water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.cups += sc.nextInt();
    }

    private void take() {
        System.out.println("\nI gave you $" + this.money);
        this.money = 0;
    }
}
