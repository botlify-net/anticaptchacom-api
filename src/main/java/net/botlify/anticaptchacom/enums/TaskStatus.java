package net.botlify.anticaptchacom.enums;

import net.botlify.anticaptchacom.response.solution.SolveResponse;
import lombok.Getter;

/**
 * The status of a task.
 * Used in {@link SolveResponse}.
 */
public enum TaskStatus {

    PROCESSING("processing"),
    READY("ready");

    @Getter
    private final String value;

    /**
     * Creates a new {@link TaskStatus}.
     * @param value The value of the task status.
     */
    TaskStatus(final String value) {
        this.value = value;
    }

}
