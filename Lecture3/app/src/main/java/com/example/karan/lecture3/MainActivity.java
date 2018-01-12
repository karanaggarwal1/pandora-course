package com.example.karan.lecture3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//anything which is diplayed on the screen has to be extended by the class view. It has the
//basic functionality required for rendering an object visible on the phone.
//ViewGroup is another class which extends View class.It can have multiple views.
//for example:in a view class object it can't have another object defined within itself.
//view group can achieve this.
//all types of layouts like RelativeLayout extend ViewGroup
//9 places for an object in frame layout based on different types of gravities for it
//no other space can be occupied in frame layouts
//z index is not available in xml
//linearlayout(orientation) gives the objects side by side according to the given orientation, horizontal or vertical
//by default linear layout is not scrollable
//relative layout allows placement of it's objects relative to each other.
//an object's positioning is relative that is it's position depends on other objects or views.
//table layout has rows and columns
//table rows is a layout which can be used within the table layout layout or independently as well.
//table layout or grid layout difference is that in grid layout that the width of the cell and the height can be in a ratio other than 1:1.
//in xml whichever is defined later is above the other object.
//View-Measure then group(Size is required prior to execution)
//ViewGroup-Group then measure(Multiple views are made in the run time as well.
//we use other layouts if possible anf iff not possible then use relative layout.
//because relative layout has a higher time complexity
//for example:frame layout has object laying time complexity O(1) because size doesn't matter
//linear layouts-layout complexity is O(n)
//in the worst case for relative layout will have a time complexity of O(n^2);
//if two views depend on each other then a dependency cycle will be created and an infinite recursion is developed.
//table layout has time complexity is O(1);
//grid layout has time complexity is O(1) on an average;
//fragment allows importing of an xml file to another xml file
//multiple files can be joined and made as a single unit.
//set content view-accepts layout not view;
//layout file can have a root as another layout but generally not used.
//generally it is view only
//containers are also view group extended classes.
//they are certain types of views which contain multiple views.
//radio group-group of radio buttons
//list view-array of objects displayed according to some logic
//expandable list view-clicking on an object gives more detail
//scrollview has a constraint that it can have only one view not multple.
//add multiple views in a single view as a workaround to the constraint as a scrollview
//list view is automatically scrollable and hence can't be put in a scroll view.
//tabhost enables scrolling of multiple tabs(like tabs in chrome)
//webview enables rendering of web pages in css and javascript code especially in an app(like instagram,facebook etc)
//custom-not part of the OS. present because of support libs.
//view changes reflect in model, vice-versa, there are various architectures like MCA.connection between the two is achieved via MCA
//adapter is a class-changes in a view are reflected on the screen//all major components of an activity has certain context
//activity itself extends context
//context-dependencies of an activity
//for example-the activites which can be started by their self, or an activity which depends on another all this defined in the context class.
//listView of different essential components will be different.
//this can also serve as the purpose of context,whereas getBaseContext() returns the context of the class, whereas getppContext(0) returns the context of an app
//our resources-R file-access
//OS resources-android file-access
//their parameter-which parameter in which content is added.
//in arrayadapter<> this list item which is displayed in the object, the logic is already written
//it takes four parameters
//1st parameter is the context paramate, that is in which context the app is being run
//2nd parameter specifies in what layout will the content be printed;
//3rd parameter specifies in what manner will the text be printed, for example:maybe in a textview
//4th parameter specifies the object to be printed in the layout
//convention for activity name is : ActivityName_layoutName
public class MainActivity extends AppCompatActivity {
//    public static final String[] names=new String[]{
//            "Rahul",
//            "Karan",
//            "Hello",
//            "Bye",
//            "A",
//            "B",
//            "C",
//            "D",
//            "E",
//            "F",
//            "G",
//            "H",
//            "I",
//            "J",
//    };
    ListView StudentList;
    public static final String TAG="MainAct";
    final ArrayList<Student> studentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentList=(ListView)findViewById(R.id.list_item);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                names
//        );


        studentList.add(new Student("Ram",15,"Pandora"));
        studentList.add(new Student("Rama",16,"Pandora"));
        studentList.add(new Student("Pam",17,"Pandora"));
        studentList.add(new Student("Sham",18,"Pandora"));
        studentList.add(new Student("Man",19,"Pandora"));
        studentList.add(new Student("Lamb",20,"Pandora"));
        studentList.add(new Student("Game",21,"Pandora"));
        StudentList.setAdapter(new StudentListAdapter());
    }

    class StudentListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return studentList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li= getLayoutInflater();
            View itemView=li.inflate(R.layout.list_item_student,null);
            ((TextView)itemView.findViewById(R.id.tvName)).setText(studentList.get(i).getName());
            ((TextView)itemView.findViewById(R.id.tvAge)).setText(String.valueOf(studentList.get(i).getAge()));
            ((TextView)itemView.findViewById(R.id.tvCourse)).setText(studentList.get(i).getCourse());
            return itemView;
        }
    }
}
