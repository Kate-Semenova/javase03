package test.t02;

import main.t02.TheQuestionListBundle;
import org.junit.Test;

import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ekaterina Semenova on 17.03.2018.
 */
public class TheQuestionListBundleTest {
    private Scanner in;

    {
        in = new Scanner("ru");
        TheQuestionListBundle.setLanguage(in);
    }

    @Test
    public void setLanguageShouldSetNewDefaultLanguage() {
        Locale english = new Locale("en", "US");
        Locale russian = new Locale("ru", "RU");

        in = new Scanner("en");
        TheQuestionListBundle.setLanguage(in);
        assertEquals(english, Locale.getDefault());

        in = new Scanner("ru");
        TheQuestionListBundle.setLanguage(in);
        assertEquals(russian, Locale.getDefault());
    }

    @Test
    public void printListOfQuestionsShouldReturnStringOfAllQuestionsFromProperties() {
        String questionList = "1 - Почему?\n2 - Столица России?\n3 - Столица Турции?\n4 - Столица Австралии?\n5 - Столица Республики Науру?\n6 - Как выучить JAVA?\n";
        assertEquals(questionList, TheQuestionListBundle.printListOfQuestions());
    }

    @Test
    public void getAnswerShouldReturnno_answerFromPropertyIfTheIsNoAnswerOnTheQuestion(){
        String noAnswer = "Такого вопроса нет в списке. Проверьте введенное вами число.";
        assertEquals(noAnswer, TheQuestionListBundle.getAnswer(11111111));
    }
}
