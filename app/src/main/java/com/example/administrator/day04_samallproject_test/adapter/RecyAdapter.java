package com.example.administrator.day04_samallproject_test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day04_samallproject_test.R;
import com.example.administrator.day04_samallproject_test.bean.MyApplication;
import com.example.administrator.day04_samallproject_test.bean.Student;
import com.example.administrator.day04_samallproject_test.bean.User;
import com.example.greendaodemo.gen.StudentDao;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private List<User.StudentsBean.StudentBean> beanList;

    private Context context;
    OnClick listener;

    public RecyAdapter(List<User.StudentsBean.StudentBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyAdapter.ViewHolder holder = null;

        View inflate = LayoutInflater.from(context).inflate(R.layout.recy_item, parent, false);
        holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.content.setText(beanList.get(position).getContent());
        holder.name.setText(beanList.get(position).getName());
        Picasso.with(context).load(beanList.get(position).getImg()).into(holder.img);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    StudentDao studentDao = MyApplication.getApplication().getDaoSession().getStudentDao();
                    Student student =new Student();
                    student.setContent(beanList.get(position).getContent());
                    student.setName(beanList.get(position).getName());
                    student.setImg(beanList.get(position).getImg());
                    studentDao.insert(student);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return beanList.size();
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
    }


    public void OnItemClikListener(OnClick listener) {

        this.listener = listener;
    }
}
