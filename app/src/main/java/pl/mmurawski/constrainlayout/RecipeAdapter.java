package pl.mmurawski.constrainlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<RecipeItem> recipeItems;
    Context context;

    public RecipeAdapter(Context context) {
        this.context = context;
        recipeItems = loadData();
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recepie_row, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final RecipeItem recipeItem = recipeItems.get(position);
        holder.name.setText(recipeItem.getName());
        Picasso.with(context)
                .load(recipeItem.getPictureAddress())
                .resize(150,100)
                .centerCrop()
                .into(holder.picture);
//        holder.picture.setBackgroundResource(recipeItem.getPictureAddress());
    }

    @Override
    public int getItemCount() {
        return recipeItems.size();
    }

    private List<RecipeItem> loadData(){
        List<RecipeItem> recipes = new ArrayList<>();
        recipes.add(new RecipeItem("Some mushrooms", R.drawable.r1));
        recipes.add(new RecipeItem("Some sweet buns", R.drawable.r2));
        recipes.add(new RecipeItem("Pizza", R.drawable.r3));
        recipes.add(new RecipeItem("Green Soup", R.drawable.r4));
        recipes.add(new RecipeItem("Some Burger", R.drawable.r5));
        recipes.add(new RecipeItem("Some Ribs", R.drawable.r6));
        return recipes;
    }

    static class RecipeViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{

        @BindView(R.id.recipe_picture) ImageView picture;
        @BindView(R.id.recipe_name) TextView name;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
