import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LohinTest {
	
	Loginpage lp =new Loginpage();
	
	DataFile d=new DataFile();
	
	
	
	
	@Before
	public void setUp() throws Exception {
		lp.openbrowser();
		lp.opengmail();
		lp.testTakesScreenshot();
	
	}

	@After
	public void tearDown() throws Exception {
		lp.closebrowser();
		lp.testTakesScreenshot();
	
	}

	@Test
	public void InvalidPassword() throws InterruptedException {
		lp.enteremail(d.validEmail);
		lp.enterpassword(d.invalidPassword);
		Assert.assertEquals(lp.readerrorpassword(), d.PasswordMessage);
		lp.testTakesScreenshot();
	}
	@Test
	public void InvalidEmail() throws InterruptedException {
		lp.enteremail(d.invalidEmail1);
		
		Assert.assertEquals(lp.readerroremail(),d.EmailMessage1 );
		lp.testTakesScreenshot();
		}
	@Test
	public void InvalidEmail1() throws InterruptedException {
		lp.enteremail(d.invalidEmail2);
		
		Assert.assertEquals(lp.readerroremail(),d.EmailMessage2 );
		lp.testTakesScreenshot();
		}
	
		
	}

