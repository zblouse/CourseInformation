package com.example.coursedescriptions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourseInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        Course course = getIntent().getSerializableExtra("selectedCourse", Course.class);

        TextView courseNameTextView = findViewById(R.id.courseName);
        courseNameTextView.setText(course.getCourseName());

        TextView courseCodeTextView = findViewById(R.id.courseCode);
        courseCodeTextView.setText(course.getCourseCode());

        TextView creditsTextView = findViewById(R.id.credits);
        creditsTextView.setText("Credits: " + course.getCredits());

        TextView courseDescriptionTextView = findViewById(R.id.description);
        courseDescriptionTextView.setText(course.getCourseDescription());

        Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseInfoActivity.this, MainActivity.class);
                intent.putExtra("toastMessageExtra", new ToastMessageExtra("Operation Successful"));
                startActivity(intent);
            }
        });

    }
}
