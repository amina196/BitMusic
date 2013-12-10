/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
<<<<<<< HEAD
 * @author MB
=======
 * @author Jib
>>>>>>> cf7cb7431903a9b956447e2ea6bf985d4a4a5a5f
 */
public class SongLibraryTest {
    
    public SongLibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getlibrary method, of class SongLibrary.
     */
    @Test
    public void testGetlibrary() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        ArrayList<Song> expResult = songs;
        ArrayList<Song> result = library.getlibrary();
        assertEquals(expResult, result);

    }

    /**
     * Test of setlibrary method, of class SongLibrary.
     */
    @Test
    public void testSetlibrary() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        library.setlibrary(new ArrayList<Song>());
        assertTrue(library.getlibrary().isEmpty());

    }

    /**
     * Test of islocal method, of class SongLibrary.
     */
    @Test
    public void testIslocal() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        
        String songId = "2";
        boolean result = library.islocal(songId);
        assertTrue(result);

    }

    /**
     * Test of getSong method, of class SongLibrary.
     */
    @Test
    public void testGetSong() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        
        String songId = "2";

        Song result = library.getSong(songId);
        assertTrue(result.getTitle().equals("titre2"));
        assertTrue(result.getAlbum().equals("album2"));
        assertTrue(result.getArtist().equals("artiste2"));
        assertTrue(result.getSongId().equals("2"));

    }

    /**
     * Test of removeSong method, of class SongLibrary.
     */
    @Test
    public void testRemoveSong() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        
        String songId = "1";
        
        library.removeSong(songId);
        
        assertFalse(library.islocal("1"));
        assertTrue(library.islocal("2"));
        

    }

    /**
     * Test of addSong method, of class SongLibrary.
     */
    @Test
    public void testAddSong() {

        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        SongLibrary library = new SongLibrary(songs);
        
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), new HashMap<String,Rights>());
        library.addSong(song2);
        
        assertTrue(library.islocal(song2.getSongId()));
        assertTrue(library.islocal(song1.getSongId()));

    }

    /**
     * Test of addCategory method, of class SongLibrary.
     */
    @Test
    public void testAddCategory() {

        HashMap<String,Rights> rightsByCat1 = new HashMap<String,Rights>();
        rightsByCat1.put("family", new Rights(true,true,false,false));
        rightsByCat1.put("friends", new Rights(true,true,true,false));
        
        HashMap<String,Rights> rightsByCat2 = new HashMap<String,Rights>();
        rightsByCat2.put("judo", new Rights(true,true,true,true));
        rightsByCat2.put("yoga", new Rights(false,false,false,false));
        
        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), rightsByCat1);
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), rightsByCat2);
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        
        String name = "karate";
        Rights rights = new Rights(false, true, false, true);
        library.addCategory(name, rights);
        
        assertTrue(library.getSong("1").getRightsByCategory().containsKey("karate"));
        assertTrue(library.getSong("2").getRightsByCategory().containsKey("karate"));

    }

    /**
     * Test of removeCategory method, of class SongLibrary.
     */
    @Test
    public void testRemoveCategory() {

        HashMap<String,Rights> rightsByCat1 = new HashMap<String,Rights>();
        rightsByCat1.put("family", new Rights(true,true,false,false));
        rightsByCat1.put("friends", new Rights(true,true,true,false));
        
        HashMap<String,Rights> rightsByCat2 = new HashMap<String,Rights>();
        rightsByCat2.put("judo", new Rights(true,true,true,true));
        rightsByCat2.put("yoga", new Rights(false,false,false,false));
        
        Song song1 = new Song("1", "titre1", "artiste1", "album1", "1", new LinkedList<String>(), rightsByCat1);
        Song song2 = new Song("2", "titre2", "artiste2", "album2", "2", new LinkedList<String>(), rightsByCat2);
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        SongLibrary library = new SongLibrary(songs);
        
        library.removeCategory("family");
        assertFalse(library.getSong("1").getRightsByCategory().containsKey("family"));

    }
    
}
