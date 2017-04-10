package br.com.creditas.creditas.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.entity.ExpenseType;

/**
 * Created by renan on 4/30/15.
 */
public class ExpenseTypeAdapter extends RecyclerView.Adapter<ExpenseTypeAdapter.ViewHolder> {
    private final Context context;
    private final List<ExpenseType> items;
    private final CallbackClick clickCallback;

    public ExpenseTypeAdapter(Context context, CallbackClick clickSegments) {
        super();
        this.context = context;
        this.items = ExpenseType.getAll();
        this.clickCallback = clickSegments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_line, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ExpenseType item = items.get(position);
        holder.label.setText(item.getLabel());
        holder.color.setBackgroundResource(item.getColor());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView label;
        View color;

        public ViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.item_single_line_label);
            color = itemView.findViewById(R.id.item_single_line_color);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickCallback.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface CallbackClick {
        void onClick(ExpenseType item);
    }

}
