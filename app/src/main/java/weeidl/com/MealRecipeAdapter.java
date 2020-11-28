package weeidl.com;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealRecipeAdapter extends RecyclerView.Adapter<MealRecipeAdapter.MealRecipeViewHolder> {

    ArrayList<MealReipeItem> mealReipeItems;
    Context context;

    public MealRecipeAdapter(ArrayList<MealReipeItem> mealReipeItems, Context context) {
        this.mealReipeItems = mealReipeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MealRecipeAdapter.MealRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_recipe_item,
                parent, false);

        MealRecipeViewHolder mealRecipeViewHolder = new MealRecipeViewHolder(view);
        return mealRecipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealRecipeViewHolder holder, int position)  {
            MealReipeItem mealReipeItem = mealReipeItems.get(position);

            holder.Meal_imageView.setImageResource(mealReipeItem.getImageResource());
            holder.title.setText(mealReipeItem.getTitle());
            holder.description.setText(mealReipeItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return mealReipeItems.size();
    }

    class MealRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView Meal_imageView;
        public TextView title;
        public TextView description;

        public MealRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            Meal_imageView = itemView.findViewById(R.id.Meal_imageView);
            title = itemView.findViewById(R.id.title_TextView);
            description = itemView.findViewById(R.id.description_TextView);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            MealReipeItem mealReipeItem = mealReipeItems.get(position);

            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("imageResourse", mealReipeItem.getImageResource());
            intent.putExtra("title", mealReipeItem.getTitle());
            intent.putExtra("description", mealReipeItem.getDescription());
            intent.putExtra("recipe", mealReipeItem.getRecipe());
            context.startActivity(intent);
        }
    }

}
