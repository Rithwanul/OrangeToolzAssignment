package com.orange.toolz.tasks;

import com.orange.toolz.models.UserDetail;
import com.orange.toolz.utilities.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class QueryOperationTask implements Callable<ArrayList<UserDetail>> {

    int flag;

    public QueryOperationTask(int flag) {
        this.flag = flag;
    }

    @Override
    public ArrayList<UserDetail> call() throws Exception {
        ArrayList<UserDetail> results = new ArrayList<>();

        if (flag == 0) {
            results = getInvalidCustomers();
        } else {

        }

        return results;
    }

    private ArrayList<UserDetail> getInvalidCustomers() {
        ArrayList<UserDetail> results = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(Utils.DB_URL, Utils.DB_USER, Utils.DB_PASS);
            PreparedStatement queryStatement = connection.prepareStatement(Utils.COUNT_INVALID_CUSTOMER_SQL)) {
            ResultSet resultSet = queryStatement.executeQuery();

            while (resultSet.next()) {
                UserDetail userDetail = new UserDetail();
                userDetail.setFirstName(resultSet.getString("first_name"));
                userDetail.setLastName(resultSet.getString("last_name"));
                userDetail.setCity(resultSet.getString("city"));
                userDetail.setProvince(resultSet.getString("province"));
                userDetail.setPostalCode(resultSet.getString("postal_code"));
                userDetail.setPhoneNumber(resultSet.getString("phone_number"));
                userDetail.setEmail(resultSet.getString("email"));
                userDetail.setIpAddress(resultSet.getString("ip_address"));
                results.add(userDetail);
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

        return results;
    }
}
