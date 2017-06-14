package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class FileTest {
	
	//复制路径
	private static String newPath="D:/test";
	
	public static void main(String[] args) {
		 File root = new File("D:/source");
		  try {
			showAllFiles(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAllFiles(File dir) throws Exception{
		  File[] fs = dir.listFiles();
		  for(int i=0; i<fs.length; i++){
		   System.out.println(fs[i].getAbsolutePath());
		   System.out.println(fs[i].getName());
		   String fileName = fs[i].getName().substring(0,fs[i].getName().indexOf("."));
		   //复制文件到另一个路径
		   if(fileName.contains("log")){
			   copyfile(fs[i]);
		   }
		   if(fs[i].isDirectory()){
		    try{
		     showAllFiles(fs[i]);
		    }catch(Exception e){}
		   }
		  }
		 }
	
	public static void copyfile(File file){
		try { 
			int bytesum = 0; 
			int byteread = 0; 
			if (file.isFile()) { //文件存在时 
			InputStream inStream = new FileInputStream(file); //读入原文件 
			FileOutputStream fs = new FileOutputStream(newPath+ "/" + 
					(file.getName()).toString()); 
			byte[] buffer = new byte[1444]; 
			int length; 
			while ( (byteread = inStream.read(buffer)) != -1) { 
			bytesum += byteread; //字节数 文件大小 
			System.out.println(bytesum); 
			fs.write(buffer, 0, byteread); 
			} 
			inStream.close(); 
			} 
			} 
			catch (Exception e) { 
			System.out.println("复制单个文件操作出错"); 
			e.printStackTrace(); 
			} 
	}
	
	public static void moveFile(File file){
		if(file.renameTo(new File(newPath + file.getName()))){
			System.out.println(file.getName()+"移动成功");
		}else{
			System.out.println(file.getName()+"移动失败");
		}
	}
	
}
