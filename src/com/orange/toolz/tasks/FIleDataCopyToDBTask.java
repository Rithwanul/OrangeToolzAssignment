package com.orange.toolz.tasks;

import com.mysql.cj.util.Util;
import com.orange.toolz.utilities.Utils;

import java.sql.*;
import java.util.concurrent.Callable;

public class FIleDataCopyToDBTask implements Callable<Boolean> {



    @Override
    public Boolean call() throws Exception {

        boolean result = false;

        try(Connection connection = DriverManager.getConnection(Utils.DB_URL, Utils.DB_USER, Utils.DB_PASS);
            PreparedStatement queryStatement = connection.prepareStatement(Utils.LOAD_DATA_FROM_FILE_SQL)) {
            result = queryStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return result;
    }
}
