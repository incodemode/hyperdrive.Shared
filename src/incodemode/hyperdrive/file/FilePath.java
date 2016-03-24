package incodemode.hyperdrive.file;

import java.io.File;

public class FilePath{
	public static String getRelativePath(File parentDirectory, File file){
		String parentPath = parentDirectory.getAbsolutePath() + File.separator;
		String filePath = file.getAbsolutePath();
		String relativePath;
		if(filePath.indexOf(parentPath) == 0){
			int position = parentPath.length();
			relativePath = filePath.substring(position);
		}else{
			relativePath = filePath;
		}
		return relativePath;
		
	}
}
