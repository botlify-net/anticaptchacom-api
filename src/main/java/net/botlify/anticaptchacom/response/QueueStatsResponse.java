package net.botlify.anticaptchacom.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public class QueueStatsResponse {

    /**
     * Number of idle workers online, waiting for a task.
     */
    @Getter(onMethod_ = @NotNull)
    public int waiting;

    /**
     * Queue load as a percentage.
     */
    @Getter(onMethod_ = @NotNull)
    public double load;

    /**
     * Average task solution cost in USD.
     */
    @Getter(onMethod_ = @NotNull)
    public double bid;

    /**
     * Average task solution speed in seconds.
     */
    @Getter(onMethod_ = @NotNull)
    public double speed;

    /**
     * Total number of workers.
     */
    @Getter(onMethod_ = @NotNull)
    public int total;

}
