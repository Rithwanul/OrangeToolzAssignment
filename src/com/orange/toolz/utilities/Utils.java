package com.orange.toolz.utilities;

public class Utils {
    public static final String LOAD_DATA_FROM_FILE_SQL = "load data infile 'C:/Users/DICO/Desktop/Assignment/src/com/orange//toolz/data/1M-customers.txt'\n" +
            "into table assignment_orange.user_details\n" +
            "fields terminated by ','\n" +
            "lines terminated by '\r\n';";

    public static final String DB_URL = "jdbc:mysql://localhost:3306/assignment_orange?useSSL=false";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "";

    public static final String CREATE_FULL_NAME_INDEX_SQL = "create index full_name on user_details(first_name, last_name);";
    public static final String CREATE_EMAIL_PHONE_INDEX_SQL = "create index email_phone on user_details(first_name, last_name);";
    public static final String COUNT_INVALID_CUSTOMER_SQL = "select * FROM `user_details` WHERE `email` NOT " +
            "REGEXP " + "'^[a-zA-Z0-9_!#$%&\\'*+/=`{|}~^.-]+@[a-zA-Z0-9.-]+$'" +  "\n" +
            "or `phone_number` NOT REGEXP " + "'^\\(?:([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$'" + ";";

}
