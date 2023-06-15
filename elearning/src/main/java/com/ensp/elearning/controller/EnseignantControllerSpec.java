package com.ensp.elearning.controller;

import com.ensp.elearning.entity.Enseignant;
import org.springframework.ui.Model;

public interface EnseignantControllerSpec {
        String create(Enseignant enseignant, Model model);

        String getEnseignantCreateForm(Model model);

        String getEnseignantUpdateForm(Long id, Model model);

        String update(Enseignant enseignant, Model model);

        String read(Long id, Model model);

        String readAll(Model model);

        String delete(Long id, Model model);


        }
