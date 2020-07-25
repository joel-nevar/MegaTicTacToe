package org.academiadecodigo.felinux.service;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.felinux.mvc.controller.CentralController;
import org.academiadecodigo.felinux.mvc.controller.Controller;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;
import org.academiadecodigo.felinux.mvc.view.GameView;
import org.academiadecodigo.felinux.mvc.view.PlayerPrompt;

import java.io.IOException;

public class BootStrap {

    public static void init(){

        try {

            //Todo passar isto pra ServerStartService ou merda assim

            Prompt serverPrompt = new Prompt(System.in, System.out);

            IntegerRangeInputScanner portScanner = new IntegerRangeInputScanner(0,16000);
            portScanner.setMessage("Insert a port number to initialize the server\n");
            portScanner.setError("A valid one thx\n");
            int port = serverPrompt.getUserInput(portScanner);

            CentralController centralController = new CentralController();
            Lobby lobby = new Lobby();
            PlayerService playerService = new PlayerService();

            centralController.setLobby(lobby);
            centralController.setPlayerService(playerService);

            playerService.setLobby(lobby);


            Server server = new Server(port);
            server.setCentralController(centralController);
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static PlayerController initPlayer(PlayerHandler playerHandler) {

        System.out.println("broculos grelhados");

        PlayerPrompt playerPrompt = new PlayerPrompt(playerHandler.getSocket());
        GameView playerScreen = new GameView();
        playerScreen.setPrompt(playerPrompt);

        System.out.println("gelado de cogumelos");

        PlayerController controller = new PlayerController();
        controller.setView(playerScreen);
        controller.setPlayer(playerHandler);

        System.out.println("penino com chocolate");

        playerScreen.setController(controller);

        System.out.println("kebab");

        return controller;
    }
}
