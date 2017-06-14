package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class FileTest {
	
	//����·��
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
		   //�����ļ�����һ��·��
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
			if (file.isFile()) { //�ļ�����ʱ 
			InputStream inStream = new FileInputStream(file); //����ԭ�ļ� 
			FileOutputStream fs = new FileOutputStream(newPath+ "/" + 
					(file.getName()).toString()); 
			byte[] buffer = new byte[1444]; 
			int length; 
			while ( (byteread = inStream.read(buffer)) != -1) { 
			bytesum += byteread; //�ֽ��� �ļ���С 
			System.out.println(bytesum); 
			fs.write(buffer, 0, byteread); 
			} 
			inStream.close(); 
			} 
			} 
			catch (Exception e) { 
			System.out.println("���Ƶ����ļ���������"); 
			e.printStackTrace(); 
			} 
	}
	
	public static void moveFile(File file){
		if(file.renameTo(new File(newPath + file.getName()))){
			System.out.println(file.getName()+"�ƶ��ɹ�");
		}else{
			System.out.println(file.getName()+"�ƶ�ʧ��");
		}
	}
	
}
