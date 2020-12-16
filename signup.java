package Linkclasss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class signup {
	
	public static void main(String[] args) throws InterruptedException {
		// set property to launch chrome
		System.setProperty("webdriver.chrome.driver", "/home/deelip/Downloads/chromedriver_linux64 (1)/chromedriver");
		WebDriver	wd = new ChromeDriver();
		
		// pageload time
		 wd.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

		 try {
			 // launch the website
				wd.get("https://www.google.com/");
			    wd.manage().window().maximize();   // maximize the browser
			 // time wait
				 wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


				System.out.println("first title= "+wd.getTitle());     // getting title of window
				
				 String parentWindowHandle = wd.getWindowHandle();    
				 
				 System.out.println("Parent window's handle -> " + parentWindowHandle);
				 
				 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
					wd.findElement(By.xpath("//*[text()='Gmail']")).sendKeys(selectLinkOpeninNewTab);
				 
					
					 
			 
			wd.get("https://linkclassroom.com/");
			
				
			    Thread.sleep(3000);      // waiting time
			wd.findElement(By.xpath("//*[text()='JOIN TODAY']")).click();
			Thread.sleep(2000);
			wd.findElement(By.xpath("//*[text()='Phone/Email id']")).click();
			Thread.sleep(2000);
			wd.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/div[2]/form[1]/input[1]")).click();

			//signup with email id
			Thread.sleep(1000);
			wd.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/div[2]/form[1]/input[1]")).sendKeys("deelip one");
			wd.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/div[2]/form[1]/input[2]")).sendKeys("deelip2@mailinator.com");
			wd.findElement(By.xpath("//*[text()='NEXT']")).click();
			
			
			// enter in child window for work
			 String childHandle = wd.getWindowHandle();
			 for (String handle: wd.getWindowHandles()) {
			     if (!childHandle.equals(handle))
			         wd.switchTo().window(handle);
			         Thread.sleep(3000);
			     
			 }
			 
			 // finding otp
			 wd.get("https://www.mailinator.com/");
			 Thread.sleep(5000);
			 wd.findElement(By.xpath("//input[@id='addOverlay']")).sendKeys("deelip2");
			 Thread.sleep(1000);
			 wd.findElement(By.xpath("//button[@id='go-to-public']")).click();
			 Thread.sleep(3000);
			 wd.findElement(By.linkText("Got it!")).click();
			 Thread.sleep(5000);
			 
			                                           //html[1]/body[1]/div[3]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]
			wd.findElement(By.xpath("//a[contains(text(),'Your Link OTP is')]")).click();
//			System.out.println(otpclick); 
			Thread.sleep(3000);
			 wd.switchTo().frame("msg_body");

			 String otp = wd.findElement(By.xpath("//h1")).getText();
			 System.out.println(otp);
			 
				wd.switchTo().window(parentWindowHandle);
				Thread.sleep(3000);
//				wd.findElement(By.cssSelector("css=input[type='text']")).click();
				Thread.sleep(1000);

//				wd.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/input[1]")).click();
				Thread.sleep(1000);

	            wd.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/div[3]/form[1]/input[1]")).sendKeys(otp);

				Thread.sleep(1000);
				wd.findElement(By.xpath("//button[contains(text(),'GET STARTED')]")).click();
				
				Thread.sleep(3000);
				System.out.println("Pass");

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed");
		}
					
			
		         

	}
}
