package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [GameResultEntity::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameResultDao(): GameResultDao
}
