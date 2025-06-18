package com.moutamid.misshelper.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.moutamid.misshelper.R;
import com.moutamid.misshelper.adapter.FaqAdapter;
import com.moutamid.misshelper.model.FaqModel;

import java.util.ArrayList;
import java.util.List;

public class FaqFragment extends Fragment {

    private RecyclerView faqRecyclerView;

    public FaqFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        faqRecyclerView = view.findViewById(R.id.faqRecyclerView);

        List<FaqModel> faqList = new ArrayList<>();
        faqList.add(new FaqModel("How do I apply for a job?",
                "Complete your profile, upload documents, then tap 'Apply' on the job listing."));
        faqList.add(new FaqModel("What documents are required?",
                "Resume, CNIC, and educational certificates."));
        faqList.add(new FaqModel("How long does the application process take?",
                "The review process usually takes between 2 to 5 business days."));
        faqList.add(new FaqModel("Can I apply for more than one job?",
                "Yes, you can apply to multiple jobs."));
        faqList.add(new FaqModel("How can I contact support?",
                "Use the 'Chat Now' button on the Contact Us screen."));

        faqRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        faqRecyclerView.setAdapter(new FaqAdapter(faqList));

        return view;
    }

}