package com.example.logotrivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logotrivia.databinding.FragmentLooserBinding;


public class LooserFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";


    private String name;
    private FragmentLooserBinding mBinding;
    public LooserFragment() {
        // Required empty public constructor
    }

        public static LooserFragment newInstance(String param1) {
        LooserFragment fragment = new LooserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentLooserBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String message = getString(R.string.incorrecto, name);
        mBinding.tvLooser.setText(message);
        mBinding.btLooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addLooser(name);
            }
        });
    }

    private void addLooser(String name) {
       TriviaFragment triviaFragment = TriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, triviaFragment, TriviaFragment.class.getSimpleName())
                .addToBackStack(null);
        transaction.commit();
    }
}
