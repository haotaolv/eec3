package com.eec.model;

import javax.persistence.*;
import java.util.Date;

/**
* Created by 智康 on 2015/2/10 0010.
*/
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column
    private String courseCat;

    @Column
    private boolean isPublished;

    @Column
    private String courseName;

    @Column
    private String courseQihao;

    @Column
    private Date startTime;

    @Column
    private String teachCenter;

    @Column
    private String address;

    @Column
    private int attended;

    @Column
    private int maxAttend;

    @Column
    private int price;

    @Column
    private String courseTixi;

    @Column
    private String courseTese;

    @Column
    private String trainObject;

    @Column
    private String trainFacility;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseQihao() {
        return courseQihao;
    }

    public void setCourseQihao(String courseQihao) {
        this.courseQihao = courseQihao;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getTeachCenter() {
        return teachCenter;
    }

    public void setTeachCenter(String teachCenter) {
        this.teachCenter = teachCenter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAttended() {
        return attended;
    }

    public void setAttended(int attended) {
        this.attended = attended;
    }

    public int getMaxAttend() {
        return maxAttend;
    }

    public void setMaxAttend(int maxAttend) {
        this.maxAttend = maxAttend;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCourseTixi() {
        return courseTixi;
    }

    public void setCourseTixi(String courseTixi) {
        this.courseTixi = courseTixi;
    }

    public String getCourseTese() {
        return courseTese;
    }

    public void setCourseTese(String courseTese) {
        this.courseTese = courseTese;
    }

    public String getTrainObject() {
        return trainObject;
    }

    public void setTrainObject(String trainObject) {
        this.trainObject = trainObject;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public String getCourseCat() {
        return courseCat;
    }

    public void setCourseCat(String courseCat) {
        this.courseCat = courseCat;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Course(String courseCat, boolean isPublished, String courseName, String courseQihao, Date startTime, String teachCenter, String address, int attended, int maxAttend, int price, String courseTixi, String courseTese, String trainObject) {
        this.courseCat = courseCat;
        this.isPublished = isPublished;
        this.courseName = courseName;
        this.courseQihao = courseQihao;
        this.startTime = startTime;
        this.teachCenter = teachCenter;
        this.address = address;
        this.attended = attended;
        this.maxAttend = maxAttend;
        this.price = price;
        this.courseTixi = courseTixi;
        this.courseTese = courseTese;
        this.trainObject = trainObject;
    }

    public Course() {}
}
