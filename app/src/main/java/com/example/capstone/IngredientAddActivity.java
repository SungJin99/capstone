package com.example.capstone;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.capstone.R;

public class IngredientAddActivity extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    public static final int BARCODE_SCAN_REQUEST_CODE = 200;

    private EditText nameEditText;
    private EditText expiryEditText;
    private Button cameraButton;
    private Button increaseButton;
    private Button decreaseButton;
    private TextView quantityTextView;
    private EditText memoEditText;
    private Button registerButton;

    private TextView barcodeTextView;
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_add);
        barcodeTextView = findViewById(R.id.barcodeEditText);
        nameEditText = findViewById(R.id.nameEditText);
        expiryEditText = findViewById(R.id.expiryEditText);
        cameraButton = findViewById(R.id.cameraButton);
        increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);
        quantityTextView = findViewById(R.id.quantityTextView);
        memoEditText = findViewById(R.id.memoEditText);
        registerButton = findViewById(R.id.registerButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(IngredientAddActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(IngredientAddActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                } else {
                    openCamera();
                }
            }
        });

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity--;
                    quantityTextView.setText(String.valueOf(quantity));
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String expiry = expiryEditText.getText().toString();
                String memo = memoEditText.getText().toString();

                // 등록할 식재료 정보와 메모를 이용하여 작업 수행
                // ...

                // 예시: 토스트 메시지로 등록 완료 메시지 표시
                Toast.makeText(IngredientAddActivity.this, "식재료가 등록되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openCamera() {
        Intent intent = new Intent(IngredientAddActivity.this, CameraActivity.class);
        startActivityForResult(intent, BARCODE_SCAN_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BARCODE_SCAN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String scanResult = data.getStringExtra("SCAN_RESULT");
                // 스캔 결과 처리
                // 예를 들어, TextView에 스캔 결과 출력
                barcodeTextView.setText("스캔 결과: " + scanResult);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // 스캔 취소 처리
            } else {
                // 기타 처리
            }
        }
    }

}