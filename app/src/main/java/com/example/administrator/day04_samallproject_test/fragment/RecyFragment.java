package com.example.administrator.day04_samallproject_test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.day04_samallproject_test.R;
import com.example.administrator.day04_samallproject_test.bean.ApiService;
import com.example.administrator.day04_samallproject_test.bean.Constant;
import com.example.administrator.day04_samallproject_test.bean.MyApplication;
import com.example.administrator.day04_samallproject_test.bean.Student;
import com.example.administrator.day04_samallproject_test.bean.User;
import com.example.administrator.day04_samallproject_test.adapter.RecyAdapter;
import com.example.greendaodemo.gen.StudentDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyFragment extends Fragment {

    private List<User.StudentsBean.StudentBean> beanList;
    private RecyclerView lv_recy;
    private RecyAdapter adapter;

    //dasdas
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_recy, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getDataUrl(Constant.URL);
        call.enqueue(new Callback<User>() {



            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                beanList = response.body().getStudents().getStudent();

                LinearLayoutManager manager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                adapter = new RecyAdapter(beanList,getActivity());
                lv_recy.setLayoutManager(manager);
                lv_recy.setAdapter(adapter);
               // initListener();

            }



          /*  private void initListener() {

                adapter.OnItemClikListener(new RecyAdapter.OnClick() {
                    @Override
                    public void OnItemClick(int position) {

                        StudentDao studentDao = MyApplication.getApplication().getDaoSession().getStudentDao();
                        Student student =new Student();
                        student.setContent(beanList.get(position).getContent());
                        student.setName(beanList.get(position).getName());
                        student.setImg(beanList.get(position).getImg());
                        studentDao.insert(student);
                    }
                });



            }
*/
            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private void initView(View inflate) {
        lv_recy = (RecyclerView) inflate.findViewById(R.id.lv_recy);
    }
}
