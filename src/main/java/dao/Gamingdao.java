package dao;

import entity.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Gamingdao {

    private Connection conn;

    public Gamingdao() {
        try {
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GamingApp", "postgres", "gaurav123");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public boolean addGame(Game game) {
        boolean isAdded = false;
        try {
            CallableStatement statement = this.conn.prepareCall("{Call insert_game(?,?,?)}");
            statement.setInt(1, game.getGame_id());
            statement.setString(2, game.getGame_name());
            statement.setInt(3, game.getNo_of_players());
            isAdded = statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    public Game findGame(Integer id) {
        Game game = null;
        try {
            CallableStatement statement= this.conn.prepareCall("{Call getGameById(?)}");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                game = new Game(result.getInt("game_id"), result.getString("game_name"), result.getInt("no_of_players"));
            }
            return game;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Game> getAllGame() {
        List<Game> gameList=new ArrayList<>();
        try {
            CallableStatement statement = this.conn.prepareCall("{Call getAllGames()}");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                gameList.add(new Game(result.getInt("game_id"), result.getString("game_name"), result.getInt("no_of_players")));
            }
            return gameList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteGame(Integer id) {
        boolean isDeleted  = false;
        try {
            CallableStatement statement= this.conn.prepareCall("{Call deleteGame_by_id(?)}");
            statement.setInt(1, id);
            isDeleted = statement.execute();
            return isDeleted;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateGame(Integer id,String name, int players) {
        Game game = null;
        try {
            CallableStatement statement= this.conn.prepareCall("{Call updateGame_by_id(?,?,?)}");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, players);

            boolean result = statement.execute();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}


