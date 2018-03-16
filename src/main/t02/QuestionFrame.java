package main.t02;

import layout.TableLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Created by Ekaterina Semenova on 16.03.2018.
 */
public class QuestionFrame extends JFrame {
    private JButton button;

    JComboBox<String> comboBox = new JComboBox<>(
            new String[]{"russian", "english"});
    private JTextArea language;
    private JTextField numberField;
    private JTextArea answer;
    private JTextArea listQuestions;


    public QuestionFrame() {
        setTitle(TheQuestionListBundle.getString("title"));
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initInterface();
        initInteraction();

        setVisible(true);
    }

    private void initInterface() {
        TableLayout layout = new TableLayout(new double[][]{
                {TableLayout.PREFERRED, TableLayout.FILL}, //столбцы
                {TableLayout.PREFERRED, 400, TableLayout.PREFERRED, TableLayout.PREFERRED} //строки
        });

        setLayout(layout);
        language = new JTextArea();
        language.setText("Language:");
        add(language, "0 0 0 0'");
        add(comboBox, "1 0");
        listQuestions = new JTextArea();
        listQuestions.setText(TheQuestionListBundle.printListOfQuestions());
        add(new JScrollPane(listQuestions), "0 1 1 1");


        numberField = new JTextField();
        button = new JButton(TheQuestionListBundle.getString("get_the_answer"));

        add(numberField, "0 2");
        add(button, "1 2");
        answer = new JTextArea(TheQuestionListBundle.getString("please_type_the_number_of_question"));
        add(answer, "0 3 1 3");


    }

    private void initInteraction() {
        ActionListener actionListenerForNumberField = e -> {
            String text = numberField.getText();
            try {
                int numberOfQuestion = Integer.parseInt(text);
                System.out.println(TheQuestionListBundle.getAnswer(numberOfQuestion));
                answer.setText(TheQuestionListBundle.getAnswer(numberOfQuestion));
            } catch (NumberFormatException exception){
                System.out.println(exception.getMessage());
                answer.setText(TheQuestionListBundle.getString("not_a_number"));
            }

        };

        button.addActionListener(actionListenerForNumberField);
        numberField.addActionListener(actionListenerForNumberField);

        comboBox.addActionListener(event -> {
            System.out.println(comboBox.getSelectedItem());
            TheQuestionListBundle.setLanguage(comboBox.getSelectedItem().toString());
            System.out.println(Locale.getDefault().toString());
            System.out.println(TheQuestionListBundle.printListOfQuestions());
            listQuestions.setText(TheQuestionListBundle.printListOfQuestions());
            button.setText(TheQuestionListBundle.getString("get_the_answer"));
            answer.setText(TheQuestionListBundle.getString("please_type_the_number_of_question"));
            setTitle(TheQuestionListBundle.getString("title"));
        });

    }

    public static void main(String[] args) {
        new QuestionFrame();
    }

}
