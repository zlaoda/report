package com.ytbig;

//import com.ytbig.controller.LoginThread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ytbig.model.UserInfo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.Objects;


public class Index extends Application {

    //icon
    private static final String iconImg = ClassLoader.getSystemResource("images/icon.png").toString();

    //开屏动画
    private static final String startImg = ClassLoader.getSystemResource("images/index.gif").toString();

    public volatile boolean exit = true;

    private static Label infoLb;
    private static WebView webView;
    private static WebEngine webEngine;
    private static  Home home;


    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(startImg);
        ImageView view = new ImageView(image);
        infoLb = new Label();
        infoLb.setTextFill(Color.WHITE);
        infoLb.setFont(new Font("微软雅黑", 18));
        infoLb.setWrapText(true);
        AnchorPane.setRightAnchor(infoLb, 10.0);
        AnchorPane.setBottomAnchor(infoLb, 10.0);
        AnchorPane page = new AnchorPane();
        page.getChildren().addAll(view, infoLb);

        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("https://app-oauth.nbsedu.com/oauth2/qrconnect?appid=mc0626e33517466e04&redirect_uri=http://nbzhenming.ytbig.cn/middlePage&response_type=code&scope=snsapi_login&state=edu#edu_redirect");
//        webEngine.load("http://nbzhenming.ytbig.cn/evaluationPage");

        stage.setScene(new Scene(page));
        stage.setWidth(image.getWidth());
        stage.setHeight(image.getHeight());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(iconImg));
        stage.show();


        // 核心代码
        new Thread(() -> {
            initSystem();// 1

            Platform.runLater(() -> {// 2
                try {
                   home = new Home();

                    home.addEventHandler(WindowEvent.WINDOW_SHOWN, event -> {
                        stage.hide();
                    });
                    home.show();
                } catch (Throwable e) {
                    e.printStackTrace();// 3
                }
            });
        }).start();

        new Thread(() -> {
            while (this.exit) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    Object script = webEngine.executeScript("window.sessionStorage.getItem('userInfo')");
                    System.out.println(script);
                    if (!Objects.isNull(script)) {
                        UserInfo userInfo = JSON.parseObject(script.toString(), UserInfo.class);
                        if (!Objects.isNull(userInfo)) {
                            this.exit = false;
                            stage.close();
                            home.close();
                        }
                    }
                });
            }
        }).start();

    }


    // 初始化系统
    private void initSystem() {
        try {
            showInfo("启动中：检查新版本…");
            Thread.sleep(1500);
            showInfo("启动中：获取二维码…");
            Thread.sleep(1500);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    // 显示信息
    public static void showInfo(String info) {
        Platform.runLater(() -> infoLb.setText(info));
    }

    /**
     * 主页
     *
     * @author Miaoqx
     */
    public class Home extends Stage {

        public Home() throws InterruptedException {

            setTitle("振明中心小学 综合素质评价管理系统v1.0.0");

            setScene(new Scene(webView, webView.getPrefWidth(),
                    webView.getPrefHeight()));
            setWidth(webView.getWidth());
            setHeight(webView.getHeight());
            //窗口最大化
//            setMaximized(true);
            getIcons().add(new Image(iconImg));

        }
    }
}
