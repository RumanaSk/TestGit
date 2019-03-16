package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ALBUM")
public class Album {

	@Id         //primary key
    @GeneratedValue  //auto generate primary key
   
private int id;
private String albumName;
private String productionHouse;
@OneToMany(mappedBy="album" , cascade=CascadeType.ALL) // to show that this table doesn't have the fk,  here album is the obj in song class
private Set<Song> songs;
// cascade is like domino effect whatver we will will do with (parent)album it wil get automatically done on songs(child) too 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAlbumName() {
	return albumName;
}
public void setAlbumName(String albumName) {
	this.albumName = albumName;
}
public String getProductionHouse() {
	return productionHouse;
}
public void setProductionHouse(String productionHouse) {
	this.productionHouse = productionHouse;
}
public Set<Song> getSongs() {
	return songs;
}
public void setSongs(Set<Song> songs) {
	this.songs = songs;
}


}
