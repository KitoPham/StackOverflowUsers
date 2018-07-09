package com.kitopham.stackoverflowusers.Activities

import android.content.Context
import android.support.constraint.R.id.parent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kitopham.stackoverflowusers.R
import com.kitopham.stackoverflowusers.Models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_item.view.*


class MyCustomGridAdapter(private var context: Context, private val users: List<User> ) : BaseAdapter() {


    class ViewHolder{
        var displayNameLabel : TextView? = null
        var imageView : ImageView? = null
        var reputation : TextView? = null
    }

    override fun getView(position: Int, view: View?, viewGroup : ViewGroup?): View? {

        var newView: View? = view
        val layoutInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var mViewHolder = ViewHolder()

        if (newView == null) {
            newView = layoutInflater.inflate(R.layout.grid_item, viewGroup, false)

            mViewHolder.displayNameLabel = newView.displayName
            mViewHolder.imageView = newView.profilePicture
            mViewHolder.reputation = newView.reputation

            newView.tag = mViewHolder


        } else {
            mViewHolder = newView.tag as ViewHolder
        }

        val imageURL = users[position].profile_image ?: "No image url"
        mViewHolder.displayNameLabel?.text = users[position].display_name ?: "Name Unavailable"
        mViewHolder.reputation?.text = users[position].reputation ?: "0"
        Picasso.get()
                .load(imageURL)
                .fit()
                .centerInside()
                .into(mViewHolder.imageView)

        return newView
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return users.count()
    }

}