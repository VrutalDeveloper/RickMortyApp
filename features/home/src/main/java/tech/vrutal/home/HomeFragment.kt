package tech.vrutal.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.imageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import tech.vrutal.home.databinding.FragmentHomeBinding
import tech.vrutal.ui.BaseFragment
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home
) {

    @Inject lateinit var tree: Timber.Tree
    @Inject lateinit var name: String

    private val logger: (it: Any) -> Unit = { it -> tree.d(it.toString()) }

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = HomeAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
            this.adapter = adapter
        }

        resources.displayMetrics.run {
            val pair = Pair(widthPixels / density, heightPixels / density)
            logger(pair)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            homeViewModel.characterList.collect { list -> adapter.submitList(list)}
        }
    }
}