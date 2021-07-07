package com.example.waterdropcc.detail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.example.waterdropcc.data.UserRepo
import com.example.waterdropcc.databinding.FragmentDetailBinding
import com.example.waterdropcc.utils.TakePhotoHelper
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.ext.android.inject

private const val ARG_USER_ID = "userId"

class DetailFragment : Fragment() {

    private val repo: UserRepo by inject()
    private val viewModel: DetailViewModel by viewModels { DetailViewModelFactory(this, repo) }
    private var photoHelper: TakePhotoHelper? = null

    val getContent: ActivityResultLauncher<Uri> = registerForActivityResult(ActivityResultContracts.TakePicture()) { uri ->
        photoHelper?.setPic(photo_img)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.setUserId(it.getString(ARG_USER_ID))
        }
        take_photo_btn.setOnClickListener {
            photoHelper = TakePhotoHelper(requireContext()).also {
                it.dispatchTakePictureIntent(getContent)
            }
        }
    }
}