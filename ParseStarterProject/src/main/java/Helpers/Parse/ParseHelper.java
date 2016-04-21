package Helpers.Parse;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.MainActivity;

import java.util.ArrayList;
import java.util.List;

import Model.Recipe;

/**
 * Created by Dahan on 08/04/2016.
 */
public class ParseHelper {

    ArrayList<String> recipesInfo = new ArrayList<>();

    //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipesInfo);

    public void updateRecipes (final ArrayList<Recipe> recipes) {

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Recipe");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    // your logic here
                    if(objects.size() > 0){

                        recipesInfo.clear();
                    }

                    for(ParseObject recipe : objects){



                    }

                    for(int i=0; i<objects.size(); i++){
//
                        ParseRecipe parseRecipe = new ParseRecipe(objects.get(i));
                        Recipe recipe = new Recipe(parseRecipe);
                        recipes.add(recipe);
                    }

                    Log.i("recipes", String.valueOf(recipesInfo));

                } else {
                    // handle Parse Exception here
                    Log.d("Brand", "Error: " + e.getMessage());
                }
            }
        });
    }

    public ArrayList<String> getRecipesList(ArrayList recipes){

        return recipes;
    }
}
