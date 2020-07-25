package org.academiadecodigo.felinux.mvc.model;

import java.util.ArrayList;

public class Lobby {

    private ArrayList <Room> rooms;

    public Lobby(){

        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room>getRooms(){
        return rooms;
    }
}
