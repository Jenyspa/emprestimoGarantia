package br.com.creditas.creditas.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.entity.ExpenseType;
import br.com.creditas.creditas.ui.adapter.ExpenseTypeAdapter;

/**
 * Created by renan on 5/14/15.
 */
public class DialogExpenseType extends DialogFragment {

    private View view;
    private Callback callback;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_expense_type, container);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        init();
        return view;
    }

    private void init() {
        loadValues();
        setList();
    }

    private void loadValues() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }

    private void setList() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(DialogExpenseType.this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ExpenseTypeAdapter(DialogExpenseType.this.getActivity(), onItemClickScheduleStatus()));
    }

    private ExpenseTypeAdapter.CallbackClick onItemClickScheduleStatus() {
        return new ExpenseTypeAdapter.CallbackClick() {
            @Override
            public void onClick(ExpenseType item) {
                callback.onSelectItem(item);
                DialogExpenseType.this.dismiss();

            }
        };
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        callback.onCancel();
        super.onCancel(dialog);
    }

    public static DialogExpenseType showDialog(FragmentManager fragmentManager, Callback callback) {
        DialogExpenseType dialog = new DialogExpenseType();
        dialog.setRetainInstance(true);
        dialog.setCallback(callback);
        dialog.show(fragmentManager, "categoriesDialog");

        return dialog;
    }

    private void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onSelectItem(ExpenseType scheduleStatusItem);

        void onCancel();
    }
}