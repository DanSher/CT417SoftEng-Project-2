package softEngTestGro.softEngTestArt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.joda.time.DateTime;

import softEng.softEngEnda.Course;
import softEng.softEngEnda.Module;
import softEng.softEngEnda.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ArrayList<Student> studList1 = new ArrayList<Student>();
    	studList1.add( new Student("John Bloggs", 21, "22/03/1996", 15573922) );
    	studList1.add( new Student("Jane Bloggs", 20, "15/01/1997", 15573452) );
    	
    	ArrayList<Student> studList2 = new ArrayList<Student>();
    	studList2.add( new Student("David Fahy", 21, "26/05/1996", 15573624) );
    	studList2.add( new Student("Elaine Fitzgerald", 19, "30/04/1998", 15573710) );
    	studList2.add( new Student("Jane Bloggs", 20, "15/01/1997", 15573452) );
    	
    	ArrayList<Module> moduleList = new ArrayList<Module>();
    	moduleList.add( new Module("Data Science", "CT639", studList1) );
    	moduleList.add( new Module("Programming", "CT416", studList2) );
    	
    	ArrayList<Course> courseList = new ArrayList<Course>();
    	courseList.add( new Course( "Computer Science", moduleList, new DateTime(), new DateTime()) );
    	//placed the course into an array to show multiple courses could work
    	HashMap<String, String> map = new HashMap<String, String>();
    	
    	for( Course course : courseList ){
	    	for( Module module : course.getModuleList() ){
	    		for( Student student : module.getStudentList() ){
	    			String studentName = student.getName();
	    			if( !map.containsKey( studentName ) ){
	    				map.put( studentName, module.getName() );
	    			}
	    			else{
	    				map.put( studentName , map.get( studentName ) + ", " + module.getName() );
	    			}
	    		}
	    	}
	    	for( Entry<String, String> entry : map.entrySet() ){
	    		System.out.println( "Student: " + entry.getKey() + "\n Course: " + course.getName() +
	    				"\n Modules: " + entry.getValue() + "\n" );
	    	}
    	}
    }
}
