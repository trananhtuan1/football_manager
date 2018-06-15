package service;

import model.Football;

import java.sql.SQLException;
import java.util.List;

public interface FootballService {
    List<Football> findAll() throws ClassNotFoundException, SQLException;

    void save(Football football) throws ClassNotFoundException, SQLException;

    Football findById(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Football football) throws ClassNotFoundException, SQLException;

    void remove(int id) throws ClassNotFoundException, SQLException;
}
