package Mahavitaran;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Mahavitaran 
{
	public static WebElement tab()
	{
		WebElement driver = null;
		for(String abc :((WebDriver) driver).getWindowHandles())
		{
			((WebDriver) driver).switchTo().window(abc);
		}
		return null;
	}
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mahadiscom.in/");
		driver.findElement(By.xpath("//a[text()='English']")).click();
		driver.findElement(By.xpath("//img[contains(@class,'alignnone size-')]")).click();
		Thread.sleep(5000);
		driver.getWindowHandles();
		Thread.sleep(5000);
		
		
		for(String abc :driver.getWindowHandles())
		{
			driver.switchTo().window(abc);
		}
		driver.findElement(By.xpath("//a[contains(text(),'View & Pay Bills Online')]")).click();
		
		for(String abc :driver.getWindowHandles())
		{
			driver.switchTo().window(abc);
		}
		
		
		FileInputStream file = new FileInputStream("E:\\Software Testing\\Selenium\\Parameterization\\Mahadiscom paybill.xlsx");
		Sheet sheet1 = WorkbookFactory.create(file).getSheet("Sheet1");
		String Consumerno = sheet1.getRow(8).getCell(3).getStringCellValue();
		String BU = sheet1.getRow(10).getCell(3).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@id='consumerNo']")).sendKeys(Consumerno);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(BU);
		WebElement refresh = driver.findElement(By.xpath("//img[@alt='refresh']"));
		refresh.click();
		Thread.sleep(2000);
		refresh.click();
		Thread.sleep(2000);
		refresh.click();
		Thread.sleep(2000);
		refresh.click();
		Thread.sleep(2000);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='View History']")).click();
		//Second scenario
		
		List<WebElement> trow = driver.findElements(By.xpath("//table[@class='form_table']//tr"));
		String Name = sheet1.getRow(19).getCell(3).getStringCellValue();
		for(int i=2;i<=trow.size();i++)
		{
			List<WebElement> td = driver.findElements(By.xpath("//table[@class='form_table']//tr[2]/td"));
			for(int j=1;j<=td.size();j++)
			{
				WebElement tabler = driver.findElement(By.xpath("//table[@class='form_table']//tr["+i+"]/td["+j+"]"));
				String exdata = tabler.getText();
				//System.out.print(exdata+" ");
				if(exdata.equals(Name))
				{
					System.out.println(Name + " :Name Validate Successfully");
				}
			}
		}
		Thread.sleep(2000);
		WebElement Consugraph = driver.findElement(By.xpath("//span[text()='View Billing Graph']"));
		Actions act = new Actions(driver);		
		act.moveToElement(Consugraph).perform();
		Thread.sleep(2000);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\Software Testing\\Selenium\\Screenshots\\Bill.jpg");
		FileHandler.copy(source, dest);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='View Billing Graph']")).click();
		
		WebElement lineGraph = driver.findElement(By.xpath("//span[text()='Line Graph']"));
		act.moveToElement(lineGraph);
		Thread.sleep(2000);
		File source1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest1 = new File("E:\\Software Testing\\Selenium\\Screenshots\\Billing.jpg");
		FileHandler.copy(source1, dest1);
		
		driver.findElement(By.xpath("//span[text()='Payments History']")).click();
		
	
		File source2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest2 = new File("E:\\Software Testing\\Selenium\\Screenshots\\Billing2.jpg");
		FileHandler.copy(source2, dest2);
	}
}
