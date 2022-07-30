package model;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Comment {
    private int commentId;
    private int userId;
    private int courseId;
    private int evaluation;
    private String comment;
    private User user;
    private Course course;

    public Comment(int commentId, int userId, int courseId, int evaluation, String comment){
        this.commentId = commentId;
        this.evaluation = evaluation;
        this.comment = comment;
        this.user = User.getUserById(userId);
        this.course = Course.getCourseById(courseId);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public static ArrayList<Comment> getCommentByCourseId(int course_id){
        ArrayList<Comment> commentList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM public.comment WHERE course_id = " + course_id;

        Comment comment;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int commentId = resultSet.getInt("comment_id");
                int userId = resultSet.getInt("user_id");
                int courseId = resultSet.getInt("course_id");
                int evaluation = resultSet.getInt("evaluation");
                String commentContent = resultSet.getString("comment");
                comment = new Comment(commentId, userId, courseId, evaluation, commentContent);
                commentList.add(comment);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commentList;
    }

    public static boolean add(int userId, int courseId, int evaluation, String comment){
        boolean key = false;
        String sqlInsert = "INSERT INTO public.comment(user_id, course_id, evaluation, comment) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.setInt(3, evaluation);
            preparedStatement.setString(4, comment);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }
}
