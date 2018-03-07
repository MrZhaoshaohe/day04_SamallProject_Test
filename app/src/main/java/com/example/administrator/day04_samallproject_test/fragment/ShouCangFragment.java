package com.example.administrator.day04_samallproject_test.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.day04_samallproject_test.R;
import com.example.administrator.day04_samallproject_test.activity.InfoActivity;
import com.example.administrator.day04_samallproject_test.adapter.ShouCangAdapter;
import com.example.administrator.day04_samallproject_test.bean.MyApplication;
import com.example.administrator.day04_samallproject_test.bean.Student;
import com.example.greendaodemo.gen.StudentDao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouCangFragment extends Fragment {


    private RecyclerView lv_recy;
    private List<Student> studentList;
    private ShouCangAdapter adapter;
    private StudentDao studentDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shou_cang, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser &&adapter!=null) {
            initData();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }


    public void initData() {
        studentDao = MyApplication.getApplication().getDaoSession().getStudentDao();
        studentList = studentDao.loadAll();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        lv_recy.setLayoutManager(manager);
        adapter = new ShouCangAdapter(getActivity(), studentList);
        lv_recy.setAdapter(adapter);

        initListner();

    }

    private void initListner() {

        adapter.OnItemClikListener(new ShouCangAdapter.OnClick() {
            @Override
            public void OnItemClick(int position) {

                Intent intent =new Intent(getActivity(),InfoActivity.class);
                intent.putExtra("name",studentList.get(position).getName());
                intent.putExtra("content",studentList.get(position).getContent());
                intent.putExtra("img",studentList.get(position).getImg());
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(final int position) {


                new AlertDialog.Builder(getActivity()).setMessage("确认要删除吗?")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Long id = studentList.get(position).getId();
                                studentDao.deleteByKey(id);
                               initData();
                            }
                        })
                        .create()
                        .show();

            }
        });

    }

    private void initView(View inflate) {
        lv_recy = (RecyclerView) inflate.findViewById(R.id.lv_recy);

    }
}
