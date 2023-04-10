package net.botlify.anticaptchacom.response.solution;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.botlify.anticaptchacom.enums.TaskStatus;

@ToString
@EqualsAndHashCode
public abstract class SolveResponse<R> {

    @Getter
    private TaskStatus status;

    @Getter
    private double cost;

    @Getter
    private String ip;

    /**
     * The time the task was created in UNIX time.
     */
    @Getter
    private int createTime;

    /**
     * The time the task was ended in UNIX time.
     */
    @Getter
    private int endTime;

    /**
     * Number of workers who tried to complete your task.
     */
    @Getter
    private int solveCount;

    /**
     * The solution of the task.
     */
    @Getter
    private R solution;

}
