package main.t02;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Ekaterina Semenova on 14.03.2018.
 */
public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please type \"en\" for English.");
        System.out.println("Пожалуйста, введите \"ru\" для Русского языка");
        System.out.print("_");

        QuestionListBundle.setLanguage(in);

        System.out.println(QuestionListBundle.printListOfQuestions());

        QuestionListBundle.getAnswer(in);
    }
}

