package be.vdab.hfdstk6.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Menu {
    private int id;
    private String title;
    private Collection<Ingredient> ingredients = new ArrayList<>();

    public Menu() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
