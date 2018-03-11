package main.t01;

import main.t01.CrazyLogger;

import java.util.Date;

/**
 * Created by Ekaterina Semenova on 11.03.2018.
 */
public class Run {
    public static void main(String[] args) {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.addMessage("Hello");
        crazyLogger.addMessage("Byu");
        crazyLogger.addMessage("Why?");

        crazyLogger.findInfo("Hell");
        System.out.println("================================");

        crazyLogger.findInfo(11, 3, 2018, 14, 38);
        System.out.println("================================");

        Date date = new Date(1333333333333L);
        crazyLogger.findInfo(date);
        System.out.println("================================");

        Date date1 = new Date();
        crazyLogger.findInfo(date1);
        System.out.println("================================");
        System.out.println("Time Of creation is " + crazyLogger.getTimeOfCreation());
        System.out.println("================================");
        System.out.println("Last method used: " + crazyLogger.lastMethodUsed());
        System.out.println("================================");
        System.out.println("==========The whole log=========");
        System.out.println(crazyLogger.toString());

        System.out.println();
    }
}
