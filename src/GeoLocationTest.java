import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class GeoLocationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtool= driver.getDevTools();
		devtool.createSession();
		Map<String,Object> cordinates =new HashMap<String,Object>();
		cordinates.put("latitude", 35);
		cordinates.put("longitude", 139);
		cordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", cordinates);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb ")).get(0).click();
		String title= driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);
	
				
	}

}
