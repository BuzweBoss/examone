package vcmsa.ci.examone

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var outputText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        outputText = findViewById(R.id.tvOutput)
        val showSongBtn = findViewById<Button>(R.id.btnShowSong)
        val showAverageBtn = findViewById<Button>(R.id.btnShowAverage)
        val returnBtn = findViewById<Button>(R.id.btnReturn)

        showSongBtn.setOnClickListener {
            displaySong(showAverage = true)
        }

        showAverageBtn.setOnClickListener {
            displaySong(showAverage = false)
        }

        returnBtn.setOnClickListener {
            finish()
        }
    }

    private fun displaySong(showAverage: Boolean) {/
        val builder = StringBuilder()

        for (i in MainActivity.song.indices) {
            val qty = MainActivity.rating[i]
            if (showAverage || qty >= 5) {
                val n = Unit

                builder.append("Song: ${MainActivity.song[i]}\n")
                builder.append("Artist: ${MainActivity.artist[i]}\n")
                builder.append("Rating: $qty\n")
                builder.append("Comments: ${MainActivity.comments[i]}\n\n")
            }
        }

        outputText.text = if (builder.isEmpty()) "No items to show." else builder.toString()
    }
}
