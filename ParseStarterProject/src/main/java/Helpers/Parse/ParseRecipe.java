package Helpers.Parse;

import android.util.Log;

import com.parse.ParseObject;

/**
 * Created by Dahan on 08/04/2016.
 */
public class ParseRecipe {

    ParseObject recipe;
    
    public ParseRecipe(ParseObject object) {

        this.recipe = object;
    }

    public String getId(){
        return this.recipe.getObjectId();
    }

    public String getTitle(){
        return this.recipe.getString("title");
    }

    public int getCookTime (){
        return this.recipe.getInt("cookTime");
    }

    public String getLevel () {
        return this.recipe.getString("level");
    }

    public String getType(){
        return this.recipe.getString("type");
    }

    public int getPrepTime(){
        return this.recipe.getInt("prepTime");
    }

    public String getDirections(){
        return this.recipe.getString("directions");
    }
}
