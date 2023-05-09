package mathgames.example.com.mathgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startQuizBtn;
    private Button guessNumBtn;
    private Button magicTriangleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startQuizBtn = (Button) findViewById(R.id.buttonStartQuiz);

        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityQuiz();
            }
        });

        magicTriangleBtn = (Button) findViewById(R.id.buttonMagicTriangle);

        magicTriangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityTriangle();
            }
        });

        guessNumBtn = (Button) findViewById(R.id.buttonGuessNum);

        guessNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityGuess();
            }
        });
    }
    public void openActivityQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
    public void openActivityGuess(){
        Intent intent = new Intent(this, GuessActivity.class);
        startActivity(intent);
    }
    public void openActivityTriangle(){
        Intent intent = new Intent(this, TriangleActivity.class);
        startActivity(intent);
    }
}
