package com.nano.Operating.Systems;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

@Controller
public class OperatingSystemsController {
    int shareNumber = 0;


    //lecture one
    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index.html");
    }

    //lecture two
    @RequestMapping("/processor-process")
    public ModelAndView processorProcess(){
        return new ModelAndView("processor-process.html");
    }


    //lecture three
    @RequestMapping("/process-sync-deadlocks")
    public ModelAndView processSyncDeadlocks(){
        return new ModelAndView("process-sync-deadlocks.html");
    }

    //lecture four
    @RequestMapping("/memoryManagement")
    public ModelAndView memoryManagement(){
        return new ModelAndView("memory-management.html");
    }

    //lecture five
    @RequestMapping("/fileManagement")
    public ModelAndView fileManagement(){
        return new ModelAndView("file-management.html");
    }


    //lecture six
    @RequestMapping("/osSecurityAndProtection")
    public ModelAndView osSecurityAndProtection(){
        return new ModelAndView("os-security-and-protection.html");
    }



    //lecture seven
    @RequestMapping("/osSecurityAndProtectionII")
    public ModelAndView osSecurityAndProtectionII(){
        ModelAndView modelAndView = new ModelAndView("os-security-and-protection-ii.html");
        return modelAndView;
    }

    //lecture eight
    @RequestMapping("/linuxBasics")
    public ModelAndView linuxBasics(){
        ModelAndView modelAndView = new ModelAndView("linux-basics");
        return  modelAndView;
    }


    @PostMapping("/runCriticalSectionProgram")
    public ModelAndView runCriticalSectionProgram(){
        //Create a Variable to be accessed
        shareNumber = 0;
        //create 5 threads to access the value
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    shareNumber++;

                    System.out.println("This is thread number 1 and number is " + shareNumber);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    shareNumber++;
                    System.out.println("This is thread number 2 and number is " + shareNumber);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    shareNumber++;
                    System.out.println("This is thread number 3 and number is " + shareNumber);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    shareNumber++;
                    System.out.println("This is thread number 4 and number is  " + shareNumber);
                }
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    shareNumber++;
                    System.out.println("This is thread number 5 and number is " + shareNumber);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Semaphore s = new Semaphore(5);
        try {
            s.wait();
        }catch (Exception e){
            e.printStackTrace();
        }

        return home();
    }

    //my music
    @RequestMapping("/nanoMusic")
    public ModelAndView nanoMusic(){
        String[] songs  = null;
        try {
            songs = Song.getSongs();
        }catch (Exception e){
            System.out.println("failed to get songs.");
        }
        ModelAndView nanoMusic = new ModelAndView("mystuff/nano-music.html");
        nanoMusic.addObject("songs", songs);
        return nanoMusic;
    }

    @RequestMapping("/playSong")
    public String playSong(@RequestParam String song){
        return "/music/"+song;
    }

    //my hub
    @RequestMapping("/nanoHub")
    public ModelAndView nanoHub(){
        return new ModelAndView("mystuff/nano-hub.html");
    }




}

