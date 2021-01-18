package tech.vrutal.core.remote

import tech.vrutal.core.remote.responses.CharacterResponse
import tech.vrutal.domain.Charac

fun CharacterResponse.toCharac() = Charac(
    id = id.toString(),
    name = name,
    imageUri = image
)