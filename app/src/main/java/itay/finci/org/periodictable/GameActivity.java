package itay.finci.org.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int indexx[];
    int index;
    int roundNum;
    final static int MAX_ROUNDS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        indexx = new int[10];
        for(int i=0; i< indexx.length ; i++){
            indexx[i]= -1;
        }
        index = 0;
        roundNum = 0;
        act();
    }

    Random random;
    int placeindata;
    int truebutton;
    int amountofclicks;
    int inFirstTry = 0,inSecondTry = 0,dontSeccede = 0;
    int mode = 0;
    private void act(){
        final Periodic[] periodic= {
                new Periodic(getString(R.string.Hydrogen) , "H"),
                new Periodic(getString(R.string.lithium) , "Li"),
                new Periodic(getString(R.string.sodium) , "Na"),
                new Periodic(getString(R.string.Potassium) , "K"),
                new Periodic(getString(R.string.Calcium) , "Ca"),
                new Periodic(getString(R.string.Magnesium) , "Mg"),
                new Periodic(getString(R.string.Beryllium) , "Be"),
                new Periodic(getString(R.string.Helium) , "He"),
                new Periodic(getString(R.string.Neon) , "Ne"),
                new Periodic(getString(R.string.Fluorine) , "F"),
                new Periodic(getString(R.string.Oxygen) , "O"),
                new Periodic(getString(R.string.Nitrogen) , "N"),
                new Periodic(getString(R.string.Carbon) , "C"),
                new Periodic(getString(R.string.Boron) , "B"),
                new Periodic(getString(R.string.Chlorine) , "Cl"),
                new Periodic(getString(R.string.Sulfur) , "S"),
                new Periodic(getString(R.string.Phosphorus) , "P"),
                new Periodic(getString(R.string.Silicon) , "Si"),
                new Periodic(getString(R.string.Aluminium) , "Al"),
                new Periodic(getString(R.string.Bromine) , "Br"),
                new Periodic(getString(R.string.Iodine) , "I"),
                new Periodic(getString(R.string.Copper) , "Cu"),
                new Periodic(getString(R.string.Zinc) , "Zn"),
                new Periodic(getString(R.string.Silver) , "Ag"),
                new Periodic(getString(R.string.Gold) , "Au"),
                new Periodic(getString(R.string.Mercury) , "Hg"),
                new Periodic(getString(R.string.Iron) , "Fe")
        };
        TextView tvHowFar,tvInFirstTry,tvInSecondTry,tvDontSeccede,tvTheGiven;
        tvHowFar = (TextView) findViewById(R.id.tvHowFar);
        tvInFirstTry = (TextView) findViewById(R.id.tvInFirstTry);
        tvInSecondTry = (TextView) findViewById(R.id.tvInSecondTry);
        tvDontSeccede = (TextView) findViewById(R.id.tvDontSeccede);
        tvTheGiven = (TextView) findViewById(R.id.tvTheGiven);
        Button btOption1,btOption2,btOption3;
        btOption1 = (Button) findViewById(R.id.btOption1);
        btOption2 = (Button) findViewById(R.id.btOption2);
        btOption3 = (Button) findViewById(R.id.btOption3);
        String inFirstTimeS,inSecondTimeS,DOntSeccedeS;
        amountofclicks = 0;
        //seting the text
        roundNum++;
         mode = 4;
        if (roundNum > MAX_ROUNDS)
        {
            Intent intent = new Intent(getApplicationContext() , Results.class);
            intent.putExtra("IN_FIRST_TRY" , inFirstTry);
            intent.putExtra("IN_SECOND_TRY", inSecondTry);
            intent.putExtra("DIDNT_SECCEDE", dontSeccede);
            startActivity(intent);
            return;
        }
        tvHowFar.setText("" + roundNum + "/" + MAX_ROUNDS);
        inFirstTimeS = "" + getText(R.string.inFirsttime) + inFirstTry;
        tvInFirstTry.setText(inFirstTimeS);
        inSecondTimeS = "" + getText(R.string.seccondtry) + inSecondTry;
        tvInSecondTry.setText(inSecondTimeS);
        DOntSeccedeS = "" + getText(R.string.dontseccede) + dontSeccede;
        tvDontSeccede.setText(DOntSeccedeS);
        random = new Random();
        boolean redo =false;
        do{
            placeindata = random.nextInt(periodic.length);
            redo =false;
            for(int j=0; j< indexx.length ; j++){
                if(placeindata == indexx[j]){
                    redo = true;
                }
            }
        }while(redo);
        indexx[index]= placeindata;
        index = (index +1)% indexx.length;

        switch (random.nextInt(2)){
            case 0:
                tvTheGiven.setText(periodic[placeindata].getName());
                mode = 0;
                break;
            case 1:
                tvTheGiven.setText(periodic[placeindata].getSymbole());
                mode = 1;
                break;
        }
        int placeholder1,placeholder2;
        switch (random.nextInt(3)){
            case 0:
                truebutton = 1;
                do {
                    placeholder1 = random.nextInt(periodic.length);
                }while (placeholder1 == placeindata);
                do{
                    placeholder2 = random.nextInt(periodic.length);
                }while (placeholder1 == placeholder2 || placeholder2 == placeindata);
                if(mode == 0){
                    btOption1.setText(periodic[placeindata].getSymbole());
                    btOption2.setText(periodic[placeholder1].getSymbole());
                    btOption3.setText(periodic[placeholder2].getSymbole());
                }else if(mode == 1){
                    btOption1.setText(periodic[placeindata].getName());
                    btOption2.setText(periodic[placeholder1].getName());
                    btOption3.setText(periodic[placeholder2].getName());
                }

                break;
            case 1:
                do {
                    placeholder1 = random.nextInt(periodic.length);
                }while (placeholder1 == placeindata);
                do{
                    placeholder2 = random.nextInt(periodic.length);
                }while (placeholder1 == placeholder2 || placeholder2 == placeindata);
                do{
                    placeholder2 = random.nextInt(periodic.length);
                }while (placeholder1 == placeholder2);
                truebutton = 2 ;
                if (mode == 0){
                    btOption2.setText(periodic[placeindata].getSymbole());
                    btOption1.setText(periodic[placeholder1].getSymbole());
                    btOption3.setText(periodic[placeholder2].getSymbole());
                }else if (mode == 1){
                    btOption2.setText(periodic[placeindata].getName());
                    btOption1.setText(periodic[placeholder1].getName());
                    btOption3.setText(periodic[placeholder2].getName());
                }
                break;
            case 2:
                do {
                    placeholder1 = random.nextInt(periodic.length);
                }while (placeholder1 == placeindata);
                do{
                    placeholder2 = random.nextInt(periodic.length);
                }while (placeholder1 == placeholder2 || placeholder2 == placeindata);
                truebutton = 3;
                if (mode == 0){
                    btOption3.setText(periodic[placeindata].getSymbole());
                    btOption2.setText(periodic[placeholder1].getSymbole());
                    btOption1.setText(periodic[placeholder2].getSymbole());
                }else if(mode ==1 ){
                    btOption3.setText(periodic[placeindata].getName());
                    btOption2.setText(periodic[placeholder1].getName());
                    btOption1.setText(periodic[placeholder2].getName());
                }
                break;
        }

        btOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 1){
                    if(amountofclicks == 0){
                        Toast.makeText(GameActivity.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                    }else if(amountofclicks ==1){
                        Toast.makeText(GameActivity.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                    }
                    act();
                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(GameActivity.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        if (mode == 0){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getSymbole() , Toast.LENGTH_SHORT).show();
                        }else if (mode ==1){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getName() , Toast.LENGTH_SHORT).show();
                        }
                        dontSeccede++;
                        act();
                    }
                }
            }
        });
        btOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton ==2){
                    if(amountofclicks == 0){
                        Toast.makeText(GameActivity.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                    }else if(amountofclicks ==1){
                        if (mode == 0){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getSymbole() , Toast.LENGTH_SHORT).show();
                        }else if (mode ==1){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getName() , Toast.LENGTH_SHORT).show();
                        }
                        inSecondTry++;
                    }
                    act();
                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(GameActivity.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        if (mode == 0){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getSymbole() , Toast.LENGTH_SHORT).show();
                        }else if (mode ==1){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getName() , Toast.LENGTH_SHORT).show();
                        }
                        dontSeccede++;
                        act();
                    }
                }
            }
        });
        btOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 3){
                    if(amountofclicks == 0){
                        Toast.makeText(GameActivity.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                    }else if(amountofclicks ==1){
                        Toast.makeText(GameActivity.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                    }
                    act();
                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(GameActivity.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        if (mode == 0){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getSymbole() , Toast.LENGTH_SHORT).show();
                        }else if (mode ==1){
                            Toast.makeText(GameActivity.this, getText(R.string.notcorrect)
                                    + periodic[placeindata].getName() , Toast.LENGTH_SHORT).show();
                        }
                        dontSeccede++;
                        act();
                    }
                }
            }
        });

    }

}
