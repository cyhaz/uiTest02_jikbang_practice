package kr.co.youhyun.uitest02_jikbang_practice;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.co.youhyun.uitest02_jikbang_practice.adapters.RoomAdapter;
import kr.co.youhyun.uitest02_jikbang_practice.databinding.ActivityMainBinding;
import kr.co.youhyun.uitest02_jikbang_practice.datas.Room;

public class MainActivity extends BaseActivity {

    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;
    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }
}
