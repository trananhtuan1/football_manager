package service;

import model.Football;
import model.FootballForm;
import model.Teams;

import java.sql.SQLException;
import java.util.List;

public interface FootballService {
    List<FootballForm> findAll() throws ClassNotFoundException, SQLException;

    void save(Football football) throws ClassNotFoundException, SQLException;

    Football findById(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Football football) throws ClassNotFoundException, SQLException;

    void remove(int id) throws ClassNotFoundException, SQLException;
}
