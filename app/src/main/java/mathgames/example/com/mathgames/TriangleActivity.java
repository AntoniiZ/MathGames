package mathgames.example.com.mathgames;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        builder = new AlertDialog.Builder(this);
    }

    public void onClickCheckTriangle(View view)
    {

        Button btn = (Button) findViewById(R.id.buttonMagicTriangle);
        EditText et1 = (EditText) findViewById(R.id.node1);
        EditText et2 = (EditText) findViewById(R.id.node2);
        EditText et3 = (EditText) findViewById(R.id.node3);
        EditText et4 = (EditText) findViewById(R.id.node4);
        EditText et5 = (EditText) findViewById(R.id.node5);
        EditText et6 = (EditText) findViewById(R.id.node6);
        try {
            int n1 = Integer.parseInt(et1.getText().toString());
            int n2 = Integer.parseInt(et2.getText().toString());
            int n3 = Integer.parseInt(et3.getText().toString());
            int n4 = Integer.parseInt(et4.getText().toString());
            int n5 = Integer.parseInt(et5.getText().toString());
            int n6 = Integer.parseInt(et6.getText().toString());

            int[] values = new int[]{n1, n2, n3, n4, n5, n6};

            Arrays.sort(values);
            for (int i = 0; i < values.length - 1; i++)
            {
                if (values[i] == values[i + 1])
                {
                    builder.setTitle("Error!")
                            .setMessage("The nodes need to contain " +
                                    "different numbers!").show();
                    return;
                }
            }
            if((n1 + n2 + n4) == (n1 + n3 + n6) &&
                    (n1 + n3 + n6) == (n4 + n5 + n6))
            {

                builder.setTitle("Excellent!")
                        .setMessage("This is a magic triangle with sum : " + (n1 + n2 + n4))
                        .setCancelable(true).show();
                return;
            }

            builder.setTitle("Wrong!")
                    .setMessage("The nodes do not represent a magic triangle, " +
                            "try again!").show();


        } catch (NumberFormatException ex)
        {
            builder.setTitle("Error!")
                    .setMessage("All nodes must contain numbers!").show();
        }
    }
}
