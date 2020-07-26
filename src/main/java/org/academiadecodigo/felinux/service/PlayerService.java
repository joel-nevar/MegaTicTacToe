package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;

import java.util.ArrayList;

public class PlayerService {

    private Lobby lobby;

    public void registerPlayer(PlayerHandler player){

        MultiPlayerController multiPlayerController = player.getMultiPlayerController();

        synchronized (lobby) {

            ArrayList<Room> rooms = lobby.getRooms();

            for (Room room : rooms) {

                if (!room.checkRoomIsFull()) {
                    room.addPlayer(player);
                    multiPlayerController.transmit("Let the game begin!!!");

                    return;
                }
            }

            Room room = new Room(player);
            multiPlayerController.transmit("Waiting for contestant...");
            lobby.addRoom(room);
        }
    }


    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

}
