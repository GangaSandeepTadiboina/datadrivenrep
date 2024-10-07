package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import applicationLayer.Com.Page.SuppliersPage;
import config.AppUtil1;
import utilities.ExcelFileUtil;

public class SuppliersScript extends AppUtil1{
	String inputpath ="./FileInput/SuppliersData.xlsx";
	String outputpath ="./FileOutput/SuppliersResults.xlsx";
	String SSheet ="Suppliers";
	
	@Test
	public void starttest() throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc=xl.rowCount(SSheet);
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String sname =xl.getCellData(SSheet, i, 0);
			String Address =xl.getCellData(SSheet, i, 1);
			String city =xl.getCellData(SSheet, i, 2);
			String country =xl.getCellData(SSheet, i, 3);
			String cperson =xl.getCellData(SSheet, i, 4);
			String pnumber =xl.getCellData(SSheet, i, 5);
			String email =xl.getCellData(SSheet, i, 6);
			String mnumber =xl.getCellData(SSheet, i, 7);
			String notes =xl.getCellData(SSheet, i, 8);
			
			SuppliersPage supplieradd=PageFactory.initElements(driver, SuppliersPage.class);
			boolean res =supplieradd.addsuppliers(sname, Address, city, country, cperson, pnumber, email, mnumber, notes);
			if(res)
			{
				xl.setCellData(SSheet, i, 9, "Pass", outputpath);
			}
			else
			{
				xl.setCellData(SSheet, i, 9, "Fail", outputpath);
			}
			
			
		}
		
	}
}
