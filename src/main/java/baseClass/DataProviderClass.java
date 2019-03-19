package baseClass;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
		//data provider function search provider
		@DataProvider(name="SearchProvider")
		public Object[][] SampleFunction()
		{
			return new Object[][]
					{
						{"mayurraskar3@gmail.com","crossworld3"},
						{"mayurraskar4@gmail.com","crossworld4"},
								
					};
			
			
			
		}
	
	
	

}
