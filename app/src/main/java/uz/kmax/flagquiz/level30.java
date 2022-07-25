package uz.kmax.flagquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class level30 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_countries);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_countries_about);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(level30.this, GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(level30.this, GameLevels.class);
            startActivity(intent);finish();
        }catch (Exception e){
            System.out.println("Xatolik");
        }
    }
}