package com.donatenaccept.dna.navigation;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna._history.BloodHistoryFragment;
import com.donatenaccept.dna._home.HomeFragment;
import com.donatenaccept.dna._memories.MemoriesFragment;
import com.donatenaccept.dna._notifications.NotificationFragment;
import com.donatenaccept.dna._profile.ProfileFragment;
import com.donatenaccept.dna._request.RequestFragment;
import com.donatenaccept.dna._setting.view.SettingsFragment;
import com.donatenaccept.dna.sample.BlankFragment;
import com.donatenaccept.dna.utils.Utility;


public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    boolean shouldLoadHomeFragOnBackPress = true;
    private Fragment fragment;
    private boolean doubleBackToExitPressedOnce = false; // flag to load home fragment when user presses back key
    private Handler mHandler;
    public static int navItemIndex = 0;  // index to identify current nav menu item

    // tags used to attach the fragments
    private static final String TAG_HOME = "TAG_HOME";
    private static final String TAG_REQUEST = "TAG_REQUEST";
    private static final String TAG_NOTIFICATIONS = "TAG_NOTIFICATIONS";
    private static final String TAG_BLOOD_HISTORY = "TAG_BLOOD_HISTORY";
    private static final String TAG_MY_PROFILE = "TAG_MY_PROFILE";
    private static final String TAG_MEMORIES = "TAG_MEMORIES";
    private static final String TAG_SETTINGS = "TAG_SETTINGS";
    public static String CURRENT_TAG = TAG_MY_PROFILE;

    TextView tvTitle, tvAction;
    ImageView ivAction;
    LinearLayout llLocation, llProfileBank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utility.setStatusBarTranslucent(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        findViewById();

        initUi(savedInstanceState);

    }

    private void initUi(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        mHandler = new Handler();

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_MY_PROFILE;
            loadHomeFragment();
        }
    }

    private void findViewById() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) toolbar.findViewById(R.id.tv_nav_title);
        tvAction = (TextView) toolbar.findViewById(R.id.tv_action);
        tvAction.setOnClickListener(this);
        ivAction = (ImageView) toolbar.findViewById(R.id.iv_action);
        ivAction.setOnClickListener(this);
        llLocation = (LinearLayout) toolbar.findViewById(R.id.ll_location);
        llProfileBank = (LinearLayout) toolbar.findViewById(R.id.ll_profile_bank);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    public void loadNavHeader() {


    }


    private void loadHomeFragment() {

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();

    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // Home

                refreshActionBarContent();
                llLocation.setVisibility(View.VISIBLE);
                llProfileBank.setVisibility(View.VISIBLE);
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new HomeFragment();

                return fragment;

            case 1:
                // Request

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("Request");
                tvAction.setVisibility(View.VISIBLE);
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new RequestFragment();

                return fragment;

            case 2:
                // Notification

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("Notifications");
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new NotificationFragment();

                return fragment;

            case 3:
                // History

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("Blood History");
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new BloodHistoryFragment();

                return fragment;

            case 4:
                // Profile

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("My Profile");
                ivAction.setVisibility(View.VISIBLE);
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar2));
                fragment = new ProfileFragment();

                return fragment;

            case 5:
                // Memories

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("Memories");
                tvAction.setVisibility(View.VISIBLE);
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new MemoriesFragment();

                return fragment;

            case 6:
                // Settings

                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("Settings");
                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar));
                fragment = new SettingsFragment();

                return fragment;

            default:
                refreshActionBarContent();
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText("");

                toolbar.setBackground(getResources().getDrawable(R.drawable.layout_bg_toolbar2));

                return new BlankFragment();

        }
    }

    private void setUpNavigationView() {

        navigationView.setItemIconTintList(null);

        disableNavigationViewScrollbars(navigationView);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_request:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_REQUEST;
                        break;
                    case R.id.nav_notifications:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_NOTIFICATIONS;
                        break;
                    case R.id.nav_blood_history:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_BLOOD_HISTORY;
                        break;
                    case R.id.nav_profile:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_MY_PROFILE;
                        break;
                    case R.id.nav_memories:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_MEMORIES;
                        break;

                    case R.id.nav_share:
                        String appUrl = Utility.getAppUrl(NavigationActivity.this);
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_TEXT, appUrl);
                        startActivityForResult(Intent.createChooser(i, "Share with"), 600);
                        break;

                    case R.id.nav_rate_us:
                        Utility.OpenPlayStore(NavigationActivity.this);
                        break;


                    case R.id.nav_settings:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;


                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.hamburger, getTheme());

        actionBarDrawerToggle.setHomeAsUpIndicator(drawable);
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


    private void refreshActionBarContent() {
        tvTitle.setVisibility(View.GONE);
        tvAction.setVisibility(View.GONE);
        ivAction.setVisibility(View.GONE);
        llLocation.setVisibility(View.GONE);
        llProfileBank.setVisibility(View.GONE);
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_MY_PROFILE;
                loadHomeFragment();
                return;
            } else {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_action:
                if (fragment != null && fragment instanceof RequestFragment)
                    ((RequestFragment) fragment).addRequest();
                else if (fragment != null && fragment instanceof MemoriesFragment)
                    ((MemoriesFragment) fragment).addMemories();

                break;

            case R.id.iv_action:
                Utility.showToast(NavigationActivity.this, "Action Profile");
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}