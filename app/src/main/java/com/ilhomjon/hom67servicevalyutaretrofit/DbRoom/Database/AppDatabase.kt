package com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.DAO.ValyutaDao
import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Entity.Valyuta

@Database(entities = [Valyuta::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun valyutaDao():ValyutaDao

    companion object{
        private var instance:AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "news_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}