package com.xinlin.wisdomtree.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xinlin.wisdomtree.R;
import com.xinlin.wisdomtree.entity.Leaf;
import com.xinlin.wisdomtree.entity.Tree;
import com.xinlin.wisdomtree.entity.Trunk;

import java.util.List;

/**
 * Created by lixinlin on 2018/2/13.
 */

public class CommonAdapter<E> extends BaseAdapter {
    private Context mContext;
    private List<E> list;
    private int  selectItem = -1;
    private Holder holder;

    @SuppressLint("ResourceAsColor")
    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    public CommonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(list != null){
            return list.size();
        }
       return 0;
    }

    @Override
    public Object getItem(int position) {
        if(list !=null){
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_common_layout, null, false);
            holder.name = convertView.findViewById(R.id.tv_tree_name);
            holder.detail = convertView.findViewById(R.id.tv_tree_detail);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        E e = list.get(position);
        if(e instanceof Tree){
            Tree tree = (Tree) e;
            holder.name.setText(tree.getName());
            holder.detail.setText(tree.getDetail());
        }else if(e instanceof Trunk){
            Trunk trunk = (Trunk) e;
            holder.name.setText(trunk.getName());
            holder.detail.setText(trunk.getDetail());
        }else if(e instanceof Leaf){
            Leaf leaf = (Leaf) e;
            holder.name.setText(leaf.getName());
            holder.detail.setText(leaf.getDetail());
        }

            if(position == selectItem){
                convertView.setBackgroundColor(Color.parseColor("#ff00B486"));

            }else{
                convertView.setBackgroundColor(Color.parseColor("#ffffff"));
            }

        return convertView;
    }

    class Holder{
        TextView name;
        TextView detail;
    }
}
