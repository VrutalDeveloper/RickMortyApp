package tech.vrutal.home

import tech.vrutal.domain.Charac
import tech.vrutal.home.databinding.ItemCharacterBinding
import tech.vrutal.ui.BaseAdapter
import tech.vrutal.ui.BindingViewHolder

class HomeAdapter : BaseAdapter<Charac, ItemCharacterBinding>(
    R.layout.item_character,
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old.name == new.name }
) {
    override fun onViewHolderCreated(holder: BindingViewHolder<ItemCharacterBinding>) {

    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemCharacterBinding>, position: Int) {
        holder.binding.character = getItem(position)
    }
}