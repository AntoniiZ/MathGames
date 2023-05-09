package mathgames.example.com.mathgames;


import android.annotation.SuppressLint;

public class QuizAnswers {
    private String[] questions = new String[10];
    private int[] answers = new int[10];
    private int[][] options = new int[10][4];

    public QuizAnswers()
    {
        for(int i = 1; i <= 10; i++) {
            int operation = (int) (Math.random() * 4);

            String opString;
            int num1 = (int) (Math.random() * 99) + 1;
            int num2 = (int) (Math.random() * 99) + 1;
            while((operation == 3 && (num1 < num2 || (num1 % num2 != 0)))
                    || (operation == 1 && num1 < num2))
            {
                operation = (int) (Math.random() * 4);
            }
            switch(operation)
            {
                case 0:
                    opString = "+";
                    answers[i-1] = num1 + num2;
                    break;
                case 1:
                    opString = "-";
                    answers[i-1] = num1 - num2;
                    break;
                case 2:
                    opString = "*";
                    answers[i-1] = num1 * num2;
                    break;
                case 3:
                    opString = "/";
                    answers[i-1] = num1 / num2;
                    break;
                default:
                    opString = "+";
                    answers[i-1] = num1 + num2;
                    break;
            }
            questions[i-1] = String.format(
                    "%d. What is the result of the expression : %d %s %d = ?",
                    i, num1, opString, num2);

            for(int j = 0; j < 4; j++)
            {
                do {
                    options[i - 1][j] = answers[i - 1] + (int) (Math.random() * 20) - 40;
                } while (options[i-1][j] == answers[i-1]);

            }
            options[i-1][(int) (Math.random() * 4)] = answers[i-1];
        }
    }

    public String[] getQuestions()
    {
        return questions;
    }
    public int[][] getOptions()
    {
        return options;
    }

    public int[] getAnswers()
    {
        return answers;
    }
}
