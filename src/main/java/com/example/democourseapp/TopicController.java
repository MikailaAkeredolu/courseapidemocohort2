package com.example.democourseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired  //Tell spring to inject the singleton - declare the dependency for service - needs dependency injection
    private TopicService topicService;  //private instance variable

    //GET by Endpoint
    @RequestMapping("/topics") //http://localhost:8080/topics
    public List<Topic> getAllTopics(){  //return a list of Topic Class Objects
        return topicService.getAllTopics();  //singleton.serviceMethod()
    }


    //GET BY ID
    @RequestMapping("/topics/{id}")  //whatever i am expecting as an argument becomes a variable in the path {}
    public Topic getTopic(@PathVariable String id){  // String id = {id}
        return topicService.getTopic(id);
    }
    //Change to Post request - Map to any Post request on /topics endpoint
    //Post body should contain the post request the object been sent
    //Get the post body and convert the post body to topic instance and add it to the list in the topic service
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){  //take request body and pass it to the topic service
        topicService.addTopic(topic);  //topic from the payload the parameter above
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){  //take request body and pass it to the topic service
        topicService.updateTopic(id,topic);  //topic from the payload the parameter above
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")  //whatever i am expecting as an argument becomes a variable in the path {}
    public void deleteTopic(@PathVariable String id){  // String id = {id}
        topicService.deleteTopic(id);
    }

}
