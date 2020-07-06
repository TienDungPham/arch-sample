package com.tiendungpham.core.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tiendungpham.core.data.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        fun create(context: Context): WordDatabase {
            return Room.databaseBuilder(context, WordDatabase::class.java, "WordDatabase").build()
        }
    }
}