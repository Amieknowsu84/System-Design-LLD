package com.llm;

import java.util.Date;

public abstract class Notification {

    private Long id;
    private String content;
    private Date createdDate;

    public abstract void sendNotification(String content);

}
