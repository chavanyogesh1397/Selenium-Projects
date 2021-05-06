package Paytm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Paytm 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\chromedriver_win32new\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		driver.findElement(By.xpath("//span[text()='Electricity']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//span[text()='Maharashtra']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Mahavitaran-Maharashtra')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'4677')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("170658871911");
		driver.findElement(By.xpath("//button[@class='_11kC  _15qf _2qE6']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//li[@class='_26Vr']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		//170658871911
	}
}
