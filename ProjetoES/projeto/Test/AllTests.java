package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFeature_Envy.class, TestIG.class, TestLong_Method.class, TestReadExcelFile.class })
public class AllTests {

}
