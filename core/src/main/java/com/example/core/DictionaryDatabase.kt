package com.example.core


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.entities.Word

@Database(
entities = [Word::class],
version = 1
)
//@TypeConverters(PhoneticsTypeConverter::class)
abstract class DictionaryDatabase: RoomDatabase() {

}