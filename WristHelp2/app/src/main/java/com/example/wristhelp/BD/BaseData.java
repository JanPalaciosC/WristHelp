package com.example.wristhelp.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class BaseData extends SQLiteOpenHelper {

    public static class Datostabla implements BaseColumns {
        public static final String TABLE_NAME = "Usuarios";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NOMBRES = "nombre";
        public static final String COLUMN_PASSWORD = "contrasena";
        public static final String COLUMN_EMAIL = "correo";

        private static final String TEXT_TYPE = "TEXT";
        private static final String COMMA_SEP = ",";

        private static final String CREATE_TABLE_1 =
                "CREATE TABLE " + Datostabla.TABLE_NAME + " (" +
                        Datostabla.COLUMN_NOMBRES + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +
                        Datostabla.COLUMN_PASSWORD + TEXT_TYPE+COMMA_SEP +
                        Datostabla.COLUMN_EMAIL+ TEXT_TYPE +
                        ")";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Datostabla.TABLE_NAME;

    }

   public static final int DATABASE_VERSION = 1;
   public static final String DATABASE_NAME = "MiBasedeDatos.db";

    public BaseData(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Datostabla.CREATE_TABLE_1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL(Datostabla.SQL_DELETE_ENTRIES);
    onCreate(db);


    }
}
