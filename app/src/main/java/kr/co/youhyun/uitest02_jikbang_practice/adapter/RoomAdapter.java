package kr.co.youhyun.uitest02_jikbang_practice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import kr.co.youhyun.uitest02_jikbang_practice.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects, Context mContext, List<Room> mList, LayoutInflater inf) {
        super(context, resource, objects);
        this.mContext = mContext;
        this.mList = mList;
        this.inf = inf;
    }
}
