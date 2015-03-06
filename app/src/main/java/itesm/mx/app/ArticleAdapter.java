package itesm.mx.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gomezhyuuga on 05/03/15.
 */
public class ArticleAdapter extends BaseAdapter {

    ArticleAdapter() {
        super();
    }

    List<Article> articleList = getDataForListView();
    private String[] initVals = {"Papel", "Aluminio", "Carton", "Equipos de cómputo",
            "Metales", "Baterías", "Envase"};

    @Override
    public int getCount() {
        return articleList.size();
    }

    @Override
    public Object getItem(int position) {
        return articleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {

        TextView title = (TextView) arg1.findViewById(R.id.tv_articleTitle);
        TextView quantity = (TextView) arg1.findViewById(R.id.tv_quantity);

        Article a = articleList.get(arg0);

        title.setText(a.name);
        quantity.setText(a.quantity);

        return arg1;
    }

    public List<Article> getDataForListView() {
        List<Article> codeLearnChaptersList = new ArrayList<Article>();

        for (String s : initVals) {
            Article a = new Article();
            a.name = s;
            a.quantity = 1;
            articleList.add(a);
        }

        return codeLearnChaptersList;

    }
}
