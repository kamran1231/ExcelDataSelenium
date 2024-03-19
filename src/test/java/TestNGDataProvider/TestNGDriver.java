package TestNGDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDriver {
	
	
	
	@Test(dataProvider = "driveTest")
	public void testCaseData(String name,String job,int id) {
		
		System.out.println(name+job+id);
	}
	
	@DataProvider(name="driveTest")
	public Object[][] getData() {
		
		Object[][] data = {{"kamran","QA",1},{"Aisha","BA",2},{"Imran","SA",3}};
		return data;
		
	}

}
