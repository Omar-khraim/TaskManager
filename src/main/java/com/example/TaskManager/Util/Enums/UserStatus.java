package com.example.TaskManager.Util.Enums;

public enum UserStatus {

    Active(1),
    Disabled(2),
    Postponed(3),
    Deleted(4);

    private final int value;

    UserStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
