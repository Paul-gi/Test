package com.example.andy.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TwoFragment extends Fragment {

    public String[] data = {"item1","item2","item3","item4","item5","item6","item7"};
    List<listview_Data> listview_data = new ArrayList<listview_Data>();
    String getsdf="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.getCalendar();
        getsdf = sdf.toString();

        View v= inflater.inflate(R.layout.fragmenttwo, container, false);
        ListView listView=(ListView)v.findViewById(R.id.list);
        listviewAdapter itemadapter = new listviewAdapter(data,getsdf,inflater);
        listView.setAdapter(itemadapter);

        setData(listview_data);

        return v;
    }


    public class  listviewAdapter extends BaseAdapter {

        private String[] ElementsData;   //資料
        private String days;
        private LayoutInflater inflater;    //加載layout
        private int indentionBase;          //item缩排

        //初始化
        public  listviewAdapter(String[] data,String daysetting, LayoutInflater inflater) {
            this.ElementsData = data;
            this.days = daysetting;
            this.inflater = inflater;
            indentionBase = 100;
        }

        @Override
        public int getCount() {
            return ElementsData.length;
        }

        @Override
        public Object getItem(int position) {
            return ElementsData[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                convertView = inflater.inflate(R.layout.fragmenttwo_item, null);
                TextView item = (TextView) convertView.findViewById(R.id.item);
                TextView calender = (TextView) convertView.findViewById(R.id.calender);
                item.setText(listview_data.get(position).getitem());
                calender.setText(listview_data.get(position).getcalender());

            return convertView;
        }
    }
    private  void setData(List<listview_Data> detailList){

        Calendar c = Calendar.getInstance();
        String today="";
        String weekday ="";
        int wek=c.get(Calendar.DAY_OF_WEEK);
        for (int i = 0;i<7;i++) {
            String year = Integer.toString(c.get(Calendar.YEAR));                      //取出年
            String month = Integer.toString(c.get(Calendar.MONTH)+ 1 );           //取出月，月份的編號是由0~11 故+1
            String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH)-i);
            if(wek<1){
                wek = 7;
            }
            if (wek == 1) {
                weekday = "(星期日)";
            }
            if (wek == 2) {
                weekday = "(星期一)";
            }
            if (wek == 3) {
                weekday = "(星期二)";
            }
            if (wek == 4) {
                weekday = "(星期三)";
            }
            if (wek == 5) {
                weekday = "(星期四)";
            }
            if (wek == 6) {
                weekday = "(星期五)";
            }
            if (wek == 7) {
                weekday = "(星期六)";
            }
            wek--;
            today = (year + "/" + month + "/" + day + " " + weekday);
            listview_Data oneDetail = new listview_Data();
            oneDetail.setitem(data[i]);
            oneDetail.setcalender(today);
            detailList.add(oneDetail);
        }
    }


}
