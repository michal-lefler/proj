package com.michal.demo.kid.controller;

import java.util.List;

public class KidRequest {
    private String name;
    private String phoneNumber;
    private List<Long> parents; // list of parent IDs

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getParents() {
        return parents;
    }

    public void setParents(List<Long> parents) {
        this.parents = parents;
    }
}