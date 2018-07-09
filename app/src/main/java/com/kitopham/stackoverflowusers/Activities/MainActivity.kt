package com.kitopham.stackoverflowusers.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kitopham.stackoverflowusers.Constants.*
import com.kitopham.stackoverflowusers.R
import com.kitopham.stackoverflowusers.Models.User
import com.kitopham.stackoverflowusers.Models.Users
import com.kitopham.stackoverflowusers.ViewModels.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    var data : List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        if (data == null) {
            viewModel.getNames().observe(this, Observer<Users> { users ->
                if (users != null) {
                    data = users.items
                    populateGrid(this)
                }
            })
        } else {
            populateGrid(this)
        }

    }

    private fun populateGrid(context: Context){
        val adapter = MyCustomGridAdapter(context, data as List<User>)
        val gridView = GridView(context)
        val users = data
        gridView.adapter = adapter
        gridView.numColumns = 2
        gridView.horizontalSpacing = 30
        gridView.verticalSpacing = 30
        gridView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val intent = Intent(context, UserDetailsActivity::class.java)
                users?.let {
                    intent.putExtra(USER_DISPLAY, it[position].display_name)
                    intent.putExtra(USER_REPUTATION, it[position].reputation)
                    intent.putExtra(USER_ABOUT_ME, it[position].about_me)
                    intent.putExtra(USER_PICTURE, it[position].profile_image)
                    intent.putExtra(USER_BADGE_BRONZE, it[position].badge_counts?.bronze)
                    intent.putExtra(USER_BADGE_SILVER, it[position].badge_counts?.silver)
                    intent.putExtra(USER_BADGE_GOLD, it[position].badge_counts?.gold)
                }

                context.startActivity(intent)
            }
        }
        myLinearLayout.addView(gridView)
    }


}
