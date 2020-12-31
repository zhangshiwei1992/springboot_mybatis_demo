package com.zsw.demo.redis;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class UserEntity implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", guid='" + guid + '\'' + ", name='" + name + '\'' + ", age='" + age + '\''
            + ", createTime=" + createTime + '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Date getCreateTime() {
        return createTime;
    }
}