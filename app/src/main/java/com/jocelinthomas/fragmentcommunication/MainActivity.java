package com.jocelinthomas.fragmentcommunication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener,FragmentB.FragmentBListener{

    FragmentA fragmentA;
    FragmentB fragmentB;
    TextView txtmsg;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if ((findViewById(R.id.frame_a) != null) || (findViewById(R.id.frame_b) != null))
        {
            if (savedInstanceState != null)
            {
                return;
            }
    
            fragmentA = new FragmentA();
            fragmentB = new FragmentB();
            
            
            //Add fragments to main activity
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_a,fragmentA,null)
                    .add(R.id.frame_b,fragmentB,null)
                    .commit();
            
        }
        
    }

    @Override
    public void sendAData(String text) {
        
        //frag to frag communication
        fragmentB.updateBText(text);
        
        //frag to frag by replacing frag A with C
        FragmentC fragmentC = new FragmentC();
        
        Bundle bundle = new Bundle();
        bundle.putString("message",text);
        fragmentC.setArguments(bundle);
        
        
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frame_a,fragmentC,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        
    
        //frag to activity communication
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        txtmsg.setText(text);
        
    }
    
    @Override
    public void sendBData(String text) {
    fragmentA.updateText(text);
    }
    
    
    }
