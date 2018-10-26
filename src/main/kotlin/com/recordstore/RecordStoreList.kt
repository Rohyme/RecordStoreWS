package com.recordstore

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class RecordStoreList {

    @RequestMapping("/records", method = [RequestMethod.GET])
    fun getRecords(@RequestParam("page") pageNum: Int): List<Records.Record> {
        return RecordsHolder.instance.getRecordsList(pageNum)
    }

    @RequestMapping("/sortedRecords", method = [RequestMethod.GET])
    fun getRecordsSorted(@RequestParam("page") pageNum: Int,
                         @RequestParam("sortType") sort: String,
                         @RequestParam("isDesc") order: Boolean): List<Records.Record> {
        return RecordsHolder.instance.getRecordsSorted(sort, order, pageNum)
    }


    @RequestMapping("/toggleFav", method = [RequestMethod.POST])
    fun toggleFav(@RequestParam("recordId") recordId: String): Boolean {
        return RecordsHolder.instance.toggleFavourite(recordId)
    }

    @RequestMapping("/favourites", method = [RequestMethod.GET])
    fun getFavouriteRecords(): List<Records.Record> {
        return RecordsHolder.instance.getFavouriteList()
    }

    @RequestMapping("/sortedFavourites", method = [RequestMethod.GET])
    fun getFavouriteRecords(@RequestParam("sortType") sort: String,
                            @RequestParam("isDesc") order: Boolean): List<Records.Record> {
        return RecordsHolder.instance.getFavouriteSorted(sort, order)
    }


}