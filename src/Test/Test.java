package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    private static Random random = new Random();

    public static void main(String[] args) {
        Test test = new Test();
        test.simulateQuestion();
    }

    private void simulateQuestion() {
    	// Array of questions and options
        String[][] questions = {
            {"What is the main function of a Java compiler?", "It examines the bytecodes to ensure that they are valid and do not violate Java’s security restrictions.", "It places the program in memory to execute it", "It translates the Java source code into bytecodes that represent the tasks to execute.", "It executes the bytecodes"},
            {"Which one of the following symbols indicates a single line comment in Java application source code:", "##", "\\", "#!", "//"},
            {"Which one of the following symbols indicates a multi-line comment in Java application source code?", "||         ||", "//         \\", "##", "/*           */"},
            {"Which of the following components does a Java application need to have at least one of?", "Instance variable", "Local variable", "Class", "Non-static Method"},
            {"Which of the following typically groups related classes so that they could be imported into programs and reused?", "IDE", "Method", "Package", "Function"}
        };

        int score = 0;

        // Iterate through the questions array
        for (int i = 0; i < questions.length; i++) {
            String question = questions[i][0];
            String[] options = {questions[i][1], questions[i][2], questions[i][3], questions[i][4]};
            int correctOptionIndex = getCorrectOptionIndex(i);

            String userAnswer = inputAnswer(question, options);

         // Check if the answer is correct
            if (checkAnswer(userAnswer, options[correctOptionIndex])) {
                score++;
                String message = generateMessage();
                JOptionPane.showMessageDialog(null, message);
            } else {
                String correctAnswer = options[correctOptionIndex];
                String message = respondWrongMessage(correctAnswer);
                JOptionPane.showMessageDialog(null, message);
            }
        }

        // Calculate the score and percentage
        double percentage = (double) score / questions.length * 100;
        JOptionPane.showMessageDialog(null, "Your score: " + score + "/" + questions.length + "\nPercentage: " + percentage + "%");
    }

    // Get user input for the answer
    private String inputAnswer(String question, String[] options) {
        String userAnswer = (String) JOptionPane.showInputDialog(null, question, "Question",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return userAnswer;
    }
    // Check if the answer is correct
    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer);
    }
    // Generate a random message for correct answers
    private String generateMessage() {
        switch (random.nextInt(4)) {
            case 0:
                return "Excellent!";
            case 1:
                return "Good!";
            case 2:
                return "Keep up the good work!";
            case 3:
                return "Nice work!";
            default:
                return "Keep it up!";
        }
    }
    // Generate a random message for wrong answers
    private String respondWrongMessage(String correctAnswer) {
        switch (random.nextInt(4)) {
            case 0:
                return "No. Please try again\nCorrect answer: " + correctAnswer;
            case 1:
                return "Wrong. Try once more\nCorrect answer: " + correctAnswer;
            case 2:
                return "Don't give up\nCorrect answer: " + correctAnswer;
            case 3:
                return "No. Keep trying..\nCorrect answer: " + correctAnswer;
            default:
                return "Keep it up!\nCorrect answer: " + correctAnswer;
        }
    }

    private int getCorrectOptionIndex(int questionIndex) {
        switch (questionIndex) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 2;
            default:
                return 0;
        }
    }
}
