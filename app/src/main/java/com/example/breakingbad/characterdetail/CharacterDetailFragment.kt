package com.example.breakingbad.characterdetail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.breakingbad.BaseFragment
import com.example.breakingbad.R
import kotlinx.android.synthetic.main.fragment_details.*

class CharacterDetailFragment : BaseFragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val selectedCharacter = CharacterDetailFragmentArgs.fromBundle(it).character
            details_character_name.text = String.format(
                getString(R.string.character_name_label),
                selectedCharacter.name
            )
            details_character_nickname.text = String.format(
                getString(R.string.character_nickname_label),
                selectedCharacter.nickname
            )
            details_character_status.text = String.format(
                getString(R.string.character_status_label),
                selectedCharacter.status
            )
            details_character_occupation.text = String.format(
                    getString(R.string.character_occupation_label),
            selectedCharacter.occupation.joinToString()
            )
            details_character_season_appearance.text = String.format(
                getString(R.string.character_season_appearance_label),
                selectedCharacter.appearance.joinToString(separator = " . ")
            )
            Glide.with(details_character_image.context).load(selectedCharacter.img)
                .into(details_character_image)
        }
    }
}