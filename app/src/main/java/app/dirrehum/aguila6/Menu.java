package app.dirrehum.aguila6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.login.R;

public class Menu extends AppCompatActivity {
    public ImageButton imgAvisos, imgCipd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imgAvisos = findViewById(R.id.imgAvisos);
        imgCipd = findViewById(R.id.imgCipd);
        try {
            imgAvisos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),Avisos.class);
                    startActivity(i);
                }
            });

            imgCipd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Carnet.class);
                    startActivity(i);
                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"ocurrio un error",Toast.LENGTH_LONG).show();
        }



    }
}