package service;

import general.DbConnector;
import general.Helper;
import model.Hotel_Info;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class Hotel_InfoService {

    public static boolean add(String hotelName, String hotelMail, String hotelPhoneNumber, String city, String district, String hotelAddress, int hotelStar){
        boolean key = false;
        String sqlInsert = "INSERT INTO public.\"hotel-info\"(hotel_name, hotel_mail, hotel_phone_number, city, district, hotel_address, hotel_star)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        if(validationOfMail(hotelMail) && validationOfPhoneNumber(hotelPhoneNumber)){
            try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
                preparedStatement.setString(1, hotelName);
                preparedStatement.setString(2, hotelMail);
                preparedStatement.setString(3, hotelPhoneNumber);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, district);
                preparedStatement.setString(6, hotelAddress);
                preparedStatement.setInt(7, hotelStar);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                key = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            key = false;
            Helper.showMessage("duplicate");
        }

        return key;
    }

    public static int getHotelIdByMail(String hotelMail){
        int hotelId = 0;
        String sqlSelect = "SELECT hotel_id FROM \"hotel-info\" WHERE hotel_mail = ?";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1,hotelMail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                hotelId = resultSet.getInt("hotel_id");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelId;
    }

    public static String getHotelNameById(int hotelId){
        String hotelName = "";
        String sqlSelect = "SELECT hotel_name FROM \"hotel-info\" WHERE hotel_id = " + hotelId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                hotelName = resultSet.getString("hotel_name");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelName;
    }

    public static Hotel_Info getHotelInfoById(int hotelId){
        String sqlSelect = "SELECT * FROM \"hotel-info\" WHERE hotel_id = " + hotelId;
        Hotel_Info hotelInfo = null;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                hotelInfo = new Hotel_Info();
                hotelInfo.setHotelId(resultSet.getInt("hotel_id"));
                hotelInfo.setHotelName(resultSet.getString("hotel_name"));
                hotelInfo.setHotelMail(resultSet.getString("hotel_mail"));
                hotelInfo.setHotelPhoneNumber(resultSet.getString("hotel_phone_number"));
                hotelInfo.setCity(resultSet.getString("city"));
                hotelInfo.setDistrict(resultSet.getString("district"));
                hotelInfo.setHotelAddress(resultSet.getString("hotel_address"));
                hotelInfo.setHotelStar(resultSet.getInt("hotel_star"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelInfo;
    }

    public static ArrayList<Hotel_Info> getHotelInfoByHotelId(int hotelId){
        ArrayList<Hotel_Info> infoList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM \"hotel-info\" WHERE hotel_id = " + hotelId;
        Hotel_Info hotelInfo = null;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                hotelInfo = new Hotel_Info();
                hotelInfo.setHotelId(resultSet.getInt("hotel_id"));
                hotelInfo.setHotelName(resultSet.getString("hotel_name"));
                hotelInfo.setHotelMail(resultSet.getString("hotel_mail"));
                hotelInfo.setHotelPhoneNumber(resultSet.getString("hotel_phone_number"));
                hotelInfo.setCity(resultSet.getString("city"));
                hotelInfo.setDistrict(resultSet.getString("district"));
                hotelInfo.setHotelAddress(resultSet.getString("hotel_address"));
                hotelInfo.setHotelStar(resultSet.getInt("hotel_star"));
                infoList.add(hotelInfo);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return infoList;
    }

    public static ArrayList<Hotel_Info> getList(){
        ArrayList<Hotel_Info> hotels = new ArrayList<>();
        String sqlSelect = "SELECT * FROM \"hotel-info\";";
        Hotel_Info hotel_info;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                hotel_info = new Hotel_Info();
                hotel_info.setHotelId(resultSet.getInt("hotel_id"));
                hotel_info.setHotelName(resultSet.getString("hotel_name"));
                hotel_info.setHotelMail(resultSet.getString("hotel_mail"));
                hotel_info.setHotelPhoneNumber(resultSet.getString("hotel_phone_number"));
                hotel_info.setCity(resultSet.getString("city"));
                hotel_info.setDistrict(resultSet.getString("district"));
                hotel_info.setHotelAddress(resultSet.getString("hotel_address"));
                hotel_info.setHotelStar(resultSet.getInt("hotel_star"));
                hotels.add(hotel_info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    //Should be return true
    private static boolean validationOfMail(String hotelMail){
        String sqlSelect = "SELECT hotel_name FROM \"hotel-info\" WHERE hotel_mail = ?";
        String hotelName = null;

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1, hotelMail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                hotelName = resultSet.getString("hotel_name");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(hotelName == null){
            return true;
        }else{
            return false;
        }
    }

    //Should be return true
    private static boolean validationOfPhoneNumber(String hotelPhoneNumber){
        String sqlSelect = "SELECT hotel_name FROM \"hotel-info\" WHERE hotel_phone_number = ?";
        String hotelName = null;

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1, hotelPhoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                hotelName = resultSet.getString("hotel_name");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(hotelName == null){
            return true;
        }else{
            return false;
        }
    }
}
