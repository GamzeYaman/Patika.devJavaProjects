package model;

import general.DbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Educator extends User{

    public Educator(int user_id, String name_surname, String username, String password, String type) {
        super(user_id, name_surname, username, password, type);
    }

    /*public static ArrayList<Course> getEducatorCourseList(User educator){
        ArrayList<Course> courseList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM course WHERE user_id = " + educator.getUser_id();

        Course course;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
