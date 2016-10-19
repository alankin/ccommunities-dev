package ccomunities.alashka.com.ccommunities_dev.fragments;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import java.io.Console;

import ccomunities.alashka.com.ccommunities_dev.NewPublicationActivity;
import ccomunities.alashka.com.ccommunities_dev.R;

public class PublicationFragment extends Fragment {

    private FloatingActionButton fab;


    public PublicationFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publication, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewPublicationActivity.class );
                startActivity(intent);

            }
        });
        return view;
    }

}
