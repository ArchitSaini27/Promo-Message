package com.archit.promomessage

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateJoiner:Boolean,
    val availableFromDate:String?
) : Serializable{

    fun getFullJobTitle():String= if(includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailableDate():String=if(immediateJoiner) "immediately" else "from $availableFromDate"



}


