package Model;

import android.util.Log;

import Helpers.Parse.ParseRecipe;

/**
 * Created by Dahan on 08/04/2016.
 */
public class Recipe {

   public String id;
   public String title;
    public String type;
    public String level;
    public int cookTime;
    public int prepTime;
    public Object directions;

    public Recipe(ParseRecipe parseRecipe) {
        this.id = parseRecipe.getId();
        this.title = parseRecipe.getTitle();
        this.cookTime = parseRecipe.getCookTime();
        this.level = parseRecipe.getLevel();
        this.type = parseRecipe.getType();
        this.prepTime = parseRecipe.getPrepTime();
        this.directions = parseRecipe.getDirections();
    }
}
