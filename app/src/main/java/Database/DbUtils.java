package Database;

/**
 * Created by Hemant Bansal on 11/24/2016.
 */

public class DbUtils {
    private static final String COMMA_SEP=",";
    private static final String TYPE_TEXT=" TEXT";

    public static final String CREATE_TABLE="CREATE TABLE "+Schema.DbEntry.TABLE_NAME+" ("+Schema.DbEntry._ID+" INTEGER PRIMARY KEY,"
            +Schema.DbEntry.COLUMN_STUDENT_NAME+TYPE_TEXT+COMMA_SEP+Schema.DbEntry.COLUMN_STUDENT_CONTACT+TYPE_TEXT+" )";

}
