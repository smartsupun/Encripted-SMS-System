package com.example.app3;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class chat_bubble extends Activity {
    ListView listview;
    EditText chat_text;
    Button SEND;
    boolean position=false;
    ChatAdapter adapter;
    Context ctx=this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_bubble);

        listview= (ListView) findViewById(R.id.chat_list_view);
        chat_text=(EditText) findViewById(R.id.chatTxt);
        SEND=(Button)findViewById(R.id.send_button);

        adapter=new ChatAdapter(ctx,R.layout.single_message_layout);
        listview.setAdapter(adapter);
        listview.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        // Remove list item divider
        listview.setDivider(null);
        listview.setDividerHeight(10);

        adapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged(){
                super.onChanged();
                listview.setSelection(adapter.getCount()-1);

            }
        });

    SEND.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            adapter.add(new DataProvider(position,chat_text.getText().toString()));
            position=!position;
            chat_text.setText("");

        }
    });

    }




}
