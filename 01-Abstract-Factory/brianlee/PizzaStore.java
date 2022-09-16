package me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory.brian;

public class PizzaStore {

    private IngredientFactory ingredientFactory;

    public PizzaStore(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public Pizza createPizza(String name) {
        return new Pizza(name, ingredientFactory.createDough(),
                ingredientFactory.createCheese(),
                ingredientFactory.createSource());
    }
}
