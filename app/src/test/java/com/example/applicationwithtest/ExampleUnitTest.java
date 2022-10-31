package com.example.applicationwithtest;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    //OK
    @Test
    public void checkEmailTestOk() {
        String email = "vanya@gmail.com";
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("vanya2@gmail.com", "123456789"));
        assertTrue(MainActivity.checkEmail(email, users));
    }

    //NOT OK
    @Test
    public void checkEmailTestNotOk() {
        String email = "vanya@gmail.com";
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("vanya@gmail.com", "123456789"));
        assertTrue(MainActivity.checkEmail(email, users));
    }


    //OK
    @Test
    public void checkPasswordTestOk() {
        String password = "123asdASD$$$$$$$";
        assertTrue(MainActivity.checkPassword(password));
    }

    //NOT OK
    @Test
    public void checkPasswordTestNotOk() {
        String password = "123";
        assertTrue(MainActivity.checkPassword(password));
    }


    //OK
    @Test
    public void checkAddUserOk() {
        String email = "vanya@gmail.com";
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("vanya2@gmail.com", "123asdASD$$$$$$"));
        assertTrue(MainActivity.addUser(email,"123asdASD$$$$$$$", users));
    }

    //NOT OK
    @Test
    public void checkAddUserNotOk() {
        String email = "vanya@gmail.com";
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("vanya2@gmail.com", "123asdASD$$$$$$"));
        assertTrue(MainActivity.addUser(email,"123", users));
    }
}