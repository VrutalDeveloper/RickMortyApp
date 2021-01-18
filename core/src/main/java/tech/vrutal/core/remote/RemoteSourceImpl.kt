package tech.vrutal.core.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import tech.vrutal.core.remote.responses.CharacterResponse
import tech.vrutal.core.remote.responses.InfoResponse
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val client: HttpClient) : RemoteSource {

    override suspend fun getCharacters(vararg ids: Int): List<CharacterResponse> =
        client.get("https://rickandmortyapi.com/api/character/${ids.joinToString(",")}")


    override suspend fun getAllCharacters(): InfoResponse<CharacterResponse> =
        client.get("https://rickandmortyapi.com/api/character/")
}