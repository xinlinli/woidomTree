package com.xinlin.wisdomtree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WisDomForestActivity extends AppCompatActivity {

    @BindView(R.id.et_tree_name)
    EditText etTreeName;
    @BindView(R.id.et_tree_detail)
    EditText etTreeDetail;
    @BindView(R.id.lv_forest)
    ListView lvForest;
    @BindView(R.id.btn_add_tree)
    Button btnAddTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wis_dom_forest);
        ButterKnife.bind(this);
        lvForest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    @OnClick(R.id.btn_add_tree)
    public void onBtnAddTreeClicked() {
        String treeName = etTreeName.getText().toString();
        String treeDetail = etTreeDetail.getText().toString();

    }
}
