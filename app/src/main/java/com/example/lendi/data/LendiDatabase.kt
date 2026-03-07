package com.example.lendi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lendi.data.dao.LoanDao
import com.example.lendi.data.dao.UserDao
import com.example.lendi.data.entity.Loan
import com.example.lendi.data.entity.User

@Database(entities = [User::class, Loan::class], version = 1)
abstract class LendiDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun loanDao(): LoanDao

    companion object {
        @Volatile
        private var INSTANCE: LendiDatabase? = null

        fun getDatabase(context: Context): LendiDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LendiDatabase::class.java,
                    "lendi_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}