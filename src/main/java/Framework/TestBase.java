package Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import Framework.Browse.DriverManager;
import Framework.Browse.TypeBrowser;
import Framework.Utils.FileOperation;
import Report.Report;

public class TestBase extends DriverManager{

private static WebDriver driver;
    
    private static String URL = FileOperation.getProperties("url").getProperty("index");
    
    public static WebDriver getDriverManager() {
    	driver = getDriver(TypeBrowser.CHROME);
    	return driver;
    	
    }
    

    
    @BeforeEach
    public void setup() {
        getDriverManager().get(URL);
    }
    
    @AfterEach
    public void finish() {
        Report.close();
        quitDriver();
    }
}
