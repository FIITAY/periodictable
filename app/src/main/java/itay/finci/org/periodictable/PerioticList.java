package itay.finci.org.periodictable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PerioticList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periotic_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listView);
        String[] periotictable = new String[PeriodicTable.getInstance(getApplicationContext()).getNumElements()];
        for (int i = 0; i < PeriodicTable.getInstance(getApplicationContext()).getNumElements(); i++) {
            periotictable[i] = PeriodicTable.getInstance(getApplicationContext()).getPeriodic(i).getName()
                    + " = " + PeriodicTable.getInstance(getApplicationContext()).getPeriodic(i).getSymbole();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, periotictable);
        listView.setAdapter(adapter);
    }

}
