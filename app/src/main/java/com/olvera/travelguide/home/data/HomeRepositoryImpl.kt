package com.olvera.travelguide.home.data

import com.olvera.travelguide.home.data.remote.ChatgptApi
import com.olvera.travelguide.home.data.remote.dto.ChatRequestDto
import com.olvera.travelguide.home.domain.HomeRepository
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(
    private val chatGptApi: ChatgptApi
) :  HomeRepository {
    override suspend fun getTravelGuide(): Result<String> {
        return try {
            val request = ChatRequestDto(
                maxTokens = 1500,
                model = "test-davicn",
                prompt = "Soy una guia",
                temperature = 0.7
            )
            val information = chatGptApi.getTravelInformation(request)
            Result.success(information.choices.first().text)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}