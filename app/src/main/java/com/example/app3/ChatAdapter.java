package com.example.app3;

import org.xml.sax.DTDHandler;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends ArrayAdapter<DataProvider> {
    private List<DataProvider> chat_list=new ArrayList<DataProvider>();
    private TextView CHAT_TXT;
    Context CTX;


    public ChatAdapter(Context context , int resource){
        super(context,resource);
        CTX=context;
    }

    @Override
    public void add(@Nullable DataProvider object) {
        chat_list.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return chat_list.size();
    }

    @Override
    public DataProvider getItem(int position){
        return chat_list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){
    if(convertView==null){
        LayoutInflater inflator =(LayoutInflater) CTX.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflator.inflate(R.layout.single_message_layout,parent,false);

    }
    CHAT_TXT = (TextView) convertView.findViewById(R.id.singleMessage);
    String Message;
    boolean POSITION;
    DataProvider provider =getItem(position);
    Message=provider.message;
    POSITION=provider.position;
    CHAT_TXT.setText(Message);
    CHAT_TXT.setBackgroundResource(POSITION ? R.drawable.left_side_bubble : R.drawable.right_side_bubble);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    if(!POSITION) {
        params.gravity= Gravity.RIGHT;
    }
    else{
        params.gravity =Gravity.LEFT;
    }
    CHAT_TXT.setLayoutParams(params);
    return convertView;
   }

}