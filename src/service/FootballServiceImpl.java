package service;

import model.Football;
import model.FootballForm;
import model.Teams;

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
    public List<FootballForm> findAll() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "SELECT fm.id,fm.name, fm.age, fm.height, fm.nationality, fm.postion, t.name as teamName" +
                " from football_manager as fm left join teams as t on fm.teamId=t.id";
        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<FootballForm> footballs = new ArrayList<>();
        while (resultSet.next()) {
            FootballForm footballForm = new FootballForm();
            footballForm.setId(resultSet.getInt("id"));
            footballForm.setName(resultSet.getString("name"));
            footballForm.setAge(resultSet.getInt("age"));
            footballForm.setHeight(resultSet.getInt("height"));
            footballForm.setNationality(resultSet.getString("nationality"));
            footballForm.setPostion(resultSet.getString("postion"));
            footballForm.setTeamName(resultSet.getString("teamName"));
            footballs.add(footballForm);
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

        String sql = "INSERT INTO football_manager(name, age, height, nationality, postion, teamId) values(?, ?, ? ,? ,?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, football.getName());
        preparedStatement.setInt(2, football.getAge());
        preparedStatement.setInt(3, football.getHeight());
        preparedStatement.setString(4, football.getNationality());
        preparedStatement.setString(5, football.getPostion());
        preparedStatement.setInt(6, football.getTeamId());

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
            football.setTeamId(resultSet.getInt("teamId"));
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
        sql = "UPDATE football_manager SET name = ?, age = ?, height = ?, nationality = ?, postion = ?, name = ? where id = ?";
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
