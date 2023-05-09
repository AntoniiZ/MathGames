package mathgames.example.com.mathgames;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GuessActivity extends AppCompatActivity {

    private int number = 0;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        number = (int) (Math.random()*1001);
        builder = new AlertDialog.Builder(this);
    }

    public void onClickGuess(View view)
    {
        Button btn = (Button) findViewById(R.id.buttonGuessNum);
        EditText et = (EditText) findViewById(R.id.guessedNumber);

        try {
            int guessedNum = Integer.parseInt(et.getText().toString());
            if(guessedNum < 0 || guessedNum > 1000)
            {
                builder.setTitle("Error!")
                        .setMessage("Enter a number in the valid range!").show();
                return;
            }
            if (guessedNum == number)
            {
                builder.setTitle("Correct!")
                        .setMessage("You have gussed the number!")
                        .setCancelable(true)
                        .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(intent);
                            }}
                        ).show();
                return;
            }
            if (guessedNum > number) {
                builder.setTitle("Wrong!")
                        .setMessage("Number is smaller!")
                        .setCancelable(true).show();
                return;
            }
            builder.setTitle("Wrong!")
                    .setMessage("Number is larger!")
                    .setCancelable(true).show();

        } catch (NumberFormatException ex)
        {

            builder.setTitle("Error!")
                    .setMessage("Enter a number in the valid range!").show();
        }

    }
}
