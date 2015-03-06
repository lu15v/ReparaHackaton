package itesm.mx.app;

import android.provider.BaseColumns;

/**
 * Created by LU15 on 05/03/2015.
 */
public class RecicladoraTable {
    public RecicladoraTable(){

    }
    public static abstract class TableInfo implements BaseColumns
    {
    public final String USER_NAME = "user_name";
    public final String PASSWORD = "pass";
    public final String NAME = "nombre";
    public final String TABLE_NAME = "recicladora";

    }

}
