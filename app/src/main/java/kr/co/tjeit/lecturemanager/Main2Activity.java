package kr.co.tjeit.lecturemanager;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> studentsArrayList;
    ListView studentListView;
    ArrayAdapter<String> studentListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        studentsArrayList = new ArrayList<String>();
        studentsArrayList.add("학생1");
        studentsArrayList.add("학생2");
        studentsArrayList.add("학생3");
        studentsArrayList.add("학생4");
        studentsArrayList.add("학생5");
        studentsArrayList.add("학생6");
        studentsArrayList.add("학생7");
        studentsArrayList.add("학생8");
        studentsArrayList.add("학생9");
        studentsArrayList.add("학생10");



        studentListView = (ListView)findViewById(R.id.studentListView);
        studentListAdapter = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1, studentsArrayList);
        studentListView.setAdapter(studentListAdapter);

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this,  position+"번 학생.", Toast.LENGTH_SHORT).show();
            }
        });

        studentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(Main2Activity.this);
                myBuilder.setTitle("삭제확인");
                myBuilder.setMessage("정말 삭제 하시겠습니까?");
                myBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        studentsArrayList.remove(position);
                        studentListAdapter.notifyDataSetChanged();

                    }
                });
                myBuilder.setNegativeButton("취소", null);
                myBuilder.show();
                return false;
            }
        });




    }
}
