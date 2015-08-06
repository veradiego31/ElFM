package io.veradiego31.elfm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.veradiego31.elfm.ui.HypedArtistsFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState== null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new HypedArtistsFragment())
                    .commit();
        }



    }

}
