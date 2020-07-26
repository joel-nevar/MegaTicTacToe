package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;

import java.util.ArrayList;

public class PlayerService {

    private Lobby lobby;

    public void registerPlayer(PlayerHandler player){

        synchronized (lobby) {

            ArrayList<Room> rooms = lobby.getRooms();

            for (Room room : rooms) {

                if (!room.checkRoomIsFull()) {
                    room.addPlayer(player);
                    return;
                }
            }

            Room room = new Room(player);
            lobby.addRoom(room);
        }
    }


    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }


}
