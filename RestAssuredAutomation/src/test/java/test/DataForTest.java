package test;

import org.testng.annotations.DataProvider;

public class DataForTest {
	
	@DataProvider(name = "dateforpost")
	public Object[][] dataforpost() {
		Object[][] data =new Object[2][3];
		
	/*	data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data [0][2] = 3;
		

		data[1][0] = "Thomas";
		data[1][1] = "Cook";
		data [1][2] = 5;
		return data;*/
		
		return new Object[][] {
			{"news","Bell",6},
			{"gayle","Cook",7}
		};
		
	}
	@DataProvider(name ="deleteuserid")
	public Object[] userdel()
	{
		{
			return new Object[] {
				5,6,7
				};
		
	    }
			
	}

}
