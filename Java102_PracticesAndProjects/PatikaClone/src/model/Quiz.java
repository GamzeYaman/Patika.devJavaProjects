package model;

import general.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int quizId;
    private String quizName;
    private String userNameSurname;

    public Quiz(){}

    public Quiz(int quizId, String quizName, String userNameSurname){
        this.quizId = quizId;
        this.quizName = quizName;
        this.userNameSurname = userNameSurname;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getUserNameSurname() {
        return userNameSurname;
    }

    public void setUserNameSurname(String userNameSurname) {
        this.userNameSurname = userNameSurname;
    }

    public static ArrayList<Quiz> getList(){
        ArrayList<Quiz> quizList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM quiz;";

        Quiz quiz;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("quiz_id"));
                quiz.setQuizName(resultSet.getString("quiz_name"));
                quiz.setUserNameSurname(resultSet.getString("name_surname"));
                quizList.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }

    public static boolean add(String quizName, String userNameSurname){
        boolean key = false;
        String sqlInsert =  "INSERT INTO public.quiz(\n" +
                "\tquiz_name, name_surname)\n" +
                "\tVALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
            preparedStatement.setString(1, quizName);
            preparedStatement.setString(2, userNameSurname);
            preparedStatement.executeUpdate();
            key = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }

    public static Quiz getQuizById(int quizId){
        String sqlSelect =  "SELECT * FROM quiz WHERE quiz_id = ?";
        Quiz quiz = null;

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setInt(1, quizId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("quiz_id"));
                quiz.setQuizName(resultSet.getString("quiz_name"));
                quiz.setUserNameSurname(resultSet.getString("name_surname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quiz;
    }
}
