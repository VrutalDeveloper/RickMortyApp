package tech.vrutal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VB: ViewDataBinding>(
    @LayoutRes val layoutRes: Int,
    val itemsSame: (old: T, new: T) -> Boolean,
    val contentsSame: (old: T, new: T) -> Boolean
) : ListAdapter<T, BindingViewHolder<VB>>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(old: T, new: T): Boolean = itemsSame(old, new)
    override fun areContentsTheSame(old: T, new: T): Boolean = contentsSame(old, new)
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: VB = DataBindingUtil.inflate(inflater, layoutRes, parent, false)
        return BindingViewHolder(binding).also {
            onViewHolderCreated(it)
        }
    }

    abstract fun onViewHolderCreated(holder: BindingViewHolder<VB>)
}