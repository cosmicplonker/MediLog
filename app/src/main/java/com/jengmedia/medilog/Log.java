package com.jengmedia.medilog;

import java.util.Date;

public class Log {

    private int _id;
    private String _name;
    private Date _date;

    public Log(int pid,String pname, Date pdate){
        this._id = pid;
        this._name = pname;
        this._date = pdate;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date _date) {
        this._date = _date;
    }
}
