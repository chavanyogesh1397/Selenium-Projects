package W3School.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class W3School_com 
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException
	{
		String a[]= {"Speedy Express","United Package","Federal Shipping"};
		
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\chromedriver_win32new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'TUTORIALS ')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Learn SQL')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself ')]")).click();
		Thread.sleep(1000);
		
		Set<String> address = driver.getWindowHandles();
		ArrayList<String> add = new ArrayList<String>(address);
		String addres = add.get(1);
		String main = add.get(0);
//		System.out.println(add.get(0));
//		System.out.println(add.get(1));
		driver.switchTo().window(addres);
		
		WebElement textfield = driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.click(textfield).perform();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		
//		for(int i=1;i<=50;i++)
//		{
//			act.sendKeys(Keys.BACK_SPACE).perform();
//		}
		
		FileInputStream file = new FileInputStream("E:\\Software Testing\\Selenium\\Parameterization\\Sprint_Backlog_W3School_Project.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Query");
		String data = sheet.getRow(7).getCell(6).getStringCellValue();
		act.sendKeys(data).perform();
		
		
		WebElement runsql = driver.findElement(By.xpath("//button[@class='w3-green w3-btn']"));
		runsql.click();
		Thread.sleep(2000);
		try
		{
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			alert.accept();
			driver.switchTo().window(addres);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		
		Thread.sleep(2000);
		act.click(textfield).perform();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		
		
//		for(int i=1;i<=50;i++)
//		{
//			act.sendKeys(Keys.BACK_SPACE).perform();
//		}
		
		Thread.sleep(5000);
		
		String data1 = sheet.getRow(9).getCell(6).getStringCellValue();
		//act.click(textfield);
		act.sendKeys(data1).perform();
		//act.sendKeys("SELECT * FROM Shippers").perform();
		Thread.sleep(3000);
		runsql.click();
		
		int trow = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr")).size();
		ArrayList ar = new ArrayList();
		
		for(int i=2;i<=trow;i++)
		{
				WebElement tdata = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+i+"]/td[2]"));
				String info = tdata.getText();
				//System.out.print(info);
				ar.add(info);
		}
		for(int i=0;i<=2;i++)
		{
			if(a[i].equals(ar.get(i)))
			{
				System.out.println(a[i]+ " verified");
			}
			
		}
		Thread.sleep(3000);
		WebElement link = driver.findElement(By.xpath("//a[text()='w3schools.com']"));
		act.moveToElement(link).perform();
		Thread.sleep(3000);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\Software Testing\\Selenium\\Screenshots\\w3school.png");
		FileHandler.copy(source, dest);
		
		Thread.sleep(3000);
		driver.switchTo().window(main);
		
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		String data2 = sheet.getRow(13).getCell(6).getStringCellValue();
		if(url.equals(data2))
		{
			System.out.println("Url Verified successfully");
		}
		Thread.sleep(3000);
		
		//One Scenario Done
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='SQL Select Distinct']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[text()='Try it Yourself »']")).click();
		
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Try it Yourself »']")).click();
		Thread.sleep(3000);
		Set<String> newurl = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(newurl);
		driver.switchTo().window(al.get(2));
		
		
		
		Thread.sleep(3000);
		WebElement textfield1 = driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
		Thread.sleep(3000);
		Actions act1 = new Actions(driver);
		act.click(textfield1).perform();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
		
//		for(int i=1;i<=50;i++)
//		{
//			act1.sendKeys(Keys.BACK_SPACE).perform();
//		}
		Thread.sleep(3000);
		String data3 = sheet.getRow(17).getCell(6).getStringCellValue();
		//act.click(textfield);
		act.sendKeys(data3).perform();
		//act.sendKeys("SELECT * FROM Shippers").perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Run SQL »']")).click();
		Thread.sleep(3000);
		List<WebElement> rowdata = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr"));
		for(int i=1;i<=rowdata.size();i++)
		{
			if(i==1)
			{
				WebElement th = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr/th[1]"));
				String header = th.getText();
				System.out.println(header);
			}
			else
			{
				WebElement td = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+i+"]/td"));
				String tdata = td.getText();
				System.out.println(tdata);
			}
			
		}
	
	}
}
