package com.example.playground.OOP_3;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Personal personal = new Personal();
        personal.addUser(new User("Петя", "Тарасов", 56))
                .addUser(new User("Серж", "Анокян", 39))
                .addUser(new User("Ахмед", "Бахтьеров", 20))
                .addUser(new User("Аскар", "Нурилджонов", 86));

        User bigBoss = new User(personal, "Николай", "Путяр", 22);

        Personal personal2 = new Personal();
        personal2.addUser(new User("Сехрож", "Анисиммов", 57));
        User smallBoss = new User(personal2, "Ликан", "Оборотневский", 71);
        personal.addUser(smallBoss);

        for (User item : personal) {
            System.out.println(item);

        }

        System.out.println("____________________");
        Collections.sort(personal.getUsers());

        personal.forEach(System.out::println);

        System.out.println("----------------------");

        Company company = new Company(bigBoss);
        for (User item : company) {
            System.out.println(item);
        }

        System.out.println("----------------------");
        System.out.println("Порядок сотрудников в мануальном списке:");
        UsersLinkedList usersLinkedList = new UsersLinkedList(bigBoss);
        for (User item : usersLinkedList) {
            System.out.println(item);
        }
    }
}