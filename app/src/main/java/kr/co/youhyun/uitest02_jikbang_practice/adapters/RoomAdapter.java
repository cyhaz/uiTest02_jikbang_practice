package kr.co.youhyun.uitest02_jikbang_practice.adapters;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.youhyun.uitest02_jikbang_practice.R;
import kr.co.youhyun.uitest02_jikbang_practice.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.room_list_item, null);
        }

        Room data = mList.get(position);

        TextView roomPriceTxt = row.findViewById(R.id.roomPriceTxt);
        TextView roomAddressTxt = row.findViewById(R.id.roomAddressTxt);
        TextView roomDetailTxt = row.findViewById(R.id.roomDetailTxt);

//        setText에는 int값을 넣지 말자!!!
//        1만 이상이면 억 단위, 아니면 ,찍어서 숫자만 표기
        if (data.getPrice() >= 10000) {
            int uk = data.getPrice() / 10000;
            int thousand = data.getPrice() % 10000;
            if (thousand == 0) {
                roomPriceTxt.setText(String.format("%d억", uk));
            } else {
                roomPriceTxt.setText(String.format("%d억 %,d", uk, thousand));
            }
        } else {
            roomPriceTxt.setText(String.format("%,d", data.getPrice()));
        }

//        주소와 층수 결합해서 출력
        String floorStr = "";
        if (data.getFloor() > 0){
            floorStr = String.format("%d층",data.getFloor());
        } else if (data.getFloor() == 0) {
            floorStr = "반지하";
        } else {
            floorStr = String.format("지하 %d층",data.getFloor()*-1);
        }
        roomAddressTxt.setText(String.format("%s, %s",data.getAddress(), floorStr));

        roomDetailTxt.setText(data.getDetail());

        return row;
    }
}
