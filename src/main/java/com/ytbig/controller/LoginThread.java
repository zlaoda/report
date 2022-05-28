//package com.ytbig.controller;
//
//import javafx.application.Platform;
//import javafx.scene.web.WebEngine;
//
//public class LoginThread{
//    public volatile boolean exit = true;
//
//    public volatile WebEngine webEngine;
//
//    public void run() {
//            while (exit) {
//            try {
//                Thread.sleep(2000);
//                Platform.runLater(() -> {
//                    Object script = webEngine.executeScript("window.sessionStorage.getItem('userInfo')");
//                    System.out.println(script);
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
