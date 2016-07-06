package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String srcPath = args[0];
		String destDir = args[1];
		FileInputStream fis = new FileInputStream(srcPath);
		
		String destFileName = srcPath.substring(srcPath.lastIndexOf('/')+1);
		String destFilePath = destDir + "/" +destFileName;
		FileOutputStream fos = new FileOutputStream(destFilePath);
		cypher(fis,fos);
		fis.close();
		fos.close();

	}
	private static void cypher(InputStream ips,OutputStream ops) throws Exception{
		int b = -1;
		while((b=ips.read())!=-1){
			ops.write(b^0xff);
		}
	}

}
