package model;

import general.DbConnector;
import general.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int user_id;
    private String name_surname;
    private String username;
    private String password;
    private String type;

    public User(){};

    public User(int user_id, String name_surname, String username, String password, String type) {
        this.user_id = user_id;
        this.name_surname = name_surname;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int uder_id) {
        this.user_id = uder_id;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();

        String sqlSelect = "SELECT * FROM \"user\"";

        User obj;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()){
                obj = new User();
                obj.setUser_id(resultSet.getInt("user_id"));
                obj.setName_surname(resultSet.getString("name_surname"));
                obj.setUsername(resultSet.getString("username"));
                obj.setPassword(resultSet.getString("password"));
                obj.setType(resultSet.getString("user_type"));

                userList.add(obj);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static boolean add(String nameSurname, String username, String password, String userType ){
        boolean key = true;

        String sqlInsert = "INSERT INTO \"user\"(\n" +
                "\tname_surname, username, password, user_type)\n" +
                "\tVALUES (?, ?, ?, ?);";

        if(validationOfUsername(username) == null){
            try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlInsert);
                preparedStatement.setString(1, nameSurname);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3,  password);
                preparedStatement.setString(4,  userType);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                key = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            key = false;
            Helper.showMessage("duplicate");
        }

        return key;
    }

    public static boolean delete(int user_id){
        boolean key = false;
        String sqlDelete = "DELETE FROM \"user\" WHERE user_id = ?";

        ArrayList<Course> courseList = Course.getListByUserId(user_id);
        for(Course course : courseList){
            Course.delete(course.getCourseId());
        }

        try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlDelete);
                preparedStatement.setInt(1, user_id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                key = true;
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return key;
    }

    public static boolean update(int userId, String nameSurname, String username, String password, String userType){
        boolean key = false;
        String sqlUpdate =  "UPDATE \"user\"\n" + "\tSET name_surname=?, username=?, password=?, user_type=?\n" + "\tWHERE user_id=?;";

        if(validationOfUsername(username) != null && validationOfUsername(username).getUser_id() == userId){
            try {
                PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlUpdate);
                preparedStatement.setString(1, nameSurname);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, userType);
                preparedStatement.setInt(5, userId);
                preparedStatement.executeUpdate();
                key = true;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            key = false;
        }

        return key;
    }

    public static User getUserById(int userId){
        String sqlSelect = "SELECT * FROM \"user\" WHERE user_id = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setName_surname(resultSet.getString("name_surname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("user_type"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static ArrayList<User> searchList(String query){
        ArrayList<User> userList = new ArrayList<>();

        User obj;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                obj = new User();
                obj.setUser_id(resultSet.getInt("user_id"));
                obj.setName_surname(resultSet.getString("name_surname"));
                obj.setUsername(resultSet.getString("username"));
                obj.setPassword(resultSet.getString("password"));
                obj.setType(resultSet.getString("user_type"));

                userList.add(obj);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static String searchQuery(String name_surname, String username, String user_type){
        String sqlSearch = "SELECT * FROM \"user\" WHERE name_surname LIKE '%{{name_surname}}%' AND username LIKE '%{{username}}%' AND user_type LIKE '%{{user_type}}%' ";
        sqlSearch = sqlSearch.replace("{{name_surname}}", name_surname);
        sqlSearch = sqlSearch.replace("{{username}}", username);
        sqlSearch = sqlSearch.replace("{{user_type}}", user_type);
        return sqlSearch;
    }

    public static User login(String username, String password) {
        String sqlSelect = "SELECT * FROM \"user\" WHERE username = ? AND password = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                switch(resultSet.getString("user_type")){
                    case "Operator":
                        user = new Operator();
                        break;
                    default:
                        user = new User();
                }
                user.setUser_id(resultSet.getInt("user_id"));
                user.setName_surname(resultSet.getString("name_surname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //If username was not taken this method should be return null
    private static User validationOfUsername(String username){
        String sqlSelect = "select * from public.\"user\" where username = ?";
        User user = null;
        user = getUser(username, sqlSelect, user);

        if(user == null){ //This username not taken
            return null;
        }else{
            return user; //This username taken
        }
    }

    //ıf user exist method must be return true
    private static boolean validationOfIsUserExist(int user_id){
        String sqlSelect = "select * from public.\"user\" where user_id = ?";
        User user = null;
        user = getUser(String.valueOf(user_id), sqlSelect, user);

        if(user != null){
            return true;
        }else{
            Helper.showMessage("delete");
            return false;
        }
    }

    private static User getUser(String str, String sqlSelect, User user) {
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sqlSelect);
            preparedStatement.setString(1, str);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setName_surname(resultSet.getString("name_surname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
