import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	public WebDriver driver;
	@FindBy(id = "identifierId")
	public static WebElement Email;
	
	@FindBy(xpath = ".//*[@id='identifierNext']/content/span")
	public static WebElement EmailButton;
	
	@FindBy(xpath = ".//*[@name='password']")
	public static WebElement Password;
	
	@FindBy(xpath = ".//*[@class='CwaK9']")
	public static WebElement PasswordButton;
	
	@FindBy(xpath = "(.//*[@class = 'LXRPh'])[1]")
	public static WebElement PasswordError;
	

	@FindBy(xpath = ".//*[@class='LXRPh']/div[2]")
	public static WebElement EmailError;
	
	
	/*public WebElement Email = driver.findElement(By.id("identifierId"));
	public WebElement EmailButton = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
	public WebElement Password = driver.findElement(By.xpath(".//*[@name='password']"));
	public WebElement PasswordButton = driver.findElement(By.xpath(".//*[@class='CwaK9']"));
	public WebElement PasswordError = driver.findElement(By.xpath("(.//*[@jsname='B34EJ'])[1]"));
	public WebElement EmailError = driver.findElement(By.xpath(".//*[@class='LXRPh']/div[2]"));*/
	
	
	public void openbrowser(){
	driver = new FirefoxDriver();
	PageFactory.initElements(driver, this);
	}
	
	public void closebrowser(){
		driver.close();
		}
	
	public void opengmail(){
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	public void enteremail(String a) throws InterruptedException{
		Email.sendKeys(a);
		//driver.findElement(By.id("identifierId")).sendKeys(a);
		//driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		EmailButton.click();
		Thread.sleep(3000);
		
	}
	public void enterpassword(String b) throws InterruptedException{
		Password.sendKeys(b);
		PasswordButton.click();
		// driver.findElement(By.xpath(".//*[@name='password']")).sendKeys(b);
		// driver.findElement(By.xpath(".//*[@class='CwaK9']")).click();
		Thread.sleep(3000);
	}
	
	public String readerrorpassword(){
		String ActualError = PasswordError.getText();
		//String ActualError = driver.findElement(By.xpath("(.//*[@jsname='B34EJ'])[1]")).getText();
		System.out.println(ActualError);
		return ActualError;
	}
	
	public String readerroremail(){
		String ActualError =EmailError.getText();
		//String ActualError = driver.findElement(By.xpath(".//*[@class='LXRPh']/div[2]")).getText();
		System.out.println(ActualError);
		return ActualError;
		
	}
	
	
	
	public void testTakesScreenshot()
	{
	Calendar calendar = Calendar.getInstance();
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	int minute = calendar.get(Calendar.MINUTE);
	int second = calendar.get(Calendar.SECOND);
	int milisecond = calendar.get(Calendar.MILLISECOND);

	String directory = "C:\\Users\\IBM_ADMIN\\Downloads\\Desktop\\POM";
	String fileName = "snapshot_"+ hour + "_"+ minute+ "_"+second+ "_"+milisecond +".png";

	File dest = new File(directory, fileName);
	
	//DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	//Date date = new Date();
	//String filename = "Super_Selenium";
	  try {
		 
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, dest);
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}
	

	

}
