package com.example.karan.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //we need a layout manager because recycler layout is multi purpose and can be used for grids,tables as well.
    ListView studentListView;
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

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rvStudentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentAdapter slAdapter=new StudentAdapter(students,this);
        recyclerView.setAdapter(slAdapter);

    }
}
