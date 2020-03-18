package kr.co.youhyun.uitest02_jikbang_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import kr.co.youhyun.uitest02_jikbang_practice.databinding.ActivityRoomDetailBinding;
import kr.co.youhyun.uitest02_jikbang_practice.datas.Room;

public class RoomDetailActivity extends BaseActivity {

    ActivityRoomDetailBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_detail);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        첨부된 방 데이터를 받아서 화면에 출력
        Room room = (Room) getIntent().getSerializableExtra("room");

        // 가격
        binding.priceTxt.setText(room.getFormattedPrice());

        // 주소
        binding.addressTxt.setText(room.getAddress());

        // 층수
        binding.floorTxt.setText(room.getFormattedFloor());

        // 상세설명
        binding.detailText.setText(room.getDetail());

    }
}
