package practica.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MyStepDef extends Steps {
    @Given("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        открытьХром();
        chromeDriver.get(url);
    }

    @Then("тайтл верен '(.*)'")
    public void тайтлВерен(String checkTitle) {
        String title = chromeDriver.getTitle();
        Assert.assertTrue(title.contains(checkTitle));
    }

    @Then("закончить работу")
    public void закончитьРаботу() {
        закрытьХром();
    }

    /*@Given("вывести список")
    public void вывестиСписок(List<String> arg) {
        System.out.println(arg);
    }

    @Then("вывести таблицу")
    public void вывестиТаблицу(DataTable arg) {
        System.out.println(arg.toString());
    }

    @Then("вывести название доступных пунктов")
    public void вывестиНазваниеДоступныхПунктов(DataTable arg) {
        List<Map<String,String>> table = arg.asMaps(String.class,String.class);
        table.stream()
                .filter(x->x.get("Доступен").equals("true"))
                .forEach(x-> System.out.println(
                        x.get("Название")+" "+
                        x.get("Количество подменю")+" "+
                        x.get("Отлад"))
                );

        for(int i=0; i<table.size();++i)
        {
            if(table.get(i).get("Доступен").equals("true"))
                System.out.println(table.get(i).get("Название")+" "+table.get(i).get("Количество подменю")+" "+table.get(i).get("Отлад"));
        }
    }

    @Then("^вывод (.*) и (.*) из списка$")
    public void выводКлючИЗначениеИзСписка(String a, String b) {
        System.out.println(a+b);
    }

    @When("ищем '(.*)' в результатах поиска")
    public void ищемКириллФиленковВРезультатахПоиска(String keyWord) {
        PageObjectBell bellPO = new PageObjectBell(chromeDriver);
        bellPO.find("RPA");
        bellPO.refreshListOfElement();
        Assert.assertTrue(bellPO.getNews().stream().anyMatch(x->x.getText().contains("Кирилл Филенков")));
    }*/
}
