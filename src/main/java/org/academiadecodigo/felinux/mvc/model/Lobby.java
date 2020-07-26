package org.academiadecodigo.felinux.mvc.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Lobby {

    private ArrayList<MegaRoom>megaRooms;
    private ArrayList <Room> rooms;
    private HashSet<PlayerHandler> players;



    public Lobby(){

        rooms = new ArrayList<>();
        players = new HashSet<>();
        megaRooms = new ArrayList<>();
    }

    public void addMegaRoom(MegaRoom megaRoom){
        megaRooms.add(megaRoom);
    }
    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room>getRooms(){
        return rooms;
    }

    public ArrayList<MegaRoom> getMegaRooms() {
       return megaRooms;
    }
}
