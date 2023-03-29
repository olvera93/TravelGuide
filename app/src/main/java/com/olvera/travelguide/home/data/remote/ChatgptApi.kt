package com.olvera.travelguide.home.data.remote

import com.olvera.travelguide.home.data.remote.dto.ChatRequestDto
import com.olvera.travelguide.home.data.remote.dto.ChatResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatgptApi {

    @POST("completions")
    suspend fun getTravelInformation(@Body body: ChatRequestDto): ChatResponseDto

}