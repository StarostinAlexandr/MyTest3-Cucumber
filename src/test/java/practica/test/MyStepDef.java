package practica.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class MyStepDef extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        открытьХром();
        chromeDriver.get(url);
    }

    @Then("тайтл верен '(.*)'")
    public void тайтлВерен(String checkTitle) {
        проверитьТайтл(checkTitle);
    }

    @Then("курс (.*) (.*) (.*) (.*)")
    public void курсВалютаЗначения1ОперацияЗначение2(String typeMoney, String typeOper1, String kvan, String typeOper2) {
        проверитьКурсВалюты(typeMoney, typeOper1, kvan, typeOper2);
    }

    @Then("закончить работу")
    public void закончитьРаботу() {
        закрытьХром();
    }

}
