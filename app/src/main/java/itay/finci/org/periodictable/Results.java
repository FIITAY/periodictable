package itay.finci.org.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        int firstTry = b.getInt("IN_FIRST_TRY");
        int secondTry =b.getInt("IN_SECOND_TRY");
        int dontSeccede = b.getInt("DIDNT_SECCEDE");

        TextView tvInFirstTime = (TextView) findViewById(R.id.tvInFirstTry);
        TextView tvInSecondTime = (TextView) findViewById(R.id.tvInSecondTry);
        TextView tvDontSeccede = (TextView) findViewById(R.id.tvDontSeccede);

        tvInFirstTime.setText(""+ getText(R.string.inFirsttime) + firstTry);
        tvInSecondTime.setText( ""+ getText(R.string.seccondtry) + secondTry);
        tvDontSeccede.setText(""+ getText(R.string.dontseccede) + dontSeccede);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = getString(R.string.share);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Download the Periodictable app today");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btGoBack = (Button) findViewById(R.id.btBack);
        btGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainScreen.class));
            }
        });
    }

}
