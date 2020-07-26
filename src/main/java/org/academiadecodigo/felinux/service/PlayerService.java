package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;

import java.util.ArrayList;

public class PlayerService {

    private Lobby lobby;
    private PlayerController playerController;

    public void registerPlayer(PlayerHandler player){

        playerController = player.getController();

        synchronized (lobby) {

            ArrayList<Room> rooms = lobby.getRooms();

            for (Room room : rooms) {

                if (!room.checkRoomIsFull()) {
                    room.addPlayer(player);
                    playerController.transmit("Let the game begin!!!");
                    return;
                }
            }

            Room room = new Room(player);
            System.out.println("New Room created by "+Thread.currentThread().getName());
            playerController.transmit("Waiting for contestant...");
            lobby.addRoom(room);
        }
    }


    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }


}
