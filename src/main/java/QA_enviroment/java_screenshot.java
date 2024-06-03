package QA_enviroment;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class java_screenshot {

	public static void getscreenshot() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
		String dateandtime = String.valueOf(java.time.LocalDateTime.now());
		String currentdateandtime = dateandtime.replace(":", "-");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourecfile = screenshot.getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\RavishankarN\\eclips_respace\\TestNG\\screenshots/"+currentdateandtime+".png");
		FileUtils.copyFile(sourecfile,Destination);
	}
	
	public static void currenttimedate() {
		java.time.LocalDateTime.now();
		String currentdateandtime = String.valueOf(java.time.LocalDateTime.now());
		String [] date_time = currentdateandtime.split("T");
		int date = Integer.parseInt(date_time[0].substring(8));
		int seven_date_ago = date-7;
		System.out.println(seven_date_ago);
		//int month = Integer.parseInt(date_time[0].substring(6));
		String month = (date_time[0].substring(5,7));
		System.out.println(month);
		String year = (date_time[0].substring(0,4));
		System.out.println(year);
		
		System.out.println(date_time[1]);
		
		String hours = date_time[1].substring(0,2);
		System.out.println(hours);
		
		String minits = (date_time[1].substring(3,5));
		System.out.println(minits);
		
		
		
	}
	
	public static void launch_browser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
		
		String currentdateandtime = String.valueOf(java.time.LocalDateTime.now());
		String [] date_time = currentdateandtime.split("T");
		String [] formate_date = date_time[0].split("-");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=formate_date.length-1; i>=0; i--){
			sb.append(formate_date[i]);
			if(i>0) {
				sb.append("-");
			}
		}
		
		String Full_date = sb.toString(); //---> check the code
		
		//String Full_date = "02-01-1997";
		System.out.println(Full_date);
		
		String date = Full_date.substring(0, 2);
		String date_value;
		String month_value;
		int final_month =0 ;
		int final_date =0;
		int final_year = 0;
		
		int month = Integer.parseInt(Full_date.substring(3, 5));
		System.out.println(month);
		
		int year = Integer.parseInt(Full_date.substring(6, 10));
		System.out.println(year);
		
		if(Integer.parseInt(date)-7<=0) {
			System.out.println("checking>>>>>>>>>>>>>>");
			final_date = 30+(Integer.parseInt(date)-7);
			//int pre_final_month = month-1;
			if((month-1)<=0) {
				final_month = 12-(month-1);
			}else {
				final_month = month-1;
			}
			if(final_month<=0) {
				year = year-1;
			}else {
				year = year;
			}
			
		}else {
			final_date = Integer.parseInt(date)-7;
			final_month = month;
			final_year = year;
		}
				
		if(final_date<=9) {
			date_value = "0"+final_date;
			System.out.println(date_value);
		}else {
			date_value = String.valueOf(final_date);
			System.out.println(date_value);
		}
		if(final_month<=9) {
			month_value = "0"+final_month;
			System.out.println(month_value);
		}else {
			month_value = String.valueOf(final_month);
			System.out.println(month_value);
		}
		
		String date_field_value = month_value+"/"+date_value+"/"+year;
		System.out.println(date_field_value);	
		
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date_field_value);
		
		
	}
	
	public static void main(String[] args) throws IOException {	
		//getscreenshot();
		//currenttimedate();
		launch_browser();
	}
}
