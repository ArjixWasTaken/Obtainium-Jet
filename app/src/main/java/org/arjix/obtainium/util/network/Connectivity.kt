package org.arjix.obtainium.util.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.*
import kotlinx.coroutines.*
import java.net.InetAddress
import java.net.UnknownHostException

suspend fun isDnsResolvable(): Boolean {
    return withContext(Dispatchers.IO) {
        try {
            /*
                www.msftconnecttest.com is what windows uses to determine if a network is connected to the internet
                to be fair, windows requests for http://www.msftconnecttest.com/connecttest.txt and checks the content
                but a simple DNS lookup is enough for us, me thinks :^)
            */
            val address = InetAddress.getByName("www.msftconnecttest.com")
            !address.hostAddress.isNullOrEmpty()
        } catch (e: UnknownHostException) {
            false
        }
    }
}

suspend fun hasNetwork(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

    return activeNetwork.hasCapability(NET_CAPABILITY_VALIDATED) && isDnsResolvable()
}
