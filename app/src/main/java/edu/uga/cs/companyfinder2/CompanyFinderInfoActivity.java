package edu.uga.cs.companyfinder2;
/**
 * CSCI 4060 Project 3
 *
 * @author  Josh Messitte
 * @version 1.0
 * @since 2021-10-13
 */

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity for company-specific information within Company Finder.
 */
public class CompanyFinderInfoActivity extends AppCompatActivity {


    private static final String TAG = "CompanyFinder2";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        Log.d( TAG, "CompanyFinderInfoActivity.onCreate()" );

        super.onCreate( savedInstanceState );

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled( true );

        if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            Log.d( TAG, "CompanyFinderInfoActivity.onCreate(): in landscape mode; returning" );
            finish();
            return;
        }

        Log.d(TAG, "CompanyFinderInfoActivity.onCreate(): in portrait mode; replacing fragments");

        CompanyFinderInfoFragment companyFinderInfoFragment = new CompanyFinderInfoFragment();
        Log.d(TAG, "CompanyFinderInfoActivity.onCreate(): companyFinderInfoFragment: " + companyFinderInfoFragment);


        // pass on any saved data
        companyFinderInfoFragment.setArguments( getIntent().getExtras() );

        getSupportFragmentManager().beginTransaction().replace( android.R.id.content, companyFinderInfoFragment ).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Implement Back button listener method.
        // This method may be used for other actions from the ActionBar menu, if provided in the layout.
        int id = item.getItemId();

        // android.R.id.home is the built-in designation of the back button widget.
        if( id == android.R.id.home ) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}
