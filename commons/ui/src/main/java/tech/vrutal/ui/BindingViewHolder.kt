package tech.vrutal.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingViewHolder<VB : ViewDataBinding>(
    val binding: VB
) : RecyclerView.ViewHolder(
    binding.root
)