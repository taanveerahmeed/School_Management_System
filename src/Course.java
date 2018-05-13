 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taanveer Ahmeed
 */
public class Course {
    
    int courseId,classId;
    String courseName,day,roomAndTime,teacherId;
    
    Course (){
    
    }
    
    Course (String nm,int id,int classid,String day,String roomtime,String teacherid){
        
        courseName = nm;
        courseId = id;
        classId = classid;
        this.day = day;
        roomAndTime = roomtime;
        teacherId = teacherid;
       // teacherName = teachername;
    }
    
    public void showInfoInGui (RegisteredCourses r){
        
        r.output.setText("Course Name : " + courseName + "\nCourse ID : " +courseId+ "\nTiming : " + day + roomAndTime );
    
    }
    
    public void showInfoInGui (TeacherRegisteredCourses r){
        
        r.output.setText("Course Name : " + courseName + "\nCourse ID : " +courseId+ "\nTiming : " + day + roomAndTime );
    
    }
    
}
