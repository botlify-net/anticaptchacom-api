package net.botlify.anticaptchacom.data.response

import com.fasterxml.jackson.annotation.JsonProperty

data class QueueStatsResponse(
    /**
     * Number of idle workers online, waiting for a task.
     */
    @JsonProperty("waiting")
    var waiting: Int,

    /**
     * Queue load as a percentage.
     */
    @JsonProperty("load")
    var load: Double,

    /**
     * Average task solution cost in USD.
     */
    @JsonProperty("bid")
    var bid: Double,

    /**
     * Average task solution speed in seconds.
     */
    @JsonProperty("speed")
    var speed: Double,

    /**
     * Total number of workers.
     */
    @JsonProperty("total")
    var total: Int
);