package model;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int courseId;
    private String courseName;
    private int educatorId;
    private int patikaId;
    private String language;

    private Patika patika;
    private User educator;

    public Course() {}

    public Course(int courseId, String courseName, int educatorId, int patikaId, String language) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.educatorId = educatorId;
        this.patikaId = patikaId;
        this.language = language;
        this.patika = Patika.getPatikaById(patikaId);
        this.educator = User.getUserById(educatorId);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(int educatorId) {
        this.educatorId = educatorId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }

    public static ArrayList<Course> getList(){
        ArrayList<Course> courseList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM course;";

        Course obj;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int educatorId = resultSet.getInt("user_id");
                int patikaId = resultSet.getInt("patika_id");
                String language = resultSet.getString("language");
                obj = new Course(courseId, courseName, educatorId, patikaId, language);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public static boolean add(String courseName, int educatorId, int patikaId, String language ){
        boolean key = false;
        String sqlInsert = "INSERT INTO public.course(\n" +
                "\tcourse_name, user_id, patika_id, language)\n" +
                "\tVALUES (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, educatorId);
            preparedStatement.setInt(3, patikaId);
            preparedStatement.setString(4, language);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static boolean delete(int courseId){
        boolean key = false;
        String sqlDelete = "Delete From course WHERE course_id = ?";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlDelete);
            preparedStatement.setInt(1,courseId);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static ArrayList<Course> getListByUserId(int userId){
        ArrayList<Course> courseList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM course WHERE user_id = " + userId;

        Course obj;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int educatorId = resultSet.getInt("user_id");
                int patikaId = resultSet.getInt("patika_id");
                String language = resultSet.getString("language");
                obj = new Course(courseId, courseName, educatorId, patikaId, language);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public static Course getCourseById(int courseId){
        String sqlSelect = "SELECT * FROM course WHERE course_id = " + courseId;
        Course course = null;

        try {
            Statement statement =  DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int course_id = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int educatorId = resultSet.getInt("user_id");
                int patikaId = resultSet.getInt("patika_id");
                String language = resultSet.getString("language");
                course = new Course(course_id, courseName, educatorId, patikaId, language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
