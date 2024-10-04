package com.example.coursedescriptions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Adapter for the array of courses that will be displayed in the ListView
 */
public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(Context context, ArrayList<Course> courseList){
        super(context,0,courseList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_list_view, parent, false);
        }

        Course course = getItem(position);

        TextView courseCodeTextView = convertView.findViewById(R.id.courseCode);
        TextView courseNameTextView = convertView.findViewById(R.id.courseName);

        courseCodeTextView.setText(course.getCourseCode());
        courseNameTextView.setText(course.getCourseName());

        return convertView;
    }
}
