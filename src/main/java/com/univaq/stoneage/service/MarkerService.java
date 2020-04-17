package com.univaq.stoneage.service;

import com.univaq.stoneage.repository.IMarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService implements IMarkerService {

    @Autowired
    private IMarkerRepository markerRepository;

    //    @Override
//    public List<MMarker> getAllMarkers() {
//        return markerRepository.findAll();
//    }
    public void getAllMarkers() {
        markerRepository.findAll();
    }
}
