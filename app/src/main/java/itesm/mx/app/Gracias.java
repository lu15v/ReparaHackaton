package itesm.mx.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class Gracias extends ActionBarActivity {

   // private String[] initVals = {"ASC", "ALV", "ACC", "ADD", "ADC","ALG","AVF","AFD"};
   // private ArrayList<String> articles = new ArrayList<String>(Arrays.asList(initVals));
    private ArrayList<Button> buttons = new ArrayList<Button>();

    ListView asociations;
    EditText et_articleName;
    EditText et_quantity;
    ArrayAdapter<String> adapter;
    String[] arrayL = {"Fierros y Metales de México","Reciclados de Papel y Cartón","Comercializadora y Embarques"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            setContentView(R.layout.activity_gracias);
            this.asociations = (ListView) findViewById(R.id.lv01);
            asociations.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_gracias, arrayL));
            this.asociations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                    String str = ((TextView) view).getText().toString();
                    if (str.equals(arrayL[0])){
                        Intent intent = new Intent(getBaseContext(), FierrosyMetalesdeMexico.class);
                        startActivity(intent);
                    }else if (str.equals(arrayL[1])){
                        Intent intent = new Intent(getBaseContext(), RecicladosdePapelyCarton.class);
                        startActivity(intent);
                    }else if (str.equals(arrayL[2])){
                        Intent intent = new Intent(getBaseContext(), ComercializadorayEmbarques.class);
                        startActivity(intent);
                    }
                }
            });
        }catch (Exception x){
            x.printStackTrace();
        }



        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arrayL);
        asociations.setAdapter(adapter);





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
