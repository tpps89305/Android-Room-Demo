package com.dispy.roomdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.dispy.roomdemo.databinding.FragmentSecondBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels {
        AppViewModelFactory((activity?.application as MyApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.buttonCreate.setOnClickListener {
            addUser()
        }

        return binding.root

    }

    private fun addUser() {
        if (binding.editName.text.isNullOrEmpty() ||
            binding.editAge.text.isNullOrEmpty() ||
            binding.editAddress.text.isNullOrEmpty()) {
            return
        }
        val newUser = User(name = binding.editName.text.toString(),
            age = binding.editAge.text.toString().toInt(),
            address = binding.editAddress.text.toString())
        viewModel.insert(newUser)
        Toast.makeText(
            context?.applicationContext,
            "Add new user ${newUser.name}",
            Toast.LENGTH_LONG
        ).show()
        binding.editName.setText("")
        binding.editAge.setText("")
        binding.editAddress.setText("")
        Log.i("SecondFragment", "Add user: ${binding.editName.text.toString()}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}