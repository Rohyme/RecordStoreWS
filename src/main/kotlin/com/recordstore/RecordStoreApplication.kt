package com.recordstore
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.IOException

@SpringBootApplication
class RecordStoreApplication

fun main(args: Array<String>) {
    setRecordsHolder()
    runApplication<RecordStoreApplication>(*args)
}

fun setRecordsHolder(){
    val mapper = ObjectMapper()
    val mapType = jacksonObjectMapper()
    val jsonFile = com.fasterxml.jackson.core.type.TypeReference::class.java.getResourceAsStream("/static/json/record.json")
    var stateList = Records()
    try {
        stateList = mapper.readValue(jsonFile, Records::class.java)
        RecordsHolder.instance.setRecordsList(stateList)
    } catch (e: IOException) {
        System.out.println(e.message)
    }
}