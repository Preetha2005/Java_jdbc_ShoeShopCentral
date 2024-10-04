package com.preetha_shoeshop;

public class shoeshop {
	private String name;
    private double size;
    private String color;
    private String type;
    private String id;
    public shoeshop() {
   
    }
    public shoeshop(String name,String id) {
    this.name=name;
    this .id=id;
    }
    public shoeshop(String name,double size, String color, String type) {
    this.name=name;
    this.size = size;
    this.color = color;
    this.type = type;
    }
    public void setname(String name) {
    this.name=name;
    }
    public String getname() {
    return this.name;
    }
    public void setsize(double size) {
    this.size=size;
    }
    public double getsize() {
    return this.size;
    }
    public void setcolor(String color) {
    this.color=color;
    }
    public String getcolor() {
    return this.color;
    }
    public void settype(String type) {
    this.type=type;
    }
    public String gettype() {
    return this.type;
    }
    public void setid(String id) {
    this.id=id;
    }
    public String getid() {
    return this.id;
    }
    @Override
    public String toString() {
    return "shoeshop [name =" + name + ", size=" + size + ", color=" + color + ", type=" + type + ",id=" + id + "]";
    }
}
