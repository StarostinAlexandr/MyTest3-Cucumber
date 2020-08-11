package practica.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageObjectOpen {

    private String selectorExchangeRates = "//*[@class='main-page-exchange main-page-info__card']";
    private String selectorTableHeaders = ".//tbody/tr[contains(@class,'header')]/td";
    private String selectorTableRows = ".//tbody/tr[contains(@class,'row')]";

    private WebDriver driver;

    private WebElement exchangeRates;
    private List<Map<String, String>> collectExchangeRates = new ArrayList<>();

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getExchangeRates() {
        return exchangeRates;
    }

    private String mainURL = "https://www.open.ru/";

    public PageObjectOpen(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().contains("Открытие"))
            driver.get(mainURL);
        exchangeRates = driver.findElement(By.xpath(selectorExchangeRates));
    }

    public List<Map<String, String>> getCollectExchangeRates() {
        List<WebElement> tableHeaders = exchangeRates.findElements(By.xpath(selectorTableHeaders));
        List<WebElement> tableRows = exchangeRates.findElements(By.xpath(selectorTableRows));


        for (int i = 0; i < tableRows.size(); ++i) {
            Map<String, String> collectRow = new HashMap<>();
            for (int j = 0; j < tableHeaders.size(); ++j) {
                collectRow.put(
                        tableHeaders.get(j).getText(),
                        tableRows.get(i).findElement(By.xpath("./td[" + (j + 1) + "]")).getText()
                );
            }
            collectExchangeRates.add(collectRow);
        }

        return collectExchangeRates;
    }

    public Double getCourse(String moneyType, String typeOper) {
        System.out.println("moneyType " + moneyType);
        System.out.println("typeOper " + typeOper);
    /*    System.out.println("res 1 " + getCollectExchangeRates().stream()
                .filter(x->x.get("Валюта обмена").contains(moneyType))
                .findFirst().get().containsKey("Банк покупает")
                );
        System.out.println("res 1 " + getCollectExchangeRates().stream()
                .filter(x->x.get("Валюта обмена").contains(moneyType))
                .findFirst().get().get("Банк покупает")
        );
        System.out.println("res 2 " + getCollectExchangeRates().stream()
                .filter(x->x.get("Валюта обмена").contains("USD"))
                .findFirst().get().get("Банк " + typeOper).replace(",", ".")
        );

        return 0.0;*/
       return Double.parseDouble(
                getCollectExchangeRates().stream()
                        .filter(x -> x.get("Валюта обмена").contains(moneyType))
                        .findFirst()
                        .get().get("Банк " + typeOper).replace(",", "."));
    }
}
