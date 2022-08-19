package service;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class HotelPeriodService {

    public static boolean add(int hotelId, Date firstPeriodStart, Date firstPeriodEnd, Date secondPeriodStart, Date secondPeriodEnd){
        boolean key = false;
        String sqlInsert = "INSERT INTO public.\"hotel-period\"(hotel_id, first_period_start, first_period_end, second_period_start, second_period_end)\n" +
                "\tVALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setDate(2, firstPeriodStart);
            preparedStatement.setDate(3, firstPeriodEnd);
            preparedStatement.setDate(4, secondPeriodStart);
            preparedStatement.setDate(5, secondPeriodEnd);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }
}

