package fileAccess;
import java.io.*;

public class Access {
	public static void main(String[] args) {
		String personalFolder = "C:\\Users\\aleleotta\\carpetas.txt";
		File file = new File(personalFolder);
		try {
			if(file.createNewFile()) {
				System.out.println("The following file has been created.");
			} else {
				System.out.println("The following file already exists.");
			}
		} catch (IOException err) {
			System.out.println("An error has occured!");
			err.getMessage();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(personalFolder));
			// metodo readLine recorres cada línea y harás un bucle
			// con mkdir crear una carpeta de cada línea
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				if(file.exists()) {
					while(reader.readLine() != null) {
						String line = reader.readLine();
						System.out.println(line);
					}
				} else if(!file.exists()) {
					System.out.println("The following file doesn't exist."
							+ "Make sure you place the file with the following"
							+ "folder paths in the correct directory.");
				}
				reader.close();
				writer.close();
			} catch (IOException err) {
				System.out.println("The following file was not written.");
				err.getMessage();
			}
		} catch (FileNotFoundException err) {
			System.out.println("The following file was not found.");
			err.getMessage();
		}
	}
}