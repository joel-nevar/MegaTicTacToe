package org.academiadecodigo.felinux.service;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.mvc.controller.*;
import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;
import org.academiadecodigo.felinux.mvc.view.GameOverView;
import org.academiadecodigo.felinux.mvc.view.GameView;
import org.academiadecodigo.felinux.mvc.view.MenuView;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;

import java.io.*;

public class BootStrap {

    public static CentralController centralController;

    public static void init(){

        try {

            //Todo passar isto pra ServerStartService ou merda assim

            Prompt serverPrompt = new Prompt(System.in, System.out);

          /*  IntegerRangeInputScanner portScanner = new IntegerRangeInputScanner(0,16000);
            portScanner.setMessage("Insert a port number to initialize the server\n");
            portScanner.setError("A valid one thx\n");
            int port = serverPrompt.getUserInput(portScanner);*/
            int port = 9000;

            centralController = new CentralController();
            Lobby lobby = new Lobby();
            PlayerService playerService = new PlayerService();

            centralController.setLobby(lobby);
            centralController.setPlayerService(playerService);

            playerService.setLobby(lobby);


            Server server = new Server(port);
            server.setCentralController(centralController);
            //This says Client Found
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initPlayer(PlayerHandler playerHandler) throws IOException {

        PrintWriter printWriter = new PrintWriter(playerHandler.getSocket().getOutputStream(), true);
        Prompt prompt = new Prompt(playerHandler.getSocket().getInputStream(),
                new PrintStream(playerHandler.getSocket().getOutputStream()));

        MenuView menuView = new MenuView();
        menuView.setPrompt(prompt);
        menuView.setWriter(printWriter);

        MainController mainController = new MainController();
        mainController.setMenuView(menuView);
        menuView.setMainController(mainController);

        GameView gameView = new GameView();
        gameView.setPrompt(prompt);
        gameView.setWriter(printWriter);

        GameOverView gameOverView = new GameOverView();
        gameOverView.setPrompt(prompt);
        gameOverView.setWriter(printWriter);

        SinglePlayerView singlePlayerView = new SinglePlayerView();
        singlePlayerView.setPrompt(prompt);
        singlePlayerView.setWriter(printWriter);

        PlayerController playerController = new PlayerController();
        playerController.setGameView(gameView);
        playerController.setPlayer(playerHandler);
        playerController.setMainController(mainController);

        GameOverController gameOverController = new GameOverController();
        gameOverController.setGameOverView(gameOverView);
        gameOverController.setMainController(mainController);

        SinglePlayerController singlePlayerController = new SinglePlayerController();
        singlePlayerController.setSinglePlayerView(singlePlayerView);
        singlePlayerController.setGameOverController(gameOverController);

        mainController.setPlayerController(playerController);
        mainController.setPlayerHandler(playerHandler);
        mainController.setCentralController(centralController);

        gameView.setController(playerController);
        singlePlayerView.setSinglePlayerController(singlePlayerController);
        gameOverView.setGameOverController(gameOverController);

        playerHandler.setController(mainController);
        playerHandler.setPlayerController(playerController);


    }
}
