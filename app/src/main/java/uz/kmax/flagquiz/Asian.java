package uz.kmax.flagquiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Asian extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;
    public InterstitialAd InterstitialAd;
    public int transition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // Reklama kodi - Start
        MobileAds.initialize(this);
        InterstitialAd = new InterstitialAd(this);
        InterstitialAd.setAdUnitId("ca-app-pub-4664801446868642/7374004703");
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.loadAd(adRequest);

        InterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                 try {
                     switch(transition){
                         case 0: break;
                         case 1: Intent intent = new Intent(Asian.this, GameLevels.class);
                             startActivity(intent);finish();break;
                         case 2:Intent intent1 = new Intent(Asian.this, europa.class);
                             startActivity(intent1);finish();break;
                         default:break;
                     }

                 }catch (Exception e){
                     // Empty
                 }
             }
        });
        // Reklama kodi - End


        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level_asian);

        // Rasm burchaklarini to'g'irlash - Start
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        // RAsm burchaklarini to'g'irlash - End

        // Text left and Text right code - Start
        TextView text_left = findViewById(R.id.text_left);

        TextView text_right = findViewById(R.id.text_right);
        // Text left and Text right code - End
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Dialog kodi - Start
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_asian);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView button_close_asian = (TextView)dialog.findViewById(R.id.button_close_asian);
        button_close_asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InterstitialAd.isLoaded()) {
                    transition = 1;
                    InterstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(Asian.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("Xatolik");
                    }
                    dialog.dismiss();
                }
            }
        });

        Button button_continune = (Button)dialog.findViewById(R.id.dialog_asian_button);
        button_continune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        dialog.show();
        // Dialog kodi - End
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        //-----------DialogEnd -- Oynasi -- Kodi -- Start ------//

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);

        // Dialog oynasini yopish - Start
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.button_close_asian);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InterstitialAd.isLoaded()) {
                    transition = 1;
                    InterstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(Asian.this, GameLevels.class); // level 2 dan GameLevelga qaytish
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    dialogEnd.dismiss(); // dialog oynasini yopish .
                }
            }
        });
        // Dialog oynasini yopish - End

        // "Davom etish" kodi boshlanishi - Start
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.dialog_asian_button);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InterstitialAd.isLoaded()) {
                    transition = 2;
                    InterstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(Asian.this, europa.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }

                    dialogEnd.dismiss();
                }
            }
        });
        // "Davom etish" kodi boshlanishi - End

        //-----------DialogEnd -- Oynasi -- Kodi -- End---------//

        //////////////////////////////////////////////////////////////

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InterstitialAd.isLoaded()){
                    transition = 1;
                    InterstitialAd.show();
                }else {
                    try {
                        Intent intent = new Intent(Asian.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        System.out.println("xatolik");
                    }
                }
            }
        });

        // Progress uchun Massiv - Start
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        // Progress uchun Massiv - End

        // Animatsiya chaqirish - Start
        final Animation a = AnimationUtils.loadAnimation(Asian.this, R.anim.alpha);
        // Animatsiya chaqirish - End

        numLeft = random.nextInt(103); // 0 dan 140 gacha random son chap rasm uchun
        numRight = random.nextInt(103);  // 0 dan 140 gacha random son o'ng rasm uchun

        // While sikl numLeft == numRight ? - Start
        while (numLeft == numRight){
            numRight = random.nextInt(103); // Qayta sikl
        }
        // While sikl numLeft == numRight ? - End

        if (numLeft % 2 == 0 && numRight % 2 == 0 || numLeft % 2 == 1 && numRight % 2 == 1){
            numRight=numRight+1;
        }

        // Chap rasm uchun - Start
        img_left.setImageResource(array.Asian[numLeft]);
        text_left.setText(array.AsianName[numLeft]);
        // Chap rasm uchun - End

        // O'ng rasm uchun - Start
        img_right.setImageResource(array.Asian[numRight]); // O'ng rasmda rasm chiqarish kodi
        text_right.setText(array.AsianName[numRight]); // O'ng rasm da yozuvi
        // O'ng rasm uchun - End

        // Chap Rasm Progress - Start
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Ekran bosish kodi - start
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    // Agar rasm bosilsa - Start
                    img_right.setEnabled(false); // o'ng rasm bloklash
                    if (array.AsiantrueAndFalse[numLeft]<array.AsiantrueAndFalse[numRight]){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    // Agar rasm bosilsa - End
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    // Qo'yib yuborilsa - Start
                    if (array.AsiantrueAndFalse[numLeft]<array.AsiantrueAndFalse[numRight]){
                        // Agar chap rasm o'ngdan katta bo'lsa - Start
                        if (count<20){
                            count= count+1;
                        }
                        /////////////////////////////////////////////////////////////////////////////////////////
                        // Indigo stil  - Start
                        for (int i = 0; i < 20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point);
                        }
                        // Indigo stil  - End

                        // To'g'ri javob va yashil stil berish kodi - Start
                        for(int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point_green);
                        }
                        // To'g'ri javob va yashil stil berish kodi - End
                        ////////////////////////////////////////////////////////////////////////////////////////
                        // Agar chap rasm o'ngdan katta bo'lsa - End
                    }else {
                        // Agar chap rasm o'ngdan kichik bo'lsa - Start
                        if (count>0){
                            if (count==1){
                                count = 0;
                            }else {
                                count=count-2;
                            }
                        }
                        // Indigo stil  - Start
                        for (int i = 0; i < 19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point);
                        }
                        // Indigo stil  - End

                        // To'g'ri javob va yashil stil berish kodi - Start
                        for(int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point_green);
                        }
                        // To'g'ri javob va yashil stil berish kodi - End
                        // Agar chap rasm o'ngdan kichik bo'lsa - End
                    }
                    if (count==20){
                        // Asiandan europaga o'tish
                        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
                        final int continent = save.getInt("continent",1);
                        if (continent>1){
                            // Empty
                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("continent",2);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(103); // 0 dan 140 gacha random son chap rasm uchun
                        numRight = random.nextInt(103);  // 0 dan 140 gacha random son o'ng rasm uchun

                        // While sikl numLeft == numRight ? - Start
                        while (numLeft == numRight){
                            numRight = random.nextInt(103); // Qayta sikl
                        }
                        // While sikl numLeft == numRight ? - End

                        if (numLeft % 2 == 0 && numRight % 2 == 0 || numLeft % 2 == 1 && numRight % 2 == 1){
                            numRight=numRight+1;
                        }

                        // Chap rasm uchun - Start
                        img_left.setImageResource(array.Asian[numLeft]);
                        text_left.setText(array.AsianName[numLeft]);
                        // Chap rasm uchun - End

                        // O'ng rasm uchun - Start
                        img_right.setImageResource(array.Asian[numRight]); // O'ng rasmda rasm chiqarish kodi
                        text_right.setText(array.AsianName[numRight]); // O'ng rasm da yozuvi
                        // O'ng rasm uchun - End

                        img_right.setEnabled(true); // O'ng tomon rasmini qayta ishga tushirish
                    }
                }
                // Ekran bosish kodi - End

                return true;
            }
        });

        // Chap Rasm Progress - End

        // O'ng rasm Progress - Start
        // O'ng rasm clik - Start
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Ekran bosish kodi - start
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    // Agar rasm bosilsa - Start
                    img_left.setEnabled(false); // Chap rasm bloklash
                    if (array.AsiantrueAndFalse[numLeft]>array.AsiantrueAndFalse[numRight]){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    // Agar rasm bosilsa - End
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    // Qo'yib yuborilsa - Start
                    if (array.AsiantrueAndFalse[numLeft]>array.AsiantrueAndFalse[numRight]){
                        // Agar O'ng rasm Chapdan katta bo'lsa - Start
                        if (count<20){
                            count= count+1;
                        }
                        /////////////////////////////////////////////////////////////////////////////////////////
                        // Indigo stil  - Start
                        for (int i = 0; i < 20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point);
                        }
                        // Indigo stil  - End

                        // To'g'ri javob va yashil stil berish kodi - Start
                        for(int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point_green);
                        }
                        // To'g'ri javob va yashil stil berish kodi - End
                        ////////////////////////////////////////////////////////////////////////////////////////
                        // Agar chap rasm o'ngdan katta bo'lsa - End
                    }else {
                        // Agar O'ng rasm Chapdan kichik bo'lsa - Start
                        if (count>0){
                            if (count==1){
                                count = 0;
                            }else {
                                count=count-2;
                            }
                        }
                        // Indigo stil  - Start
                        for (int i = 0; i < 19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point);
                        }
                        // Indigo stil  - End

                        // To'g'ri javob va yashil stil berish kodi - Start
                        for(int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_point_green);
                        }
                        // To'g'ri javob va yashil stil berish kodi - End
                        // Agar chap rasm o'ngdan kichik bo'lsa - End
                    }
                    if (count==20){
                        // LEVEL 1 DAN LEVEL 2 GA O'TISH KODI
                        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
                        final int continent = save.getInt("continent",1);
                        if (continent>1){
                            // Empty
                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("continent",2);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(103); // 0 dan 140 gacha random son chap rasm uchun
                        numRight = random.nextInt(103);  // 0 dan 140 gacha random son o'ng rasm uchun

                        // While sikl numLeft == numRight ? - Start
                        while (numLeft == numRight){
                            numRight = random.nextInt(103); // Qayta sikl
                        }
                        // While sikl numLeft == numRight ? - End

                        if (numLeft % 2 == 0 && numRight % 2 == 0 || numLeft % 2 == 1 && numRight % 2 == 1){
                            numRight=numRight+1;
                        }

                        // Chap rasm uchun - Start
                        img_left.setImageResource(array.Asian[numLeft]);
                        text_left.setText(array.AsianName[numLeft]);
                        // Chap rasm uchun - End

                        // O'ng rasm uchun - Start
                        img_right.setImageResource(array.Asian[numRight]); // O'ng rasmda rasm chiqarish kodi
                        text_right.setText(array.AsianName[numRight]); // O'ng rasm da yozuvi
                        // O'ng rasm uchun - End

                        img_left.setEnabled(true); // Chap tomon rasmini qayta ishga tushirish
                    }
                }
                // Ekran bosish kodi - End

                return true;
            }
        });
        // O'ng rasm clik - End
        // O'ng rasm Progress - End
    }

    @Override
    public void onBackPressed() {
        if (InterstitialAd.isLoaded()) {
            transition = 1;
            InterstitialAd.show();
        } else {
            try {
                Intent intent = new Intent(Asian.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                System.out.println("Xatolik");
            }
        }
    }
}