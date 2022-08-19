package service;

import general.DbConnector;
import model.Amenity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AmenityService {

    public static boolean add(int hotelId, String parkingFree, String freeWifi, String swimmingPool, String fitnessCenter, String hotelConcierge, String spa, String roomService){
        boolean key = false;
        String sqlInsert = "INSERT INTO amenity(hotel_id, free_parking, free_wifi, swimming_pool, fitness_center, hotel_concierge, spa, room_service)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, parkingFree);
            preparedStatement.setString(3, freeWifi);
            preparedStatement.setString(4, swimmingPool);
            preparedStatement.setString(5, fitnessCenter);
            preparedStatement.setString(6, hotelConcierge);
            preparedStatement.setString(7, spa);
            preparedStatement.setString(8, roomService);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static ArrayList<Amenity> getAmenityByHotelId(int hotelId){
        ArrayList<Amenity> amenityList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM amenity WHERE hotel_id = " + hotelId;
        Amenity amenity ;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                amenity = new Amenity();
                amenity.setAmenityId(resultSet.getInt("amenity_id"));
                amenity.setHotelId(resultSet.getInt("hotel_id"));
                amenity.setFreeParking(resultSet.getString("free_parking"));
                amenity.setFreeWifi(resultSet.getString("free_wifi"));
                amenity.setSwimmingPool(resultSet.getString("swimming_pool"));
                amenity.setFitnessCenter(resultSet.getString("fitness_center"));
                amenity.setHotelConcierge(resultSet.getString("hotel_concierge"));
                amenity.setSpa(resultSet.getString("spa"));
                amenity.setRoomService(resultSet.getString("room_service"));
                amenityList.add(amenity);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amenityList;
    }
}
