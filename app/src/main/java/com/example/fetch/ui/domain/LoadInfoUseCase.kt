package com.example.fetch.domain

import com.example.fetch.base.CoroutineUseCase
import com.example.fetch.data.InfoRepository
import kotlinx.coroutines.CoroutineDispatcher

class LoadInfoUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    val repository: InfoRepository
) : CoroutineUseCase<Unit, List<Info>>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit): List<Info> {
        val infoList = repository.getInfo().filter { it.name.isNullOrBlank().not() }.map {
            Info(
                id = it.id,
                listId = it.listId,
                name = it.name!!
            )
        }.sortedWith(compareBy<Info> { it.listId }.thenBy { it.name })
            .groupBy { it.listId }
        return infoList.values.flatten()
    }
}