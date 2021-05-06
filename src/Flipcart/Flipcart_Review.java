package Flipcart;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipcart_Review 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(4000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		searchbox.sendKeys("apple 12 pro max");
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		Thread.sleep(6000);
		Set<String> window = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(window);
		String add = al.get(1);
		driver.switchTo().window(add);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='_2_R_DZ']")).click();
		WebElement Rating = driver.findElement(By.xpath("//div[@class='row _2afbiS']//span"));
		String Rat = Rating.getText();
		System.out.println("Current Rating: "+Rat.substring(0,3));
		 
		WebElement review = driver.findElement(By.xpath("(//div[@class='col-12-12']//span)[2]"));
		String rev = review.getText();
		System.out.println("Current Review: "+rev.substring(0, 2));
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='q6DClP'])[5]")).click();
		Thread.sleep(4000);
		WebElement courser = driver.findElement(By.xpath("//img[@alt='APPLE iPhone 12 Pro Max (Silver, 128 GB)']"));
		Thread.sleep(4000);
		//driver.navigate().refresh();
//		Thread.sleep(4000);
		act.moveToElement(courser).perform();
		Thread.sleep(4000);
		act.moveToElement(courser).perform();
		//(//ul[@class='_3GnUWp']//li)[5]
	}
}
