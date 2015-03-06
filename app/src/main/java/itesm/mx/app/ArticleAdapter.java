package itesm.mx.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gomezhyuuga on 05/03/15.
 */
public class ArticleAdapter extends BaseAdapter {

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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
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
