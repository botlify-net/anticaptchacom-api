package net.botlify.anticaptchacom.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class QueueStatsResponse {

  /**
   * Number of idle workers online, waiting for a task.
   */
  @JsonProperty("waiting")
  public int waiting;

  /**
   * Queue load as a percentage.
   */
  @JsonProperty("load")
  public double load;

  /**
   * Average task solution cost in USD.
   */
  @JsonProperty("bid")
  public double bid;

  /**
   * Average task solution speed in seconds.
   */
  @JsonProperty("speed")
  public double speed;

  /**
   * Total number of workers.
   */
  @JsonProperty("total")
  public int total;

}
