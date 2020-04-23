package com.interneted.beautifulswitch

import android.content.Context
import android.widget.Toast

/**
 * Creator: ED
 * Date: 2020/4/23 10:31 AM
 * Mail: salahayo3192@gmail.com
 *
 * **/

object Toast {

    fun show(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}