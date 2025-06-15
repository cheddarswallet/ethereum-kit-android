package io.cheddarswallet.ethereumkit.core.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import io.cheddarswallet.ethereumkit.api.storage.RoomTypeConverters
import io.cheddarswallet.ethereumkit.models.InternalTransaction
import io.cheddarswallet.ethereumkit.models.Transaction
import io.cheddarswallet.ethereumkit.models.TransactionSyncerState
import io.cheddarswallet.ethereumkit.models.TransactionTag

@Database(
        entities = [
            Transaction::class,
            InternalTransaction::class,
            TransactionTag::class,
            TransactionSyncerState::class
        ],
        version = 13,
        exportSchema = false
)
@TypeConverters(RoomTypeConverters::class, TransactionDatabase.TypeConverters::class)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun transactionTagDao(): TransactionTagDao
    abstract fun transactionSyncerStateDao(): TransactionSyncerStateDao

    companion object {

        fun getInstance(context: Context, databaseName: String): TransactionDatabase {
            return Room.databaseBuilder(context, TransactionDatabase::class.java, databaseName)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }
    }

    class TypeConverters {
        @TypeConverter
        fun toString(list: List<String>): String {
            return list.joinToString(separator = ",")
        }

        @TypeConverter
        fun fromString(string: String): List<String> {
            return string.split(",")
        }
    }

}
