package tech.vrutal.core.remote

import tech.vrutal.core.remote.responses.CharacterResponse
import tech.vrutal.core.remote.responses.InfoResponse

interface RemoteSource {

    suspend fun getCharacters(vararg ids: Int) : List<CharacterResponse>

    suspend fun getAllCharacters(): InfoResponse<CharacterResponse>
}