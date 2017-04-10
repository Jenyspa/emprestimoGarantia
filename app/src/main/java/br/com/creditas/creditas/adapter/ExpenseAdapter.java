package br.com.creditas.creditas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.entity.Expense;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by renansantos on 29/06/16.
 */
public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private final List<Expense> expenseList;
    private final CallbackClick onItemClick;
    private Context context;

    public ExpenseAdapter(List<Expense> expenseList, CallbackClick onItemClick){
        super();
        this.expenseList = expenseList;
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.title.setText(expense.getTitle());
        holder.value.setText(formatValue(expense.getValue()));
        holder.label.setBackgroundResource(expense.getExpenseType().getColor());
    }

    private String formatValue(BigDecimal value) {
        return String.format(context.getString(R.string.money_format),
                value.setScale(2, BigDecimal.ROUND_DOWN).toString());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.item_expense_label)
        View label;

        @Bind(R.id.item_expense_title)
        TextView title;

        @Bind(R.id.item_expense_value)
        TextView value;


        public ViewHolder(View item){
            super(item);
            ButterKnife.bind(this, item);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClick.onClick(expenseList.get(getAdapterPosition()));
        }
    }

    public interface CallbackClick {
        void onClick(Expense clickedService);
    }
}
