package kr.co.youhyun.uitest02_jikbang_practice;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 클릭된 방의 정보를 목록에서 빼옴 (position번째)
                Room clickedRoom = roomDatas.get(position);

                // 방 상세화면으로 이동
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);
            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                꾹 누르고 있으면, 해당 방의 설명을 Toast로 출력
//                Room data = roomDatas.get(position);
//                Toast.makeText(mContext, data.getDetail(), Toast.LENGTH_SHORT).show();

//                꾹 누르면, 해당 아이템을 목록에서 삭제
                // 지우기 전에 정말 지울건지 확인받기
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("방 삭제 확인");
                alert.setMessage("정말 이 방을 삭제하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 얼럿에서도 확인을 누른 경우 => 삭제
                        roomDatas.remove(position);
                        roomAdapter.notifyDataSetChanged();   // 어댑터에게 새로고침 시킴
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();


                return true;
            }
        });

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);
        addRooms();
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
