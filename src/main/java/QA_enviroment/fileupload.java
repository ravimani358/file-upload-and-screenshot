package QA_enviroment;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class fileupload {

	public static void lunch_browser() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeDriver driver1 = new ChromeDriver();
		driver.get("https://ufile.io/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,350);");
		
		driver.findElement(By.xpath("//div[contains(@class,'message')]")).click();
		
		Thread.sleep(3000);
		
		String filepath = "C:\\Users\\RavishankarN\\eclips_respace\\ST_Selenium\\Attachment\\sample.pdf";
		
		StringSelection selc = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selc,null);
		
		Robot rb = new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		lunch_browser();		

	}

}
