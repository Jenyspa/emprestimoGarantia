package br.com.creditas.creditas.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.util.List;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.adapter.ExpenseAdapter;
import br.com.creditas.creditas.entity.Expense;
import br.com.creditas.creditas.entity.ExpenseType;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SimulatorFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_simulator, container, false);
        init();
        return view;
    }

    private void init() {
        ButterKnife.bind(this, view);
        loadValues();
        setEvents();
    }

    private void setEvents() {
    }


    private BigDecimal convertTextInMoney(String s) {
        if (s.isEmpty()){
            return new BigDecimal(0.00);
        } else {
            return new BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN);
        }
    }

    private void loadValues() {

    }


}
