package edu.udea.LaBastilla.services;
import edu.udea.LaBastilla.model.Profile;
import edu.udea.LaBastilla.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesProfile implements ServicesProfileInterface {
    @Autowired
    private ProfileRepository repository;

    @Override
    public List<Profile> getProfiles() {
        return repository.findAll();
    }

    @Override
    public Profile getProfile(String id) throws Exception {
        Optional<Profile> profileDB = repository.findById(id);
        if (profileDB.isPresent())
            return profileDB.get();
        throw new Exception("Perfil no existe");
    }

    @Override
    public String setProfile(Profile newProfile) {
        repository.save(newProfile);
        return "Perfil creado exitosamente";
    }

    @Override
    public Profile updateProfile(Profile profileUpdated, String id) throws Exception {
        Profile profileDB = getProfile(id);
        if (profileUpdated.getImage() != null && !profileUpdated.getImage().equals(""))
            profileDB.setImage(profileUpdated.getImage());

        if (profileUpdated.getPhone() != null && !profileUpdated.getPhone().equals(""))
            profileDB.setPhone(profileUpdated.getPhone());

        profileDB.setUpdatedAt(new Date());
        return repository.save(profileDB);

    }

    @Override
    public String deleteProfile(String id) {
        repository.deleteById(id);
        return "Perfil eliminado exitosamente";
    }
}