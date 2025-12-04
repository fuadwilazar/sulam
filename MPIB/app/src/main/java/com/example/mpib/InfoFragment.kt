package com.example.mpib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri

class InfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_facebook).setOnClickListener {
            openUrl("https://www.facebook.com/lpnm.gov/")
        }

        view.findViewById<View>(R.id.btn_twitter).setOnClickListener {
            openUrl("https://x.com/lpnm_gov")
        }

        view.findViewById<View>(R.id.btn_instagram).setOnClickListener {
            openUrl("https://www.instagram.com/nanas_lpnm/?hl=en")
        }

        view.findViewById<View>(R.id.btn_youtube).setOnClickListener {
            openUrl("https://www.youtube.com/user/lpnmgov")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}