package Telecom_Domain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TelecomDomain 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Telecom Project']")).click();//find element "Telecom Project" Using Xpath by text locaters
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();//find element "Add Customer" Using Xpath by text locaters
		driver.findElement(By.xpath("//label[@for='done']")).click();//find element lable for done radio button by using Xpath by attribute
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Yogesh");
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Chavan");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Yogii@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Room No 304 sai krupa appartrment  Kolhapur 412658");
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("7412369852");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		String s1 = driver.findElement(By.xpath("//h3[contains(text(),'')]")).getText();
		//System.out.println(s1);
		driver.findElement(By.xpath("//a[contains(text(),'Ho')]")).click();
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan to Customer']")).click();
		driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(s1);
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		driver.findElement(By.xpath("//td[@align='center']")).click();
		driver.findElement(By.xpath("//input[@class='fit']")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
	}
}
