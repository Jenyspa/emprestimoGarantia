package br.com.creditas.creditas.ui.fragment;

import android.content.Context;
import android.net.Uri;
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
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.adapter.ExpenseAdapter;
import br.com.creditas.creditas.entity.Expense;
import br.com.creditas.creditas.entity.ExpenseType;
import br.com.creditas.creditas.ui.dialog.DialogExpenseType;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpensesFragment extends Fragment {

    @Bind(R.id.include_expenses_add_item_title_ed)
    EditText titleAddItem;

    @Bind(R.id.include_expenses_add_item_value_ed)
    EditText valueAddItem;

    @Bind(R.id.include_expenses_add_item_create_btn)
    View createBtn;

    @Bind(R.id.include_expenses_summary_amount_alimentacao)
    TextView alimentacaoTV;

    @Bind(R.id.include_expenses_summary_amount_compras)
    TextView comprasTV;

    @Bind(R.id.include_expenses_summary_amount_outros)
    TextView outrosTV;

    @Bind(R.id.include_expenses_summary_amount_lazer)
    TextView lazerTV;

    @Bind(R.id.include_expenses_summary_month_amount)
    TextView monthAmountTV;

    @Bind(R.id.include_expenses_items_rl)
    RecyclerView expensesRV;

    private View view;
    private ExpenseType selectedExpenseType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_expenses, container, false);
        init();
        return view;
    }

    private void init() {
        ButterKnife.bind(this, view);
        loadValues();
        setEvents();
    }

    private void setEvents() {
        createBtn.setOnClickListener(onClickCreateBtn());
    }

    private DialogExpenseType.Callback onSelectLabelDialog() {
        return new DialogExpenseType.Callback() {
            @Override
            public void onSelectItem(ExpenseType expenseType) {
                selectedExpenseType = expenseType;
                Expense.getSavedExpenses().add(new Expense(
                        selectedExpenseType,
                        validateTextToSave(titleAddItem.getText().toString()),
                        convertTextInMoney(valueAddItem.getText().toString())
                ));

                updateMonthAmount();
                setList(Expense.getSavedExpenses());
                setSummary();
            }

            @Override
            public void onCancel() {
                if (selectedExpenseType == null){
                    selectedExpenseType = ExpenseType.getAll().get(0);
                }
            }
        };
    }

    private void updateMonthAmount() {
        monthAmountTV.setText(formatValue(Expense.getSavedExpenesAmount()));
    }

    private String formatValue(BigDecimal value) {
        return String.format(getString(R.string.money_format),
                value.setScale(2, BigDecimal.ROUND_DOWN).toString());
    }

    private View.OnClickListener onClickCreateBtn() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogExpenseType.showDialog(getFragmentManager(), onSelectLabelDialog());
            }
        };
    }

    private String validateTextToSave(String s) {
        return s.isEmpty() ? "Sem título" : s;
    }

    private void setSummary() {
        comprasTV.setText(Expense.getExpensesAmountByType().get(ExpenseType.getAll().get(0))+"%");
        outrosTV.setText(Expense.getExpensesAmountByType().get(ExpenseType.getAll().get(1))+"%");
        lazerTV.setText(Expense.getExpensesAmountByType().get(ExpenseType.getAll().get(2))+"%");
        alimentacaoTV.setText(Expense.getExpensesAmountByType().get(ExpenseType.getAll().get(3))+"%");
    }

    private BigDecimal convertTextInMoney(String s) {
        if (s.isEmpty()){
            return new BigDecimal(0.00);
        } else {
            return new BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN);
        }
    }

    private void loadValues() {
        selectedExpenseType = ExpenseType.getAll().get(0);
        setList(Expense.getSavedExpenses());
        setSummary();
        updateMonthAmount();
    }

    private void setList(List<Expense> expenseList) {

        expensesRV.setLayoutManager(new LinearLayoutManager(expensesRV.getContext()));
        expensesRV.setAdapter(new ExpenseAdapter(expenseList, onItemClick()));
    }

    private ExpenseAdapter.CallbackClick onItemClick() {
        return new ExpenseAdapter.CallbackClick() {
            @Override
            public void onClick(Expense clickedService) {
                Snackbar.make(view, "Remover item?", 1000);
            }
        };
    }

}
