package com.lti.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

// here the relation is bidirectional as song has obj of album and vice-versa
public class AlbumSongTest {

	/*
	 * @Test public void addNewAlbumAlongWithSomeSongs() { Album album = new
	 * Album(); album.setAlbumName("Hamari Adhuri kahani");
	 * album.setProductionHouse("T-series"); Song s1 = new Song();
	 * s1.setName("Humari Adhuri kahani"); s1.setDuration(300); s1.setAlbum(album);
	 * // in db song has album id so keeping that in mind
	 * 
	 * Song s2 = new Song(); s2.setName("Hasi bangaye "); s2.setDuration(1220);
	 * s2.setAlbum(album);
	 * 
	 * Song s3 = new Song(); s3.setName("Aey Humnava "); s3.setDuration(680);
	 * s3.setAlbum(album);
	 * 
	 * GenericDao dao = new GenericDao(); dao.merge(album); dao.merge(s1);
	 * dao.merge(s2); dao.merge(s3);
	 */

	@Test
	public void addNewAlbum() { // to add album first and then song after that
		Album album = new Album();
		album.setAlbumName("Hamari Adhuri kahani");
		album.setProductionHouse("T-series");
		GenericDao dao = new GenericDao();
		dao.merge(album);
	}

	@Test
	public void addSongsToExistingAlbum() {// add song now aftr adding album
		GenericDao dao = new GenericDao();
		Album album = dao.fetch(Album.class, 121);// check album id in db
		Song s1 = new Song();
		s1.setName("Humari Adhuri kahani");
		s1.setDuration(300);
		s1.setAlbum(album); // in db song has album id so keeping that in mind

		Song s2 = new Song();
		s2.setName("Hasi bangaye ");
		s2.setDuration(1220);
		s2.setAlbum(album);

		Song s3 = new Song();
		s3.setName("Aey Humnava ");
		s3.setDuration(680);
		s3.setAlbum(album);

		dao.merge(album);
		dao.merge(s1);
		dao.merge(s2);
		dao.merge(s3);

	}

	@Test
	public void addNewAlbumAlongWiithSomeSongs() {// adding simultanously album and song
		Album a = new Album();

	
		a.setAlbumName("Java 75511111");
		a.setProductionHouse("LTI");

		Song s1 = new Song();
		s1.setName("hum hogeh kamiyab abhi.....");
		s1.setDuration(129);
        s1.setAlbum(a);
		Song s2 = new Song();
		s2.setName("We will rock now......");
		s2.setDuration(1292);
		 s2.setAlbum(a);
		
		Set<Song> songs = new HashSet<>();
		songs.add(s1);
		songs.add(s2);
		
		a.setSongs(songs);
		

		GenericDao dao = new GenericDao();
		dao.merge(a);

	}

}
