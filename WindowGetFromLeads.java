package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowGetFromLeads {
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver (); // object
		 driver.get("http://leaftaps.com/opentaps"); // URL
		 driver.manage().window().maximize();    // to maximize
		 // find the user name and enter the user name
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 // find the password field and enter the password
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 // to click login button
		 driver.findElement(By.className("decorativeSubmit")).click();
		 // Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 //Click on Leads Button
		 driver.findElement(By.linkText("Leads")).click();
		 //Click Merge Leads Link 
		 driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		 //Click the icon following the from lead
		 driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		 // Switch to new window
		 String WindowHandle=driver.getWindowHandle();
		 System.out.println(WindowHandle);
		 
		 Set<String>WindowHandles=driver.getWindowHandles();
		 List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		 String secondWindowHandles=lstWindowHandles.get(1);
		 driver.switchTo().window(secondWindowHandles);
		 
		 //Enter the first name as Babu
		 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
		 //Click Find Leads Button
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(5000);
		 // Click on the first resulting lead
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
		 
		 // Move the control back to first window
		 driver.switchTo().window(WindowHandle);
		 //getTittle
		System.out.println(driver.getTitle());
		


}
}