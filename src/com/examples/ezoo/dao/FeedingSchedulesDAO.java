package com.examples.ezoo.dao;

import java.util.List;

import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.SchedulAssignment;
import com.examples.ezoo.model.Schedule;

public interface FeedingSchedulesDAO 
{
        public   List<Schedule> getAllScheds();
        public   List<SchedulAssignment> getSchedAssignments();
        public  void saveSched2DB(Schedule schedule) throws Exception;
        public  void deleteSchedFromDB(int id);
        public  Schedule getSched(int animalid);
        public  void assignSched(int animalid,int scheduleid);
        public  void cancelSched(int anid,int schedid);

}
