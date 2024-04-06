package com.example.englishsummary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [EnglishLiteratureData::class, EnglishGrammerData::class, IndianBoardsData::class],
    version=1,
    exportSchema=false
)

abstract class CategoryIdsDB:RoomDatabase() {
    abstract fun getELDao(): EnglishLiteratureDao
    abstract fun getEGDao(): EnglishGrammerDao
    abstract fun getIBDao(): IndianBoardsDao



    companion object{
        private const val DB_NAME="categoryid_database.db"
        private var instance: CategoryIdsDB?=null

        operator fun invoke(context: Context)= instance?: synchronized(Any()){
            instance ?: buildDatabase(context).also{
                instance=it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CategoryIdsDB::class.java,
            DB_NAME
        ).build()
    }
}