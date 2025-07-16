package com.community_library.community_info.controller;

import org.springframework.stereotype.Component;

@Component
public class CommunityDTO {


    private short communityId;
    private String community_Name;
    private String communityType;
    private boolean activeIndicator;
    private short communityManagerId;
    private String city;
    private String state;
    private short zip;
    private short zip4;



    public short getCommunityId() {
        return communityId;
    }

    public void setActiveIndicator(boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public boolean isActiveIndicator() {
        return activeIndicator;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCommunity_Name() {
        return community_Name;
    }

    public String getCommunityType() {
        return communityType;
    }

    public short getCommunityManagerId() {
        return communityManagerId;
    }

    public void setCommunityId(short communityId) {
        this.communityId = communityId;
    }

    public void setCommunity_Name(String community_Name) {
        this.community_Name = community_Name;
    }

    public void setCommunityType(String communityType) {
        this.communityType = communityType;
    }

    public void setCommunityManagerId(short communityManagerId) {
        this.communityManagerId = communityManagerId;
    }

    public short getZip() {
        return zip;
    }

    public short getZip4() {
        return zip4;
    }

    public void setZip(short zip) {
        this.zip = zip;
    }

    public void setZip4(short zip4) {
        this.zip4 = zip4;
    }

    @Override
    public String toString() {
        return "CommunityDTO{" +
                "communityId=" + communityId +
                ", community_Name='" + community_Name + '\'' +
                ", communityType='" + communityType + '\'' +
                ", activeIndicator=" + activeIndicator +
                ", communityManagerId=" + communityManagerId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", zip4=" + zip4 +
                '}';
    }
}
