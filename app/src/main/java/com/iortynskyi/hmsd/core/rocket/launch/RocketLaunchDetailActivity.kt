package com.iortynskyi.hmsd.core.rocket.launch

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.iortynskyi.hmsd.R
import com.iortynskyi.hmsd.base.BaseActivity
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchDetailPresenter
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchDetailView
import com.iortynskyi.hmsd.extensions.loadUrl
import kotlinx.android.synthetic.main.activity_launch_detail.*
import javax.inject.Inject

class RocketLaunchDetailActivity : BaseActivity(), RocketLaunchDetailView {

    @Inject lateinit var presenter: RocketLaunchDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        presenter.attachView(this)
        presenter.fetchLaunch(intent.extras.getLong(EXTRA_LAUNCH_ID))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setupComponent() {
        app.components.launchComponent().inject(this)
    }

    override fun loadLaunch(launch: Launch) {
        supportActionBar?.title = launch.rocket?.name
        launch.rocket?.imageUrl?.let { rocketImage.loadUrl(it) }
        rocketName.text = getString(R.string.rocket_name, launch.rocket?.name)
        rocketConfiguration.text = getString(R.string.rocket_configuration, launch.rocket?.configuration)
        rocketFamilyName.text = getString(R.string.rocket_family_name, launch.rocket?.familyName)
        locationCountry.text = getString(R.string.location_country, launch.location?.countryCode)
        locationName.text = getString(R.string.location_name, launch.location?.name)
        val missions = StringBuilder(getString(R.string.mission_name))
        launch.missions.forEach { missions.append("- ${it.name} \n") }
        missionName.text = missions
        if (launch.missions.isEmpty()) missionName.visibility = View.GONE
    }

    companion object {

        private const val EXTRA_LAUNCH_ID = "EXTRA_LAUNCH_ID"

        fun createBundle(id: Long): Bundle {
            val bundle = Bundle()
            bundle.putLong(EXTRA_LAUNCH_ID, id)
            return bundle
        }
    }
}
