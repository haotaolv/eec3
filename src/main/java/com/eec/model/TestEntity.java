package com.eec.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2015/3/19.
 */
@Entity
@Table(name = "test", schema = "", catalog = "chat")
public class TestEntity {
    private int id;
    private String testName;
    private String testTo;
    private String message;
    private String time;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "testName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Basic
    @Column(name = "testTo", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTestTo() {
        return testTo;
    }

    public void setTestTo(String testTo) {
        this.testTo = testTo;
    }

    @Basic
    @Column(name = "message", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "time", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntity that = (TestEntity) o;

        if (id != that.id) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (testName != null ? !testName.equals(that.testName) : that.testName != null) return false;
        if (testTo != null ? !testTo.equals(that.testTo) : that.testTo != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (testName != null ? testName.hashCode() : 0);
        result = 31 * result + (testTo != null ? testTo.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
