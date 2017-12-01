/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

/**
 * World object, handles specific data regarding object
 * @author Sean
 */
public class World {
       
    public int worldID;
    public boolean Exists = true; 
    private int maxNPCs = 1;
    private int maxPlayers = 1;

    public World() {
        //do nothing for now
    
    }
    
    public World(int maxNPC, int maxPlayers){
        
        this.Exists = true;
        this.maxNPCs = maxNPC;
        this.maxPlayers = maxPlayers;
        
        //Add this world to the list
        
        
        System.out.print("Starting world - maxNPC: " + maxNPCs + " | maxPlayers: " + maxPlayers + "\n");
    }
   
    public boolean exists(){
        return this.Exists;
    }
    
    public void shutdown() {
        this.Exists = false;
    }
    
    
}
