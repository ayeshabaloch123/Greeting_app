package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GreetmethodsFDBTest {

    @Test
    public void addToTable(){
         GreetMethodsForDataBase greet = new GreetMethodsForDataBase();

         greet.greetPerson("shane","zulu");

         assertEquals(1,greet.counter());
    }

}
