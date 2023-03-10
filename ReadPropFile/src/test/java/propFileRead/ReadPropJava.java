package propFileRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropJava {
	
public Properties prop; 

WebDriver driver ;

@Test 
public void readPropFile()
{
	prop = new Properties();
	
	
try {
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Resources\\config.properties");
	prop.load(ip);
	
} catch (FileNotFoundException e) {
	System.out.println("config file is not found please provide corect path");
	e.printStackTrace();
} catch (IOException e) {
	System.out.println("IOException occurd while loading the config properties file");
	
		e.printStackTrace();
}
   /* System.out.println(prop.getProperty("url"));
    System.out.println(prop.getProperty("browser"));
    System.out.println(prop.getProperty("headless"));
    System.out.println(prop.getProperty("maximize"));
    System.out.println(prop.getProperty("userName"));
    System.out.println(prop.getProperty("userLastName"));**/

   driver = new ChromeDriver();
   if(prop.getProperty("maximize").equalsIgnoreCase("yes"))
   {
	   driver.manage().window().maximize();
   }

   driver.manage().deleteAllCookies();
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.get(prop.getProperty("url"));
   
   System.out.println(driver.getTitle());
   
   driver.quit();























}
}