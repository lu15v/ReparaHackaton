package itesm.mx.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class DonateActivity extends ActionBarActivity {

    private String[] initVals = {"Papel", "Aluminio", "Carton", "Equipos de cómputo",
            "Metales", "Baterías", "Envase"};
    private ArrayList<String> articles = new ArrayList<String>(Arrays.asList(initVals));

    ListView lv_articles;
    EditText et_articleName;
    EditText et_quantity;
    ArrayAdapter<String> adapter;

    public void addArticle(View view) {
        String name = et_articleName.getText().toString();
        articles.add(name);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        this.lv_articles = (ListView) findViewById(R.id.lv_articles);
        this.et_articleName = (EditText) findViewById(R.id.ed_articleName);
        this.et_quantity = (EditText) findViewById(R.id.ed_quantity);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, articles);
        lv_articles.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void linkToDonate(View view){
        Intent i = new Intent(this, Gracias.class);
        startActivity(i);
    }
}
