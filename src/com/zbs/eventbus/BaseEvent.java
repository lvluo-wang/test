package com.zbs.eventbus;

import java.util.UUID;

public abstract class BaseEvent {
    private final String eventId = UUID.randomUUID().toString();

    public String getEventId() {
        return eventId;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
            "eventId='" + eventId + '\'' +
            '}';
    }
}