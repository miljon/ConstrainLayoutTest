package pl.mmurawski.constrainlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recepie_recyclerview) RecyclerView recyclerView;

    private RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        int numberOfColumns = Math.round(getWidth()/160.0f);
        if(numberOfColumns==0) numberOfColumns = 1;
        Log.i("COLUMNS:", String.valueOf(numberOfColumns));
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
//        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recipeAdapter = new RecipeAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recipeAdapter);
//        recyclerView.addItemDecoration(divider);
    }

    private float getWidth(){
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        return dpWidth;
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
////        int width = size.x;
////        int height = size.y;
//        Log.i("Width: ", String.valueOf(size.x));
//        Log.i("Height: ", String.valueOf(size.y));
//        return size.x;
    }
}
