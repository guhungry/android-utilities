package com.guhungry.utilities.app.listexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guhungry.utilities.R
import com.guhungry.utilities.app.listexample.ExampleAdapter.ExampleViewHolder
import kotlinx.android.synthetic.main.list_item_example.view.*
import com.guhungry.utilities.ImageUtilsFacade as ImageUtils

class ExampleAdapter(context: Context, private val list: List<ExampleModel>) : RecyclerView.Adapter<ExampleViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private var listener: ((ExampleModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = inflater.inflate(R.layout.list_item_example, parent, false)
        return ExampleViewHolder(view) { handleClick(it) }
    }

    private fun getItem(position: Int) = list[position]
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    fun setOnItemClickListener(l: (ExampleModel) -> Unit) {
        listener = l
    }

    private fun handleClick(view: View) = listener?.invoke(view.tag as ExampleModel)

    class ExampleViewHolder(itemView: View, listener: (View) -> Unit) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(listener)
        }

        fun onBind(item: ExampleModel) {
            itemView.tag = item

            itemView.name.text = item.title
            ImageUtils.loadImage(itemView.icon, item.icon, itemView.icon.context)
        }
    }
}
