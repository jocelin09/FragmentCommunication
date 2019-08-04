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
import android.widget.EditText;

/**
 * Created by jocelinthomas on 04/08/19.
 */

public class FragmentA extends Fragment {
    private FragmentAListener fragmentAListener;
    
    private EditText editText;
    private Button btnOk;
    
    public interface FragmentAListener{
        void sendAData(String text);
        
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    
    View v = inflater.inflate(R.layout.fragment_a,container,false);
    editText = v.findViewById(R.id.message);
    btnOk = v.findViewById(R.id.btnok);
    btnOk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String textmsg = editText.getText().toString();
            fragmentAListener.sendAData(textmsg); //sends the input over interface to the activity that implements the interface
        
        }
    });
    return v;
    
    }
    
    //When fragment is attached to activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener)    //checks if activity implements the interface
        {
        fragmentAListener = (FragmentAListener) context; //assign listener variable to activity
        }
        else
        {
            throw new RuntimeException(context.toString()+"should implement FragmentBListener");
        }
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        fragmentAListener = null;
    }
    
    public void updateText(String string)
    {
    editText.setText(string);
    }

}
