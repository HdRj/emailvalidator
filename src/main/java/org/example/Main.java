package org.example;

public class Main {
    public static void main(String[] args) {

        EmailValidator emailValidator = new EmailValidator();
        System.out.println(emailValidator.checkEmail("asdsd.asdd@gmail.com"));
    }
}