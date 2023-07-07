package deneme;

import java.io.* ;
import java.util.Scanner;
public class JavaIO {
	
	public static void main (String[ ]args) throws IOException {
		
		File file = new File("code.txt");
		
		if(!file.exists()) {
				file.createNewFile();
			} 
		
		
		String variable = "Java Programming";
		FileWriter write = new FileWriter(file,false);
		BufferedWriter write2 = new BufferedWriter(write);
		write2.write(variable);
		write2.close();
		
		
		FileReader read = new FileReader(file);
		String line;
		
		BufferedReader read2 = new BufferedReader(read);
		
		while((line = read2.readLine()) != null){
			
			System.out.println(line);
			
		}
		
		// for our second file
		
		File anotherfile = new File("hi.txt");
		anotherfile.createNewFile();
		
		Scanner fileReader = new Scanner(anotherfile);
		FileWriter fileWriter = new FileWriter(anotherfile);
		
		fileWriter.write("Hi!");
		System.out.println();
		fileWriter.write("\nJava");
		fileWriter.flush();
		
		while(fileReader.hasNext())
			System.out.println(fileReader.next());
		
		
		read2.close();
		fileReader.close();
		fileWriter.close();
	
		
		BufferedWriterAndReader();	
		
		//for our third file (buffered reader & writer)
		
		}

	private static void BufferedWriterAndReader() throws IOException {
		
		File thirdfile = new File("new.txt");
		FileWriter buffer = new FileWriter(thirdfile);
		BufferedWriter buffer2 = new BufferedWriter(buffer);
		
		
		FileReader thirdread = new FileReader(thirdfile);
		BufferedReader bufferreader = new BufferedReader(thirdread);
		
		buffer2.write("New");
		System.out.println();
		buffer2.flush();
		
		String line2;
		
        while((line2 = bufferreader.readLine()) != null){
			
			System.out.println(line2);
			
		}
        
        buffer2.close();
		bufferreader.close();
	}
	
			
	
	
	}
	
