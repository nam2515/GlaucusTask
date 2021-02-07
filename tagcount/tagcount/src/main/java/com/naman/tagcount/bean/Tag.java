package com.naman.tagcount.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NUMBER")
public class Tag {
    private int number;
    @Id
    private String tagId;

    public Tag()
    {}

    public Tag(String tagId , int number)
    {
        this.tagId=tagId;
        this.number=number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
    public int getNumber()
    {
        return this.number;
    }

    public String getTagId()
    {
        return this.tagId;
    }

    public void setTagId(String tagId)
    {
        this.tagId = tagId;
    }

}
