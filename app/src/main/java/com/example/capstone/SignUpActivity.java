package com.example.capstone;// SignUpActivity.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpButton = findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 버튼 클릭 시 DB에 처리하는 코드 작성
                // 여기에 회원가입 처리 코드를 작성합니다.
                // 데이터베이스에 새로운 회원 정보를 저장하고, 필요한 처리를 수행합니다.
            }
        });
    }
}
