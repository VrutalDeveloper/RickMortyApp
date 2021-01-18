package tech.vrutal.core.di

/*
@Suppress("UNCHECKED_CAST")
inline fun <reified VM: ViewModel?> Fragment.viewModel(
    noinline block: () -> VM
): Lazy<VM> = lazy {

    val vm = block()
    val factory = object: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = vm as T
    }

    ViewModelProvider(this, factory).get(VM::class.java) as VM
}

object InjectorUtil {
    fun createClient(): HttpClient = HttpClient(Android) {

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    fun createRemoteSource(): RemoteSource = RemoteSourceImpl(createClient())
}*/
