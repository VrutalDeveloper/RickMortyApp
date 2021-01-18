package tech.vrutal.core.remote.responses
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
data class InfoResponse<T>(
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val results: List<T>
)

@Serializable
data class Info(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("pages")
    val pages: Int,
    @SerialName("prev")
    val prev: String?
)