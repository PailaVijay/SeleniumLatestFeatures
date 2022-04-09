import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
	DevTools devtool=driver.getDevTools();
	devtool.createSession();
	devtool.send(Fetch.enable(Optional.empty(),Optional.empty()));
	devtool.addListener(Fetch.requestPaused(), request->
	{
		if(request.getRequest().getUrl().contains("shetty"))
		{
			String mockurl=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
			System.out.println(mockurl);
			devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockurl), Optional.of(request.getRequest().getMethod()),
					Optional.empty(), Optional.empty(), Optional.empty()));
		}
		else {
			
			devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
					Optional.empty(), Optional.empty(), Optional.empty()));
			
		}
		
	});
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	Thread.sleep(3000);
	
	System.out.println(driver.findElement(By.cssSelector("p")).getText());
	
			
			
		
	 

}
}