package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayGroundWindow {
	public static void main(String[] args) throws InterruptedException {
		//Setup Webdriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch Browser
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		////Creating set to handle new pages 
		Set<String>WindowHandles=driver.getWindowHandles();
		 List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		 String secondWindowHandles=lstWindowHandles.get(1);
		 driver.switchTo().window(secondWindowHandles);
		 driver.close();
		 String maimWindow = lstWindowHandles.get(0);
		driver.switchTo().window(maimWindow);
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()=\"Open Multiple Windows\"]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>(windowHandles2);
		//Printing number of active session
		System.out.println(newWindow.size() );
		//Close all except this window
		String thirdWindow = newWindow.get(2);
		driver.switchTo().window(thirdWindow);
		driver.close();
		String secondWindow = newWindow.get(1);
		driver.switchTo().window(secondWindow);
		driver.close();
		String mainWindow = newWindow.get(0);
		driver.switchTo().window(mainWindow);
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()=\"Wait for 5 seconds\"]")).click();
		Thread.sleep(5000);
		//Close all current active browser tap
		driver.quit();
		

}
}