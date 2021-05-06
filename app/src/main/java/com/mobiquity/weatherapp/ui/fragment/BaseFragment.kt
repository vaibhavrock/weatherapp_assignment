package com.mobiquity.weatherapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected fun changeInnerFragment(fragment: Fragment, containerID: Int, args: Bundle?) {
        val fm = fragmentManager
        val tag = fragment.javaClass.name

        if (args != null) {
            fragment.arguments = args
        }
        val ts = fm?.beginTransaction()
        ts?.add(containerID, fragment, tag)
        ts?.addToBackStack(tag)
        ts?.commit()
    }

}
