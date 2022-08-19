package service;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomPricingService {

    public static boolean add(int hotelId, int roomId, int pensionId, double firstPeriodAdultPrice, double firstPeriodKidPrice, double secondPeriodAdultPrice, double secondPeriodKidPrice){
        boolean key = false;
        String sqlInsert = "INSERT INTO \"room-pricing\"(hotel_id, room_id, pension_id, first_period_adult_price, first_period_kid_price, second_period_adult_price, second_period_kid_price)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.setInt(3, pensionId);
            preparedStatement.setDouble(4, firstPeriodAdultPrice);
            preparedStatement.setDouble(5, firstPeriodKidPrice);
            preparedStatement.setDouble(6, secondPeriodAdultPrice);
            preparedStatement.setDouble(7, secondPeriodKidPrice);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static double getAdultFirstPeriodRoomPrice(int roomId){
        double adultRoomPrice = 0;
        String sqlSelect = "SELECT first_period_adult_price FROM \"room-pricing\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                adultRoomPrice = resultSet.getDouble("first_period_adult_price");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adultRoomPrice;
    }

    public static double getAdultSecondPeriodRoomPrice(int roomId){
        double adultRoomPrice = 0;
        String sqlSelect = "SELECT second_period_adult_price FROM \"room-pricing\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                adultRoomPrice = resultSet.getDouble("second_period_adult_price");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adultRoomPrice;
    }

    public static double getKidFirstPeriodRoomPrice(int roomId){
        double kidRoomPrice = 0;
        String sqlSelect = "SELECT first_period_kid_price FROM \"room-pricing\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                kidRoomPrice = resultSet.getDouble("first_period_kid_price");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kidRoomPrice;
    }

    public static double getKidSecondPeriodRoomPrice(int roomId){
        double kidRoomPrice = 0;
        String sqlSelect = "SELECT second_period_kid_price FROM \"room-pricing\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                kidRoomPrice = resultSet.getDouble("second_period_kid_price");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kidRoomPrice;
    }


}
