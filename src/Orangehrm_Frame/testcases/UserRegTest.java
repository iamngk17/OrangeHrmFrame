package Orangehrm_Frame.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.AdminModuleUtils;
import orangehrm.library.User;

public class UserRegTest extends AdminModuleUtils
{
	@Parameters({"role","empname","uname","pwd"})
	@Test
	public void checkUserReg(String role,String empname,String uname,String pwd) throws InterruptedException 
	{
		User us=new User();
		boolean res=us.addUser(role,empname,uname,pwd);
		Assert.assertTrue(res);
		
		
	}

}
