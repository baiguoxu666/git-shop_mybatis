package com.bgx.entity;

/**
 * @author: 大神
 * @date: 2021/5/23 21:56
 * @description: 加油呀冲出去
 */
public class Date {
    private Date hour;
    private Date minute;
    private Date seconds;

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Date getMinute() {
        return minute;
    }

    public void setMinute(Date minute) {
        this.minute = minute;
    }

    public Date getSeconds() {
        return seconds;
    }

    public void setSeconds(Date seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Date{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", seconds=" + seconds +
                '}';
    }
}
