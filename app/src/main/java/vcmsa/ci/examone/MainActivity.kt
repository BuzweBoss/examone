package vcmsa.ci.examone


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Companion object to store parallel arrays
    companion object {
        val song = mutableListOf<String>()
        val artist = mutableListOf<String>()
        val rating: MutableList<Int> = mutableListOf<Int>()
        val comments = mutableListOf<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val songInput = findViewById<EditText>(R.id.etSong)
        val artistInput = findViewById<EditText>(R.id.etArtist)
        val ratingInput = findViewById<EditText>(R.id.etRating)
        val commentsInput = findViewById<EditText>(R.id.etComments)

        val addPlaylistButton = findViewById<Button>(R.id.btnPlaylist)
        val nextButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addPlaylistButton.setOnClickListener {
            val song = songInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val ratingStr = ratingInput.text.toString().trim()
            val comment = commentsInput.text.toString().trim()

            if (song.isEmpty() || artist.isEmpty() || ratingStr.isEmpty()) {
                Toast.makeText(this, "Please complete all required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating = ratingStr.toIntOrNull()
            if (rating == null || rating <= 0) {
                Toast.makeText(this, "Enter a valid rating (> 0).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            Toast.makeText(this, "Thank you for adding!", Toast.LENGTH_SHORT).show()

            // Clear inputs
            songInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentsInput.text.clear()
        }

        nextButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
        exitButton.setOnClickListener {
            finish()
        }
    }
}