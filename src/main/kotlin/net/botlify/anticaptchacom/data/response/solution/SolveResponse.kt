package net.botlify.anticaptchacom.data.response.solution

import com.fasterxml.jackson.annotation.JsonProperty
import net.botlify.anticaptchacom.enums.TaskStatus

class SolveResponse<T> internal constructor(
    /**
     * The id of the error.
     */
    @JsonProperty("errorId")
    val errorId: Int,

    /**
     * The status of the task.
     */
    @JsonProperty("status")
    val status: TaskStatus,

    /**
     * The cost of the task in USD.
     */
    @JsonProperty("cost")
    val cost: Int,

    /**
     * The IP address of the worker who completed the task.
     */
    @JsonProperty("ip")
    val ip: String,

    /**
     * The time the task was created in UNIX time.
     */
    @JsonProperty("createTime")
    val createTime: Int,

    /**
     * The time the task was ended in UNIX time.
     */
    @JsonProperty("endTime")
    val endTime: Int,

    /**
     * Number of workers who tried to complete your task.
     */
    @JsonProperty("solveCount")
    val solveCount: Int,

    /**
     * The solution of the task.
     */
    @JsonProperty("solution")
    val solution: T
);
