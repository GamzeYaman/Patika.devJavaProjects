package model;

import general.DbConnector;

import java.sql.*;
import java.util.ArrayList;

public class StudentCourse {
    private int studentCourseId;
    private int userId;
    private int courseId;
    private User user;
    private Course course;

    public StudentCourse(int studentCourseId, int userId, int courseId){
        this.studentCourseId = studentCourseId;
        this.user = User.getUserById(userId);
        this.course = Course.getCourseById(courseId);
    }

    public int getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(int studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public static ArrayList<StudentCourse> getList(){
        ArrayList<StudentCourse> studentCourseList = new ArrayList<>();
        StudentCourse studentCourse;

        String sqlSelect =  "SELECT * FROM \"student-course\";";

        try {
            Statement statement =  DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int studentCourseId = resultSet.getInt("student_course_id");
                int userId = resultSet.getInt("user_id");
                int course_id = resultSet.getInt("course_id");
                studentCourse = new StudentCourse(studentCourseId, userId, course_id);
                studentCourseList.add(studentCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourseList;
    }


    public static boolean add(int userId, int courseId){
        boolean key = false;
        String sqlInsert = "INSERT INTO \"student-course\"(user_id, course_id) VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();
            key = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }
}
