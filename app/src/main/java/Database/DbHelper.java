package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hemantbansal.spref.List;

import java.util.ArrayList;

/**
 * Created by Hemant Bansal on 11/24/2016.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="HostelStudents.db";
    private static final String TAG="DbHelper";
    private Context context;

    public DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbUtils.CREATE_TABLE);
        ContentValues values=new ContentValues();
        values.put(Schema.DbEntry.COLUMN_STUDENT_NAME,"Hemant");
        values.put(Schema.DbEntry.COLUMN_STUDENT_CONTACT,"9698741235");
        db.insert(Schema.DbEntry.TABLE_NAME,null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void  addEntryToDb(String studentName,String studentNumber){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Schema.DbEntry.COLUMN_STUDENT_NAME,studentName);
        values.put(Schema.DbEntry.COLUMN_STUDENT_CONTACT,studentNumber);
        db.insert(Schema.DbEntry.TABLE_NAME,null,values);
    }

    public ArrayList<String> retrieveInfoFromDb(){

        SQLiteDatabase db=getReadableDatabase();
        String[] projection={Schema.DbEntry.COLUMN_STUDENT_NAME,Schema.DbEntry.COLUMN_STUDENT_CONTACT};

        Cursor readCursor=db.query(Schema.DbEntry.TABLE_NAME,projection,null,null,null,null,null);
        readCursor.moveToFirst();
        int totalRows=readCursor.getCount();

        ArrayList<String> results=new ArrayList<>();
        while(totalRows>0){
            totalRows--;
            String studentName=readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_STUDENT_NAME));
            String studentNumber=readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_STUDENT_CONTACT));
            String converted=studentName+"\n"+studentNumber;
            results.add(converted);

            readCursor.moveToNext();
        }
        readCursor.close();
        return results;
    }



    public ArrayList<User> retrieveListFromDb(){

        SQLiteDatabase db=getReadableDatabase();
        String[] projection={Schema.DbEntry.COLUMN_STUDENT_NAME,Schema.DbEntry.COLUMN_STUDENT_CONTACT};

        Cursor readCursor=db.query(Schema.DbEntry.TABLE_NAME,projection,null,null,null,null,null);

        readCursor.moveToFirst();

        int totalRows=readCursor.getCount();
        ArrayList<User> results=new ArrayList<>();

        while(totalRows>0){
            totalRows--;
            String studentName=readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_STUDENT_NAME));
            String studentNumber=readCursor.getString(readCursor.getColumnIndexOrThrow(Schema.DbEntry.COLUMN_STUDENT_CONTACT));
            results.add(new User(studentName,studentNumber));
            readCursor.moveToNext();
        }
        readCursor.close();
    return results;
    }

    public class User{
        private String phone,name;

        public User(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }
    }
}
