package com.elslode.getcontacts.presentation.eventGetContact

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.elslode.getcontacts.R
import com.elslode.getcontacts.databinding.FragmentGetContactBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventGetContactFragment : Fragment(R.layout.fragment_get_contact) {

    private var _binding: FragmentGetContactBinding? = null
    private val binding: FragmentGetContactBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    private val vm: GetContactViewModel by lazy {
        ViewModelProvider(this).get(GetContactViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGetContactBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val eventsRecyclerView = view.findViewById<EpoxyRecyclerView>(R.id.events)
        vm.contactsList.observe(viewLifecycleOwner) { contact ->
            eventsRecyclerView.withModels {
                contact.forEach { cont ->
                    WidgetGetContactModel_()
                        .id(cont.id)
                        .acceptData(cont)
                        .addTo(this)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EventGetContactFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}