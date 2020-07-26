package org.academiadecodigo.felinux.mvc.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Lobby {

    private ArrayList <Room> rooms;
    private HashSet<PlayerHandler> players;

    public Lobby(){

        rooms = new ArrayList<>();
        players = new HashSet<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room>getRooms(){
        return rooms;
    }
}
