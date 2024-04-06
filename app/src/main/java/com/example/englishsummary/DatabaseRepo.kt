package com.example.englishsummary

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update

class DatabaseRepo(
    private val daoel:EnglishLiteratureDao,
    private val daoeg:EnglishGrammerDao,
    private val daoib:IndianBoardsDao


) {

    suspend fun insertInEnglishLiterature(cdetail:EnglishLiteratureData){
        daoel.insert(cdetail)
    }
    fun deleteInEnglishLiterature(cdetail:EnglishLiteratureData){
        daoel.delete(cdetail)
    }
    fun getCategoryNameInEnglishLiterature(cid:Int)=daoel.getCategoryName(cid)
    fun getCategoryIdInEnglishLiterature(cname:String)=daoel.getCategoryId(cname)



    suspend fun insertInEnglishGrammer(cdetail:EnglishGrammerData){
        daoeg.insert(cdetail)
    }
    fun deleteInEnglishGrammer(cdetail:EnglishGrammerData){
        daoeg.delete(cdetail)
    }
    fun getCategoryNameInEnglishGrammer(cid:Int)=daoeg.getCategoryName(cid)
    fun getCategoryIdInEnglishGrammer(cname:String)=daoeg.getCategoryId(cname)



    suspend fun insertInIndianBoards(cdetail:IndianBoardsData){
        daoib.insert(cdetail)
    }
    fun deleteInIndianBoards(cdetail:IndianBoardsData){
        daoib.delete(cdetail)
    }
    fun getCategoryNameInIndianBoards(cid:Int)=daoib.getCategoryName(cid)
    fun getCategoryIdInIndianBoards(cname:String):Int=daoib.getCategoryId(cname)


}
