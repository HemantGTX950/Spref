package Database;

import android.provider.BaseColumns;

/**
 * Created by Hemant Bansal on 11/24/2016.
 */

public class Schema {
    public Schema() {
    }

    public static abstract class DbEntry implements BaseColumns{
        public static final String  TABLE_NAME="Students";
        public static final String  COLUMN_STUDENT_NAME="student_name";
        public static final String  COLUMN_STUDENT_CONTACT="person_contact";

    }


}
