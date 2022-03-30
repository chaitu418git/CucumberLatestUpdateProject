package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
	public static String configProp(String propertyName) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		prop.load(fis);
		return prop.getProperty(propertyName);

	}

}
