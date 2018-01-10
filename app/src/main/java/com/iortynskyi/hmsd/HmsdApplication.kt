package com.iortynskyi.hmsd

import android.app.Application
import com.iortynskyi.hmsd.di.ComponentFacade

class HmsdApplication : Application() {

    val components: ComponentFacade = ComponentFacade(this)
}
