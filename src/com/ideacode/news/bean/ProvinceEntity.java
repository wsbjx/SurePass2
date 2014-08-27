package com.ideacode.news.bean;

import java.util.List;

public class ProvinceEntity
{
    private int              id;
    private String           name;
    private List<CityEntity> cities;
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public List<CityEntity> getCities()
    {
        return cities;
    }
    
    public void setCities(List<CityEntity> cities)
    {
        this.cities = cities;
    }
}
