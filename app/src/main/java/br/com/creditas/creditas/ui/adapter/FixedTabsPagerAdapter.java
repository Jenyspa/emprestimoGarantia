package br.com.creditas.creditas.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.creditas.creditas.ui.fragment.ExpensesFragment;
import br.com.creditas.creditas.ui.fragment.SimulatorFragment;
import br.com.creditas.creditas.ui.fragment.TipsFragment;

/**
 * Created by renansantos on 20/10/15.
 */
public class FixedTabsPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public FixedTabsPagerAdapter(FragmentManager fm) {
        super(fm);
        setFragmentList();
    }

    private void setFragmentList() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ExpensesFragment());
        fragmentList.add(new SimulatorFragment());
        fragmentList.add(new TipsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

}
