package test.t01;

import main.t01.CrazyLogger;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ekaterina Semenova on 11.03.2018.
 */
public class CrazyLoggerTest {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private CrazyLogger crazyLogger;
    private Date date;
    private String message;
    String dateString;


    @Before
    public void setUp() {
        crazyLogger = new CrazyLogger();
        date = Date.from(Instant.now());
        dateString = simpleDateFormat.format(date);
        message = "HelloWorld!";
        crazyLogger.addMessage(message);
    }

    @Test
    public void addMessageShouldAddStringMassageWithDate() {
        StringBuilder expected = new StringBuilder(simpleDateFormat.format(date))
                .append(" - CrazyLogger has been created\n")
                .append(simpleDateFormat.format(date))
                .append(" - ")
                .append(message)
                .append("\n");
        assertEquals(expected.toString(), crazyLogger.toString());
    }

    @Test
    public void lastMethodUsedShouldReturnStringWithTheNameOfLastMethodUsed() {
        StringBuilder expected = new StringBuilder(dateString)
                .append(" - CrazyLogger has been created\n")
                .append(dateString)
                .append(" - ")
                .append(message)
                .append("\n").append(dateString)
                .append(" - User was searching for information about the last method used with lastMethodUsed()\n");
        assertEquals("addMessage(String message)", crazyLogger.lastMethodUsed());
        assertEquals(expected.toString(), crazyLogger.toString());

    }

    @Test
    public void findInfoStringShouldPrintInfoAndReturnNumberOfInformationFound() {
        StringBuilder expected = new StringBuilder(dateString)
                .append(" - CrazyLogger has been created\n")
                .append(dateString)
                .append(" - ")
                .append(message)
                .append("\n").append(dateString)
                .append(String.format(" - User was searching for information about \"%s\" with %s %s",
                        "hell", "findInfo(String info)", "successfully and found 1 message\n"));
        //ТУТ ПОЛУЧИЛАСЬ ОШИБКА, ПОТОМУ ЧТО hell и Hell. Специально не стала ничего исправлять, пусть будет ошибка. Повод улучшить кое-что в коде
        //Вообще, я рада ошибке)
        assertEquals(1, crazyLogger.findInfo("Hell"));
        assertEquals(expected.toString(), crazyLogger.toString());
    }


}


