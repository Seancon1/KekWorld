/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import java.util.*;
import static kekworld.Main.gMsg;


/**
 *
 * @author seanc
 */
public class PlayerHandler  {
    
    //This will handle all players, this will be used in the World class

    /**
     *List will hold all current players where needed
     */
    public LinkedList<Player> playerList = new LinkedList<Player>();
    
    public PlayerHandler() {
    
    }
    
    public void addPlayer(Player player) {
        if(player == null) {
            //do nothing bc null
        } else {
        playerList.add(player);
        }
    }
    
    /*
    *Main form of receiving player input via text in cmd
    */
    public String gamePlayerInput(String statement){
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println(statement);
            
            String input = reader.nextLine();
            
            return input;
        }
    
    /*
    Lists all players in system out, each player is displayed on a new line
    Displays Name, HP
    */
    public void listAllPlayers(){
        
        System.out.println("Listing all players:");
        try {
           playerList.forEach((player) -> {
            Main.gMsg(player.getName() + " HP: "+ player.getHP());
        });
 
        } catch (Exception e){
            //do nothing 
            
        }
        
    }
    /*
    *Gets player via id
    */
    public Player selectPlayer(int id){
        try {
        return playerList.get(id);
        } catch (Exception e) {
            System.out.println(e);
            return playerList.getLast();
        }
    }
    
    /**
     * Gets input and player object, this ensures that all commands can effect the user
     * @param input
     * @param player 
     */
    public String checkChat(String input, Player player) {
        //
        
        if(input.isEmpty()) {
            //empty
            Main.gMsg("You said nothing, try again?");
        } else{
            
        if(input.startsWith("done")) {
            return "done";
        }
        
        /*
                if(input.startsWith("git")) {
          return "gameFrame";
        }
        */
        
        if(input.startsWith("help")) {
          gMsg("Type cmd followed by a keyword to do a command. Commands are: whoami, playerlist, eat, attack, done, quit");
          gMsg("Type 'Done' to end your turn.");
        }
           
        if(input.startsWith("bossfight")) {
            //We needed this new thread to also be able to call methods from the new class THREAD, so we also pass
            //this PlayerHandler class into the argument so we can call methods from it
            //Process ID 2, executes the doBossCycle() thread
          Thread newTestThread = new Thread(new ThreadHandler(player, 2, this));
          newTestThread.start();
          return "bossCycleDone";
        }
        
        if(input.startsWith("cmd")){
            //Main.gMsg("Command detected ->");
            
          if(input.contains("eat")) {
              player.takeTrueDMG(+2);
              Main.gMsg("You eat some food. You now have " + player.getHP() + " HP");
              
          }
          
          if(input.contains("whoami")) {
              Main.gMsg("Your stats: " + player.getName() + " - HP:" + player.getHP() +" Rights: "+ player.getPlayerRights()); 
          }
          
          if(input.contains("listplayers") || input.contains("list") || input.contains("playerlist")) {
              listAllPlayers(); 
              playersAlive();
              playersDead();
          }
          
          if(input.contains("worlds")) {
              Main.gMsg("Listing all worlds...");
  
          }
          
          if(input.contains("done")) {    
            return "done";
          }
                    
          if(input.contains("attack")) {
              String ID = gamePlayerInput("Attack what player?");
              //default 2 dmg so far, this will depend on weapons and other variables
              dmgToPlayer(ID, -2, player); //dmg -> player IS not defined here
              
              }
              
          
          
         
          
          if(input.contains("quit")) {
             //This uses method in main to change gameRunning value to false, closing the world
             //are you sure?
             
             //Main.shutdown();
             return "shutdown";
          }
          
          }
        }
        return null;
        }
    

    
    public void dmgToPlayer(String playerName, int dmg, Player self){  
        
              for(Player playerA1 : playerList){
                  if(playerA1.getName().toLowerCase().equals(playerName.toLowerCase())){
                      playerA1.takeTrueDMG(-dmg);
                      Main.gMsg("You hit " + playerA1.getName() + " they now have " + playerA1.getHP() + " HP.");
                    }
              }
                  //Random rebound dmg that can effect you as well
                  //30% chance for recoil
                  if(getRandomNumber(0, 10) >= 8){
                      self.takeTrueDMG(-1);
                      Main.gMsg("Recoil from the attack does 1 dmg. ");
                  }
    }
              
        
    public void dmgAllPlayers(int min, int max) {
        Player chosenPlayer;
        try{
            for (int i = 0; i < playerList.size()-5; i++){
                 chosenPlayer = playerList.get(getRandomNumber(0, playerList.size()-1));
                 
                if(getRandomNumber(0,10) > 6 & isPlayerAlive(chosenPlayer) ) {
                    Main.gMsg(chosenPlayer.getName() + " dodges the projectile and remains unscathed.");
                } else if (!isPlayerAlive(chosenPlayer)) {
                    //do nothing since player is dead
                } else {
                   Main.gMsg(chosenPlayer.getName() + " has been hit " + chosenPlayer.takeTrueDMG(-getRandomNumber(min, max)));    
                }
                //we need to check which person is dead after dmg is inflicted, this needs to be done before the Main while() loop can cycle through
                //so when someone dies, they cannot cheat death by healing before deathCycle()
            deathCycle();
            }
            
            
            /*
             for(Player player1 : playerList) {
                 player1.takeTrueDMG(getRandomNumber(min, max));
                Main.gMsg(player1.getName() + " takes damage.");   
             }
            */
        }catch(Exception x){
                 Main.gMsg("unable to deal damage: " + x);
        }

    }
    
    /*
    * Allows each alive bot to attack another alive target player, this is done at random.
    */
    public void dmgBotAttackPhase() {
        
        for(Player player : playerList) {
            if(player.getPlayerRights() == 0 && player.getDeathStatus() == false) {
                
                Player randomPlayerID = playerList.get(getRandomNumber(0, playerList.size()-1));

                Main.gMsg("Player " + player.getName() + " attacks " + randomPlayerID.getName() + " for " + randomPlayerID.takeTrueDMG(-getRandomNumber(0,2)) + " dmg.");
                
            }
        }
    }
    
    public void deathCycle(){
        for(Player player : playerList) {
            if(player.getHP() <= 0 && player.getDeathStatus() == false) {
                Main.gMsg(player.getName() + " has died.");
                //Instead of completely removing player from playerList, put isDead status to true. So we can distinguish between alive or dead.
                player.setDeathStatus(true);
                
                //playerList.remove(player);
            }
        }
    }
    
    public void playersAlive() {
        Main.gMsg("Players Alive:");
            for(Player player : playerList) {
                if(player.getDeathStatus() == false) {
                    
                    Main.gMsg(player.getName() + " and has " + player.getHP() + "HP");
                    
                }
            }
    }
    
    public boolean isPlayerAlive(Player player) {
        if(player.getDeathStatus() == false) { 
            //check player death status, true=not dead, false=dead
            return true;
        }
        return false;
    }
    
        public void playersDead() {
        Main.gMsg("Players Dead:");
            for(Player player : playerList) {
                if(player.getDeathStatus() == true) {                  
                    Main.gMsg(player.getName());
                    
                }
            }
    }
    
    public Player isPlayerAvailable(Player playerSearch) {
    //search for player in playerlist
    for(Player player1 : playerList){
    if(playerList.contains(playerSearch)) {
        Main.gMsg("Found player " + playerSearch);
        return playerSearch;
    }
    }
    return null;
    }
    
    
    
    public int getRandomNumber(int min, int max) {
        Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;
        }   
}
