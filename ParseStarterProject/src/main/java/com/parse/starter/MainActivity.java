/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.sax.Element;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Helpers.Parse.ParseHelper;
import Helpers.Parse.ParseRecipe;
import Model.Recipe;


public class MainActivity extends AppCompatActivity {

   // static ArrayList<Recipe> recipes = new ArrayList<Recipe>();


  ArrayList<String> recipes;
  ArrayAdapter arrayAdapter;
  ListView listView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());

    //Start your code here.

    recipes = new ArrayList<>();
    arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
    listView = (ListView) findViewById(R.id.listView);

    listView.setAdapter(arrayAdapter);

    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Recipe");

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, com.parse.ParseException e) {
        if (e == null) {
          // your logic here
          if (objects.size() > 0) {

            recipes.clear();
          }

          for (int i = 0; i < objects.size(); i++) {
//
            ParseRecipe parseRecipe = new ParseRecipe(objects.get(i));
            Recipe recipe = new Recipe(parseRecipe);
            recipes.add(String.valueOf(recipe));
          }

          arrayAdapter.notifyDataSetChanged();

          Log.i("recipes", String.valueOf(recipes));

        } else {
          // handle Parse Exception here
          Log.d("Brand", "Error: " + e.getMessage());
        }
      }
    });


  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
