package com.xinlin.wisdomtree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;
import com.anye.greendao.gen.ForestDao;
import com.anye.greendao.gen.TreeDao;
import com.xinlin.wisdomtree.adapter.CommonAdapter;
import com.xinlin.wisdomtree.api.MergeDevOpenHelper;
import com.xinlin.wisdomtree.entity.Forest;
import com.xinlin.wisdomtree.entity.Tree;
import com.xinlin.wisdomtree.utils.SharedUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WisDomForestActivity extends AppCompatActivity {

    private static final String TAG = "WisDomForestActivity";
    @BindView(R.id.et_tree_name)
    EditText etTreeName;
    @BindView(R.id.et_tree_detail)
    EditText etTreeDetail;
    @BindView(R.id.lv_forest)
    ListView lvForest;
    @BindView(R.id.btn_add_tree)
    Button btnAddTree;
    @BindView(R.id.btn_delete_tree)
    Button btnDeleteTree;

    private DaoSession daoSession;
    private ForestDao forestDao;
    private TreeDao treeDao;
    private Forest forest;
    private List<Tree> trees;
    private Tree tree;
    private CommonAdapter<Tree> adapter;
    private DaoMaster daoMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wis_dom_forest);
        ButterKnife.bind(this);
//        DaoMaster.DevOpenHelper devOpenHelperDB = new DaoMaster.DevOpenHelper(this, "greendb");
        daoMaster = MergeDevOpenHelper.getDaoMaster("greendb");
        daoSession = daoMaster.newSession();
        forestDao = daoSession.getForestDao();
        treeDao = daoSession.getTreeDao();
        nintForest();//森林初始化仅一次
        initview();
        initData();

    }

    private void nintForest() {
        boolean isInit = SharedUtils.getBoolean(this, "hasInitForest", false);
        if (!isInit) {
            String name = "智慧森林";
            String details = "智慧森林中生长着很多智慧树，照料这片森林的人将获得回报";
            Forest forest = new Forest(1l, name, details);
            long insert = forestDao.insert(forest);
            if (insert != 0) {
                SharedUtils.saveBoolean(this, "hasInitForest", true);
            }
        }
    }

    private void initData() {
        adapter = new CommonAdapter<>(this);
        lvForest.setAdapter(adapter);
        queryTrees();


    }

    private void queryTrees() {
        //新的session才能拿到关联的tree数据；
        daoSession = daoMaster.newSession();
        forestDao = daoSession.getForestDao();
        forest = forestDao.queryBuilder().build().unique();
//        Log.d(TAG, "initData: " + forest.getName() + forest.getDetail() + forest.getId() + forest.getTrees());
        trees = new ArrayList<>();
        List<Tree> treesTemp = forest.getTrees();
        if(forest!=null&&treesTemp!=null){
            int size = treesTemp.size();
            for(int i=0;i<size;i++)
           trees.add(treesTemp.get(size-i-1));
       }


        if (adapter != null) {
            adapter.setList(this.trees);
            int a = adapter.getCount();
            adapter.notifyDataSetChanged();
        }

    }

    private void initview() {
        lvForest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelectItem(position);
                tree = adapter.getList().get(position);
                showSelectedTree(tree);

            }
        });
    }

    private void showSelectedTree(Tree tree) {
        etTreeName.setText(tree.getName());
        etTreeDetail.setText(tree.getDetail());
    }


    @OnClick(R.id.btn_add_tree)
    public void onBtnAddTreeClicked() {
        String treeName = etTreeName.getText().toString();
        String treeDetail = etTreeDetail.getText().toString();
        if (treeName != null && !"".equals(treeName)) {
            tree = new Tree(null, treeName, treeDetail, forest.getId());
            try {
                treeDao.insertOrReplace(tree);
                adapter.setSelectItem(-1);
                queryTrees();

            } catch (Exception e) {
                etTreeName.setText("name already exist");
            }
        } else {
            Toast.makeText(this, "name empty", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btn_delete_tree)
    public void onViewClicked() {
        if (tree != null) {
            try {
                treeDao.delete(tree);
                adapter.setSelectItem(-1);
                queryTrees();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
