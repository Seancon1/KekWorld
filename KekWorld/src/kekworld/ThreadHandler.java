/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import java.util.Random;

/**
 *
 * @author Sean
 */
public class ThreadHandler implements Runnable {
    
    //PlayerHandler playerHandler = new PlayerHandler();
        //Define some variables to use in this instance
    private Player player1;    
    private int processID;    
    private PlayerHandler playerHandler;
    
    public ThreadHandler(Player player, int processID, PlayerHandler playerHandler){
        this.player1 = player;
        this.processID = processID;        
        this.playerHandler = playerHandler;

    }
    
    public void run(){
        try{
            switch(processID){
                case 1:
                    simpleRepeat(player1.getName());
                    break;
                case 2:
                    //do boss event
                    Main.gMsg("The boss fight has started.");
                    doBossCycle();
                    
                    break;
                default:
                    //do nothing?
                    break;
            }
            
        } catch (Exception e) {
            Main.gMsg(e.toString());
        }
            
        //simpleRepeat(player1.getName());
    }
    


      

    
    //PlayerHandler playerHandler = new PlayerHandler();
    
    public void simpleRepeat(String pass){
        
        int counter=0;
        Random randomGen = new Random();

        while(counter < 5) {
         Main.gMsg("Hitting player " + pass + " - for 1 hp :" + randomGen.nextInt(100));
         player1.takeTrueDMG(-1);
         
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                //do nothing right now
            }
         counter++;
        
        }
    }
    
     public void doBossCycle() {
         Main.gMsg("--Bossfight--"); 
         Main.gMsg("You can do commands while the fight happens.");
         Main.gMsg("King Gerald: You will not survive my wrath!");

         for (int i = 0; i < 5; i++) {
         try {
                Main.gMsg("King Gerald swings throwing projectiles and debris.");
                playerHandler.dmgAllPlayers(5, 10);
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                //do nothing right now
                Main.gMsg("The boss dismisses himself, you are not strong enough.");
                
            }
         
         }
         
         Main.gMsg("The king has stopped his rampage for now.");
           
     }
        
    }

