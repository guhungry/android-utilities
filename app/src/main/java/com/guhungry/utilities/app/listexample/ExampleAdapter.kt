package com.guhungry.utilities.app.listexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guhungry.utilities.ImageUtilsFacade as ImageUtils
import com.guhungry.utilities.R
import com.guhungry.utilities.app.ExampleModel
import com.guhungry.utilities.app.listexample.ExampleAdapter.ExampleViewHolder
import kotlinx.android.synthetic.main.list_item_example.view.*

class ExampleAdapter(private val context: Context, private val list: List<ExampleModel>) : RecyclerView.Adapter<ExampleViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = inflater.inflate(R.layout.list_item_example, parent, false)
        return ExampleViewHolder(view)
    }

    private fun getItem(position: Int) = list.get(position)
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(item: ExampleModel) {
            itemView.name.text = "ExampleViewHolder Bind ${item.first}"
            ImageUtils.loadImage(itemView.icon, item.second, itemView.icon.context)
        }
    }
}
