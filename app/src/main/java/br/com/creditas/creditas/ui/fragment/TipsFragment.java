package br.com.creditas.creditas.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.creditas.creditas.R;
import br.com.creditas.creditas.entity.Tips;
import br.com.creditas.creditas.ui.adapter.TipsAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TipsFragment extends Fragment {

    private View view;

    @Bind(R.id.recyclerView)
    RecyclerView tipsRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tips, container, false);
        init();
        return view;
    }

    private void init() {
        ButterKnife.bind(this, view);
        setEvents();
        setList();
    }

    private void setEvents() {
    }

    private void setList() {

        tipsRV.setLayoutManager(new LinearLayoutManager(tipsRV.getContext()));
        tipsRV.setAdapter(new TipsAdapter(onItemClick()));
    }

    private TipsAdapter.CallbackClick onItemClick() {
        return new TipsAdapter.CallbackClick() {
            @Override
            public void onClick(Tips clickTips) {
                Toast.makeText(TipsFragment.this.getContext(), clickTips.getTitle(), Toast.LENGTH_SHORT).show();
            }
        };
    }


}
