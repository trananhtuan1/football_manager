package service;

import model.Football;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballServiceImpl implements FootballService {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/football";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123456";

    public FootballServiceImpl() {
    }

    @Override
    public List<Football> findAll() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "SELECT * FROM football_manager";
        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Football> footballs = new ArrayList<>();
        while (resultSet.next()) {
            Football football = new Football();
            football.setId(resultSet.getInt("id"));
            football.setName(resultSet.getString("name"));
            football.setAge(resultSet.getInt("age"));
            football.setHeight(resultSet.getInt("height"));
            football.setNationality(resultSet.getString("nationality"));
            football.setPostion(resultSet.getString("postion"));
            footballs.add(football);
        }
        resultSet.close();
        connection.close();
        preparedStatement.close();

        return footballs;
    }

    @Override
    public void save(Football football) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "INSERT INTO football_manager(name, age, height, nationality, postion) values(?, ?, ? ,? ,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, football.getName());
        preparedStatement.setInt(2, football.getAge());
        preparedStatement.setInt(3, football.getHeight());
        preparedStatement.setString(4, football.getNationality());
        preparedStatement.setString(5, football.getPostion());

        int insertRecord = preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();
    }

    @Override
    public Football findById(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement preparedStatement = null;
        String sql;
        sql = "SELECT * FROM football_manager where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Football football = new Football();
        while (resultSet.next()) {
            football.setId(resultSet.getInt("id"));
            football.setName(resultSet.getString("name"));
            football.setAge(resultSet.getInt("age"));
            football.setHeight(resultSet.getInt("height"));
            football.setNationality(resultSet.getString("nationality"));
            football.setPostion(resultSet.getString("postion"));
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();

        return football;
    }

    @Override
    public void update(int id, Football football) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "UPDATE football_manager SET name = ?, age = ?, height = ?, nationality = ?, postion = ? where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, football.getName());
        preparedStatement.setInt(2, football.getAge());
        preparedStatement.setInt(3, football.getHeight());
        preparedStatement.setString(4, football.getNationality());
        preparedStatement.setString(5, football.getPostion());
        preparedStatement.setInt(6, football.getId());

        int insertRecord = preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();
    }

    @Override
    public void remove(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "DELETE FROM football_manager where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int insertRecord = preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }
}
