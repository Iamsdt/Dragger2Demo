package com.iamsdt.dragger2demo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.fragment_details.*
import timber.log.Timber

class DetailsActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        val intent = intent
        val result:ResultsItem =
                intent.getSerializableExtra(Intent.EXTRA_TEXT) as ResultsItem

        val  posterPath = "http://image.tmdb.org/t/p/w185/${result.posterPath}"

        val component = MyApplication().get(this).getComponent()
        component?.getPicasso?.load(posterPath)?.fit()?.into(details_imageView)

        details_title.text = "Title:${result.title}"
        details_original_title.text = "Original Title:${result.originalTitle}"
        details_language.text = "Language:${result.originalLanguage}"
        details_overview.text = "Overview:${result.overview}"
        details_popularity.text = "Popularity:${result.popularity}"
        details_release_date.text = "Release Date:${result.releaseDate}"
        details_vote_average.text = "Vote Average:${result.voteAverage}"
        details_vote_count.text = "Vote count:${result.voteCount}"

        supportActionBar?.setDisplayShowHomeEnabled(true)

        Timber.i(component?.getPicasso.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (android.R.id.home == item?.itemId){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
