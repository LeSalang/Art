package kz.lesa.drawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kz.lesa.drawerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = ArtAdapter()
    private val imageIdList = listOf(
        R.drawable.art1,
        R.drawable.art2,
        R.drawable.art3,
        R.drawable.art4,
        R.drawable.art5,
        R.drawable.art6,
        R.drawable.art7,
        R.drawable.art8,
        R.drawable.art9,
        R.drawable.art10,
        R.drawable.art11,
        R.drawable.art12,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,4)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 11) index = 0
                val art = Art(imageIdList[index], "Art $index")
                adapter.addArt(art)
                index++
            }
        }
    }
}