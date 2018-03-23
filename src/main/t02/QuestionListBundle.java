package main.t02;

import java.util.*;

/**
 * Created by Ekaterina Semenova on 14.03.2018.
 */
public final class QuestionListBundle {
    private static final String question = "question";
    private static final String answer = "answer";
    private static final Locale english = new Locale("en", "US");
    private static final Locale russian = new Locale("ru", "RU");
    private static final int exitNumber = 666;
    private static ResourceBundle myBundle = ResourceBundle.getBundle("main/t02/QuestionList");

    public static String getString(String key) {
        return myBundle.getString(key);
    }

    public static void setLanguage(Scanner in) {
        String language = in.next();
        switch (language.toLowerCase()) {
            case "en": {
                Locale.setDefault(english);
                myBundle = ResourceBundle.getBundle("main/t02/QuestionList");
                break;
            }
            case "ru": {
                Locale.setDefault(russian);
                myBundle = ResourceBundle.getBundle("main/t02/QuestionList");
                break;
            }
            default: {
                System.out.println("Please, type it correctly. Пожалуйста, введите всего две буквы правильно");
                setLanguage(in);
            }
        }
    }

    public static String printListOfQuestions() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; myBundle.containsKey(question + i); i++) {
            stringBuilder.append(String.format("%d - %s\n", i, myBundle.getString(question + i)));
        }
        return stringBuilder.toString();
    }

    public static String getAnswer(int numberOfQuestion) {
        String questionNumber = question + numberOfQuestion;
        String answerNumber = answer + numberOfQuestion;

        if (myBundle.containsKey(questionNumber)) {
            if (myBundle.containsKey(answerNumber)) {
                return String.format(myBundle.getString("the_question_is_the_answer_is"),
                        myBundle.getString(questionNumber),
                        myBundle.getString(answerNumber));
            } else {
                return myBundle.getString("no_answer");
            }
        } else {
            return myBundle.getString("no_question");
        }
    }

    public static void getAnswer(Scanner scanner) {
        System.out.print(myBundle.getString("please_type_the_number_of_question"));

        for (int numberOfQuestion = scanner.nextInt(); numberOfQuestion != exitNumber;
             numberOfQuestion = scanner.nextInt()) {
            System.out.println();

            System.out.println(getAnswer(numberOfQuestion));
            System.out.println();

            System.out.println(String.format(myBundle.getString("exit"), exitNumber));
            System.out.println(myBundle.getString("please_type_the_number_of_question"));
        }

    }

    //ДАЛЕЕ методы для QuestionFrame. Ну он один получился

    public static void setLanguage(String language) {
        switch (language.toLowerCase()) {
            case "english": {
                Locale.setDefault(english);
                myBundle = ResourceBundle.getBundle("main/t02/QuestionList");
                break;
            }
            case "russian": {
                Locale.setDefault(russian);
                myBundle = ResourceBundle.getBundle("main/t02/QuestionList");
            }
        }
    }
}
