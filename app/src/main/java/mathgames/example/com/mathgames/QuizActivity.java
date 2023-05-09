package mathgames.example.com.mathgames;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private int currentScore = 0;
    private int currentQuestion = 0;
    private Button selectedBtn;

    private AlertDialog.Builder builder;
    private QuizAnswers qa = new QuizAnswers();
    private String[] questions = qa.getQuestions();
    private int options[][] = qa.getOptions();
    private int answers[] = qa.getAnswers();

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        builder = new AlertDialog.Builder(this);
        updateQuestion();
    }

    public void updateQuestion()
    {
        currentQuestion++;
        if(currentQuestion > questions.length)
        {
            builder.setTitle("Quiz completed")
                    .setMessage(String.format("Score : %d / %d",
                            currentScore, questions.length))
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();

            return;
        }
        TextView questionsCount = (TextView) findViewById(R.id.quiz);
        questionsCount.setText(String.format(
                "Question: (%d / %d)", currentQuestion, questions.length)
        );
        TextView questionDesc = (TextView) findViewById(R.id.questionDesc);
        questionDesc.setText(questions[currentQuestion-1]);

        Button optBtn1 = (Button) findViewById(R.id.questionFirstOpt);
        Button optBtn2 = (Button) findViewById(R.id.questionSecondOpt);
        Button optBtn3 = (Button) findViewById(R.id.questionThirdOpt);
        Button optBtn4 = (Button) findViewById(R.id.questionFourthOpt);

        optBtn1.setText(Integer.toString(options[currentQuestion-1][0]));
        optBtn2.setText(Integer.toString(options[currentQuestion-1][1]));
        optBtn3.setText(Integer.toString(options[currentQuestion-1][2]));
        optBtn4.setText(Integer.toString(options[currentQuestion-1][3]));
    }

    public void onClickFirstOpt(View view)
    {

        Button optBtn1 = (Button) findViewById(R.id.questionFirstOpt);
        optBtn1.setEnabled(true);

        if(options[currentQuestion-1][0] == answers[currentQuestion-1])
        {
            currentScore++;
        }
        updateQuestion();

    }

    public void onClickSecondOpt(View view)
    {
        Button optBtn2 = (Button) findViewById(R.id.questionSecondOpt);
        optBtn2.setEnabled(true);

        if(options[currentQuestion-1][1] == answers[currentQuestion-1])
        {
            currentScore++;
        }

        updateQuestion();

    }

    public void onClickThirdOpt(View view)
    {
        Button optBtn3 = (Button) findViewById(R.id.questionThirdOpt);
        optBtn3.setEnabled(true);
        if(options[currentQuestion-1][2] == answers[currentQuestion-1])
        {
            currentScore++;
        }
        updateQuestion();

    }

    public void onClickFourthOpt(View view)
    {
        Button optBtn4 = (Button) findViewById(R.id.questionFourthOpt);
        optBtn4.setEnabled(true);
        if(options[currentQuestion-1][3] == answers[currentQuestion-1])
        {
            currentScore++;
        }
        updateQuestion();

    }
}
