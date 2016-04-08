package Helpers.Parse;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Dahan on 08/04/2016.
 */
public class ParseHelper {

    public void updateRecipes () {

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Recipe");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> recipes, com.parse.ParseException e) {
                if (e == null) {
                    // your logic here
                    recipes.size();

                    Log.i("recipes", String.valueOf(recipes.size()));
                } else {
                    // handle Parse Exception here
                }
            }
        });
    }
}
