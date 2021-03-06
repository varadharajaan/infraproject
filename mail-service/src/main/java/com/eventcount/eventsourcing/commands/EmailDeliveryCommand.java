package com.eventcount.eventsourcing.commands;

import java.time.Instant;

/**
 * Email delivery command
 *
 * @author eventcount
 */
public class EmailDeliveryCommand {

    private final String uuid;
    private final Instant instant;

    public EmailDeliveryCommand(String uuid, Instant instant) {
        this.uuid = uuid;
        this.instant = instant;
    }

    public String getUuid() {
        return uuid;
    }

    public Instant getInstant() {
        return instant;
    }

}
