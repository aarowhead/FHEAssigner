package model;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fheActivity.FheActivity;
import person.Person;

/**
 * Used to hold the groups of classes
 *
 * Created by Aaron on 7/29/2017.
 */

public class Model {

    private Set<Person> people = new HashSet<>();
    private Set<FheActivity> activities = new HashSet<>();
    private SortedMap<FheActivity, Person> assignments = new TreeMap<>();

    public void addPerson(Person newPerson){
        people.add(newPerson);
    }

    public void removePerson(Person removePerson){
        people.remove(removePerson);
    }

    public void removePersonByName(String name){
        for(Person person : people){
            if(person.getName().equals(name)){
                people.remove(person);
                return;
            }
        }
    }

    public void addActivity(FheActivity newActivity){
        activities.add(newActivity);
    }

    public void removeActivity(FheActivity removeActivity){
        activities.remove(removeActivity);
    }

    public void removeActivityByName(String name){
        for(FheActivity activity : activities){
            if(activity.getName().equals(name)){
                activities.remove(activity);
                return;
            }
        }
    }

    public void makeAssignments(){
        //TODO: Implement an algorithm to make original assignments
    }

    public void rotateAssignments(){
        //TODO: Implement an algorithm to rotate the assignments
    }
}
