import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class cdpCommandTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
	DevTools devtool=	driver.getDevTools();
	devtool.createSession();
	Map deviceMetrics= new HashMap();
	deviceMetrics.put("width", 600);
	deviceMetrics.put("height", 1000);
	deviceMetrics.put("deviceScaleFactor", 50);
	deviceMetrics.put("mobile", true);
	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div/ul/li[2]")).click();
	
	}

}
