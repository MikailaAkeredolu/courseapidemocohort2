package com.example.democourseapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics =  new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "SpringFrameWork Description" ),
            new Topic("java","Core Java", " Core Java Description"),
            new Topic("JavaScript","JS101", " JavaScript Description")
    ));

    //Method - Getter to return all the topics above - available to be called in controller
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        for(int x = 0; x < topics.size(); x++){
            Topic t = topics.get(x);

            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
        //return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic t){
        topics.add(t);
    }

    public void updateTopic(String id, Topic topic){
        for(int x = 0; x < topics.size(); x++){
            Topic t = topics.get(x); //for each topic
            if(t.getId().equals(id)){ //compare to what is passed in
                topics.set(x,topic); //topic from parameter passed in
                //return;
            }
        }
    }


    public void deleteTopic(String id){
        for(int x = 0; x < topics.size(); x++){
            Topic t = topics.get(x);
            if(t.getId().equals(id)){
                topics.remove(x);
            }
        }

        //topics.removeIf(t-> t.getId().equals(id));

    }
}
