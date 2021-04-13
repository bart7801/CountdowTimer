package com.bart;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Main {

    JFrame window;
    JLabel counterLabel;
    Font font = new Font("Arial", Font.PLAIN, 80);

    Timer timer;

    int millisecond, second, minute, hour, day;
    String ddMillisecond, ddSecond, ddMinute, ddHour, ddDay;

    DecimalFormat decimalFormat = new DecimalFormat("00");
    DecimalFormat decimalFormat2 = new DecimalFormat("000");

    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        window = new JFrame();
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        counterLabel = new JLabel("");
        counterLabel.setBounds(200, 230, 800, 100);
        counterLabel.setHorizontalAlignment(JLabel.LEFT);
        counterLabel.setFont(font);

        window.add(counterLabel);
        window.setVisible(true);

        //Simple Timer
//        second = 0;
//        simpleTimer();
//        timer.start();

        //Normal Timer
        counterLabel.setText("00:00:00:00.000");
        millisecond = 0;
        second = 0;
        minute = 0;
        hour = 0;
        day = 0;
        normalTimer();
        timer.start();

    }

    //Simple Timer
//    public void simpleTimer(){
//
//        timer = new Timer(1000, e -> {
//
//            second++;
//
//            counterLabel.setText("" + second);
//        });
//    }

    //Normal Timer
    public void normalTimer() {

        timer = new Timer(1, e -> {

            millisecond++;
            ddMillisecond = decimalFormat2.format(millisecond);
            ddSecond = decimalFormat.format(second);
            ddMinute = decimalFormat.format(minute);
            ddHour = decimalFormat.format(hour);
            ddDay = decimalFormat.format(day);


            counterLabel.setText(ddDay + ":" + ddHour + ":" + ddMinute + ":" + ddSecond + "." + ddMillisecond);

            if (millisecond == 1000) {
                millisecond = 0;
                second++;
            }

            if (second == 60) {
                second = 0;
                minute++;
            }

            if (minute == 60) {
                minute = 0;
                hour++;
            }

            if (hour == 24) {
                hour = 0;
                day++;

                ddMillisecond = decimalFormat.format(millisecond);
                ddSecond = decimalFormat.format(second);
                ddMinute = decimalFormat.format(minute);
                ddHour = decimalFormat.format(hour);
                ddDay = decimalFormat.format(day);

                counterLabel.setText(ddDay + ":" + ddHour + ":" + ddMinute + ":" + ddSecond + "." + ddMillisecond);

            }
        });
    }
}