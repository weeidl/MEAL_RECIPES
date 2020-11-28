package weeidl.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MealReipeItem> mealReipeItems = new ArrayList<>();

        mealReipeItems.add(new MealReipeItem(R.drawable.meal_1, Utilis.MEAL_1_TITLE, Utilis.MEAL_1_DESCRIPTION, Utilis.MEAL_1_RECIPE));
        mealReipeItems.add(new MealReipeItem(R.drawable.meal_2, Utilis.MEAL_2_TITLE, Utilis.MEAL_2_DESCRIPTION, Utilis.MEAL_2_RECIPE));
        mealReipeItems.add(new MealReipeItem(R.drawable.meal_3, Utilis.MEAL_3_TITLE, Utilis.MEAL_3_DESCRIPTION, Utilis.MEAL_3_RECIPE));
        mealReipeItems.add(new MealReipeItem(R.drawable.meal_4, Utilis.MEAL_4_TITLE, Utilis.MEAL_4_DESCRIPTION, Utilis.MEAL_4_RECIPE));

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        adapter = new MealRecipeAdapter(mealReipeItems, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}