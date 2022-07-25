package uz.kmax.flagquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameLevels extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        MobileAds.initialize(this);
        MobileAds.initialize(this,"ca-app-pub-4664801446868642/8014585807");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
        final int continent = save.getInt("continent",1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button example_button = (Button)findViewById(R.id.level_back);
        example_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    // Empty
                }
            }
        });

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=1) {
                        Intent intent = new Intent(GameLevels.this, Asian.class);
                        startActivity(intent);
                        finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=2){
                    Intent intent = new Intent(GameLevels.this, europa.class);
                    startActivity(intent);finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=3) {
                        Intent intent = new Intent(GameLevels.this, africa.class);
                        startActivity(intent);
                        finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=4) {
                        Intent intent = new Intent(GameLevels.this, nAmerica.class);
                        startActivity(intent);
                        finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");;
                }
            }
        });

        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=5) {
                        Intent intent = new Intent(GameLevels.this, sAmerica.class);
                        startActivity(intent);
                        finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=6) {
                        Intent intent = new Intent(GameLevels.this, oceania.class);
                        startActivity(intent);
                        finish();
                    }else {
                        // Empty
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (continent>=7) {
                        Intent intent = new Intent(GameLevels.this, level30.class);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e){
                    System.out.println("Xatolik");
                }
            }
        });

        final int[] unlock = {
                R.id.textView,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
        };

        final int[] continents = {
                R.string.continentAsia,
                R.string.continentEuropa,
                R.string.continentAfrica,
                R.string.continentNamerica,
                R.string.continentSamerica,
                R.string.continentOceania,
                R.string.level_30
        };

        for (int i = 1;i<continent;i++){
            TextView tv = findViewById(unlock[i]);
            tv.setText(continents[i]);
        }
    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){
            System.out.println("Xatolik");
        }
    }

}