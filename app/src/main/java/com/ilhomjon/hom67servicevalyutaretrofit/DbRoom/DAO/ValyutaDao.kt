package com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Entity.Valyuta

@Dao
interface ValyutaDao {
    @Query("select * from valyuta")
    fun getAllNews():List<Valyuta>

    @Insert
    fun addNews(valyuta: Valyuta)

    @Update
    fun updateNew(valyuta: Valyuta)
}