package com.learning.medicalapp.model;

import java.util.Objects;

public class UserProfile {
    private String userId;
    private String deviceId;

    public UserProfile(String userId, String deviceId) {
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;
        UserProfile userProfile = (UserProfile) o;
        return userId.equals(userProfile.userId) && deviceId.equals(userProfile.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deviceId);
    }


    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }

}