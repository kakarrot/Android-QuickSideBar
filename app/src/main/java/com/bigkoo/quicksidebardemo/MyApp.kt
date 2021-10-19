package com.bigkoo.quicksidebardemo

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * <pre>
 *     author : E.T
 *     e-mail : et@wsbroker.me
 *     time   : 2021/10/19
 *     desc   :
 * </pre>
 */
class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}