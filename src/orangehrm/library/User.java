package orangehrm.library;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.AppUtils;
public class User extends AppUtils 
{
	public boolean addUser(String role,String empname,String uname,String pwd ) throws InterruptedException 
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("btnAdd")).click();
		Select rolelist=new Select(driver.findElement(By.id("systemUser_userType")));
		rolelist.selectByVisibleText(role);
		driver.findElement(By.xpath("//input[contains(@id,'employeeName')]")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
		WebElement emptable=driver.findElement(By.id("resultTable"));
		  List<WebElement> rows=emptable.findElements(By.tagName("tr"));
		  boolean res=false;
		  for (int i = 1; i < rows.size(); i++) 
		  {
			  List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			  if (cols.get(1).getText().equals(uname)) 
			  {
				  res=true;
				  break;
				  }
			
		}
		  return res;
		  
		}
	}
