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
        addRooms();
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);
    }


    private void addRooms() {
        roomDatas.add(new Room(17000, "서울시 성북구 장위동", 3, "풀옵션"));
        roomDatas.add(new Room(20000, "서울시 성북구 성북동", 3, "반려견"));
        roomDatas.add(new Room(5500, "서울시 성북구 월곡동", 3, "투룸"));
        roomDatas.add(new Room(9700, "서울시 성북구 상월곡동", 0, "지하철 5분거리"));
        roomDatas.add(new Room(50000, "서울시 성북구 하월곡동", -1, "집주인 착함"));
        roomAdapter.notifyDataSetChanged();
    }

}
