package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentBouquetBinding
import android.example.flowerschemistry.ui.adapters.SliderAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class BouquetFragment : Fragment() {
    private var _binding: FragmentBouquetBinding? = null
    private val binding get() = _binding!!
    private var images = intArrayOf(R.drawable.image_slider1, R.drawable.image_slider2, R.drawable.image_slider3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        val sliderAdapter = SliderAdapter(images)
        binding.sliderView.setSliderAdapter(sliderAdapter)
        binding.sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.sliderView.startAutoCycle()

        return view

    }
}