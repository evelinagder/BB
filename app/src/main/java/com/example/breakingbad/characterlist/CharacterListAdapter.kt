package com.example.breakingbad.characterlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breakingbad.R
import com.example.service.model.Character
import kotlinx.android.synthetic.main.item_character_row.view.*

class CharacterListAdapter(private var categoriesList: List<Character>) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {

        val rowView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character_row, parent, false)
        return CharacterViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.update(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    fun filterBySeason(seasonNumber: Int) {
        val newList = categoriesList.filter { it.appearance.contains(seasonNumber) }
        categoriesList = newList
        notifyDataSetChanged()
    }


    class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun update(character: Character) {
            view.character_name.text = character.name
            Glide.with(view.character_image.context).load(character.img)
                .into(view.character_image)
            view.setOnClickListener {
                val navigationDirection =
                    CharacterListFragmentDirections.actionCharacterSelected(character)
                Navigation.findNavController(it).navigate(navigationDirection)
            }
        }
    }
}