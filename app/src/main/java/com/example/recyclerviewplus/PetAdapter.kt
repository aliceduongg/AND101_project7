package com.example.recyclerviewplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PetAdapter(private val petList: MutableList<String>): RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView
        val petName: TextView
        val petText: TextView
//        var toast: Toast? = null

        init {
            petImage = view.findViewById(R.id.pet_image)
            petName = view.findViewById(R.id.pet_Name)
            petText = view.findViewById(R.id.pet_Text)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pet_item, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(petList[position])
//           placeholder(R.drawable.cutedogs_placeholder)
            .centerCrop()
            .into(holder.petImage)


        holder.petName.text = petList[position]
        holder.petText.text = if (petList[position] != "") {
            petList[position]
        } else { "Text dont show" }

        holder.petImage.setOnClickListener {
//            if (holder.toast != null) { holder.toast?.cancel() }
           Toast.makeText(holder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT)
//            viewHolder.toast?.show()
        }
    }

    override fun getItemCount() = petList.size
}