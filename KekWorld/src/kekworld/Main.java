/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import java.util.Scanner;

/**
 *
 * @author Sean
 */
public class Main {

    public static boolean gameRunning = true;
    public static String playerChatReturnValue;
    public static int yourID;    
    
    //interface specific
    public static boolean playerCommandPending = false;
    public static boolean enableInterface = false;

    
            //World handler
    public static WorldHandler worldHandler = new WorldHandler();
    public static GameContainer gameWindow = new GameContainer();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create instance of gameWindow for use
        
               
        // Start of game here
        
        //start world
        World world1 = new World(0, 10);
        //add world to worldList
        worldHandler.addWorld(world1);
        
        //populate list of players
        PlayerHandler playerHandler = new PlayerHandler();
        
         
        //adds 8 players for testing purposes, otherwise this would be populated by each new login attempt from client
        for(int x = 0; x < 8; x++){
        try { 
            playerHandler.addPlayer(new Player(x, "bob" + x, 10, 0));
            
        }catch(Exception e){
                    System.out.println(e);
                    }
        
        }
        
        //debugging purposes
        playerHandler.listAllPlayers();
        
        //Have to assign a player ID for game client, in this case server and client are one
        gMsg("Before we begin, who are you?");
        setID(playerHandler.playerList.size()); //sets yourID
       
        //ask for your name and create an object for that
        //if((playerHandler.gamePlayerInput("What is your name?") == null)){
        playerHandler.addPlayer(new Player(playerHandler.playerList.size(), new PlayerHandler().gamePlayerInput("What is your name?"), 10, 1));
        //}
        
           gMsg("Type cmd followed by a keyword to do a command. Commands are: whoami, playerlist, eat, attack, done, quit");
           gMsg("Type 'Done' to end your turn.");
           
           
        if(enableInterface) {
            gameWindow.setVisible(true);
            //begin game loop, if no worlds, close game server
            while((worldHandler.listSize() > 0)) {

                //set death status to all players who are actually dead
               playerHandler.deathCycle();

                //ask for input from player            
                //check input, required to input which player is using command for all healing and dmg/rights
                //yourID defined at WHO ARE YOU question
                //String return value is assigned to playerChatReturnValue so I can 
                //if(gameWindow.isActive() == true) {
                    //listen for value from gameWindow?
                    playerChatReturnValue = gameWindow.getPlayerInput();           
                    /*
                    }else {
                    playerChatReturnValue = playerHandler.checkChat(new PlayerHandler().gamePlayerInput("What next?"), playerHandler.selectPlayer(yourID));
                    gMsg("Game Window is not focused");
                }
                    */


               if(playerCommandPending) {

                playerHandler.checkChat(gameWindow.getPlayerInput(), playerHandler.selectPlayer(yourID));

                switch(playerChatReturnValue){
                    case "done":
                        playerHandler.dmgBotAttackPhase();
                        break;
                    case "gameFrame":
                        gameWindow.setVisible(true);
                        break;
                    case "shutdown":
                        worldHandler.removeWorld(world1);
                        break;
                    default:
                        //do nothing
                }


              //listen for an input value from gamewindow
               }
              playerCommandPending = false;
              playerChatReturnValue = null;
            }
        } else {
            //begin game loop, if no worlds, close game server
            while((worldHandler.listSize() > 0)) {

                //set death status to all players who are actually dead
                //double check, should a playerHandler method not check at end
               playerHandler.deathCycle();

                //ask for input from player            
                //check input, required to input which player is using command for all healing and dmg/rights
                //yourID defined at WHO ARE YOU question
                //String return value is assigned to playerChatReturnValue so it can be used in Main
                    playerChatReturnValue = playerHandler.checkChat(new PlayerHandler().gamePlayerInput("What next?"), playerHandler.selectPlayer(yourID));

            if(playerChatReturnValue == null) {
                //do nothing since null
            } else {
               switch(playerChatReturnValue){
                   //bossCycleDone is returned from bossfight, this needs to be done so we can run a deathCycle
                   //to reflect what has done and then finish the playerChatReturnValue cycle, then while loop should continue
                    case "bossCycleDone":
                        //nothing
                        break;
                    case "done":
                        playerHandler.dmgBotAttackPhase();
                        break;
                    case "gameFrame":
                        gameWindow.setVisible(true);
                        break;
                    case "shutdown":
                        worldHandler.removeWorld(world1);
                        break; 

                    default:
                        //do nothing
                        break;
                }  
            }
           
            
            playerChatReturnValue = null;
        }
        }
           
        
        /* 
        *   here we run all of the game saving information to database
        *   save all world, player, npc data for continued use later down the road
        */       
        System.out.println("The game has ended, thanks for playing!");
    }
       
    public static void gMsg(String msg){
        System.out.println(msg);
        gameWindow.updateGameInterface(msg + "\n");
    }
    
    public static void setID(int id) {
        Main.yourID = id;
    }
    
    public static void shutdown(World w){
       System.out.println("Attempting to close game.");
        Main.gameRunning = false;
        Main.worldHandler.removeWorld(w);
        w = null;
    }
    /*
    public synchronized String getPlayerInput(){
        
        while(playerChatReturnValue.isEmpty()){
            try{
                wait();
            } catch (InterruptedException e) {}
        }
        
        return playerChatReturnValue;
        
        }
        
    }
*/

}
