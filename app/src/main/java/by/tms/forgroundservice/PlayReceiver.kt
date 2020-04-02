package by.tms.forgroundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager

class PlayReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val ringtone = RingtoneManager.getRingtone(context, uri)
        ringtone.play()
    }
}