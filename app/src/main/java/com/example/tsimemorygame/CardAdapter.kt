package com.example.tsimemorygame

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class CardAdapter(private val context: Context) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context)
            imageView.setLayoutParams(GridView@ AbsListView.LayoutParams(200, 200))
            imageView.setScaleType(ImageView.ScaleType.FIT_XY)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(R.drawable.question_mark)
        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return 16
    }

}