package net.greet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Greet greet = new Greet();
        boolean exit = true;

        while(exit){
            System.out.println("Enter command or type 'help' for the menu");
            String selection = sc.nextLine();
            String [] input = selection.split(" ");
            switch (input[0]){
                case "help":
                    greet.help();
                    break;
                case "greeted":
                    if (input.length > 1) {
                        System.out.println(greet.greeted(input[1]));
                    }else{
                    greet.greeted();
                    }
                    break;
                case "clear":
                    if(input.length > 1){
                        greet.clear(input[1]);
                    }else{
                    greet.clear();
                    }
                    break;
                case "exit":
                    exit = false;
                    break;
                case "greet":
                    String lang=" ";
                    if(input.length>1){
                    if(input.length>2){
                        lang = input[2];
                    }
                    greet.greetPerson(input[1],lang);
                    }else{
                        System.out.println("Invalid command");
                    }
                    break;
                case "counter":
                    greet.counter();
                    break;
                default :
                    System.out.println("Invalid command");
                    break;
            }

        }


    }
}
