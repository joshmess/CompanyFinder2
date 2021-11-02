package edu.uga.cs.companyfinder2;
/**
 * CSCI 4060 Project 3
 *
 * @author  Josh Messitte
 * @version 1.0
 * @since 2021-10-13
 */


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Activity for viewing company info within CompanyFinder.
 */
public class CompanyFinderMainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "CompanyFinder2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d( DEBUG_TAG, "CompanyFinderMainActivity.onCreate(): savedInstanceState: " + savedInstanceState );

        /**
         * create orientation-based UI
         */
        setContentView( R.layout.company_finder_main );
    }

}
