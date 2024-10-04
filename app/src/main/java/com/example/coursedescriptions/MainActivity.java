package com.example.coursedescriptions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

/**
 * MainActivity is the initial screen displayed when the user launches the application. It displays
 * the list of classes. Whenever this class is loaded from an intent with a ToastMessageExtra, it
 * displays the Toast.
 */
public class MainActivity extends AppCompatActivity {
    Context mainContext = this;

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

        //Check for toast message extra. If one is present, display the toast to the user.
        ToastMessageExtra toastMessageExtra = getIntent().getSerializableExtra("toastMessageExtra", ToastMessageExtra.class);
        if(toastMessageExtra != null){
            Toast toastMessage = Toast.makeText(mainContext, toastMessageExtra.getToastMessage(), Toast.LENGTH_SHORT);
            toastMessage.show();
        }

        //Display the list of Courses as an Item List
        ArrayList<Course> courseList = generateCourses();
        CourseListAdapter courseListAdapter = new CourseListAdapter(MainActivity.this, courseList);
        ListView courseListView = findViewById(R.id.courseList);
        courseListView.setAdapter(courseListAdapter);
        //When an item in the list is clicked, it will use an Intent to load the CourseInfoActivity
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Course selectedCourse = (Course) adapterView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,CourseInfoActivity.class);
                intent.putExtra("selectedCourse", selectedCourse);
                startActivity(intent);
            }
        });
    }

    /**
     * Generate the list of courses.
     * @return ArrayList of courses.
     */
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