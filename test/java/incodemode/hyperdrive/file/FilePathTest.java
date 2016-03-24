package incodemode.hyperdrive.file;

import java.io.File;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FilePathTest  extends TestCase{
	
	public FilePathTest( String testName )
    {
        super( testName );
    }
	
	
	/**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FilePathTest.class );
    }

    public void testGetRelativePathWhenValidPath()
    {
    	File parentDirectory = new File("C:/carpeta");
    	File file = new File("C:/carpeta/carpeta interna/archivo");
    	String relativePath = FilePath.getRelativePath(parentDirectory, file);
        assertEquals("carpeta interna"+File.separator+"archivo", relativePath );
        
    }
    
    public void testGetRelativePathWhenInvalidPathReturnsOriginalPath()
    {
    	File parentDirectory = new File("C:/carpetas");
    	File file = new File("C:/carpeta/carpeta interna/archivo");
    	String relativePath = FilePath.getRelativePath(parentDirectory, file);
        assertEquals("C:"+File.separator+"carpeta" + File.separator + "carpeta interna"+File.separator+"archivo", relativePath );
        
    }
	
}
