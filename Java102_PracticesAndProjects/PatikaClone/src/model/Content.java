package model;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int contentId;
    private String contentTitle;
    private String contentExplanation;
    private String contentLink;
    private int quizId;
    private int courseId;

    private Quiz quiz;
    private Course course;

    public Content(int contentId, String contentTitle, String contentExplanation, String contentLink, int quizId, int courseId) {
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.contentExplanation = contentExplanation;
        this.contentLink = contentLink;
        this.quiz = Quiz.getQuizById(quizId);
        this.course = Course.getCourseById(courseId);
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentExplanation() {
        return contentExplanation;
    }

    public void setContentExplanation(String contentExplanation) {
        this.contentExplanation = contentExplanation;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<Content> getList(){
        ArrayList<Content> contentList = new ArrayList<>();
        String sqlSelect =  "SELECT * FROM content";
        Content content;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                int contentId = resultSet.getInt("content_id");
                String contentTitle = resultSet.getString("content_title");
                String contentExplanation = resultSet.getString("content_explanation");
                String contentLink = resultSet.getString("content_link");
                int quizId = resultSet.getInt("quiz_id");
                int courseId = resultSet.getInt("course_id");
                content = new Content(contentId, contentTitle, contentExplanation, contentLink, quizId, courseId);
                contentList.add(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;
    }

    public static boolean add(String contentTitle, String contentExplanation, String contentLink, int quizId, int courseId){
        boolean key = false;
        String sqlInsert = "INSERT INTO content(content_title, content_explanation, content_link, quiz_id, course_id)\n" +
                "\tVALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setString(1, contentTitle);
            preparedStatement.setString(2, contentExplanation);
            preparedStatement.setString(3, contentLink);
            preparedStatement.setInt(4, quizId);
            preparedStatement.setInt(5, courseId);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static boolean update(String contentTitle, String contentExplanation, int quizId, int contentId){
        boolean key = false;
        String sqlUpdate = "UPDATE content SET content_title=?, content_explanation=?, quiz_id=? WHERE content_id = ?;";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, contentTitle);
            preparedStatement.setString(2, contentExplanation);
            preparedStatement.setInt(3, quizId);
            preparedStatement.setInt(4, contentId);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static boolean delete(int contentId){
        boolean key = false;
        String sqlDelete = "DELETE FROM content WHERE content_id = ?";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, contentId);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static Content getContentById(int contentId){
        String sqlSelect = "SELECT * FROM content WHERE content_id = ?";
        Content content = null;
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setInt(1, contentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int content_id = resultSet.getInt("content_id");
                String contentTitle = resultSet.getString("content_title");
                String contentExplanation = resultSet.getString("content_explanation");
                String contentLink = resultSet.getString("content_link");
                int quizId = resultSet.getInt("quiz_id");
                int courseId = resultSet.getInt("course_id");
                content = new Content(content_id, contentTitle, contentExplanation, contentLink, quizId, courseId);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static String searchQuery(String contentTitle, int courseId){
        String sqlSearch = "SELECT * FROM content WHERE content_title LIKE '%{{content_title}}% AND course_id = " + courseId;
        sqlSearch = sqlSearch.replace("{{content_title}}", contentTitle);
        return sqlSearch;
    }

    public static ArrayList<Content> searchList(int courseId, String contentTitle){
        ArrayList<Content> contentList =  new ArrayList<>();
        String sqlSearch = "SELECT * FROM content WHERE content_title LIKE '%{{content_title}}%' AND course_id = ?";
        sqlSearch = sqlSearch.replace("{{content_title}}", contentTitle);

        Content content;

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSearch);
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int contentId = resultSet.getInt("content_id");
                String content_title = resultSet.getString("content_title");
                String contentExplanation = resultSet.getString("content_explanation");
                String contentLink = resultSet.getString("content_link");
                int quizId = resultSet.getInt("quiz_id");
                int course_id = resultSet.getInt("course_id");
                content = new Content(contentId, content_title, contentExplanation, contentLink, quizId, course_id);
                contentList.add(content);

                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }

        return contentList;


    }
}
