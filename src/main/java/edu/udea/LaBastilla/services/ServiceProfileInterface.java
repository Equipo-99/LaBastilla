package edu.udea.LaBastilla.services;

import edu.udea.LaBastilla.model.Profile;

import java.util.List;

public interface ServiceProfileInterface {
    public List<Profile> getProfiles();
    public Profile getProfile(String id) throws Exception;
    public String setProfile(Profile newProfile);
    public Profile updateProfile(Profile ProfileUpdated, String id) throws Exception;
    public String deleteProfile(String id);
}
