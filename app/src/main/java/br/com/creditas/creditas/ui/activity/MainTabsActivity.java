package br.com.creditas.creditas.ui.activity;

import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.ui.adapter.FixedTabsPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by renan on 18/01/16.
 */
public class MainTabsActivity extends AppCompatActivity {

//    @Bind(R.id.toolbar)
//    Toolbar toolbar;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.tabs)
    TabLayout tabs;

    private Application application;
    private FixedTabsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);

        init();
    }

    private void init() {
        setView();
    }

    private void setView() {
        ButterKnife.bind(this);
        loadValues();
        setToolbar();
        setViewPager();
        setTabs();
    }

    private void loadValues() {
        application = (Application) this.getApplication();
    }

    private void setTabs() {
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setText("gastos");
        tabs.getTabAt(1).setText("simulador");
        tabs.getTabAt(2).setText("dicas");
    }

    private void setViewPager() {
        adapter = new FixedTabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void setToolbar() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

}