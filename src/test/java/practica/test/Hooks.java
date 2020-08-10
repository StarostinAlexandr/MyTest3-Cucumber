package practica.test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before(order = 1)
    public void start_01(){
        System.out.println("start_01");
    }

    @Before (order = 2)
    public void start_02(){
        System.out.println("start_02");
    }

    @After(order = 1)
    public void end_01(){
        System.out.println("end_01");
    }

    @After(order = 2)
    public void end_02(){
        System.out.println("end_02");
    }
/*
    @Before(value = "@correct", order = 3)
    public void customBefore() {
        System.out.println("Before только для фичи @correct");
    }

    @After(value = "@correct", order = 3)
    public void customAfter() {
        System.out.println("After только для фичи @correct");
    }

    @Before(value = "~@fail", order = 3)
    public void withoutBefore() {
        System.out.println("Before для фич кроме @fail");
    }

    @After(value = "~@fail", order = 3)
    public void withoutAfter() {
        System.out.println("Before для фич кроме @fail");
    }

    @After
    public void getScenarioInfo(Scenario scenario) {
        System.out.println("____________________________");
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getLines());
        System.out.println(scenario.getUri());
        System.out.println("____________________________");
    }*/

}
