package test.configurationfailurepolicy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassWithFailedBeforeMethodAndParallelInvocationsLessThanThreadCount {

  @BeforeMethod
  public void setupShouldFail() {
    throw new RuntimeException("Failing in setUp");
  }

  @DataProvider( name = "data.provider", parallel=true )
  public Object[][] dataProvider() {
      final int numOfTests = 6;
      Object[][] data = new Object[numOfTests][1];
      for (int i = 0; i < data.length; i++)
      {
          data[i][0] = i;
      }
      return data;
  }
  
  @Test( dataProvider = "data.provider" )
  public void test1( int s ) {

  }
  
  @Test( invocationCount = 6, threadPoolSize = 8 )
  public void test2() {
    
  }
  
}
