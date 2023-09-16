package data

import java.io.Serializable


data class Event(
    var id: Int,
    var name: String,
    var content: String,
    var address: String,
    var date: String
) : Serializable