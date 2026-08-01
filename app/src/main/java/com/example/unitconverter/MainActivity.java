package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unitconverter.activities.ConverterActivity;
import com.example.unitconverter.activities.HistoryActivity;
import com.example.unitconverter.adapters.CategoryAdapter;
import com.example.unitconverter.models.Category;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.OnCategoryClickListener {

    private RecyclerView rvCategories;
    private TextView tvGreeting;
    private List<Category> allCategories;
    private CategoryAdapter adapter;
    private View headerContainer;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Edge to Edge
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        initViews();
        setupSafeAreas();
        setupGreeting();
        setupRecyclerView();
        setupSearch();
        
        // Initial Animations
        runLayoutAnimation();
    }

    private void initViews() {
        rvCategories = findViewById(R.id.rv_categories);
        tvGreeting = findViewById(R.id.tv_greeting);
        headerContainer = findViewById(R.id.header_container);
        bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_history) {
                startActivity(new Intent(this, HistoryActivity.class));
                return true;
            } else if (id == R.id.nav_settings) {
                startActivity(new Intent(this, com.example.unitconverter.activities.SettingsActivity.class));
                return true;
            }
            return true;
        });
    }

    private void setupSafeAreas() {
        ViewCompat.setOnApplyWindowInsetsListener(headerContainer, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), insets.top + (int)(32 * getResources().getDisplayMetrics().density), 
                        v.getPaddingRight(), v.getPaddingBottom());
            return WindowInsetsCompat.CONSUMED;
        });

        ViewCompat.setOnApplyWindowInsetsListener(bottomNav, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), insets.bottom);
            v.getLayoutParams().height = (int)(85 * getResources().getDisplayMetrics().density) + insets.bottom;
            return WindowInsetsCompat.CONSUMED;
        });
    }

    private void setupGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String greeting;
        if (hour < 12) greeting = getString(R.string.greeting_morning);
        else if (hour < 17) greeting = getString(R.string.greeting_afternoon);
        else greeting = getString(R.string.greeting_evening);
        
        tvGreeting.setText(greeting + " 👋");
    }

    private void setupSearch() {
        EditText etSearch = findViewById(R.id.et_search);
        View searchCard = findViewById(R.id.search_card);
        
        etSearch.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                searchCard.animate().scaleX(1.02f).scaleY(1.02f).setDuration(200).start();
            } else {
                searchCard.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { filterCategories(s.toString()); }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterCategories(String query) {
        List<Category> filteredList = new ArrayList<>();
        for (Category category : allCategories) {
            if (category.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(category);
            }
        }
        adapter.updateList(filteredList);
    }

    private void setupRecyclerView() {
        allCategories = new ArrayList<>();
        // Grouping categories with modern colors
        allCategories.add(new Category(getString(R.string.cat_length), android.R.drawable.ic_menu_compass, getColor(R.color.cat_length_start), getColor(R.color.cat_length_end), 15));
        allCategories.add(new Category(getString(R.string.cat_weight), android.R.drawable.ic_menu_sort_by_size, getColor(R.color.cat_weight_start), getColor(R.color.cat_weight_end), 15));
        allCategories.add(new Category(getString(R.string.cat_temperature), android.R.drawable.ic_menu_day, getColor(R.color.cat_temp_start), getColor(R.color.cat_temp_end), 5));
        allCategories.add(new Category(getString(R.string.cat_area), android.R.drawable.ic_menu_mapmode, getColor(R.color.cat_area_start), getColor(R.color.cat_area_end), 15));
        allCategories.add(new Category(getString(R.string.cat_volume), android.R.drawable.ic_menu_gallery, getColor(R.color.cat_volume_start), getColor(R.color.cat_volume_end), 15));
        allCategories.add(new Category(getString(R.string.cat_data), android.R.drawable.ic_menu_save, getColor(R.color.cat_data_start), getColor(R.color.cat_data_end), 15));
        allCategories.add(new Category(getString(R.string.cat_time), android.R.drawable.ic_menu_recent_history, getColor(R.color.cat_weight_start), getColor(R.color.cat_weight_end), 15));
        allCategories.add(new Category(getString(R.string.cat_speed), android.R.drawable.ic_menu_compass, getColor(R.color.cat_length_start), getColor(R.color.cat_length_end), 15));
        allCategories.add(new Category(getString(R.string.cat_pressure), android.R.drawable.ic_menu_send, getColor(R.color.cat_pressure_start), getColor(R.color.cat_pressure_end), 15));
        allCategories.add(new Category(getString(R.string.cat_energy), android.R.drawable.ic_menu_day, getColor(R.color.cat_energy_start), getColor(R.color.cat_energy_end), 15));
        allCategories.add(new Category(getString(R.string.cat_power), android.R.drawable.ic_menu_manage, getColor(R.color.cat_power_start), getColor(R.color.cat_power_end), 15));
        allCategories.add(new Category(getString(R.string.cat_angle), android.R.drawable.ic_menu_compass, getColor(R.color.cat_angle_start), getColor(R.color.cat_angle_end), 15));
        allCategories.add(new Category(getString(R.string.cat_fuel), android.R.drawable.ic_menu_directions, getColor(R.color.cat_fuel_start), getColor(R.color.cat_fuel_end), 15));
        allCategories.add(new Category(getString(R.string.cat_frequency), android.R.drawable.ic_menu_month, getColor(R.color.cat_freq_start), getColor(R.color.cat_freq_end), 15));
        allCategories.add(new Category(getString(R.string.cat_force), android.R.drawable.ic_menu_send, getColor(R.color.cat_force_start), getColor(R.color.cat_force_end), 15));
        allCategories.add(new Category(getString(R.string.cat_density), android.R.drawable.ic_menu_sort_by_size, getColor(R.color.cat_density_start), getColor(R.color.cat_density_end), 15));
        allCategories.add(new Category(getString(R.string.cat_cooking), android.R.drawable.ic_menu_gallery, getColor(R.color.cat_cooking_start), getColor(R.color.cat_cooking_end), 15));

        adapter = new CategoryAdapter(new ArrayList<>(allCategories), this);
        int spanCount = getResources().getConfiguration().smallestScreenWidthDp >= 600 ? 3 : 2;
        rvCategories.setLayoutManager(new GridLayoutManager(this, spanCount));
        rvCategories.setAdapter(adapter);
    }

    private void runLayoutAnimation() {
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down);
        rvCategories.setLayoutAnimation(controller);
        rvCategories.scheduleLayoutAnimation();
        
        headerContainer.setAlpha(0f);
        headerContainer.setTranslationY(-50f);
        headerContainer.animate().alpha(1f).translationY(0f).setDuration(600).start();
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra("CATEGORY", category.getName());
        startActivity(intent);
    }
}