package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	private static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return td.get();
	}

	public static void initilalization(String browsername) {
		WebDriver driver = null;
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			td.set(driver);
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
			td.set(driver);
		} else if (browsername.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browsername.equals("incognito")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);
			td.set(driver);

		} else {
			System.out.println("Please Enter valid browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
