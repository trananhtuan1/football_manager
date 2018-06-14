package service;

import model.Teams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamsServiceImpl implements TeamsService {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/football";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123456";

    public TeamsServiceImpl() {
    }

    @Override
    public List<Teams> findAll() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "SELECT * FROM teams";
        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Teams> teams = new ArrayList<>();
        while (resultSet.next()) {
            Teams teams1 = new Teams();
            teams1.setId(resultSet.getInt("id"));
            teams1.setName(resultSet.getString("name"));
            teams.add(teams1);
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();

        return teams;
    }

    @Override
    public void save(Teams teams) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "INSERT INTO teams(name) value ( ? )";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, teams.getName());

        int insertRecord = preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    @Override
    public Teams findById(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM TEAMS WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Teams teams = new Teams();
        while (resultSet.next()) {
            teams.setId(resultSet.getInt("id"));
            teams.setName(resultSet.getString("name"));
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();

        return teams;
    }

    @Override
    public void update(int id, Teams teams) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement preparedStatement = null;
        String sql;
        sql = "UPDATE teams SET name = ? WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, teams.getId());
        preparedStatement.setString(2, teams.getName());

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
        sql = "DELETE FROM teams WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int insertRecord = preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();

    }
}
