package com.example.pets.serice;

import com.example.pets.IdNotFoundException;
import com.example.pets.entity.Pet;
import com.example.pets.repository.PetRepository;
import com.example.pets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;


    public void savePhoto(MultipartFile[] files, Long petId)  {

        Optional<Pet> byId = petRepository.findById(petId);
        if(byId.isPresent()){
            List<String> photos = new ArrayList<>();
            for (MultipartFile file:files){
                String fileName = petId+"_"+file.getOriginalFilename();
                File myFile = new File(FILE_DIRECTORY+fileName);
                try {
                    myFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(myFile);
                    fos.write(file.getBytes());
                    fos.close();
                    photos.add(fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Pet pet = byId.get();
            pet.setPhoto(photos);
            petRepository.save(pet);
        }else{
            throw new IdNotFoundException();
        }

    }
}
