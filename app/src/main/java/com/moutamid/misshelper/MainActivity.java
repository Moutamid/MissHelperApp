package com.moutamid.misshelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.moutamid.misshelper.activities.NotificationActivity;

public class MainActivity extends AppCompatActivity {
    View dark_bg;
    public static final int HOME_ITEM = R.id.navigation_home;
    public static final int APPLY_ITEM = R.id.navigation_apply;
    public static final int TRACK_ITEM = R.id.navigation_track;
    public static final int PROFILE_ITEM = R.id.navigation_profile;
    private NavController navController;
    //    private CurvedBottomNavigation bottomNavigation;
    ImageView navigation_icon, cancel_icon;
    RelativeLayout navigation_layout;
    LinearLayout notification_layout, feedback_layout, help_center_layout, saved_job_layout, invite_friend_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //        bottomNavigation = findViewById(R.id.bottomNavigation);
        dark_bg = findViewById(R.id.dark_bg);
        navigation_icon = findViewById(R.id.navigation_icon);
        navigation_layout = findViewById(R.id.navigation_layout);
        cancel_icon = findViewById(R.id.close_icon);
        notification_layout = findViewById(R.id.notification_layout);
        feedback_layout = findViewById(R.id.feedback_layout);
        help_center_layout = findViewById(R.id.help_center_layout);
        saved_job_layout = findViewById(R.id.saved_job_layout);
        navigation_layout.setVisibility(View.INVISIBLE);
        dark_bg.setVisibility(View.INVISIBLE);
        navigation_icon.setVisibility(View.VISIBLE);
        notification_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });
        navigation_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigation_layout.setVisibility(View.VISIBLE);
                navigation_icon.setVisibility(View.INVISIBLE);
                dark_bg.setVisibility(View.VISIBLE);
            }
        });
        cancel_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dark_bg.setVisibility(View.INVISIBLE);
                navigation_layout.setVisibility(View.INVISIBLE);
                navigation_icon.setVisibility(View.VISIBLE);
            }
        });
        initNavHost();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            WindowInsetsControllerCompat controllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
//            controllerCompat.setAppearanceLightNavigationBars(false);
//            getWindow().setDecorFitsSystemWindows(false);
//        }
//        setUpBottomNavigation();

    }

    private void initNavHost() {
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

//    private void setUpBottomNavigation() {
//        List<CurvedBottomNavigation.Model> bottomNavigationItems = new ArrayList<>();
//        bottomNavigationItems.add(new CurvedBottomNavigation.Model(
//                HOME_ITEM, "Home", R.drawable.home));
//        bottomNavigationItems.add(new CurvedBottomNavigation.Model(
//                APPLY_ITEM, "Apply", R.drawable.apply));
//        bottomNavigationItems.add(new CurvedBottomNavigation.Model(
//                TRACK_ITEM, "Track", R.drawable.track));
//        bottomNavigationItems.add(new CurvedBottomNavigation.Model(
//                PROFILE_ITEM, "Profile", R.drawable.profile_icon));
//
//        for (CurvedBottomNavigation.Model model : bottomNavigationItems) {
//            bottomNavigation.add(model);
//        }
//
//        bottomNavigation.setOnClickMenuListener(item -> {
//            navController.navigate(item.getId());
//            return null;
//        });
//
//        bottomNavigation.show(HOME_ITEM, true);
//
//        bottomNavigation.setupNavController(navController);
//    }


    @Override
    protected void onResume() {
        super.onResume();
        navigation_layout.setVisibility(View.INVISIBLE);
        dark_bg.setVisibility(View.INVISIBLE);
        navigation_icon.setVisibility(View.VISIBLE);
    }
}
