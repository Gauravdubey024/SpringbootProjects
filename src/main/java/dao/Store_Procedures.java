package dao;

public class Store_Procedures {

//  DB : Postgres


    //#################################################getGameById############################################


    /*CREATE OR REPLACE FUNCTION getGameById(IN gameId int) RETURNS Game_table
    LANGUAGE SQL
    AS $$
    SELECT * FROM Game_table WHERE game_Id= gameId;
    $$;*/

    //##########################################updateGame_by_id##############################################

   /* CREATE OR REPLACE FUNCTION updateGame_by_id(games_id INT,games_name VARCHAR(30), no_of_playerss INT)/RETURNS VOID
    AS $$
    BEGIN
    UPDATE Game_table
    SET game_name =games_name, no_of_players = no_of_playerss WHERE game_id = games_id;
    END;
    $$ LANGUAGE plpgsql;*/


    // ###########################################deleteGame_by_id##############################################

   /* CREATE OR REPLACE FUNCTION deleteGame_by_id(games_id INT)
    returns VOID
    AS $$
    BEGIN
    delete from Game_Table where game_id =games_id;
    END;
    $$ LANGUAGE plpgsql;*/


   //###################################insert_game##############################################

   /*CREATE OR REPLACE FUNCTION insert_game(games_id INT, games_name VARCHAR(30), no_of_playerss INT)
    RETURNS VOID AS $$
    BEGIN
    INSERT INTO Game_table (game_id, game_name, no_of_players)
    VALUES (games_id, games_name, no_of_playerss);
    END;
    $$ LANGUAGE plpgsql;*/

    //###################################getAllGames##############################################


    /*CREATE OR REPLACE FUNCTION getAllGames()
    RETURNS SETOF game_table
    AS
        'select * from game_table'
    LANGUAGE SQL;*/




//************************************************************************************************************************


}
