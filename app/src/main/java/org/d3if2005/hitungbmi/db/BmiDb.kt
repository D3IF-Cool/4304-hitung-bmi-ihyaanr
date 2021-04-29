package org.d3if2005.hitungbmi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class BmiDb {
    @Database(entities = [BmiEntity::class], version = 1, exportSchema = false)
    abstract class BmiDb : RoomDatabase() {
        abstract val dao: BmiEntity.BmiDao
        companion object {
            @Volatile
            private var INSTANCE: BmiDb? = null
            fun getInstance(context: Context): BmiDb {
                synchronized(this) {
                    var instance = INSTANCE
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            BmiDb::class.java,
                            "bmi.db"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
    }
}