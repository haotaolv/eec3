package com.eec.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/3/19.
 */
@Entity
@Table(name = "content", schema = "", catalog = "chat")
public class ContentEntity {
    private int id;
    private String testFrom;
    private String testTo;
    private String message;
    private Timestamp date;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "testFrom", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTestFrom() {
        return testFrom;
    }

    public void setTestFrom(String testFrom) {
        this.testFrom = testFrom;
    }

    @Basic
    @Column(name = "testTo", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTestTo() {
        return testTo;
    }

    public void setTestTo(String testTo) {
        this.testTo = testTo;
    }

    @Basic
    @Column(name = "message", nullable = false, insertable = true, updatable = true, length = 45)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentEntity that = (ContentEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (testFrom != null ? !testFrom.equals(that.testFrom) : that.testFrom != null) return false;
        if (testTo != null ? !testTo.equals(that.testTo) : that.testTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (testFrom != null ? testFrom.hashCode() : 0);
        result = 31 * result + (testTo != null ? testTo.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
