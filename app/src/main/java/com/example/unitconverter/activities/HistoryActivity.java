package com.example.unitconverter.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unitconverter.R;
import com.example.unitconverter.adapters.HistoryAdapter;
import com.example.unitconverter.database.DatabaseHelper;
import com.example.unitconverter.models.HistoryItem;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView rvHistory;
    private DatabaseHelper dbHelper;
    private TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        dbHelper = new DatabaseHelper(this);
        rvHistory = findViewById(R.id.rv_history);
        tvEmpty = findViewById(R.id.tv_empty_history);

        findViewById(R.id.btn_back_history).setOnClickListener(v -> finish());
        findViewById(R.id.btn_clear_history).setOnClickListener(v -> {
            dbHelper.clearHistory();
            loadHistory();
        });

        loadHistory();
    }

    private void loadHistory() {
        List<HistoryItem> historyList = dbHelper.getAllHistory();
        if (historyList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rvHistory.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rvHistory.setVisibility(View.VISIBLE);
            HistoryAdapter adapter = new HistoryAdapter(historyList);
            rvHistory.setLayoutManager(new LinearLayoutManager(this));
            rvHistory.setAdapter(adapter);
        }
    }
}