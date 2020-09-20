package com.example.service.characters

import com.example.service.BreakingBadApi
import com.example.service.character.CharacterListRepository
import com.example.service.model.Character
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.ClassRule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.Executor


class JokeDetailRepositoryTest {

    val api: BreakingBadApi = mock()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Test
    fun `WHEN get characterList is called to the repo a list is returned`() {
        // GIVEN
        val list = listOf(
            Character(
                name = "Walter White",
                nickname = "Heisenberg",
                appearance = listOf(1, 2, 3, 4, 5),
                occupation = listOf("Meth king pin", "teacher"),
                status = "presumed dead",
                img = "no image"
            )
        )
        whenever(api.getAllCharacters()).thenReturn(Single.just(list))
        val repository = CharacterListRepository(api)

        // WHEN
        val result = repository.getCharacterList()
        val listRes = result.blockingGet()

        // THEN
        assertThat(listRes).isEqualTo(list);
        assertThat(listRes.size).isEqualTo(1)
        assertThat(listRes.first().name).isEqualTo("Walter White")
    }
}

class RxImmediateSchedulerRule : TestRule {
    private val immediate = object : Scheduler() {
        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
        }
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setInitIoSchedulerHandler { immediate }
                RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
                RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
                RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }

                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}