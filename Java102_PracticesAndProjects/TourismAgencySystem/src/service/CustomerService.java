package service;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerService {
    public static boolean add(String customerName, String customerTc, String customerPhone, String customerMail, int hotelId, int roomId, double roomPrice){
        boolean key = false;
        String sqlInsert = "INSERT INTO customers(customer_name, customer_tc, customer_phone, customer_mail, hotel_id, room_id, room_price)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, customerTc);
            preparedStatement.setString(3, customerPhone);
            preparedStatement.setString(4, customerMail);
            preparedStatement.setInt(5, hotelId);
            preparedStatement.setInt(6, roomId);
            preparedStatement.setDouble(7, roomPrice);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }
}
