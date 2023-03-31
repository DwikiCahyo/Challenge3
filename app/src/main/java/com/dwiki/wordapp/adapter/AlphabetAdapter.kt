package com.dwiki.wordapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dwiki.wordapp.ContentFragment
import com.dwiki.wordapp.ContentFragment.Companion.DATA
import com.dwiki.wordapp.R
import com.dwiki.wordapp.databinding.ListAlphabetItemBinding
import com.dwiki.wordapp.model.Alphabet


class AlphabetAdapter(private val listAlphabet:ArrayList<Alphabet>):RecyclerView.Adapter<AlphabetAdapter.ListViewHolder>() {

    class ListViewHolder(var binding:ListAlphabetItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListAlphabetItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val alphabet = listAlphabet[position]

        holder.binding.apply {
            tvAlphabetName.text = alphabet.alphabetName
            ivAlphabet.setImageResource(alphabet.imgAlphabet)
            cvAlphabetItem.setOnClickListener {

                val appCompatActivity = it.context as AppCompatActivity
                val contentFragment = ContentFragment()

                val bundle = Bundle()
                bundle.putParcelable(DATA,alphabet)
                contentFragment(contentFragment, bundle, appCompatActivity)
            }
        }
    }

    override fun getItemCount(): Int = listAlphabet.size

    private fun contentFragment(
        contentFragment: ContentFragment,
        bundle: Bundle,
        appCompatActivity: AppCompatActivity
    ) {
        contentFragment.arguments = bundle
        appCompatActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, contentFragment)
            .addToBackStack(null)
            .commit()
    }


}