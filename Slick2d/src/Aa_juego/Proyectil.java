/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aa_juego;

/**
 *
 * @author dante
 */

public class Proyectil {

    
    public enum TipoProyectil{NORMAL,BOMB};
    private double xLocation;
    private double yLocation;
    private double xDestination;
    private double yDestination;
    private double xInit;
    private double yInit;
    private double damage;
    private double speedBullet = 10;
    private TipoProyectil tipoProy;
    private Subdito target;
    private boolean hit = false;
    //private int TowerLevel;
    
    public Proyectil(double xIn, double yIn, double xDest, double yDest, double dmg, Subdito tgt, TipoProyectil proy){

        this.xInit = xIn;
        this.yInit = yIn;
        this.xDestination = xDest;
        this.yDestination = yDest;
        this.hit = false;
        this.target = tgt;
        this.tipoProy = proy;
        this.damage = dmg;
        this.xLocation = xIn +12*Math.cos(angleOfProjectileInRadians());
        this.yLocation = yIn +12*Math.sin(angleOfProjectileInRadians());

    }
    
    
    private double angleOfProjectileInRadians() {
        return Math.atan2(yDestination-yInit, xDestination-xInit);
    }
   
    public void proyectileMove(){
        if (Math.abs(xLocation - xDestination)< speedBullet/2 || Math.abs(yLocation - yDestination)< speedBullet/2){
            hit = true;
            target.takeDamage(damage);
    }   else{
            xLocation += speedBullet*Math.cos(angleOfProjectileInRadians());
            yLocation += speedBullet*Math.sin(angleOfProjectileInRadians());
        }
    }

    public double getxLocation() {
        return xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public double getSpeedBullet() {
        return speedBullet;
    }

    public TipoProyectil getTipoProy() {
        return tipoProy;
    }

    public boolean isHit() {
        return hit;
    }
   
}
