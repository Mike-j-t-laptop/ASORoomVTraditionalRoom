package aso.asoroomvtraditionalroom;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class LoadDBFromRawResources {
    public static void loadImportedDataFromRawResources(SupportSQLiteDatabase db, Context context, ChronicleDBHelper chronicleDBHelper, long runnumber) {
        LogTime.logIt("Loading Data from Raw Resource files",chronicleDBHelper,runnumber);
        String currentTable = "";
        db.setForeignKeyConstraintsEnabled(false);
        db.beginTransaction();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            currentTable = fields[i].getName().replace(".sql","");
            if (currentTable.toLowerCase().startsWith("sqlite_")) continue;
            Log.d("RAWINFO","Checking to see if raw resource " + currentTable + " is a table name");
            //if (!ifTableExistsViaCursor(db,currentTable)) continue;
            if (!ifTableExistsViaSQLiteMaster(db,currentTable)) continue;
            Log.d("RAWINFO","Table " + currentTable + " located in DB - processing");
            try {
                loadFromRawResource(db,context,fields[i].getInt(fields[i]));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.setForeignKeyConstraintsEnabled(true);
        LogTime.logIt("Data loaded from Raw Resources",chronicleDBHelper,runnumber);

    }

    private static void loadFromRawResource(SupportSQLiteDatabase db, Context context, int resourceId) {
        BufferedReader br = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(resourceId)));
        String currentSQL = "";
        try {
            while ((currentSQL = br.readLine()) != null) {
                Log.d("LFRRINFO","Attempting to execute SQL statment :-\n\t" + currentSQL);
                db.execSQL(currentSQL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean ifTableExistsViaCursor(SupportSQLiteDatabase db, String table) {
        Cursor csr = null;
        boolean rv = true;
        try {
            csr = db.query("SELECT * FROM " + table + " LIMIT 1");
            //csr = db.query(table,null,null,null,null,null,null,"1");
        } catch (SQLiteException e) {
            rv = false;
        }
        if (csr != null && !csr.isClosed()) {
            csr.close();
        }
        return rv;
    }

    private static boolean ifTableExistsViaSQLiteMaster(SupportSQLiteDatabase db, String table) {
        //Cursor csr = db.query("sqlite_master",null,"type = 'table' AND name = ?",new String[]{table},null,null,null);
        Cursor csr = db.query("SELECT * FROM sqlite_master WHERE type = 'table' AND name = ?",new String[]{table});
        int count = csr.getCount();
        csr.close();
        return count > 0;
    }


}
