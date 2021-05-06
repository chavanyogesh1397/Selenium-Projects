package Insurance_Domain;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InsuranceAutomation 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\chromedriver_win32new\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/insurance/v1/register.php");
		
		WebElement Title = driver.findElement(By.xpath("//select[@id='user_title']"));
		Select ttl = new Select(Title);
		Thread.sleep(2000);
		ttl.selectByIndex(7);
		List<WebElement> titl = ttl.getOptions();
		System.out.println("Size of Title Box is "+titl.size());
		TreeSet tr = new TreeSet();
		for(WebElement str :titl)
		{
			 String s1 = str.getText();
			 tr.add(s1);
		}
		for(Object t:tr)
		{
			System.out.println(t);
		}
		System.out.println("---------------------------------------------");
		 Iterator m = tr.descendingIterator();
		while(m.hasNext())
		{
			System.out.println(m.next());
		}
		 
		/*for(int i=0;i<=titl.size()-1;i++) 
		{
			System.out.println(titl.get(i).getText());
			String s1 = titl.get(i).getText();
		}*/
		
		
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ranjit");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Dhuke");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1478963258");
		
		WebElement year = driver.findElement(By.xpath("//select[@name='year']"));
		Select yr = new Select(year);
		yr.selectByValue("1995");
		
		WebElement month = driver.findElement(By.xpath("//select[@name='month']"));
		Select mnt = new Select(month);
		mnt.selectByValue("11");
		
		WebElement day = driver.findElement(By.xpath("//select[@name='date']"));
		Select dy = new Select(day);
		dy.selectByValue("10");
		
		driver.findElement(By.xpath("//input[@value='Provisional']")).click();
		
		WebElement License = driver.findElement(By.xpath("//select[@name='licenceperiod']"));
		Select lc = new Select(License);
		lc.selectByValue("10");
		
		WebElement ocu = driver.findElement(By.xpath("//select[@name='occupation']"));
		Select occu = new Select(ocu);
		occu.selectByValue("12");
		
		driver.findElement(By.xpath("//input[@name='street']")).sendKeys("Kute mala,Narhe pune 41236");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		
		
		driver.findElement(By.xpath("//input[@name='county']")).sendKeys("America");
		driver.findElement(By.xpath("//input[@name='post_code']")).sendKeys("458962");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Ranju@dhuke.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name='c_password']")).sendKeys("123456789");
		//
	}
}
