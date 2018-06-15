package service;

import model.Teams;

import java.util.List;
import java.sql.SQLException;

public interface TeamsService {
    List<Teams> findAll() throws ClassNotFoundException, SQLException;

    void save(Teams teams) throws ClassNotFoundException, SQLException;

    Teams findById(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Teams teams) throws ClassNotFoundException, SQLException;

    void remove(int id) throws ClassNotFoundException, SQLException;
}
