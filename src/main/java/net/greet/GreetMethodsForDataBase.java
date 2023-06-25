package net.greet;

import java.sql.*;
import java.util.Locale;

public class GreetMethodsForDataBase {

    final String DATABASE_URL = "jdbc:h2:./target/jdbc_greet_db";

    public Connection getConnection() throws Exception{
        Connection conn = DriverManager.getConnection(DATABASE_URL,"sa","");
        return conn;
    }

    public void greetPerson(String name, String lang) {
        try{
            String lName = name.toLowerCase(Locale.ROOT);
            Connection conn = getConnection();

            final String CHECK_USER = "select count(*) as user_count from users where name =?";
            PreparedStatement checkUser = conn.prepareStatement(CHECK_USER);
            checkUser.setString(1,lName);
            ResultSet nrs = checkUser.executeQuery();
            int userStatus = nrs.getInt("user_count");

            final String GET_USER_COUNT = "select greet_count from users where name = ?";
            PreparedStatement getUserCount = conn.prepareStatement(GET_USER_COUNT);
            final String UPDATE_DATABASE = "update users set greet_count = ? where name = ?";
            PreparedStatement updateDatabase = conn.prepareStatement(UPDATE_DATABASE);
            final String INSERT_USER = "insert into users (name, greet_count) values(?, ?)";
            PreparedStatement addUser = conn.prepareStatement(INSERT_USER);

            if(userStatus>0) {
                getUserCount.setString(1,lName);
                ResultSet rs = getUserCount.executeQuery();
                int incr = rs.getInt("greet_count") +1;

                updateDatabase.setInt(1,incr);
                updateDatabase.setString(2,lName);
                updateDatabase.execute();
            }else{
                addUser.setString(1, lName);
                addUser.setDouble(2, 1);
                addUser.execute();
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

        }catch (Exception e){e.printStackTrace();}

    }

    public void greeted(){
        try{
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery ("select count(*) as user_count from users");

            System.out.println(rs.getInt("user_count"));

        }catch (Exception e){e.printStackTrace();}
    }

    public int greeted(String name){
        int count = 0;
        try {
            String lName = name.toLowerCase(Locale.ROOT);

            Connection conn = getConnection();
        final String FIND_USER ="select greet_count from users where name = ?";

        PreparedStatement getCount = conn.prepareStatement(FIND_USER);
        getCount.setString(1,lName);
            ResultSet rs = getCount.executeQuery();
            count= rs.getInt("greet_count");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int counter(){
        int count =0;
      try{
          Connection conn = getConnection();
          Statement statement = conn.createStatement();
          ResultSet rs = statement.executeQuery ("select count(*) as user_count from users");

          count= rs.getInt("user_count");
      }catch (Exception e){e.printStackTrace();}
      return count;
    }

//    public void clear(){
//        this.list.clear();
//    }
//
//    public void clear(String name){
//        String lName = name.toLowerCase(Locale.ROOT);
//        this.list.remove(lName);
//    }
//
//    public void help(){
//        System.out.println("To 'greet', type greet followed by the name and the language the user is to be greeted in");
//        System.out.println("To display a list of all users that has been greeted and how many time each user has been greeted, type 'greeted");
//        System.out.println("Typing greeted followed by a username returns how many times that username have been greeted");
//        System.out.println("Typing counter returns a count of how many unique users has been greeted");
//        System.out.println("Typing clear deletes of all users greeted and the reset the greet counter to 0");
//        System.out.println("clear followed by a username delete the greet counter for the specified user and decrement the greet counter by 1");
//        System.out.println("Typing 'exit' exits the application");
//    }

}
