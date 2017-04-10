package br.com.creditas.creditas.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.entity.Tips;

/**
 * Created by renan on 4/30/15.
 */
public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    private Context context;
    private final List<Tips> items;
    private final CallbackClick clickCallback;

    public TipsAdapter(CallbackClick clickTips) {
        super();
        this.items = Tips.getAll();
        this.clickCallback = clickTips;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tips, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Tips item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView subtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_tip_title);
            subtitle = (TextView) itemView.findViewById(R.id.item_tip_subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickCallback.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface CallbackClick {
        void onClick(Tips item);
    }

}
