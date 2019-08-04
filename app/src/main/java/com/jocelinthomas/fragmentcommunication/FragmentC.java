package com.jocelinthomas.fragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {

private TextView textView;

public FragmentC() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_c, container, false);
    textView = view.findViewById(R.id.message);
    
    Bundle bundle = getArguments();
    String message = bundle.getString("message");
    textView.setText(message);
    return view;
    
}

}
