package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver (); 
		 driver.get("https://login.salesforce.com/"); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 //Enter the username
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		 //Enter the password
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password$123");
		 //click on the login button
		 driver.findElement(By.xpath("//input[@id='Login']")).click();
		 //click on the learn more option in the Mobile publisher
		 driver.findElement(By.xpath("//button[@title='Learn More']")).click();
         //Switch to the next window using Windowhandles
		 String WindowHandle=driver.getWindowHandle();
		 System.out.println(WindowHandle);
		 
		 Set<String>WindowHandles=driver.getWindowHandles();
		 List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		 String secondWindowHandles=lstWindowHandles.get(1);
		 driver.switchTo().window(secondWindowHandles);
		 
		 //click on the confirm button in the redirecting page
		 driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		 Thread.sleep(4000);
		 //Get the title
		 String title = driver.getTitle();
		 System.out.println(title);
		 //Get back to the parent window
		 driver.switchTo().window(WindowHandle);
		 Thread.sleep(4000);
		 //close the browser
		 driver.close();
		 
		
		 
		 
		 
}
}
