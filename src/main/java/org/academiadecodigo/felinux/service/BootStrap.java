package org.academiadecodigo.felinux.service;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.felinux.mvc.controller.CentralController;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;
import org.academiadecodigo.felinux.mvc.view.GameView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
            //This says Client Found
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initPlayer(PlayerHandler playerHandler) throws IOException {

        InputStreamReader streamReader = new InputStreamReader(playerHandler.getSocket().getInputStream());
        OutputStreamWriter streamWriter = new OutputStreamWriter(playerHandler.getSocket().getOutputStream());

        Prompt prompt = new Prompt(playerHandler.getSocket().getInputStream(), System.out);

        GameView playerScreen = new GameView();
        playerScreen.setPrompt(prompt);

        PlayerController controller = new PlayerController();
        controller.setView(playerScreen);
        controller.setPlayer(playerHandler);

        playerScreen.setController(controller);

        playerHandler.setController(controller);
    }
}
