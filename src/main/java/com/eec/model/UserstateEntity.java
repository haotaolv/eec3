package com.eec.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/3/19.
 */
@Entity
@Table(name = "userstate", schema = "", catalog = "chat")
public class UserstateEntity {
    private int id;
    private String userName;
    private String serverName;
    private Timestamp chatStartTime;
    private Timestamp chatOverTime;
    private String online;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "serverName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Basic
    @Column(name = "chatStartTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getChatStartTime() {
        return chatStartTime;
    }

    public void setChatStartTime(Timestamp chatStartTime) {
        this.chatStartTime = chatStartTime;
    }

    @Basic
    @Column(name = "chatOverTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getChatOverTime() {
        return chatOverTime;
    }

    public void setChatOverTime(Timestamp chatOverTime) {
        this.chatOverTime = chatOverTime;
    }

    @Basic
    @Column(name = "online", nullable = true, insertable = true, updatable = true, length = 10)
    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserstateEntity that = (UserstateEntity) o;

        if (id != that.id) return false;
        if (chatOverTime != null ? !chatOverTime.equals(that.chatOverTime) : that.chatOverTime != null) return false;
        if (chatStartTime != null ? !chatStartTime.equals(that.chatStartTime) : that.chatStartTime != null)
            return false;
        if (online != null ? !online.equals(that.online) : that.online != null) return false;
        if (serverName != null ? !serverName.equals(that.serverName) : that.serverName != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (serverName != null ? serverName.hashCode() : 0);
        result = 31 * result + (chatStartTime != null ? chatStartTime.hashCode() : 0);
        result = 31 * result + (chatOverTime != null ? chatOverTime.hashCode() : 0);
        result = 31 * result + (online != null ? online.hashCode() : 0);
        return result;
    }
}
