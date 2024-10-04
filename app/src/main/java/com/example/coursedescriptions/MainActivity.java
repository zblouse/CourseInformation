package com.example.coursedescriptions;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Course> courseList = generateCourses();
        CourseListAdapter courseListAdapter = new CourseListAdapter(MainActivity.this, courseList);
        ListView courseListView = findViewById(R.id.courseList);
        courseListView.setAdapter(courseListAdapter);

    }

    private ArrayList<Course> generateCourses(){
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("SWENG-581","Software Testing", "This course provides a rigorous formal framework and practical information on the testing of software throughout its life cycle.",3));
        courseList.add(new Course("SWENG-586", "Requirements Engineering","Theory and applications of requirements elicitation, analysis, modeling, validation, testing, and writing for hardware and software systems", 3));
        courseList.add(new Course("SWENG-837", "Software Systems Design","Students will learn how to analyze customer requirements and then systematically develop complete software specifications to meet those requirements using appropriate techniques for the application domain.", 3));
        courseList.add(new Course("SWENG-861", "Software Construction", "Students will learn and practice the elements of constructing a large-scale distributed software system using current technologies.",3));
        courseList.add(new Course("SWENG-888","Mobile Applications","Design and development of mobile computing-based applications and services utilizing current and emerging mobile computing technologies. The purpose of this course is to provide students with an advanced and hands-on exploration of mobile computing paradigms.",3));

        return courseList;
    }
}