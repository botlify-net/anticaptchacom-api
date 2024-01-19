package net.botlify.anticaptchacom.response.solution;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import net.botlify.anticaptchacom.enums.TaskStatus;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class SolveResponse<R> {

  /**
   * The id of the error.
   */
  @JsonProperty("errorId")
  private int errorId;

  /**
   * The status of the task.
   */
  @JsonProperty("status")
  private TaskStatus status;

  /**
   * The cost of the task in USD.
   */
  @JsonProperty("cost")
  private double cost;

  /**
   * The IP address of the worker who completed the task.
   */
  @JsonProperty("ip")
  private String ip;

  /**
   * The time the task was created in UNIX time.
   */
  @JsonProperty("createTime")
  private int createTime;

  /**
   * The time the task was ended in UNIX time.
   */
  @JsonProperty("endTime")
  private int endTime;

  /**
   * Number of workers who tried to complete your task.
   */
  @JsonProperty("solveCount")
  private int solveCount;

  /**
   * The solution of the task.
   */
  @JsonProperty("solution")
  private R solution;

}
