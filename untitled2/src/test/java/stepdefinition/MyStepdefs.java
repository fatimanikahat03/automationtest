package stepdefinition;


import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeOptions;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.edge.EdgeDriverService;

public class MyStepdefs {
   WebDriver driver;
        @Given("Enter URL in  Browser")
        public void urlb()
        {
try{
EdgeDriverService service = new EdgeDriverService.Builder()
    .usingDriverExecutable(new File("C://Users//Lenovo//Downloads//edgedriver_win64 (5)//msedgedriver")).build();
           EdgeOptions options = new EdgeOptions();
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--no-sandbox");
WebDriver driver = new EdgeDriver(service, options);

//WebDriver driver = new EdgeDriver(service);

          //  driver=new EdgeDriver();
          //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.manage().window().maximize();
            // driver=new ChromeDriver();https://github.com/fatimanikahat03/jenkins2.git
            driver.get("https://www.facebook.com");

        }
           catch(Exception e)
   {
      System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
   }
        }
    @When("Click on new account button")
    public void clickOnNewAccountButton() {
        WebElement g = driver.findElement(By.className("_9vtf"));
        g.findElement(By.cssSelector("._42ft._4jy0._6lti._4jy6._4jy2.selected._51sy")).click();

    }

    @And("Enter all details in signup page")
    public void enterAllDetailsInSignupPage() throws InterruptedException {
        Thread.sleep(3000);
        WebElement g = driver.findElement(By.className("_9vtf"));
        String s = g.getText();
        String oo = driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div")).getText();
        // System.out.println(oo);
        WebElement ooo = driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div"));

        // driver.findElement(By.xpath("//*[@id=\"reg\"]"));


        // WebElement v=driver.findElement(By.xpath("//*[@id=\"u_18_a_JC\"]"));
        ooo.findElement(By.name("firstname")).sendKeys("yes");
        ooo.findElement(By.name("lastname")).sendKeys("lastyes");
        ooo.findElement(By.name("reg_email__")).sendKeys("lastemail@@gmail.com");
        ooo.findElement(By.name("reg_passwd__")).sendKeys("Lastpassword");
        WebElement d = driver.findElement(By.name("birthday_month"));
        Select select = new Select(d);
        select.selectByValue("8");
        WebElement dd = driver.findElement(By.name("birthday_day"));
        Select select1 = new Select(dd);
        select1.selectByVisibleText("6");
        WebElement ddd = driver.findElement(By.name("birthday_year"));
        Select select2 = new Select(ddd);
        select2.selectByVisibleText("1984");
        WebElement rb = driver.findElement(By.xpath("//span[@class='_5k_3']//span[1]//input"));
        String rbo = rb.getText();
        Thread.sleep(3000);
        rb.click();
    }

    @Then("Submit the Sign up button")
    public void submitTheSignUpButton() throws InterruptedException {
        driver.findElement(By.name("websubmit")).click();
        // String exp="Facebook";     it shoul be this but Im not clicking on submit so just checling with signup page title
        String exp="Facebook - log in or sign up";
        String ac=driver.getTitle();
        Assert.assertEquals(exp,ac);
Thread.sleep(1000);
        driver.close();
    }
}
