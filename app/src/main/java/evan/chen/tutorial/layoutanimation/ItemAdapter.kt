package evan.chen.tutorial.layoutanimation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by evan on 19/01/2018.
 */

class ItemAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items:List<String>? = null


    //回傳recycleview裡的item筆數
    override fun getItemCount(): Int {
        return items?.count() ?:0
    }

    override fun getItemViewType(position: Int): Int {

        return 0
    }

    //產生ViewHolder，在這裡載入layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent!!, false))
    }

    //在這裡設定Holder裡的UI
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as ItemHolder).setMessage(items!![position])
    }
}

