package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
String inputpath ="./FileInput/TestData.xlsx";
String outputpath ="./FileOutput/datadrivenResults.xlsx";
@Test
public void starttest() throws Throwable
{
	//create obejct for excel file util class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows in login sheet
	int rc =xl.rowCount("Login");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		String username = xl.getCellData("Login", i, 0);
		String password = xl.getCellData("Login", i, 1);
		//call login method from function libraray class
		boolean res =FunctionLibrary.adminLogin(username, password);
		if(res)
		{
			xl.setCellData("Login", i, 2, "Valid username and password", outputpath);
			xl.setCellData("Login", i, 3, "pass", outputpath);
		}
		else
		{
			xl.setCellData("Login", i, 2, "Invalid username and password", outputpath);
			xl.setCellData("Login", i, 3, "Fail", outputpath);
		}
		
	}
}
}
