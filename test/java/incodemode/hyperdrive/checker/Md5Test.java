package incodemode.hyperdrive.checker;

import java.io.File;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Md5Test extends TestCase {
	public Md5Test( String testName )
    {
        super( testName );
    }
	
	
	/**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Md5Test.class );
    }

    public void testGetRelativePathWhenValidPath()
    {
    	File f = new File("test/filesTestFolder/innerFolder/file1.txt");
    	Md5 md5 = new Md5();
    	String md5String = md5.fileMd5(f);
        assertEquals("912ec803b2ce49e4a541068d495ab570", md5String );
        
    }
    
    public void testGetFolderString()
    {
    	File f = new File("test/filesTestFolder/");
    	Md5 md5 = new Md5();
    	String folderString = md5.getFolderString(f);
    	String shouldBeFolderString = "a.txt"
    			+ "2e23abab93ab1e7e7bd08c3a8dcad8ee"
    			+ "innerFolder" + File.separator + "file1.txt"
    			+ "912ec803b2ce49e4a541068d495ab570"
    			+ "innerFolder" + File.separator + "file2.txt"
    			+ "d8578edf8458ce06fbc5bb76a58c5ca4"
    			+ "z.txt"
    			+ "2092d4cbda987ffe33422e5210254829";
        assertEquals(shouldBeFolderString, folderString );
        
    }
    
    public void testGetFolderMd5(){
    	
    	String testMd5 = "53f0767b52729a8d9e1c2fafa4357df4";
    	File f = new File("test/filesTestFolder/");
    	Md5 md5 = new Md5();
    	String folderMd5= md5.folderMd5(f);
    	
    	assertEquals(testMd5, folderMd5);
    	
    }

}
