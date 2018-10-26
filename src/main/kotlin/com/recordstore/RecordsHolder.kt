package com.recordstore

import java.lang.Exception

class RecordsHolder private constructor() {
    private val recordsList: ArrayList<Records.Record> = ArrayList()

    companion object {
        val instance = RecordsHolder()
    }

    fun setRecordsList(list: Records) {
        recordsList.addAll(list.records!!)
    }

    fun getRecordsList(pageNum: Int): List<Records.Record> {
        return getRecordsPaged(pageNum, recordsList)
    }

    fun getRecordsPaged(pageNum: Int, list: ArrayList<Records.Record>): List<Records.Record> {
        var pagedList = listOf<Records.Record>()
        try {
            pagedList = list.subList((pageNum - 1) * 10, (pageNum * 10))
        } catch (e: Exception) {
            print(e.message)
        }
        return pagedList
    }

    fun getFavouriteList(): List<Records.Record> {
        return recordsList.filter {
            it.isFavourite!!
        }
    }

    fun getFavouriteSorted(sortType: String, isDesc: Boolean): ArrayList<Records.Record> {
        return getListSorted(getFavouriteList(), sortType, isDesc)
    }

    fun toggleFavourite(recordId: String): Boolean {
        var isFav = false
        recordsList.forEach {
            if (it.id == recordId) {
                it.isFavourite = !it.isFavourite!!
                isFav = it.isFavourite!!
            }
        }
        return isFav
    }

    fun getRecordsSorted(sortType: String, isDesc: Boolean, pageNum: Int): List<Records.Record> {
        return getRecordsPaged(pageNum, getListSorted(recordsList, sortType, isDesc))
    }

    fun getListSorted(listToSort: List<Records.Record>, sortType: String, isDesc: Boolean): ArrayList<Records.Record> {
        val list: ArrayList<Records.Record> = ArrayList(listToSort)
        if (isDesc) {
            list.sortWith(compareByDescending {
                when (sortType) {
                    SortConstants.DATE_SORTING -> {
                        it.releaseDate
                    }
                    SortConstants.NAME_SORTING -> {
                        it.name
                    }
                    SortConstants.PRICE_SORTING -> {
                        it.price
                    }
                    else -> {
                        it.name
                    }
                }
            })
        } else {
            list.sortWith(compareBy {
                when (sortType) {
                    SortConstants.DATE_SORTING -> {
                        it.releaseDate
                    }
                    SortConstants.NAME_SORTING -> {
                        it.name
                    }
                    SortConstants.PRICE_SORTING -> {
                        it.price
                    }
                    else -> {
                        it.name
                    }
                }

            })
        }
        return list
    }

    fun getList(): ArrayList<Records.Record> {
        return recordsList
    }
}