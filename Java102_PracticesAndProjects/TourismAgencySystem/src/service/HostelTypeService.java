package service;

import general.DbConnector;
import model.HostelType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HostelTypeService {

    public static boolean add(int hotelId, String ultraAllIn, String allIn, String roomBreakfast, String fullPension, String halfPension, String onlyBed, String fullCreditNotAlcohol){
        boolean key = false;
        String sqlInsert = "INSERT INTO \"hostel-type\"(hotel_id, ultra_all_in, all_in, room_breakfast, full_pension, half_pension, only_bed, full_credit_not_alcohol)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, ultraAllIn);
            preparedStatement.setString(3, allIn);
            preparedStatement.setString(4, roomBreakfast);
            preparedStatement.setString(5, fullPension);
            preparedStatement.setString(6, halfPension);
            preparedStatement.setString(7, onlyBed);
            preparedStatement.setString(8, fullCreditNotAlcohol);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static ArrayList<HostelType> getListByHotelId(int hotelId){
        ArrayList<HostelType> hostelTypes = new ArrayList<>();
        String sqlSelect = "SELECT * FROM \"hostel-type\" WHERE hotel_id = " + hotelId;
        HostelType hostelType;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                hostelType = new HostelType();
                hostelType.setHostelTypeId(resultSet.getInt("hostel_type_id"));
                hostelType.setHotelId(resultSet.getInt("hotel_id"));
                hostelType.setUltraAllIn(resultSet.getString("ultra_all_in"));
                hostelType.setAllIn(resultSet.getString("all_in"));
                hostelType.setRoomBreakfast(resultSet.getString("room_breakfast"));
                hostelType.setFullPension(resultSet.getString("full_pension"));
                hostelType.setHalfPension(resultSet.getString("half_pension"));
                hostelType.setOnlyBed(resultSet.getString("only_bed"));
                hostelType.setFullCreditNotAlcohol(resultSet.getString("full_credit_not_alcohol"));
                hostelTypes.add(hostelType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hostelTypes;
    }

    public static HostelType getHostelTypeByHotelId(int hotelId){
        String sqlSelect =  "SELECT * FROM \"hostel-type\" WHERE hotel_id = " + hotelId;
        HostelType hostelType = null;

        try {
            Statement statement =  DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                hostelType = new HostelType();
                hostelType.setHostelTypeId(resultSet.getInt("hostel_type_id"));
                hostelType.setHotelId(resultSet.getInt("hotel_id"));
                hostelType.setUltraAllIn(resultSet.getString("ultra_all_in"));
                hostelType.setAllIn(resultSet.getString("all_in"));
                hostelType.setRoomBreakfast(resultSet.getString("room_breakfast"));
                hostelType.setFullPension(resultSet.getString("full_pension"));
                hostelType.setHalfPension(resultSet.getString("half_pension"));
                hostelType.setOnlyBed(resultSet.getString("only_bed"));
                hostelType.setFullCreditNotAlcohol(resultSet.getString("full_credit_not_alcohol"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hostelType;
    }
}
