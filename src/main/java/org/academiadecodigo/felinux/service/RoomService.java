package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;
import org.academiadecodigo.felinux.mvc.view.GameView;

public class RoomService {
    private Room room;
    private PlayerController playerController1;
    private PlayerController playerController2;


    public RoomService(Room room){
        this.room =room;
    }

    public void gameLoop(){
        System.out.println("Before loopfgggggggggggggggggggggggggggggggg");
        PlayerHandler player1 = room.getPlayer1();
        PlayerHandler player2 = room.getPlayer2();

        playerController1 = player1.getController();
        playerController2 = player2.getController();


        while(true) {
            System.out.println(Thread.currentThread().getName());
            playerController1.listenToPlayer();
            //notifyAll();
            playerController2.listenToPlayer();
        }
    }
}
