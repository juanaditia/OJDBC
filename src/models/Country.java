/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS BAE YA
 */
public class Country {
    private String id;
    private String name;
    private int idr;

    public Country() {
    }

    public Country(String id, String name, int idr) {
        this.id = id;
        this.name = name;
        this.idr = idr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public void display(){
       System.out.println("Id: "+ id +" Country: "+name+" IdRegion: "+idr);
   }

    
}
