package me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory.brian;

/**
 * https://whereami80.tistory.com/211
 */
public class ClientApp {
    public static PizzaStore nyPizza = new PizzaStore(new NYPizzaIngredientFactory());
    public static PizzaStore mexicoPizza = new PizzaStore(new MexicoPizzaIngredientFactory());

    public static void main(String[] args) {
        System.out.println(nyPizza.createPizza("New york cheese pizza").getDescription());
        System.out.println(mexicoPizza.createPizza("Mexico cheese pizza").getDescription());
    }
}
