package com.orange.toolz.tasks;

import com.orange.toolz.utilities.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class IndexCreatingTask implements Callable<ArrayList<Boolean>> {

    private int flag;

    public IndexCreatingTask(int flag) {
        this.flag = flag;
    }

    @Override
    public ArrayList<Boolean> call() throws Exception {

        ArrayList<Boolean> result = new ArrayList<>();
        if (flag == 0) {
            Boolean fullNameIndex = createFullNameIndex();
            result.add(fullNameIndex);
            System.out.println("Name index created");
        } else {
            Boolean emailPhoneIndex = createEmailPhoneIndex();
            result.add(emailPhoneIndex);
            System.out.println("Email Index created");
        }
        return null;
    }

    private Boolean createEmailPhoneIndex() {
        Boolean result = true;
        try(Connection connection = DriverManager.getConnection(Utils.DB_URL, Utils.DB_USER, Utils.DB_PASS);
            PreparedStatement queryStatement = connection.prepareStatement(Utils.CREATE_EMAIL_PHONE_INDEX_SQL)) {
            result = queryStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return result;
    }

    private Boolean createFullNameIndex() {
        boolean result = true;
        try(Connection connection = DriverManager.getConnection(Utils.DB_URL, Utils.DB_USER, Utils.DB_PASS);
            PreparedStatement queryStatement = connection.prepareStatement(Utils.CREATE_FULL_NAME_INDEX_SQL)) {
            result = queryStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return result;
    }
}
