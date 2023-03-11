package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class MyAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val prodName: TextView
        val prodImage: ShapeableImageView
        val star1: ImageView
        val star2: ImageView
        val star3: ImageView
        val star4: ImageView
        val star5: ImageView

        init {
            prodName = itemView.findViewById(R.id.productName)
            prodImage = itemView.findViewById(R.id.productImage)
            star1 = itemView.findViewById(R.id.starOneImage)
            star2 = itemView.findViewById(R.id.starTwoImage)
            star3 = itemView.findViewById(R.id.starThreeImage)
            star4 = itemView.findViewById(R.id.starFourImage)
            star5 = itemView.findViewById(R.id.starFiveImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.prodName.text = currentItem.title

        // Setting Image when URL of the image is provided
        // Using Picasso 3rd party Library
        Picasso.get().load(currentItem.thumbnail).into(holder.prodImage)
        val rating: Int = (currentItem.rating).roundToInt()

        if (rating == 0) {
            holder.star1.alpha = 0F
            holder.star2.alpha = 0F
            holder.star3.alpha = 0F
            holder.star4.alpha = 0F
            holder.star5.alpha = 0F
        } else if (rating == 1) {
            holder.star1.alpha = 1F
            holder.star2.alpha = 0F
            holder.star3.alpha = 0F
            holder.star4.alpha = 0F
            holder.star5.alpha = 0F
        } else if (rating == 2) {
            holder.star1.alpha = 1F
            holder.star2.alpha = 1F
            holder.star3.alpha = 0F
            holder.star4.alpha = 0F
            holder.star5.alpha = 0F
        } else if (rating == 3) {
            holder.star1.alpha = 1F
            holder.star2.alpha = 1F
            holder.star3.alpha = 1F
            holder.star4.alpha = 0F
            holder.star5.alpha = 0F
        } else if (rating == 4) {
            holder.star1.alpha = 1F
            holder.star2.alpha = 1F
            holder.star3.alpha = 1F
            holder.star4.alpha = 1F
            holder.star5.alpha = 0F
        } else if (rating == 5) {
            holder.star1.alpha = 1F
            holder.star2.alpha = 1F
            holder.star3.alpha = 1F
            holder.star4.alpha = 1F
            holder.star5.alpha = 1F
        }

    }
}


