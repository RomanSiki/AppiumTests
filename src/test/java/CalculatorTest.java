import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;





public class CalculatorTest  {


    static AppiumDriver  driver;

    public static void main(String[] args) throws MalformedURLException {

        openCalculator();

    }


    public static void  openCalculator () throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();


        cap.setCapability("deviceName", "POT-LX1");
        cap.setCapability("udid", "39V7N19111009263");
        cap.setCapability("platformName","Android");
        cap.setCapability("version","10.0.0");

        cap.setCapability("appPackage","com.android.calculator2");
        cap.setCapability("appActivity","com.android.calculator2.Calculator");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);

       // System.out.println("Application started....JUPÍÍÍ!!!");

        WebElement two = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        WebElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/formula"));

        two.click();
        plus.click();
        three.click();
        equals.click();

        String res = result.getText();
        System.out.println("Doufám, že je to dobře...2 + 3 =      " + res);

        Assert.assertEquals("6", driver.findElement(By.id("com.android.calculator2:id/formula")).getText());


    }


}
