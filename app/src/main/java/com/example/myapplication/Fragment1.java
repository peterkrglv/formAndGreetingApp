package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {

    private Fragment1Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = Fragment1Binding.inflate(inflater, container, false);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextScreen(makeColorBundle(FragmentColors.RED));
            }
        });
;

        return binding.getRoot();
    }

    // Метод создания бандла с параметром цвета
    private Bundle makeColorBundle(FragmentColors color) {
        Bundle bundle = new Bundle(); // Бандл способен хранить в себе информацию разных типов в виде ключ - значение
        bundle.putSerializable("color", color); // в данном случае храним информацию о цвете
        return bundle;
    }

    // Метод перехода на следующий экран с информацией из бандла
    private void moveToNextScreen(Bundle bundle) {
        Navigation
                .findNavController(binding.getRoot())
                .navigate(R.id.action_firstFragment_to_secondFragment, bundle); // Здесь указан id action из nav_graph
    }
}}