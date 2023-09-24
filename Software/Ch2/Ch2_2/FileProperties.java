import java.io.*;
import java.util.Properties;

public class FileProperties extends FileIO{
	private Properties properties;
	
	public FileProperties() {
		this.properties = new Properties();
	}
	
	public void readFromFile(String filename) throws IOException{
		properties.load(new FileReader(filename));
	}
	
	public void writeToFile(String filename) throws IOException{
		properties.store(new FileWriter(filename), "written by FileProperties");
	}
	
	public void setValue(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public String getValue(String key) {
		String k = properties.getProperty(key);
		return k;
	}

}
