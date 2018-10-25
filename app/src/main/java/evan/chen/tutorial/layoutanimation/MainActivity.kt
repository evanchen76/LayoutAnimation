package evan.chen.tutorial.layoutanimation

import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ItemAdapter
    lateinit var items: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //建立Adapter
        adapter = ItemAdapter(this)

        recycleView.layoutManager = GridLayoutManager(this, 4)
        recycleView.addItemDecoration(SpacesItemDecoration(8))
        //將Adapter指定給RecycleView
        recycleView.adapter = adapter

        fadeIn.setOnClickListener {
            loadData(R.anim.layout_animation_fade_in)
        }

        left.setOnClickListener {
            loadData(R.anim.layout_animation_left)
        }

        fadeInReverse.setOnClickListener {
            loadData(R.anim.layout_animation_fade_in_reverse)
        }

        rotate.setOnClickListener {
            loadData(R.anim.layout_animation_rotate)
        }

        fadeInRandom.setOnClickListener {
            loadData(R.anim.layout_animation_fade_in_random)
        }
    }

    private fun loadData(animId: Int) {
        items = (1..20).map { it.toString() }
        adapter.items = items
        adapter.notifyDataSetChanged()
        recycleView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this, animId)
        recycleView.scheduleLayoutAnimation()
    }
}

class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space

        if (parent.getChildPosition(view) == 0)
            outRect.top = space
    }
}