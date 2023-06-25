package net.greet;

import java.util.HashMap;
import java.util.Locale;

public class Greet {

    HashMap<String, Integer> list = new HashMap<>();

    public void greetPerson(String name, String lang) {
        String lName = name.toLowerCase(Locale.ROOT);
        if(this.list.containsKey(lName)) {
            int incr = this.list.get(lName) +1;
            this.list.replace(lName,incr);
        }else{
            this.list.put(lName, 1);
        }

        switch (lang){
            case "xhosa" :
                System.out.println("Molo "+ lName);
                break;
            case "english" :
                System.out.println("Hello "+ lName);
                break;
            case "zulu" :
                System.out.println("Sawubona "+ lName);
                break;
            default:
                System.out.println("Ndaa "+ lName);
                break;
        }

    }

    public void greeted(){
        System.out.println(this.list);
    }

    public int greeted(String name){
        String lName = name.toLowerCase(Locale.ROOT);
        //System.out.println(this.list.get(lName));
        return this.list.get(lName);
    }

    public int counter(){
        System.out.println(this.list.size());
        return this.list.size();
    }

    public void clear(){
        this.list.clear();
    }

    public void clear(String name){
        String lName = name.toLowerCase(Locale.ROOT);
        this.list.remove(lName);
    }

    public void help(){
        System.out.println("To 'greet', type greet followed by the name and the language the user is to be greeted in");
        System.out.println("To display a list of all users that has been greeted and how many time each user has been greeted, type 'greeted");
        System.out.println("Typing greeted followed by a username returns how many times that username have been greeted");
        System.out.println("Typing counter returns a count of how many unique users has been greeted");
        System.out.println("Typing clear deletes of all users greeted and the reset the greet counter to 0");
        System.out.println("clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1");
        System.out.println("Typing 'exit' exits the application");
    }

}
