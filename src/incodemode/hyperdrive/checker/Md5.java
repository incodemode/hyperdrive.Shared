package incodemode.hyperdrive.checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import incodemode.hyperdrive.file.FilePath;

public class Md5 {
	public String md5(File f){
		
		if(f.isFile()){
			return fileMd5(f);
		}else{
			return folderMd5(f);
		}
		
	}
	public String folderMd5(File file){
		try {
			
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			String folderString = getFolderString(file);
			byte[] md5FullString = folderString.getBytes();
	
	
			md.update(md5FullString);
			byte[] digest = md.digest();
	        String hex = DatatypeConverter.printHexBinary(digest);
	        return hex.toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "folder";
	}
	public String getFolderString(File file){
		System.out.println("Getting folder md5, this may take a while");
		StringBuffer md5Buffer = new StringBuffer();
		List<File> filesList = (List<File>) FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		
		for(File innerFile : filesList){
			String md5 = fileMd5(innerFile);
			String relativePath = FilePath.getRelativePath(file, innerFile);
			md5Buffer.append(relativePath);
			md5Buffer.append(md5);
		}
		
		String folderString = String.valueOf(md5Buffer);
		return folderString;
	}
	
	public String fileMd5(File file){
		
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			
			MessageDigest md = MessageDigest.getInstance("MD5");
	        FileChannel channel = inputStream.getChannel();
	        ByteBuffer buff = ByteBuffer.allocate(2048);
	        while(channel.read(buff) != -1)
	        {
	            buff.flip();
	            md.update(buff);
	            buff.clear();
	        }
	        byte[] digest = md.digest();
	        String hex = DatatypeConverter.printHexBinary(digest);
	        return hex.toLowerCase();
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	        return null;
	    } 
	    catch (IOException e) 
	    {
	        return null;
	    }
	    finally
	    {
	        try {
	            if(inputStream!=null)inputStream.close();
	            
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    } 
	}

}
