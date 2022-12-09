package Orangehrm_Frame.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class EmployeeLoginTest extends AppUtils 
{
	@Parameters({"uid","pwd"})
	@Test
	public void checkEmpLogin(String uid,String pwd) 
	{
		LoginPage ip=new LoginPage();
		ip.login(uid, pwd);
		boolean res=ip.isEmpModuleDisplayed();
        Assert.assertTrue(res);
        ip.logout();
	}

}
