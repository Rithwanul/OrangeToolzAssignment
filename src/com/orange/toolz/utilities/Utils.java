package com.orange.toolz.utilities;

public class Utils {
    public static final String LOAD_DATA_FROM_FILE_SQL = "load data infile 'C:/Users/DICO/Desktop/Assignment/src/com/orange//toolz/data/1M-customers.txt'\n" +
            "into table assignment_orange.user_details\n" +
            "fields terminated by ','\n" +
            "lines terminated by '\r\n';";

    public static final String DB_URL = "jdbc:mysql://localhost:3306/assignment_orange?useSSL=false";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "";
}