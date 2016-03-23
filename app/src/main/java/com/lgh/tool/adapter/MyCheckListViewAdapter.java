package com.lgh.tool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lgh.tool.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/22.
 */
public class MyCheckListViewAdapter extends BaseAdapter {
    private Context context;
private List<HashMap<String, Object>> listData;
    // 用来控制CheckBox的选中状况
//    private static HashMap<Integer, Boolean> isSelected;
    Map<Integer, Boolean> isCheckMap;
    class ViewHolder {

        TextView tvName;
        CheckBox cb;
    }

    public MyCheckListViewAdapter(Context context, List<HashMap<String, Object>> listData) {
        this.listData=listData;
        this.context = context;
        isCheckMap = new HashMap<Integer, Boolean>();
        // 初始化数据
        initDate();
    }

    // 初始化isSelected的数据
    private void initDate() {
        for (int i = 0; i < listData.size(); i++) {
            isCheckMap.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 页面
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.assist_device_binding_list_item, null);
            holder = new ViewHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.tv_device_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(listData.get(position).get("text").toString());
        holder.cb.setTag(listData.get(position).get("cbid").toString());
        // 监听checkBox并根据原来的状态来设置新的状态
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int cbId = Integer.parseInt(buttonView.getTag().toString());
                if (isChecked) {
                    //将选中的放入hashmap中
                    isCheckMap.put(cbId, isChecked);
                } else {
                    //取消选中的则剔除
                    isCheckMap.remove(cbId);
                }
            }
        });
        // 根据isSelected来设置checkbox的选中状况
        if(isCheckMap!=null && isCheckMap.containsKey(position)) {
            holder.cb.setChecked(isCheckMap.get(position));
        }else {
            holder.cb.setChecked(false);
        }
        return convertView;
    }
//
//    public static HashMap<Integer, Boolean> getIsSelected() {
//        return isSelected;
//    }
//    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
//        MyCheckListViewAdapter.isSelected = isSelected;
//    }
}
