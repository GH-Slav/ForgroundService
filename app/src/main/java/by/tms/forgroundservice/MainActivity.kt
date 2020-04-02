package by.tms.forgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  //      val app = applicationContext as App

        startServiceButton.setOnClickListener {
            val intentStart = Intent(this, MyService::class.java)
            intentStart.putExtra("KEY", editTextMassage.text.toString())
            startService(intentStart)
            Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show()
        }
        stopServiceButton.setOnClickListener {
            val intentStop = Intent(this, MyService::class.java)
            stopService(intentStop)
            Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show()
        }


    }


}
