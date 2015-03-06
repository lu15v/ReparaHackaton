package itesm.mx.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class RanksActivity extends ActionBarActivity {

    String ranks[] = {"Nivel 1: Novato",
            "Nivel 2: Recolector",
            "Nivel 3: Reciclatón",
            "Nivel 4: Experimentado",
            "Nivel 5: Hombre verde",
            "Nivel 6: Salvador de planetas"};
    int rankImages[] = {R.drawable.niveluno, R.drawable.niveldos, R.drawable.niveltres,
            R.drawable.nivelcuatro, R.drawable.nivelcinco, R.drawable.nivelseis};

    ArrayList<String> rankList = new ArrayList<>(Arrays.asList(ranks));
    ListView lv_ranks;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranks);

        lv_ranks = (ListView) findViewById(R.id.lv_rankList);
        RankAdapter rankAdapter = new RankAdapter(this, ranks, rankImages);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rankList);
        lv_ranks.setAdapter(rankAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ranks, menu);
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

}

class RankAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] titles;
    RankAdapter(Context c, String[] titles, int[] images) {
        super(c, R.layout.activity_rank_list_item, R.id.tv_RankDescription, titles);
        this.context = c;
        this.images = images;
        this.titles = titles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_rank_list_item, parent, false);
        ImageView iv = (ImageView) row.findViewById(R.id.iv_rankImage);
        TextView tv = (TextView) row.findViewById(R.id.tv_RankDescription);
        iv.setImageResource(this.images[position]);
        tv.setText(this.titles[position]);
        return row;
    }
}
