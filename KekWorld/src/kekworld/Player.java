/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekworld;

import java.util.Objects;

/**
 *
 * @author Sean
 */
public class Player {
    
    //Identifying information
    private int ID;
    private final String Name;
    private int HP;
    private final int playerRights;
    private boolean isDead;
    
    private int strengthLevel;
    private int defenceLevel;

    
    
    public Player(int id, String Name, int HP, int playerRights) {
        this.ID = id;
        this.Name = Objects.requireNonNull(Name);
        this.HP = HP;
        this.playerRights = playerRights;
        this.strengthLevel = 1;        
        this.defenceLevel = 1;
        this.isDead = false;

        
        //System.out.println("Adding player: " + Name);
    }
    
    public String getName() {
        return Name;
    }
    
    public int getHP() {
        return HP;
    }
    
    public int getPlayerRights(){ 
        return playerRights;
    }
    
    public boolean getDeathStatus() {
     return isDead;
    }
    
    public int takeTrueDMG(int hp) {
        //does the dmg done to the player
        HP += (hp);
        return hp;
    }
    
    public int takeDMG(int pendingDMG) {
        //here we can calculate dmg considering armor
        HP += (pendingDMG);
        return pendingDMG;
    }
    
    /*
    * Enables the change in death status to true or false. isDead = true/false;
    */
    public void setDeathStatus(boolean status) {
       isDead = status;
    }
    
}
