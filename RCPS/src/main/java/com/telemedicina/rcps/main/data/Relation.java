package com.telemedicina.rcps.main.data;

public class Relation {
    private char[] master = new char[8] ;
    private char[] slave = new char[8] ;

    public Relation(char[] master , char[] slave){
        this.master = master ;
        this.slave = slave;
    }
    public char[] getMaster() {
        return master;
    }

    public void setMaster(char[] master) {
        this.master = master;
    }

    public char[] getSlave() {
        return slave;
    }

    public void setSlave(char[] slave) {
        this.slave = slave;
    }
}
