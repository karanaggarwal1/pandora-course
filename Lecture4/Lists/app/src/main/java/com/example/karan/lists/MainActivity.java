package com.example.karan.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
//when scrolling, getView for the new item is called by reusing the view object of the object no more visible stuff
//thus,the total number of views for a class is always same as the number of items as being displayed on the screen
//old code doesn't take advantage of this fact
//because new views are created without any restriction
//view rendering is an resource intensive task.
//sometimes android may create more views than are being shown on the screen due to fast scrolling however the excess views are collected by the Garbage Collector once the screen has stopped;

public class MainActivity extends AppCompatActivity {
    ListView lvStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("A",18,"Pandora"));
        students.add(new Student("B",18,"Pandora"));
        students.add(new Student("C",18,"Pandora"));
        students.add(new Student("D",18,"Pandora"));
        students.add(new Student("E",18,"Pandora"));
        students.add(new Student("F",18,"Pandora"));
        students.add(new Student("G",18,"Pandora"));
        students.add(new Student("H",18,"Pandora"));
        students.add(new Student("I",18,"Pandora"));
        students.add(new Student("J",18,"Pandora"));
        students.add(new Student("K",18,"Pandora"));
        students.add(new Student("L",18,"Pandora"));
        students.add(new Student("M",18,"Pandora"));
        students.add(new Student("N",18,"Pandora"));
        students.add(new Student("O",18,"Pandora"));
        students.add(new Student("P",18,"Pandora"));
        students.add(new Student("Q",18,"Pandora"));
        students.add(new Student("R",18,"Pandora"));
        students.add(new Student("S",18,"Pandora"));
        students.add(new Student("T",18,"Pandora"));
        students.add(new Student("U",18,"Pandora"));
        students.add(new Student("V",18,"Pandora"));
        students.add(new Student("W",18,"Pandora"));
        students.add(new Student("X",18,"Pandora"));
        students.add(new Student("Y",18,"Pandora"));
        students.add(new Student("Z",18,"Pandora"));
        students.add(new Student("A",18,"Elixir"));
        students.add(new Student("B",18,"Elixir"));
        students.add(new Student("C",18,"Elixir"));
        students.add(new Student("D",18,"Elixir"));
        students.add(new Student("E",18,"Elixir"));
        students.add(new Student("F",18,"Elixir"));
        students.add(new Student("G",18,"Elixir"));
        students.add(new Student("H",18,"Elixir"));
        students.add(new Student("I",18,"Elixir"));
        students.add(new Student("J",18,"Elixir"));
        students.add(new Student("K",18,"Elixir"));
        students.add(new Student("L",18,"Elixir"));
        students.add(new Student("M",18,"Elixir"));
        students.add(new Student("N",18,"Elixir"));
        students.add(new Student("O",18,"Elixir"));
        students.add(new Student("P",18,"Elixir"));
        students.add(new Student("Q",18,"Elixir"));
        students.add(new Student("R",18,"Elixir"));
        students.add(new Student("S",18,"Elixir"));
        students.add(new Student("T",18,"Elixir"));
        students.add(new Student("U",18,"Elixir"));
        students.add(new Student("V",18,"Elixir"));
        students.add(new Student("W",18,"Elixir"));
        students.add(new Student("X",18,"Elixir"));
        students.add(new Student("Y",18,"Elixir"));
        students.add(new Student("Z",18,"Elixir"));
        students.add(new Student("A",18,"Launchpad"));
        students.add(new Student("B",18,"Launchpad"));
        students.add(new Student("C",18,"Launchpad"));
        students.add(new Student("D",18,"Launchpad"));
        students.add(new Student("E",18,"Launchpad"));
        students.add(new Student("F",18,"Launchpad"));
        students.add(new Student("G",18,"Launchpad"));
        students.add(new Student("H",18,"Launchpad"));
        students.add(new Student("I",18,"Launchpad"));
        students.add(new Student("J",18,"Launchpad"));
        students.add(new Student("K",18,"Launchpad"));
        students.add(new Student("L",18,"Launchpad"));
        students.add(new Student("M",18,"Launchpad"));
        students.add(new Student("N",18,"Launchpad"));
        students.add(new Student("O",18,"Launchpad"));
        students.add(new Student("P",18,"Launchpad"));
        students.add(new Student("Q",18,"Launchpad"));
        students.add(new Student("R",18,"Launchpad"));
        students.add(new Student("S",18,"Launchpad"));
        students.add(new Student("T",18,"Launchpad"));
        students.add(new Student("U",18,"Launchpad"));
        students.add(new Student("V",18,"Launchpad"));
        students.add(new Student("W",18,"Launchpad"));
        students.add(new Student("X",18,"Launchpad"));
        students.add(new Student("Y",18,"Launchpad"));
        students.add(new Student("Z",18,"Launchpad"));
        students.add(new Student("A",18,"Crux"));
        students.add(new Student("B",18,"Crux"));
        students.add(new Student("C",18,"Crux"));
        students.add(new Student("D",18,"Crux"));
        students.add(new Student("E",18,"Crux"));
        students.add(new Student("F",18,"Crux"));
        students.add(new Student("G",18,"Crux"));
        students.add(new Student("H",18,"Crux"));
        students.add(new Student("I",18,"Crux"));
        students.add(new Student("J",18,"Crux"));
        students.add(new Student("K",18,"Crux"));
        students.add(new Student("L",18,"Crux"));
        students.add(new Student("M",18,"Crux"));
        students.add(new Student("N",18,"Crux"));
        students.add(new Student("O",18,"Crux"));
        students.add(new Student("P",18,"Crux"));
        students.add(new Student("Q",18,"Crux"));
        students.add(new Student("R",18,"Crux"));
        students.add(new Student("S",18,"Crux"));
        students.add(new Student("T",18,"Crux"));
        students.add(new Student("U",18,"Crux"));
        students.add(new Student("V",18,"Crux"));
        students.add(new Student("W",18,"Crux"));
        students.add(new Student("X",18,"Crux"));
        students.add(new Student("Y",18,"Crux"));
        students.add(new Student("Z",18,"Crux"));
        lvStudent=(ListView)findViewById(R.id.lvStudent);
        StudentListAdapter2 slAdapter=new StudentListAdapter2(students,this);
        lvStudent.setAdapter(slAdapter);
    }


}
