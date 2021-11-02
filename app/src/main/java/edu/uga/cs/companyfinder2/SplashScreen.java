package edu.uga.cs.companyfinder2;
/**
 * CSCI 4060 Project 3
 *
 * @author  Josh Messitte
 * @version 1.0
 * @since 2021-10-13
 */


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Splash Screen Activity to give an overview of the application.
 */
public class SplashScreen extends AppCompatActivity {

    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        continueButton = findViewById( R.id.continueButton );

        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent( v.getContext(), CompanyFinderMainActivity.class );
                v.getContext().startActivity( intent );

            }
        });

    }
}