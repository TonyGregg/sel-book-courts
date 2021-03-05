package util;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Created on Mon, 3/1/21 at 5:30 PM by Genil. */
public class RadioClicker {

  public static void main(String[] args) {

    WebDriver driver = loginAndWaitForReserveLink();
    // Close the Browser
    //    driver.close();
  }

  private static WebDriver loginAndWaitForReserveLink() {
    // Instantiate a SafariDriver class.
    WebDriver driver = new SafariDriver();

    // Launch Website
    try {
      driver.get("http://localhost:4200");
      // Initializing webelement loginElement
      driver.manage().window().maximize();
      WebElement radioElement = driver.findElement(By.id("interval-120"));

      radioElement.click();


    } catch (Exception exception) {
      System.out.println(
          "Sorry, failed. Error Message : " + exception.getMessage());
      exception.printStackTrace();
    }

    return driver;
  }
}
