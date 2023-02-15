package entity;

public class Game {

    private Integer game_id;
    private String game_name;
    private Integer no_of_players;


    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public Integer getNo_of_players() {
        return no_of_players;
    }

    public void setNo_of_players(Integer no_of_players) {
        this.no_of_players = no_of_players;
    }

    public Game(Integer game_id, String game_name, Integer no_of_players) {
        this.game_id = game_id;
        this.game_name = game_name;
        this.no_of_players = no_of_players;
    }

    @Override
    public String toString() {
        return "entity.Game{" +
                "game_id=" + game_id +
                ", game_name='" + game_name + '\'' +
                ", no_of_players=" + no_of_players +
                '}';
    }
}
