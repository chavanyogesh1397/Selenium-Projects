package W3School.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automate 
{

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		
		//click on tutorial
		driver.findElement(By.xpath("(//a[text()='TUTORIALS '])[1]")).click();
		Thread.sleep(2000);
		
		//click on learn sql button
		driver.findElement(By.xpath("(//a[text()='Learn SQL'])[2]")).click();
		Thread.sleep(2000);
		
		//click on try it yourself
		driver.findElement(By.xpath("//a[text()='Try it Yourself »']")).click();
		Thread.sleep(2000);
		
		//move to new tab focus
		Set<String> ids = driver.getWindowHandles();
		ArrayList<String> list=new ArrayList(ids);		
		driver.switchTo().window(list.get(1));
		Thread.sleep(2000);
		
		
		//clear previous text

		Actions act =new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
		act.click(ele).perform();
		Thread.sleep(1000);
		for(int i=1;i<=39;i++)
		{
			act.sendKeys(Keys.BACK_SPACE).perform();
			//Thread.sleep(10);
		}
		Thread.sleep(1000);
		
		//enter wrong data an run
		FileInputStream file=new FileInputStream("E:\\Software Testing\\Selenium\\Parameterization\\Sprint_Backlog_W3School_Project.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		//sheet.getRow(9).getCell(3).getStringCellValue();
	
		act.sendKeys(sheet.getRow(7).getCell(6).getStringCellValue()).perform();
		
		WebElement run = driver.findElement(By.xpath("//button[text()='Run SQL »']"));
		run.click();
		Thread.sleep(5000);
		
		//handle alert popup
		try
		{
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.accept();
			driver.switchTo().window(list.get(1));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		
		
		//clear prev data and enter correct data
		act.click(ele).perform();
		Thread.sleep(1000);
		for(int i=1;i<=39;i++)
		{
			act.sendKeys(Keys.BACK_SPACE).perform();
			//Thread.sleep(10);
		}
		Thread.sleep(1000);
		
		act.sendKeys(sheet.getRow(9).getCell(6).getStringCellValue()).perform();
		Thread.sleep(1000);
		run.click();
		
		//verify shippers name
		String Expected[]= {"Speedy Express","United Package","Federal Shipping"};
		ArrayList<String> Actual=new ArrayList();
		
		int rowsize = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr")).size();
		
		for(int i=2;i<=rowsize;i++)
		{
			String str=driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+i+"]/td[2]")).getText();
			Actual.add(str);
		}
		
		for(int i=0;i<=2;i++)
		{
			if(Expected[i].equals(Actual.get(i))) 
			{
				System.out.println(Expected[i]+" is verfied");
			}
			
		}
		
//		//take ScreenShot of table
//		WebElement w3move = driver.findElement(By.xpath("//a[text()='w3schools.com']"));
//		act.moveToElement(w3move).perform();
//		File scfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String random = RandomString.make(3);
//		File dest=new File("C:\\Users\\91976\\Desktop\\Selenium ScreenShot\\shipper table"+random+".jpg");
//		FileHandler.copy(scfile,dest);
	}

}