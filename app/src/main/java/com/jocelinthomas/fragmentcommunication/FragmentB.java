package com.jocelinthomas.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jocelinthomas on 04/08/19.
 */

public class FragmentB extends Fragment {
private FragmentBListener fragmentBListener;

private TextView textView;

public interface FragmentBListener {
    void sendBData(String text);
    
}

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    
    View v = inflater.inflate(R.layout.fragment_b, container, false);
    textView = v.findViewById(R.id.message);
  
    return v;
    
}

//When fragment is attached to activity
@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof FragmentBListener)    //checks if activity implements the interface
    {
        fragmentBListener = (FragmentBListener) context; //assign listener variable to activity
    } else {
        throw new RuntimeException(context.toString() + "should implement FragmentBListener");
    }
}

@Override
public void onDetach() {
    super.onDetach();
    fragmentBListener = null;
}

public void updateBText(String string)
{
textView.setText(string);
}


}
