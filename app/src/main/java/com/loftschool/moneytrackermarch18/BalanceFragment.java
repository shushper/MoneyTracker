package com.loftschool.moneytrackermarch18;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loftschool.moneytrackermarch18.api.Api;
import com.loftschool.moneytrackermarch18.api.BalanceResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalanceFragment extends Fragment {

    private static final String TAG = "BalanceFragment";

    private TextView total;
    private TextView expense;
    private TextView income;
    private DiagramView diagram;

    private Api api;
    private App app;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (App) getActivity().getApplication();
        api = app.getApi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        total = view.findViewById(R.id.total);
        expense = view.findViewById(R.id.expense);
        income = view.findViewById(R.id.income);
        diagram = view.findViewById(R.id.diagram);

        updateData();
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser && isResumed()) {
//            updateData();
//        }
//    }

    private void updateData() {

        Call<BalanceResult> call = api.balance();

        call.enqueue(new Callback<BalanceResult>() {
            @Override
            public void onResponse(Call<BalanceResult> call, Response<BalanceResult> response) {
                BalanceResult result = response.body();

                total.setText(getString(R.string.price, result.income - result.expense));
                expense.setText(getString(R.string.price, result.expense));
                income.setText(getString(R.string.price, result.income));
                diagram.update(result.income, result.expense);
            }

            @Override
            public void onFailure(Call<BalanceResult> call, Throwable t) {

            }
        });



    }
}
