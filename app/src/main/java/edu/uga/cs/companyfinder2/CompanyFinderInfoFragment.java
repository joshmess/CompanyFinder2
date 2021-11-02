package edu.uga.cs.companyfinder2;
/**
 * CSCI 4060 Project 3
 *
 * @author  Josh Messitte
 * @version 1.0
 * @since 2021-10-13
 */


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.InputStream;

/**
 * Fragment for displaying information about a specific company.
 */
public class CompanyFinderInfoFragment extends Fragment{

    private final String[] companyTags = {
            "BAH","NASA","AMA","LOCK","SPACEX"
    };
    private TextView textView;
    private ImageView imageView;
    private TextView name;

    private static final String TAG = "Companies";

    public CompanyFinderInfoFragment()
    {
        // required default constructor
    }

    /**
     *
     * @param versionIndex
     * @return Fragment for company info.
     */
    public static CompanyFinderInfoFragment newInstance( int versionIndex ) {

        Log.d( TAG, "CompanyFinderInfoFragment.newInstance(): versionIndex: " + versionIndex );

        CompanyFinderInfoFragment fragment = new CompanyFinderInfoFragment();
        Log.d(TAG, "CompanyFinderInfoFragment.newInstance(): fragment: " + fragment);

        Bundle args = new Bundle();
        args.putInt( "versionIndex", versionIndex );
        fragment.setArguments( args );

        return fragment;
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return Updated View after selection.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        Log.d( TAG, "onCreateView()" );

        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.info_fragment, container, false );
        textView = view.findViewById( R.id.textView );
        imageView = view.findViewById( R.id.imageView2 );
        name = view.findViewById( R.id.company_name );

        //update
        String tag = companyTags[getShownVersionIndex()];

        if(tag.equals("BAH")){

            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.bah);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                imageView.setImageResource(R.drawable.bah);
                textView.setText(new String(b));
                name.setText("Booz Allen Hamilton");
            } catch (Exception e){
                textView.setText("Error fetching text from resources.");
            }

        }else if(tag.equals("NASA")){

            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.nasa);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                textView.setText(new String(b));
                imageView.setImageResource(R.drawable.nasa);
                name.setText("NASA");
            } catch (Exception e){
                textView.setText("Error fetching text from resources.");
            }

        }else if(tag.equals("AMA")){


            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.amazon);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                textView.setText(new String(b));
                imageView.setImageResource(R.drawable.amazon);
                name.setText("Amazon");
            } catch (Exception e){
                textView.setText("Error fetching text from resources.");
            }

        }else if(tag.equals("LOCK")){


            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.lockheed);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                textView.setText(new String(b));
                imageView.setImageResource(R.drawable.lockheed);
                name.setText("Lockheed Martin");
            } catch (Exception e){
                textView.setText("Error fetching text from resources.");
            }

        }else{
            // SpaceX

            try {
                Resources res = getResources();
                InputStream in_s = res.openRawResource(R.raw.spacex);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                textView.setText(new String(b));
                imageView.setImageResource(R.drawable.spacex);
                name.setText("SpaceX");
            } catch (Exception e){
                textView.setText("Error fetching text from resources.");
            }
        }

        return view;
    }



    public int getShownVersionIndex() {
        return getArguments().getInt("versionIndex", 0 );
    }
}
