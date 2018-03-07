package com.example.administrator.day04_samallproject_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.day04_samallproject_test.R;
import com.example.administrator.day04_samallproject_test.bean.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class ShouCangAdapter extends RecyclerView.Adapter<ShouCangAdapter.ViewHolder> {
    private Context context;
    private List<Student> studentList;
    OnClick listener;
    public ShouCangAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public ShouCangAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ShouCangAdapter.ViewHolder holder = null;

        View inflate = LayoutInflater.from(context).inflate(R.layout.recy_item, parent, false);
        holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShouCangAdapter.ViewHolder holder, final int position) {

        holder.content.setText(studentList.get(position).getContent());
        holder.name.setText(studentList.get(position).getName());
        Picasso.with(context).load(studentList.get(position).getImg()).into(holder.img);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked==true){

                    listener.OnItemClick(position);
                }else {
                    Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                listener.OnItemLongClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView content;
        private final CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }


    public interface OnClick {

        void OnItemClick(int position);
        void  OnItemLongClick(int position);
    }


    public void OnItemClikListener(OnClick listener) {

        this.listener = listener;
    }
}
