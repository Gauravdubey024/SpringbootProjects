package controller;

import dao.Gamingdao;
import entity.Game;

import java.util.List;
import java.util.Scanner;

public class GamingAppController {

    public static void main(String[] args) {


        Gamingdao dao = new Gamingdao();

        System.out.println(dao.findGame(10));

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n======================================Welcome to the Gaming app==========================================\n");

        boolean z = true;
        while (z) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("\n1.Add game 2. Find Game  3. Delete Game  4.Update Game Details  5.Get All Games  6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter game to add: ");
                    System.out.println("Enter game Id : ");
                    Integer gameId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter game Name : ");
                    String gameName = sc.nextLine();
                    System.out.println("Enter game players count : ");
                    int players = sc.nextInt();

                    Game game = new Game(gameId, gameName, players);
                    try {
                        System.out.println(dao.addGame(game));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter game id  : ");
                    sc.nextLine();
                    gameId = sc.nextInt();
                    try {
                        System.out.println(dao.findGame(gameId));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter game Id to be deleted : ");
                    Integer id = sc.nextInt();

                    try {

                        System.out.println(dao.deleteGame(id));

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    System.out.println("Enter game Id to be Updated : ");
                    Integer sid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter game Name:");
                    String sname = sc.nextLine();
                    System.out.println("Enter no of Players:");
                    int no_of_players = sc.nextInt();


                    System.out.println(dao.updateGame(sid, sname, no_of_players));

                    break;

                case 6:
                    z = false;
                    break;
                default:
                    System.out.println("Invalid Choice!! Please try again.....");
                    break;
                case 5:
                    List<Game> list = dao.getAllGame();
                    for (Game g :list){
                        System.out.println(g);
                    }

            }

        }
    }
}
