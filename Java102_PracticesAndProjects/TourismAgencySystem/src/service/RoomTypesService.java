package service;

import general.DbConnector;
import model.RoomTypes;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class RoomTypesService {

    public static boolean add(int hotelId, String roomType, int roomAmount, int bedNumber, String hasTv, String hasMinibar, String hasGameConsole,double size, String hasCashBox, String hasProjection, int stock){
        boolean key = false;
        String sqlInsert = "INSERT INTO public.\"room-types\"(hotel_id, room_type, room_amount, bed_number, has_tv, has_minibar, has_game_console," +
                " size, has_cash_box, has_projection, stock)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, roomAmount);
            preparedStatement.setInt(4, bedNumber);
            preparedStatement.setString(5,hasTv);
            preparedStatement.setString(6,hasMinibar);
            preparedStatement.setString(7,hasGameConsole);
            preparedStatement.setDouble(8, size);
            preparedStatement.setString(9, hasCashBox);
            preparedStatement.setString(10, hasProjection);
            preparedStatement.setInt(11, stock);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static ArrayList<RoomTypes> getListByHotelId(int hotelId){
        ArrayList<RoomTypes> roomTypeList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM \"room-types\" WHERE hotel_id = " + hotelId;
        RoomTypes roomTypes;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                roomTypes = new RoomTypes();
                roomTypes.setRoomId(resultSet.getInt("room_id"));
                roomTypes.setHotelId(resultSet.getInt("hotel_id"));
                roomTypes.setRoomType(resultSet.getString("room_type"));
                roomTypes.setRoomAmount(resultSet.getInt("room_amount"));
                roomTypes.setBedNumber(resultSet.getInt("bed_number"));
                roomTypes.setHasTv(resultSet.getString("has_tv"));
                roomTypes.setHasMinibar(resultSet.getString("has_minibar"));
                roomTypes.setHasGameConsole(resultSet.getString("has_game_console"));
                roomTypes.setSize(resultSet.getDouble("size"));
                roomTypes.setHasCashBox(resultSet.getString("has_cash_box"));
                roomTypes.setHasProjection(resultSet.getString("has_projection"));
                roomTypes.setStock(resultSet.getInt("stock"));
                roomTypeList.add(roomTypes);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypeList;
    }

    public static ArrayList<RoomTypes> getRoomTypeByRoomId(int roomId){
        ArrayList<RoomTypes> roomTypeList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM \"room-types\" WHERE room_id = " + roomId;
        RoomTypes roomTypes;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                roomTypes = new RoomTypes();
                roomTypes.setRoomId(resultSet.getInt("room_id"));
                roomTypes.setHotelId(resultSet.getInt("hotel_id"));
                roomTypes.setRoomType(resultSet.getString("room_type"));
                roomTypes.setRoomAmount(resultSet.getInt("room_amount"));
                roomTypes.setBedNumber(resultSet.getInt("bed_number"));
                roomTypes.setHasTv(resultSet.getString("has_tv"));
                roomTypes.setHasMinibar(resultSet.getString("has_minibar"));
                roomTypes.setHasGameConsole(resultSet.getString("has_game_console"));
                roomTypes.setSize(resultSet.getDouble("size"));
                roomTypes.setHasCashBox(resultSet.getString("has_cash_box"));
                roomTypes.setHasProjection(resultSet.getString("has_projection"));
                roomTypes.setStock(resultSet.getInt("stock"));
                roomTypeList.add(roomTypes);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypeList;
    }


    public static RoomTypes getRoomTypesById(int roomId){
        String sqlSelect = "SELECT * FROM \"room-types\" WHERE room_id = " + roomId;
        RoomTypes roomTypes = null;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                roomTypes = new RoomTypes();
                roomTypes.setRoomId(resultSet.getInt("room_id"));
                roomTypes.setHotelId(resultSet.getInt("hotel_id"));
                roomTypes.setRoomType(resultSet.getString("room_type"));
                roomTypes.setRoomAmount(resultSet.getInt("room_amount"));
                roomTypes.setBedNumber(resultSet.getInt("bed_number"));
                roomTypes.setHasTv(resultSet.getString("has_tv"));
                roomTypes.setHasMinibar(resultSet.getString("has_minibar"));
                roomTypes.setHasGameConsole(resultSet.getString("has_game_console"));
                roomTypes.setSize(resultSet.getDouble("size"));
                roomTypes.setHasCashBox(resultSet.getString("has_cash_box"));
                roomTypes.setHasProjection(resultSet.getString("has_projection"));
                roomTypes.setStock(resultSet.getInt("stock"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypes;
    }

    public static ArrayList<RoomTypes> listRooms(){
        ArrayList<RoomTypes> roomTypeList = new ArrayList<>();
        String sqlSelect = "SELECT room_id, room_type, hotel_id FROM \"room-types\" WHERE stock > 0";
        RoomTypes roomTypes;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while ((resultSet.next())){
                int roomId = resultSet.getInt("room_id");
                String roomType = resultSet.getString("room_type");
                int hotelId = resultSet.getInt("hotel_id");
                roomTypes = new RoomTypes(roomId, roomType, hotelId);
                roomTypeList.add(roomTypes);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypeList;
    }

    public static ArrayList<RoomTypes> searchRooms(String hotelName, String city, String district){
        ArrayList<RoomTypes> roomTypeList = new ArrayList<>();
        String sqlSelect = "SELECT room.room_id, room.hotel_id, room.room_type FROM \"room-types\" AS room\n" +
                "LEFT JOIN \"hotel-info\" AS hotel ON hotel.hotel_id = room.hotel_id\n" +
                "WHERE room.stock > 0 AND hotel.hotel_name = ? AND hotel.city = ? AND hotel.district = ?";
        RoomTypes roomTypes ;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1, hotelName);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, district);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ((resultSet.next())){
                int roomId = resultSet.getInt("room_id");
                String roomType = resultSet.getString("room_type");
                int hotelId = resultSet.getInt("hotel_id");
                roomTypes = new RoomTypes(roomId, roomType, hotelId);
                roomTypeList.add(roomTypes);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypeList;
    }

    public static int getHotelIdByRoomId(int roomId){
        int hotelId = 0;
        String sqlSelect = "SELECT hotel_id FROM \"room-types\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                hotelId = resultSet.getInt("hotel_id");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelId;
    }

    public static String getTypeByRoomId(int roomId){
        String roomType = " ";
        String sqlSelect = "SELECT room_type FROM \"room-types\" WHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                roomType = resultSet.getString("room_type");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomType;
    }

    public static int getRoomStockNumber(int roomId){
        int stockNumber = 0;
        String sqlSelectRoomStock = "Select stock FROM \"room-types\" \tWHERE room_id = " + roomId;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelectRoomStock);
            while (resultSet.next()){
                stockNumber = resultSet.getInt("stock");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockNumber;
    }

    public static boolean decreaseRoomStockNumber(int roomId){
        boolean key = false;
        int newStock = getRoomStockNumber(roomId) - 1;
        String sqlUpdate = "UPDATE \"room-types\" SET stock = ? WHERE room_id = ? ";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setInt(2, roomId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

}
