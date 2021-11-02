package edu.uga.cs.companyfinder2;
/**
 * CSCI 4060 Project 3
 *
 * @author  Josh Messitte
 * @version 1.0
 * @since 2021-10-13
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

/**
 * List Fragment for displaying all of the companies.
 */
public class CompanyFinderListFragment extends ListFragment {

    private static final String TAG = "Companies";

    // Array of companies
    private final String[] companies = {
            "Booz Allen Hamilton",
            "NASA",
            "Amazon",
            "Lockheed Martin",
            "SpaceX",
    };


    boolean twoFragmentsActivity = false;
    int versionIndex = 0;


    public CompanyFinderListFragment()
    {
        // required default constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState ) {

        super.onViewCreated(view, savedInstanceState);

        Log.d( TAG, "CompanyFinderListFragment.onActivityCreated(): savedInstanceState: " + savedInstanceState );

        // create a new ArrayAdapter for the list
        setListAdapter( new ArrayAdapter<>( getActivity(), android.R.layout.simple_list_item_activated_1, companies ) );

        // set the twoFragmentsActivity variable to true iff we are in 2 fragment (landscape) view
        View detailsFrame = getActivity().findViewById( R.id.companyInfo );
        Log.d( TAG, "CompanyFinderListFragment.onActivityCreated(): detailsFrame: " + detailsFrame );

        twoFragmentsActivity = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // restore the list index selection
        if( savedInstanceState != null ) {
            versionIndex = savedInstanceState.getInt("companySelection", 0 );
            Log.d( TAG, "CompanyFinderListFragment.onActivityCreated(): restored versionIndex: " + versionIndex );
        }

        // set the list mode as single choice
        getListView().setChoiceMode( ListView.CHOICE_MODE_SINGLE );
        getListView().setItemChecked( versionIndex, true );

        if( twoFragmentsActivity ) {
            showCompanyInfo( versionIndex );
            getListView().smoothScrollToPosition( versionIndex );
        }

    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {
        showCompanyInfo( position );
    }

    @Override
    public void onSaveInstanceState( Bundle outState ) {
        super.onSaveInstanceState(outState);
        // save the list index selection
        outState.putInt( "companySelection", versionIndex);
        Log.d( TAG, "CompanyFinderListFragment.onSaveInstanceState(): saved versionIndex: " + versionIndex );
    }

    void showCompanyInfo( int versionIndex ) {

        this.versionIndex = versionIndex;

        if( twoFragmentsActivity ) {

            getListView().setItemChecked( versionIndex, true );
            CompanyFinderInfoFragment details = (CompanyFinderInfoFragment) getParentFragmentManager().findFragmentById( R.id.companyInfo );

            if( details == null || details.getShownVersionIndex() != versionIndex ) {

                details = CompanyFinderInfoFragment.newInstance( versionIndex );

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.companyInfo, details );

                fragmentTransaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );

                fragmentTransaction.commit();
            }
        }
        else {

            Intent intent = new Intent();
            intent.setClass( getActivity(), CompanyFinderInfoActivity.class );
            intent.putExtra("versionIndex", versionIndex);
            startActivity( intent );
        }
    }

}
