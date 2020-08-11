package practica.test;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver chromeDriver;

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    @Step
    public void открытьХром() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Step
    public void проверитьТайтл(String checkTitle) {
        String title = chromeDriver.getTitle();
        Assert.assertTrue(title.contains(checkTitle));
    }

    @Step
    public void проверитьКурсВалюты(String typeMoney, String typeOper1, String kvan, String typeOper2) {
        PageObjectOpen openPage = new PageObjectOpen(chromeDriver);
        System.out.println(typeOper1 + " " + typeMoney + " " + " по курсу " + openPage.getCourse(typeMoney, typeOper1));
        System.out.println("должен быть " + kvan + " чем ");
        System.out.println(typeOper2 + " " + typeMoney + " " + " по курсу " + openPage.getCourse(typeMoney, typeOper2));

        if (kvan.contains("<")) {
            Assert.assertTrue(
                    openPage.getCourse(typeMoney, typeOper1)
                            <
                            openPage.getCourse(typeMoney, typeOper2)
            );
        }
    }

    @Step
    public void закрытьХром() {
        chromeDriver.quit();
    }
}
