package com.example.classassistantproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class CourseActivity extends AppCompatActivity {

    private static final String TAG = "SubSearchProcess";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        findViewById(R.id.searchButton).setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.searchButton:
                    startToast("검색을 시도합니다..");
                    schSub();
                    break;
            }
        }
    };

    private void schSub(){
        String getSub = ((EditText)findViewById(R.id.majorText)).getText().toString();
        if(getSub.length() >0 ){
            startToast(getSub+"로 검색합니다...");
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            final FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("courseList")
                    .whereEqualTo("courseTitle", getSub)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    //String occupancy = (String) document.get("courseOccupancy");  //if the field is String
                                    // String personal = (String) document.get("coursePersonal");  //if the field is String
                                    // String professor = (String) document.get("courseProfessor");  //if the field is String
                                    String title = (String) document.get("courseTitle");  //if the field is String

                                    startToast(title);
                                    Log.d(TAG, document.getId() + " => " + document.getData());
                                }
                            } else {
                                startToast("일치하는 결과가 없습니다.");
                            }
                        }
                    });


        }else startToast("검색할 과목을 입력해주세요.");

    }

    private void startToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}