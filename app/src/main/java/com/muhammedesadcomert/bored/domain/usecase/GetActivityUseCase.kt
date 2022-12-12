package com.muhammedesadcomert.bored.domain.usecase

import com.muhammedesadcomert.bored.data.dto.ActivityResponse
import com.muhammedesadcomert.bored.data.repository.BoredRepository
import com.muhammedesadcomert.bored.domain.entity.ActivityEntity
import com.muhammedesadcomert.bored.domain.mapper.DomainMapper
import com.muhammedesadcomert.bored.util.NetworkResponseState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetActivityUseCase @Inject constructor(
    private val boredRepository: BoredRepository,
    private val domainMapper: DomainMapper<ActivityResponse, ActivityEntity>
) {
    operator fun invoke() = flow {
        emit(NetworkResponseState.Loading)

        when (val result = boredRepository.getActivity()) {
            is NetworkResponseState.Error -> emit(result)
            is NetworkResponseState.Success -> {
                emit(NetworkResponseState.Success(domainMapper.mapToDomainModel(result.data)))
            }
            else -> Unit
        }
    }
}