import dao.Gamingdao;
import entity.Game;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;


import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class GameAppTest
{


    @Mock
    Gamingdao dao = new Gamingdao();

    @Test
    public void addGameTest()
    {
        dao.deleteGame(2000);
        Game game=new Game(2000,"Football",20);
        boolean isAdded = dao.addGame(game);
        assertNotNull(game);
        assertEquals(true, isAdded);
        dao.deleteGame(2000);
    }

    @Test
    public void findGameTest()
    {
            Game game = dao.findGame(10);
            assertEquals(game.getGame_id(),Integer.valueOf(10));

    }

    @Test
    public void deleteGame( )
    {
        Game game=new Game(2000,"Football",20);
        assertNotNull(game);
        dao.addGame(game);
        boolean isAdded = dao.deleteGame(2000);

        assertEquals(true, isAdded);
    }
    @Test
    public void updateGame( )
    {
        dao.deleteGame(2000);
        Game game=new Game(2000,"Football",20);
        dao.addGame(game);
        boolean isUpdated=dao.updateGame(2000,"BasketBall",15);
        assertEquals(true, isUpdated);
        dao.deleteGame(2000);
    }
}
