/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.music.data;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MB
 */
public class SongTest {
    
    public SongTest() {
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
     * Test of addComment method, of class Song.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");
        Comment comment = new Comment("Amina", "comment text");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        instance.addComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getComments().get(0).getComment(),comment.getComment());
    }
    /**
     * Test of addGrade method, of class Song.
     */
    @Test
    public void testAddGrade() {
        System.out.println("addGrade");
        Grade grade = new Grade("Amina", 10);
        Song instance = new Song("1", "titre", "artiste", "album", "1",new LinkedList<String>());
        instance.addGrade(grade);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getGrades().get(new String("Amina")).getGrade(), 10);
    }

    /**
     * Test of deleteGrade method, of class Song.
     */
    @Test
    public void testDeleteGrade() {
        System.out.println("deleteGrade");
        String authorId = "Simo";
        Grade grade = new Grade("Simo", 10);
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        instance.addGrade(grade);
        instance.deleteGrade("Simo");
        assertNull(instance.getGrades().get(new String("Simo")));
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of updateCategory method, of class Song.
     */
    @Test
    public void testUpdateCategory() {
        System.out.println("updateCategory");
        String categoryName = "categorie1";
        HashMap<String,Rights> rightsbycatg = new HashMap<String, Rights>();
        rightsbycatg.put(categoryName, new Rights());
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>(), rightsbycatg);
        instance.updateCategory(categoryName, new Rights(false,false,false,false));
        
        assertFalse(instance.getRightsByCategory().get(categoryName).getcanComment());
        assertFalse(instance.getRightsByCategory().get(categoryName).getcanPlay());
        assertFalse(instance.getRightsByCategory().get(categoryName).getcanRate());
        assertFalse(instance.getRightsByCategory().get(categoryName).getcanReadInfo());
        
    }

    /**
     * Test of deleteCategory method, of class Song.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        
        String categoryName = "categorie1";
        HashMap<String,Rights> rightsbycatg = new HashMap<String, Rights>();
        rightsbycatg.put(categoryName, new Rights());
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>(), rightsbycatg);
        
        instance.deleteCategory(categoryName);
        
        assertNull(instance.getRightsByCategory().get(categoryName));
    }

    /**
     * Test of getSongId method, of class Song.
     */
    @Test
    public void testGetSongId() {
        System.out.println("getSongId");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());;
        String expResult = "1";
        String result = instance.getSongId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTitle method, of class Song.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        String expResult = "titre";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setTitle method, of class Song.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "new Title";
         Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        instance.setTitle(title);
       
        assertEquals(instance.getTitle(),title);
    }

    /**
     * Test of getArtist method, of class Song.
     */
    @Test
    public void testGetArtist() {
        System.out.println("getArtist");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        String expResult = "artiste";
        String result = instance.getArtist();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAlbum method, of class Song.
     */
    @Test
    public void testGetAlbum() {
        System.out.println("getAlbum");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        String expResult = "album";
        String result = instance.getAlbum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTags method, of class Song.
     */
    @Test
    public void testGetTags() {
        System.out.println("getTags");
        LinkedList<String> listTags = new LinkedList<String>();
        listTags.add("myTag");
        Song instance = new Song("1", "titre", "artiste", "album", "1", listTags);   
        assertTrue(instance.getTags().contains(new String("myTag")));
    }

    /**
     * Test of getComments method, of class Song.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Comment comment = new Comment("Amina", "comment text");
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        instance.addComment(comment);
     
        assertEquals(instance.getComments().get(0).getComment(),"comment text");
        assertEquals(instance.getComments().get(0).getAuthor(),"Amina");
    }

    /**
     * Test of getGrades method, of class Song.
     */
    @Test
    public void testGetGrades() {
        System.out.println("getGrades");
        
        Grade grade = new Grade("1", 10);
        Song instance = new Song("1", "titre", "artiste", "album", "1",new LinkedList<String>());
        instance.addGrade(grade);
        
       
        //assertEquals(instance.getGrades().get(0).getAuthorId(),"1");
        
    }

    /**
     * Test of getOwnerId method, of class Song.
     */
    @Test
    public void testGetOwnerId() {
        Song instance = new Song("1", "titre", "artiste", "album", "1", new LinkedList<String>());
        String expResult = "1";
        String result = instance.getOwnerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocalRights method, of class Song.
     */
    @Test
    public void testGetLocalRights() {
       
        Song instance = new Song("1", "titre", "Amina", "album", "1", new LinkedList<String>(), new HashMap<String,Rights>());
        Rights expResult = new Rights(true, false, true, false);
        Rights result = instance.getLocalRights();
        assertFalse(expResult.equals(result));
        
    }

    /**
     * Test of getRightsByCategory method, of class Song.
     */
    @Test
    public void testGetRightsByCategory() {
        HashMap<String,Rights> rightsByCat = new HashMap<String,Rights>();
        rightsByCat.put("family", new Rights(true,true,false,false));
        rightsByCat.put("friends", new Rights(true,true,true,false));
        Song instance = new Song("1", "titre", "Amina", "album", "1", new LinkedList<String>(), rightsByCat);
        HashMap<String, Rights> result = instance.getRightsByCategory();
        assertTrue(result.containsKey("family"));
    }

    /**
     * Test of hasTag method, of class Song.
     */
    @Test
    public void testHasTag() {
        LinkedList<String> listTags = new LinkedList<String>();
        listTags.add("myTag2");
        listTags.add("myTag3");
        Song instance = new Song("1", "titre", "artiste", "album", "1", listTags);
        LinkedList<String> searchTags = new LinkedList<>();
        searchTags.add("myTag1");
        searchTags.add("myTag4");
        boolean result = instance.hasTag(searchTags);
        assertFalse(result);
    }
    
}
