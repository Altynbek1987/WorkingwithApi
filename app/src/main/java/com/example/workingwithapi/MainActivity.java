package com.example.workingwithapi;

import android.os.Bundle;
import android.view.View;

import com.example.workingwithapi.ui.home.CatFragment;
import com.example.workingwithapi.ui.home.FilmFragment;
import com.example.workingwithapi.ui.home.NewsFragment;
import com.example.workingwithapi.ui.home.adapter.SlideAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter adapter;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        List<Fragment> list = new ArrayList<>();
        //list.add(new HomeFragment());
        list.add(new FilmFragment());
        list.add(new NewsFragment());
        list.add(new CatFragment());
        viewPager = findViewById(R.id.view_pager);
        adapter = new SlideAdapter(getSupportFragmentManager(), (ArrayList<Fragment>) list);
        viewPager.setAdapter(adapter);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.navigation_home){
                    viewPager.setVisibility(View.VISIBLE);
                }else {
                    viewPager.setVisibility(View.GONE);
                }
            }
        });

    }

}
