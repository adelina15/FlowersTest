package android.example.flowerschemistry.ui

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ActivityAboutBouquetBinding
import android.example.flowerschemistry.databinding.ActivityMainBinding
import android.example.flowerschemistry.ui.adapters.SliderAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class AboutBouquet : AppCompatActivity() {
    lateinit var binding: ActivityAboutBouquetBinding
    private var images = intArrayOf(R.drawable.image_slider1, R.drawable.image_slider2, R.drawable.image_slider3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBouquetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sliderAdapter = SliderAdapter(images)
        binding.sliderView.setSliderAdapter(sliderAdapter)
        binding.sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.sliderView.startAutoCycle()

        binding.tvNameBouquet.text = getIntent().getStringExtra("Name")
        binding.tvDescription.text = getIntent().getStringExtra("Description")
        sliderAdapter.let {
            (intent.getStringExtra("Image")?.toInt())
        }
    }
}