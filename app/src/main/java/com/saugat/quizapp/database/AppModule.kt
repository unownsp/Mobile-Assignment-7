package com.saugat.quizapp.database

import android.app.Application
import androidx.room.Room
import com.saugat.quizapp.repo.QuizRepository
import com.saugat.quizapp.repo.QuizRepositoryImpl
import com.saugat.quizapp.utils.Constant.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuizDatabase(context: Application) : QuizDataBase {
        return Room.databaseBuilder(
            context,
            QuizDataBase::class.java,
            DB_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideQuizRepository(db: QuizDataBase) : QuizRepository {
        return QuizRepositoryImpl(db)
    }

}