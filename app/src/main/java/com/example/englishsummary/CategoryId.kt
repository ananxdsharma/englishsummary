package com.example.englishsummary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="EnglishLiteratureTable")

data class EnglishLiteratureData(
    @ColumnInfo(name = "ID")
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "NAME")
    val cName:String
)


@Entity(tableName="EnglishGrammerTable")
data class EnglishGrammerData(
    @ColumnInfo(name = "ID")
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "NAME")
    val cName:String
)

@Entity(tableName="IndianBoardsTable")
data class IndianBoardsData(
    @ColumnInfo(name = "ID")
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "NAME")
    val cName:String
)

//@Entity(tableName="InteractiveLeaTable")
//data class EnglishGrammerData(
//    @ColumnInfo(name = "ID")
//    @PrimaryKey
//    val id:Int,
//    @ColumnInfo(name = "NAME")
//    val cName:String
//)
