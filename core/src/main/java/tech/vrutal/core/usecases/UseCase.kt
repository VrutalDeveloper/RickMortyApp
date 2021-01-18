package tech.vrutal.core.usecases

import tech.vrutal.core.result.Result
import java.lang.RuntimeException

abstract class UseCase<in P, R> {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            execute(parameters).let {
                Result.Success(it)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}