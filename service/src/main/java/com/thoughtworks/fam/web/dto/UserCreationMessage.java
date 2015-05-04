package com.thoughtworks.fam.web.dto;

public class UserCreationMessage {
    private String creationStatus;
    private String message;

    public UserCreationMessage(String creationStatus, String message) {
        this.creationStatus = creationStatus;
        this.message = message;
    }

    public String getCreationStatus() {
        return creationStatus;
    }

    public void setCreationStatus(String creationStatus) {
        this.creationStatus = creationStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
