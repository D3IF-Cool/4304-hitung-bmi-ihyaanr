package org.d3if2005.hitungbmi.db

import androidx.lifecycle.LiveData
import androidx.room.*

class BmiEntity {
    @Entity(tableName = "bmi")
    data class BmiEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,
        var tanggal: Long = System.currentTimeMillis(),
        var berat: Float,
        var tinggi: Float,
        var isMale: Boolean
    )
    @Dao
    interface BmiDao {
        @Insert
        fun insert(bmi: BmiEntity)
        @Query("SELECT * FROM bmi ORDER BY id DESC LIMIT 1")
        fun getLastBmi(): LiveData<BmiEntity?>
    }
}