package com.example.englishsummary







import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface EnglishLiteratureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cdetail:EnglishLiteratureData)

    @Delete
    fun delete(cdetail:EnglishLiteratureData)
//
//    @Update
//    fun update(cdetail: EnglishLiteratureData)

    @Query("SELECT NAME FROM EnglishLiteratureTable WHERE ID = :cid")
    fun getCategoryName(cid:Int):String

    @Query("SELECT ID FROM EnglishLiteratureTable WHERE NAME = :cname")
    fun getCategoryId(cname:String):Int
}

@Dao
interface EnglishGrammerDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cdetail:EnglishGrammerData)

    @Delete
    fun delete(cdetail:EnglishGrammerData)

//    @Update
//    fun update(cdetail: EnglishGrammerData)

    @Query("SELECT NAME FROM EnglishGrammerTable WHERE ID = :cid")
    fun getCategoryName(cid:Int):String

    @Query("SELECT ID FROM EnglishGrammerTable WHERE NAME = :cname")
    fun getCategoryId(cname:String):Int
}

@Dao
interface IndianBoardsDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cdetail:IndianBoardsData)

    @Delete
    fun delete(cdetail:IndianBoardsData)
//
//    @Update
//    fun update(cdetail: IndianBoardsData)

    @Query("SELECT NAME FROM IndianBoardsTable WHERE ID = :cid")
    fun getCategoryName(cid:Int):String

    @Query("SELECT ID FROM IndianBoardsTable WHERE NAME = :cname")
    fun getCategoryId(cname:String):Int
}
