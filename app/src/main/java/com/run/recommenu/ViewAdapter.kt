package com.run.recommenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_list.view.*
import java.text.SimpleDateFormat
import java.util.*

class ViewAdapter(
    private val context: Context,
    private var recipeList: OrderedRealmCollection<Recipe>?,
    private var listener: OnItemClickListener,
    private val autoUpdate: Boolean
) :
    RealmRecyclerViewAdapter<Recipe, ViewAdapter.RecipeViewHolder>(recipeList, autoUpdate) {

    override fun getItemCount(): Int = recipeList?.size ?: 0

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe: Recipe = recipeList?.get(position) ?: return

        holder.trashImageView.setOnClickListener{
            listener.onTrashClick(recipe)
        }

        holder.cookpadImageView.setOnClickListener {
            listener.onCookpadClick(recipe)
        }

        holder.kurashiruImageView.setOnClickListener {
            listener.onKurashiruClick(recipe)
        }

        holder.container.setOnClickListener {
            listener.onItemClick(recipe)
        }

        holder.foodTextView.text = recipe.food
        holder.dateTextView.text =
            SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE).format(recipe.date)


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecipeViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false)
        return RecipeViewHolder(v)
    }


    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container : LinearLayout = view.container
        val foodTextView: TextView = view.food
        val dateTextView: TextView = view.dateText
        val cookpadImageView : ImageView = view.cookpadImage
        val kurashiruImageView : ImageView = view.KurashiruImage
        val trashImageView : ImageView = view.findViewById(R.id.trashImage)

    }

    interface OnItemClickListener {
        fun onTrashClick(item: Recipe)
        fun onCookpadClick(item: Recipe)
        fun onKurashiruClick(item: Recipe)
        fun onItemClick(item: Recipe)
    }

}