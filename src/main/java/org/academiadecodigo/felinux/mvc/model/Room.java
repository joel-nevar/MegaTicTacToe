package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;

import java.util.concurrent.SynchronousQueue;

public class Room {


    private PlayerHandler player1;
    private PlayerHandler player2;

    private boolean roomIsFull = false;

    private Grid grid;

    private SynchronousQueue<String> queue;

    public Room(PlayerHandler player1){

        queue = new SynchronousQueue<>();
        this.player1 = player1;
        grid = new Grid();
        player1.setYourTurn();
        player1.setRoom(this);
    }

    public void addPlayer(PlayerHandler player2) {
        this.player2 = player2;
        roomIsFull = true;
    }

    public boolean checkRoomIsFull(){
        return roomIsFull;
    }

    public void addToQueue(String message){

        System.out.println("queue add");
        queue.add(message);
    }

    public String removeFromQueue(){

        System.out.println("queue remove");
        return queue.poll();
    }
}
