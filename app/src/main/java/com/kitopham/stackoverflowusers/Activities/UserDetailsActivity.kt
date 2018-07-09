package com.kitopham.stackoverflowusers.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kitopham.stackoverflowusers.Constants.*
import com.kitopham.stackoverflowusers.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.details_activity.*

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val intentExtras = intent.extras
        displayNameDetail.text = intentExtras.getString(USER_DISPLAY, "No Name")
        val profilePictureURL : String = intentExtras.getString(USER_PICTURE, "No URL")
        Picasso.get()
                .load(profilePictureURL)
                .resizeDimen(R.dimen.pictureSize, R.dimen.pictureSize)
                .into(profilePictureDetail)
        reputationDetail.text = intentExtras.getString(USER_REPUTATION, "0") + " Reputation"
        aboutMeDetail.text = intentExtras.getString(USER_ABOUT_ME,"This user has not set an about me")

        bronzeCountDetail.text = intentExtras.getString(USER_BADGE_BRONZE, "0")
        silverCountDetail.text = intentExtras.getString(USER_BADGE_SILVER, "0")
        goldCountDetail.text = intentExtras.getString(USER_BADGE_GOLD, "0")

    }

}