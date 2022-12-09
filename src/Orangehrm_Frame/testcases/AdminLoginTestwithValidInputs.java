package Orangehrm_Frame.testcases;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTestwithValidInputs extends AppUtils
{
	@Parameters({"uid","pwd"})
	@Test
	public void checkAdminLogin(String uid,String pwd) 
	{
		LoginPage ip=new LoginPage();
		ip.login(uid, pwd);
		boolean res=ip.isAdminModuleDisplayed();
		Assert.assertTrue(res);
		ip.logout();
		 }
	

}
