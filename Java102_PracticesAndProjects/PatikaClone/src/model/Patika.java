package model;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int patikaId;
    private String patikaName;

    public Patika(){}

    public Patika(int patikaId, String patikaName) {
        this.patikaId = patikaId;
        this.patikaName = patikaName;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getPatikaName() {
        return patikaName;
    }

    public void setPatikaName(String patikaName) {
        this.patikaName = patikaName;
    }

    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikaList = new ArrayList<>();

        String sqlSelect =  "SELECT * FROM patika;";

        Patika obj;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                obj = new Patika();
                obj.setPatikaId(resultSet.getInt("patika_id"));
                obj.setPatikaName(resultSet.getString("patika_name"));

                patikaList.add(obj);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  patikaList;
    }

    public static boolean add(String patikaName){
        boolean key = false;
        String sqlInsert = "INSERT INTO patika(patika_name) VALUES (?);" ;

        if(validationOfPatikaName(patikaName) == null){
            try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
                preparedStatement.setString(1, patikaName);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                key = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            key = false;
        }

        return key;
    }

    public static boolean update(int patikaId, String patikaName){
        boolean key = false;
        String sqlUpdate = "UPDATE patika SET patika_name=? WHERE patika_id = ?;";


            try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlUpdate);
                preparedStatement.setString(1, patikaName);
                preparedStatement.setInt(2, patikaId);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                key = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }



        return key;

    }

    public static Patika getPatikaById(int patikaId){
        String sqlSelect = "SELECT * FROM patika WHERE patika_id = ?";
        Patika patika = null;
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setInt(1, patikaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patika = new Patika();
                patika.setPatikaId(resultSet.getInt("patika_id"));
                patika.setPatikaName(resultSet.getString("patika_name"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patika;
    }

    public static boolean delete(int patikaId){
        boolean key = false;
        String sqlDelete = "DELETE FROM \"patika\" WHERE patika_id = ?";

        ArrayList<Course> courseList = Course.getList();
        for(Course course: courseList){
            if(course.getPatika().getPatikaId() == patikaId){
                Course.delete(course.getCourseId());
            }
        }

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, patikaId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            key = true ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    private static Patika validationOfPatikaName(String patikaName){
        String sqlSelect = "SELECT * FROM patika WHERE patika_name = ?";
        Patika patika = null;
        patika = getPatika(patikaName, sqlSelect, patika);

        if(patika == null){//This patika name not taken
            return null;
        }else{
            return patika; //This patika name taken
        }

    }
    private static Patika getPatika(String str, String query, Patika patika){
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, str);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patika = new Patika();
                patika.setPatikaId(resultSet.getInt("patika_id"));
                patika.setPatikaName(resultSet.getString("patika_name"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patika;
    }
}
