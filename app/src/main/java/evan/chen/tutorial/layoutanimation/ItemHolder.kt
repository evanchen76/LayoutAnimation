package evan.chen.tutorial.layoutanimation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by evan on 25/02/2018.
 */

class ItemHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView.findViewById(R.id.message)

    fun setMessage(message: String) {
        textView.text = message
    }
}
