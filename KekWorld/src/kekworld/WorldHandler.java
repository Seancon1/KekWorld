/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import java.util.LinkedList;

/**
 * Class to handle all game worlds active on the server.
 * @author Sean
 */
public class WorldHandler {
        
    /*
    * Linked list to hold all worlds
    */
     public LinkedList<World> worldList = new LinkedList<World>();
     
     public WorldHandler() {
         
         
     }
     
     public void addWorld(World addWorld) {
         //Add world to our worldHandler
         worldList.add(addWorld);
     }
     
     public void removeWorld(World removeWorld) {
     worldList.remove(removeWorld);
     }
     
     public void listWorlds() {
         for(World world : worldList) {
             System.out.println(world + " - " + world.exists());
         }
     }
     
     public int listSize(){
         return worldList.size();
     }
}
